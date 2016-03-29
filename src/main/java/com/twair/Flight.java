package com.twair;

public class Flight {
    private String source;
    private String destination;
    private Plane plane;
    private String number;
    private final Integer availableSeats;

    public Flight(String number, String source, String destination, Plane plane) throws Exception {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        this.number = number;
        this.availableSeats = plane.getNumberOfSeats();
    }

    public boolean canBook(Integer numberOfSeats) {
        return this.availableSeats - numberOfSeats >= 0;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getNumber() {
        return number;
    }
}
