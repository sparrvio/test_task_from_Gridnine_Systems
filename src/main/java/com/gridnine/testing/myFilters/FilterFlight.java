package com.gridnine.testing.myFilters;

import com.gridnine.testing.testClasses.Flight;

import java.util.List;

public interface FilterFlight {
    List<Flight> filter(List<Flight> flights);
}
