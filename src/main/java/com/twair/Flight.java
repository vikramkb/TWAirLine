package com.twair;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flight {
    private String source;
    private String destination;
    private Plane plane;
    private String number;
    private RateFactory rateFactory;
    private final Integer availableSeats;
    private Calendar departureTime;
    private Calendar arrivalTime;
    private Map<ClassType, TravelClass> travelClassMap = new HashMap<>();


    public Flight(String number, String source, String destination, Plane plane, Calendar departure, Calendar arrival, List<TravelClass> travelClasses, RateFactory rateFactory) throws Exception {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        this.number = number;
        this.rateFactory = rateFactory;
        this.availableSeats = plane.getNumberOfSeats();
        setScheduleTime(departure, arrival);
        for(TravelClass travelClass : travelClasses) {
            travelClassMap.put(travelClass.getClassType(), travelClass);
        }
    }

    public boolean canBook(ClassType classType, Integer numberOfSeats) {
        if(travelClassMap.containsKey(classType)) {
            return travelClassMap.get(classType).canBook(numberOfSeats);
        }
        return false;
    }

    /*added temporarily for doing application testing*/
    public void book(ClassType classType, Integer numberOfSeats) throws Exception {
        if(travelClassMap.containsKey(classType)) {
            travelClassMap.get(classType).book(numberOfSeats);
        }
    }

    public Double getBasePrice(ClassType classType) {
        if( travelClassMap.containsKey(classType) ) {
            return travelClassMap.get(classType).getBasePrice() * (1 + rateFactory.getFastFillingRate(travelClassMap.get(classType)).extraBasePriceRatio());
        }
        return 0.0;
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

    public boolean hasClass(ClassType classType) {
        return travelClassMap.containsKey(classType);
    }

    private void setScheduleTime(Calendar departureTime, Calendar arrivalTime) throws Exception {
        if(departureTime.after(arrivalTime)) {
            throw new Exception("departure time cannot be greater than arrival time");
        }
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
}
