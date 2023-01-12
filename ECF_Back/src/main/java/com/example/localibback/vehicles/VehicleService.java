package com.example.localibback.vehicles;

import com.example.localibback.users.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final Logger logger = LoggerFactory.getLogger(VehicleService.class);

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /*
     * Basic CRUD methods
     */

    /**
     * Seek all vehicles from the database
     * @return
     */
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    /**
     * Save a vehicle in the database
     * @param entity
     * @return
     */
    public Vehicle save(Vehicle entity) {
        logger.info("The vehicle has been successfully created : " + entity.toString());
        return vehicleRepository.save(entity);
    }

    /**
     * Find a vehicle in the database by its id, and return it
     * @param id
     * @return
     */
    public Vehicle findById(String id) {
        return vehicleRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    /**
     * Delete a vehicle from the database
     * @param id
     */
    public void deleteById(String id) {
        vehicleRepository.deleteById(id);
    }

    /**
     * Delete all vehicles from the database
     */
    public void deleteAll() {
        this.vehicleRepository.deleteAll();
    }

    /**
     * Update a vehicle
     * @param vehicle
     * @param id
     * @return
     */
    public Vehicle update(Vehicle vehicle, String id) {
        Vehicle vehicleFromDB = this.findById(id);
        if(vehicleFromDB != null) {
            vehicleFromDB.setAvailable(vehicle.isAvailable());
            vehicleFromDB.setBrand(vehicle.getBrand());
            vehicleFromDB.setModel(vehicle.getModel());
            vehicleFromDB.setPrice(vehicle.getPrice());
            vehicleFromDB.setState(vehicle.getState());
            vehicleFromDB.setType(vehicle.getType());
        }
        return this.save(vehicleFromDB);
    }

    /*
     * Methods for filtering vehicles
     */

    /**
     * Find and return all vehicles with a type matching the parameter
     * @param type
     * @return
     */
    public List<Vehicle> findByType(String type) {
        return this.vehicleRepository.findVehiclesByType(type);
    }

    /**
     * Find and return all vehicles with an availabilty matching the parameter
     * @param bool
     * @return
     */
    public List<Vehicle> findByAvailability(Boolean bool) {
        return this.vehicleRepository.findVehiclesByAvailable(bool);
    }

    /**
     * Find and return all vehicles with a brand matching the parameter
     * @param brand
     * @return
     */
    public List<Vehicle> findByBrand(String brand) {
        return this.vehicleRepository.findVehiclesByBrand(brand);
    }

    /**
     * Find and return all vehicles with a model matching the parameter
     * @param model
     * @return
     */
    public List<Vehicle> findByModel(String model) {
        return this.vehicleRepository.findVehiclesByModel(model);
    }
}
