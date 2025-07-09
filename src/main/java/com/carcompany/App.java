package com.carcompany;
import java.util.Random;


public class App {
    private final String message;

    public App() {
        this.message = "Hello World!";
    }

    public String getMessage() {
        return this.message;
    }
    
    public int getPickupTimeInSec() {
        Random random = new Random();
        int randomNumber = random.nextInt(20) + 1;
        //return randomNumber;
        return 9;
        //return 11;
    }

    public int getCoolingTimeInMin() {
        Random random = new Random();
        int randomNumber = random.nextInt(15) + 1;
        //return randomNumber;
        return 4;
    }

    public int getSoundSystemClarityByFreqency() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        return randomNumber;
    }

    public static void main(String[] args) {
        System.out.println(new App().getMessage());
    }
}
