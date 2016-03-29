package com.twair;

public class FastFillingRate {
    private TravelClass travelClass;
    private double[][] percentageBreak;

    public FastFillingRate(TravelClass travelClass) {
        this.travelClass = travelClass;
        percentageBreak = new double[][]{
                { 0, 0 },
                { 40, 0.3 },
                { 90, 0.6 }
        };
    }

    public double extraBasePriceRatio() {
        if(travelClass.getClassType() != ClassType.ECONOMY) {
            return 0.0;
        }
        return getRatio();
    }

    private double getRatio() {
        double ratio = 0;
        for(int i=0; i < percentageBreak.length; i++) {
            if(percentageBreak[i][0] < travelClass.getOccupencyPercentage()) {
                ratio = percentageBreak[i][1];
            }
        }
        return ratio;
    }
}
