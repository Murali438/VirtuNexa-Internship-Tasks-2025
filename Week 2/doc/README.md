# Armstrong Number Checker

## Description
A Java application that determines if a number is an Armstrong number using CLI or GUI, and stores results in a local SQLite database.

## Features
- Console and GUI interfaces
- Modular design
- SQLite integration
- Input validation and error handling

## How to Compile and Run

### Compile:
```bash
javac -cp ".;lib/sqlite-jdbc.jar" src/*.java -d out

Create Executable JAR:

cd out
jar cfe ArmstrongChecker.jar ArmstrongApp *.class

Run the App:

java -jar ArmstrongChecker.jar

Run GUI:

java -cp ".;lib/sqlite-jdbc.jar" ArmstrongGUI
