package com.example.receiptprocessor.controller;

import com.example.receiptprocessor.exception.CustomException;

import com.example.receiptprocessor.model.Receipt;
import com.example.receiptprocessor.service.CalculatePoints;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/receipts")
@Slf4j
public class ReceiptController {

    @Autowired
    CalculatePoints calculatePoints;

    //HashMap to store the receipts according to the ID that receipt is linked to.
    private final static Map<String, Receipt> receiptMap = new HashMap<>();

    //POST Request
    @PostMapping("/process")
    public ResponseEntity<Map<String, String>> postReceipt(@RequestBody Receipt receipt){

        //Generate the ID
        String id = UUID.randomUUID().toString();

        //Processing the receipt and storing it into a hashmap for temporary storage of all receipts posted
        Map<String, String> response = new HashMap<>();
        receiptMap.put(id, receipt);
        response.put("id", id);

        return ResponseEntity.ok(response);
    }

    //GET request
    @GetMapping("/{id}/points")
    public ResponseEntity<Map<String, Integer>> getPoints(@PathVariable String id) {
        Map<String, Integer> response = new HashMap<>();

        //In this try catch block, the code is looking up the receipt in a lookup method that is below
        //If it doesn't find a receipt then it will return null and throw a null pointer exception
        //If it finds a receipt it will return it and send it to the service class where the receipt is calculated for
        //points, and it returns the response with points
        try {
            Receipt receipt = lookupReceiptById(id);
            int points = calculatePoints.calculatePoints(receipt);

            response.put("points", points);
        } catch (Exception e) {
            throw new CustomException("Please input a valid ID");
        }

        return ResponseEntity.ok(response);
    }

    //This is the helper method to help search the hash table with the id that is given by the user when submitting
    //a get request.
    //If it finds the id, it returns the receipt for that id, if not then it returns null.
    private Receipt lookupReceiptById(String id) {
        if(receiptMap.containsKey(id)){
            return receiptMap.get(id);
        }
        return null;
    }
}
