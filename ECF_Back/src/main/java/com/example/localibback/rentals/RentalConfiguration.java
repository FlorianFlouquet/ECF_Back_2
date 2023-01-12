package com.example.localibback.rentals;

import com.example.localibback.vehicles.VehicleRepository;
import com.example.localibback.vehicles.VehicleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RentalConfiguration {
    @Bean
    public RentalService rentalService(RentalRepository rentalRepository, VehicleService vehicleService) {
        return new RentalService(rentalRepository, vehicleService);
    }
}
