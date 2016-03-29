package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriceTests {
    private int numberOfSeats;
    private Flight flight = mock(Flight.class);
    private String source;
    private List<Flight> flightList;

    @Before
    public void setUp() throws Exception {
        numberOfSeats = 5;
        source = "TestSource";
        String destination = "TestDestination";
        flightList = new ArrayList<>();
        flightList.add(flight);
    }

    @Test
    public void shouldGiveTotalPriceForNumberOfSeats() throws Exception {
        Price price = new Price();
        when(flight.getBasePrice(ClassType.ECONOMY)).thenReturn(6000.0);
        Double totalCost = price.calculate(flight, ClassType.ECONOMY, numberOfSeats);
        Assert.assertEquals(30000.0, totalCost, 0.01);
    }

    @Test
    public void shouldCalculatePriceForListOfFlights() throws Exception {
        Price price = new Price();
        when(flight.getBasePrice(ClassType.ECONOMY)).thenReturn(6000.0);
        when(flight.getNumber()).thenReturn("F001");
        Map<String, Double> priceMap = price.calculate(flightList, ClassType.ECONOMY, numberOfSeats);
        Assert.assertEquals(30000.0, priceMap.get("F001"), 0.01);
    }
}
