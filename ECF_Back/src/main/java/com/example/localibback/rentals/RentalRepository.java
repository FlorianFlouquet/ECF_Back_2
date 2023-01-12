package com.example.localibback.rentals;

import com.example.localibback.vehicles.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends MongoRepository<Rental, String> {
    public List<Rental> findRentalsByVehicleId(String id);
}
