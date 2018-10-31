package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.repository.FlightDb;



/**
 * FlightServiceImpl
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDb flightDb;
    
    @Override
    public FlightModel addFlight(FlightModel flight) {
        return flightDb.save(flight);
    }

    @Override
    public void deleteByFlightNumber(String flightNumber) {
        flightDb.deleteByFlightNumber(flightNumber);
    }

    @Override
    public Optional<FlightModel> getFlightDetailByFlightNumber(String flightNumber) {
        return flightDb.findByFlightNumber(flightNumber);
    }

	@Override
	public Optional<FlightModel> getFlightDetailByFlightId(long flightId) {
		// TODO Auto-generated method stub
		return flightDb.findById(flightId);
	}

	@Override
	public void updateFlight(long flightId, FlightModel flight) {
		// TODO Auto-generated method stub
		flightDb.save(flight);
	}

	@Override
	public void deleteFlight(FlightModel flight) {
		// TODO Auto-generated method stub
		flightDb.delete(flight);

	}

	@Override
	public List<FlightModel> getFlights() {
		// TODO Auto-generated method stub
		return flightDb.findAll();
	}
}