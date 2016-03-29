package com.twair;

import java.util.Calendar;

public class Flight {
    private String source;
    private String destination;
    private Plane plane;
    private String number;
    private final Integer availableSeats;
    private Calendar departureTime;
    private Calendar arrivalTime;

    public Flight(String number, String source, String destination, Plane plane, Calendar departure, Calendar arrival) throws Exception {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        this.number = number;
        this.availableSeats = plane.getNumberOfSeats();
        setScheduleTime(departure, arrival);
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

    public Calendar getDepartureTime() {
        return departureTime;
    }

    public Calendar getArrivalTime() {
        return arrivalTime;
    }

    private void setScheduleTime(Calendar departureTime, Calendar arrivalTime) throws Exception {
        if(departureTime.after(arrivalTime)) {
            throw new Exception("departure time cannot be greater than arrival time");
        }
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
}
