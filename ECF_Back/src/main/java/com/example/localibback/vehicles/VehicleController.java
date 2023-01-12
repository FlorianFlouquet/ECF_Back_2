package com.example.localibback.vehicles;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("vehicles")
@CrossOrigin
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("")
    public List<Vehicle> findAll() {
        return vehicleService.findAll();
    }

    @PostMapping("")
    public Vehicle save(@RequestBody Vehicle entity) {
        return vehicleService.save(entity);
    }

    @GetMapping("{id}")
    public Vehicle findById(@PathVariable String id) {
        return vehicleService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        vehicleService.deleteById(id);
    }

    @PutMapping("{id}")
    public Vehicle updateVehicle(@PathVariable String id, @RequestBody Vehicle vehicle) {
        return vehicleService.update(vehicle, id);
    }

    /**
     * Method to search specific vehicles by their types, availability, models or brand
     * @param type
     * @param available
     * @return
     */
    @GetMapping("search")
    public List<Vehicle> filter(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Boolean available,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model
    ) {
        if(type != null) {
            return vehicleService.findByType(type);
        } else if (available != null) {
            return vehicleService.findByAvailability(available);
        } else if (brand != null) {
            return vehicleService.findByBrand(brand);
        } else if (model != null) {
            return vehicleService.findByModel(model);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
