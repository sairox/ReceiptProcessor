Receipt Processor

PLEASE READ AS IT HAS INSTRUCTIONS FOR HOW TO RUN THE PROJECT

Welcome to the custom receipt processor. This application is created by using Spring Boot framework. The API that 
was created is meant for posting a receipt and getting the total points that the purchase has accumulated.

This project is made with jdk17 and requires you to have Java 17 installed to run it.

How to run this project:
-
- If you have a mac:
  - 
    - Use your terminal and install homebrew if you do not have it already installed using this: /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    - Install maven using this command: *brew install maven*
    - After installing maven go clone the project from github onto your workspace and on the terminal go to the root directory
      of the project and run this command: *mvn clean package*
    - After that run this command to run the spring boot application: *java -jar your-app-name.jar*
    - Then in postman you can run your requests to test this code.
  
- If you have linux:
  -
    - Run this command to update package index: *sudo apt update*
    - Run this to install maven: *sudo apt install maven*
    - Then follow same steps as mac instructions

- If you have windows:
  - 
    - Download the latest Maven binary distribution from the official website: https://maven.apache.org/download.cgi
    - Extract the downloaded archive to a location on your computer.
    - Add the bin directory of the extracted Maven folder to your system's PATH environment variable. For example, if you extracted Maven to C:\apache-maven-3.8.4, you need to add C:\apache-maven-3.8.4\bin to the PATH.
    - Verify the installation by opening Command Prompt and running: *mvn -version*
    - In command prompt go to the root directory of the project.
    - Run *mvn clean install*
    - Once the build is successful, navigate to the "target" directory that was created inside your project folder.
    - Find the generated JAR file with the name ReceiptProcessor-0.0.1-SNAPSHOT.jar.
    - Run *java -jar ReceiptProcessor-0.0.1-SNAPSHOT.jar*
    - Spring boot will start and you can send requests using postman.