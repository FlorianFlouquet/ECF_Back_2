package com.example.localibback.vehicles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
    @Id
    private String id;
    private String brand;
    private String model;
    private String state;
    private String licenseNumber;
    private String type;
    private Double price;
    private boolean available;

    public Vehicle(String brand, String model, String state, String licenseNumber, String type, Double price, boolean available) {
        this.brand = brand;
        this.model = model;
        this.state = state;
        this.licenseNumber = licenseNumber;
        this.type = type;
        this.price = price;
        this.available = available;
    }
}
