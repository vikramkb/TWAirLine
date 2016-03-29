package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlightTests {
    private String source;
    private String dest;
    private Plane plane;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        dest = "TestDestination";
        plane = new Plane("type", 30);
    }

    @Test
    public void shouldHaveSourceDestination() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane);
        Assert.assertEquals(source, flight.getSource());
        Assert.assertEquals(dest, flight.getDestination());
    }

    @Test
    public void shouldReturnTrueIfNumberOfSetasCanBeBooked() throws Exception {
        Integer numberOfSeats = 10;
        Flight flight = new Flight("F001", source, dest, plane);
        Assert.assertTrue(flight.canBook(numberOfSeats));
    }

    @Test
    public void shouldReturnTrueIfNumberOfSetasExactlySameAsAvailableSeats() throws Exception {
        Integer numberOfSeats = 30;
        Flight flight = new Flight("F001", source, dest, plane);
        Assert.assertTrue(flight.canBook(numberOfSeats));
    }

    @Test
    public void shouldReturnFalseIfNumberOfSetasCanNotBeBooked() throws Exception {
        Integer numberOfSeats = 40;
        Flight flight = new Flight("F001", source, dest, plane);
        Assert.assertFalse(flight.canBook(numberOfSeats));
    }

}
