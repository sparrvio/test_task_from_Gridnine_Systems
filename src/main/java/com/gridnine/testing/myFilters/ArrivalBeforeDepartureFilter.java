package com.gridnine.testing.myFilters;

import com.gridnine.testing.testClasses.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDepartureFilter implements FilterFlight{
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> filteredFlights = flights.stream()
                .filter(flight -> !flight.getSegments().stream()
                        .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
        return filteredFlights;
    }
}
