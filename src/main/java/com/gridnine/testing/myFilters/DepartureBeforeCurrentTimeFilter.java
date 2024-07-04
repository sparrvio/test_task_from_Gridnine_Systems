package com.gridnine.testing.myFilters;

import com.gridnine.testing.testClasses.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureBeforeCurrentTimeFilter implements FilterFlight{
    @Override
    public List<Flight> filter(List<Flight> flights) {

        List<Flight> filteredFlights = flights.stream()
                .filter(flight -> !flight.getSegments().stream()
                        .anyMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now())))
                .collect(Collectors.toList());

        return filteredFlights;
    }
}
