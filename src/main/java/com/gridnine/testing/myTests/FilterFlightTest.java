package com.gridnine.testing.myTests;

import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.FlightBuilder;
import com.gridnine.testing.myFilters.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.myFilters.DepartureBeforeCurrentTimeFilter;
import com.gridnine.testing.myFilters.FilterFlight;
import com.gridnine.testing.myFilters.TransferDurationExceedsTwoHoursFilter;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class FilterFlightTest {
    FilterFlight test;

    List<Flight> testFlights = FlightBuilder.createFlights();

    @Test
    public void ArrivalBeforeDepartureFilterTest() {
        test = new ArrivalBeforeDepartureFilter();
        assertEquals(5, test.filter(testFlights).size());
    }

    @Test
    public void DepartureBeforeCurrentTimeFilterTest()  {
        test = new DepartureBeforeCurrentTimeFilter();
        assertEquals(5, test.filter(testFlights).size());
    }

    @Test
    public void TransferDurationExceedsTwoHoursFilterTest()   {
        test = new TransferDurationExceedsTwoHoursFilter();
        assertEquals(4, test.filter(testFlights).size());
    }
}
