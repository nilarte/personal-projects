package com.carcompany;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {
    @Test
    public void getMessage() {
        App app = new App();
        assertEquals("Default message is valid", app.getMessage(), "Hello World!");
    }
    
    @Test
    public void getPickupTimeInSec() {
        App app = new App();
        int pickup_time = app.getPickupTimeInSec();
        boolean is_pickup_decent = false;
        if (pickup_time < 10) is_pickup_decent = true;
        assertEquals("Picup time is: " + pickup_time, true , is_pickup_decent);
    }

    @Test
    public void getCoolingTimeInMin() { 
    //Co pilot generated this test case    
        App app = new App();
        int cooling_time = app.getCoolingTimeInMin();
        boolean is_cooling_decent = false;
        if (cooling_time < 5) is_cooling_decent = true;
        assertEquals("Cooling time is: " + cooling_time, true, is_cooling_decent);
    }
    
    
    
    /* 
    @Test
    public void getSoundSystemClarityByFreqency() {
    //Co pilot generated this test case    
        App app = new App();
        int sound_system_clarity_frequency = app.getSoundSystemClarityByFreqency();
        boolean is_sound_system_clarity_decent = false;
        if (sound_system_clarity_frequency > 50) is_sound_system_clarity_decent = true;
        assertEquals("Sound system clarity is: " + sound_system_clarity_frequency, is_sound_system_clarity_decent, true);
    }
    */

    /* Testcase for getPickupTimeInSec method which will return: 
    bad if number is greater than 10, decent if number is between 5 to 10, good if number is less than 5 */
    /* 
    @Test
    public void getPickupTimeInSecTest() {
        App app = new App();
        int pickup_time = app.getPickupTimeInSec();
        String pickup_time_result = "";
        if (pickup_time > 10) pickup_time_result = "bad";
        else if (pickup_time > 5 && pickup_time <= 10) pickup_time_result = "decent";
        else if (pickup_time <= 5) pickup_time_result = "good";
        assertEquals("Pickup time is: " + pickup_time, pickup_time_result, "good");
    }
    */
}
