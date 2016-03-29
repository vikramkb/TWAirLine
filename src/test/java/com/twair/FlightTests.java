package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class FlightTests {
    private String source;
    private String dest;
    private Plane plane;
    private Calendar departure;
    private Calendar arrival;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        dest = "TestDestination";
        plane = new Plane("type", 30);
        departure = new GregorianCalendar(2016,3,10, 9, 10, 0);
        arrival = new GregorianCalendar(2016,3,10, 10, 10, 0);
    }

    @Test
    public void shouldHaveSourceDestination() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival);
        Assert.assertEquals(source, flight.getSource());
        Assert.assertEquals(dest, flight.getDestination());
    }

    @Test
    public void shouldReturnTrueIfNumberOfSeatsCanBeBooked() throws Exception {
        Integer numberOfSeats = 10;
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival);
        Assert.assertTrue(flight.canBook(numberOfSeats));
    }

    @Test
    public void shouldReturnTrueIfNumberOfSetasExactlySameAsAvailableSeats() throws Exception {
        Integer numberOfSeats = 30;
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival);
        Assert.assertTrue(flight.canBook(numberOfSeats));
    }

    @Test
    public void shouldReturnFalseIfNumberOfSetasCanNotBeBooked() throws Exception {
        Integer numberOfSeats = 40;
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival);
        Assert.assertFalse(flight.canBook(numberOfSeats));
    }

    @Test
    public void shouldHaveArrivalAndDeparture() throws Exception {
        Calendar departure = new GregorianCalendar(2016,4,10, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2016,4,10, 11, 10, 0);
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival);
        Assert.assertEquals(departure, flight.getDepartureTime());
        Assert.assertEquals(arrival, flight.getArrivalTime());
    }

    @Test(expected=Exception.class)
    public void DepartureDateCannotBeGreaterOrEqualToArrivalTime() throws Exception {
        Calendar departure = new GregorianCalendar(2016,5,10, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2016,4,10, 11, 10, 0);
        new Flight("F001", source, dest, plane, departure, arrival);
    }
}
