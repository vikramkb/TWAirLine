package com.twair;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FastFillingRateTests {
    private TravelClass travelClass = mock(TravelClass.class);

    @Test
    public void shouldReturnZeroIfTheClassTypeIsOtherThanEconomy() throws Exception {
        when(travelClass.getClassType()).thenReturn(ClassType.BUSINESS);
        FastFillingRate fastFillingRate = new FastFillingRate(travelClass);
        Assert.assertEquals(0.0, fastFillingRate.extraBasePriceRatio(), 0.0001);
    }

    @Test
    public void shouldReturnExtraRatioOnBasePriceBecauseOfFastOccupency() throws Exception {
        when(travelClass.getClassType()).thenReturn(ClassType.ECONOMY);
        when(travelClass.getOccupencyPercentage()).thenReturn(60.0);
        FastFillingRate fastFillingRate = new FastFillingRate(travelClass);
        Assert.assertEquals(0.3, fastFillingRate.extraBasePriceRatio(), 0.0001);
    }
}
