package com.gridnine.testing.myFilters;

import com.gridnine.testing.testClasses.Flight;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransferDurationExceedsTwoHoursFilter implements FilterFlight{
    public static final int MAX_DURATION_SECONDS = 7200;
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();

        for(Flight flight  : flights){
            long totalTimeInFlyingInSeconds = flight.getSegments().stream()
                    .mapToLong(segment  -> Duration.between(segment.getDepartureDate(), segment.getArrivalDate()).toSeconds())
                    .sum();
            LocalDateTime departureFirstSegment = flight.getSegments().get(0).getDepartureDate();
            LocalDateTime arrivalsLastSegment  = flight.getSegments().get(flight.getSegments().size()-1).getArrivalDate();
            long totalTimeInSeconds = Duration.between(departureFirstSegment, arrivalsLastSegment).toSeconds();

            if(totalTimeInSeconds - totalTimeInFlyingInSeconds <= MAX_DURATION_SECONDS){
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}

