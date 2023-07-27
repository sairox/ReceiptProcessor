package com.example.receiptprocessor.service;

import com.example.receiptprocessor.model.Item;
import com.example.receiptprocessor.model.Receipt;
import org.springframework.stereotype.Service;

@Service
public class CalculatePoints {

    public int calculatePoints(Receipt receipt) {
        int points = 0;

        // Rule 1
        points += receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length();

        // Rule 2
        double total = Double.parseDouble(receipt.getTotal());
        if(total % 1 == 0){
            points += 50;
        }

        // Rule 3
        if(total % 0.25 == 0){
            points += 25;
        }

        // Rule 4
        points += receipt.getItems().size() / 2 * 5;

        // Rule 5
        for(Item item : receipt.getItems()){
            String trimmedItem = item.getShortDescription().trim();
            if(trimmedItem.length() % 3 == 0){
                points += Math.ceil(item.getPrice() * 0.2);
            }
        }

        // Rule 6
        String[] dateParts = receipt.getPurchaseDate().split("-");
        int day = Integer.parseInt(dateParts[2]);
        if (day % 2 != 0) {
            points += 6;
        }

        // Rule 7
        String[] timeParts = receipt.getPurchaseTime().split(":");
        int hour = Integer.parseInt(timeParts[0]);
        if (hour >= 14 && hour <= 16) {
            points += 10;
        }

        return points;
    }
}
