package com.example.localibback.vehicles;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    public List<Vehicle> findVehiclesByType(String type);

    public List<Vehicle> findVehiclesByAvailable(boolean bool);

    public List<Vehicle> findVehiclesByBrand(String brand);
    public List<Vehicle> findVehiclesByModel(String model);
}
