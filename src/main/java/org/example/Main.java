package org.example;

public class Main {
    public static void main(String[] args) {
        DatabaseDriver driver = DatabaseDriver.getInstance();
        driver.getObraty();
        driver.insertObraty();
        driver.getObraty();
        driver.updateObraty();
        driver.getObraty();
        driver.deleteObraty();
        driver.getObraty();
    }
}