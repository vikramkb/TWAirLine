package com.twair;

public class TravelClass {
    private ClassType classType;
    private Integer totalSeats;
    private Integer occupiedSeats;
    private Double basePrice;

    public TravelClass(ClassType classType, Integer totalSeats, Double basePrice) {
        this.classType = classType;
        this.totalSeats = totalSeats;
        this.occupiedSeats = 0;
        this.basePrice = basePrice;
    }

    public void book(int numberOfSeats) throws Exception {
        if(canBook(numberOfSeats) == false) {
            throw new Exception("Booking can not be made");
        }
        occupiedSeats += numberOfSeats;
    }

    public boolean canBook(Integer numberOfSetas) {
        if(occupiedSeats + numberOfSetas > totalSeats) {
            return false;
        }
        return true;
    }

    public ClassType getClassType() {
        return classType;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public Double getOccupencyPercentage() {
        return ((double)occupiedSeats / totalSeats) * 100;
    }
}
