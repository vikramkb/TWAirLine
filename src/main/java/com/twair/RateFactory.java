package com.twair;

public class RateFactory {
    public FastFillingRate getFastFillingRate(TravelClass travelClass) {
        return new FastFillingRate(travelClass);
    }
}
