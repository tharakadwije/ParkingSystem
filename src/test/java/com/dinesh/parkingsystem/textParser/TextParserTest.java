package com.dinesh.parkingsystem.textParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TextParserTest {
	TextParser textParser = new TextParser();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
    public void setUpOutputStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpOutputStreams() {
        System.setOut(null);
    }
    @Test
    public void createParkingLot() throws Exception {
        textParser.createParkingLot("6");
        assertEquals(6, textParser.lotSize);
        assertEquals(6, textParser.availableSlotList.size());
        assertTrue("createdparkinglotwith6slots".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
    }

    @Test
    public void createParkingDetails() throws Exception {
        textParser.createParkingDetails("KA-01-HH-1234", "White");
        textParser.createParkingDetails("KA-01-HH-9999", "White");
        textParser.createParkingDetails("KA-01-BB-0001", "Black");
        textParser.createParkingDetails("KA-01-HH-7777", "Red");
        textParser.createParkingDetails("KA-01-HH-2701", "Blue");
        textParser.createParkingDetails("KA-01-HH-3141", "Black");
       // assertEquals(0, textParser.availableSlotList.size());
       // assertTrue("Sorry, parking lot is full".equalsIgnoreCase(outContent.toString().trim()));
    }
   
    @Test
    public void createLeave() throws Exception {
        textParser.createLeave("4");
        textParser.createParkingDetails("KA-01-HH-1277", "Red");
        textParser.createLeave("6");
        textParser.createParkingDetails("KA-01-HH-3142", "Black");
       
        //assertEquals(6, textParser.mapDetailSlot.size());
    }

}
