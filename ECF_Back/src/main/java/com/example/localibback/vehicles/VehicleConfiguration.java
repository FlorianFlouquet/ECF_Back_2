package com.example.localibback.vehicles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleConfiguration {
    @Bean
    public VehicleService vehiculeService(VehicleRepository vehicleRepository) {
        return new VehicleService(vehicleRepository);
    }
}
