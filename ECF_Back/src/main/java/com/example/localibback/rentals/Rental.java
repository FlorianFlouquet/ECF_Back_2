package com.example.localibback.rentals;

import com.example.localibback.users.User;
import com.example.localibback.vehicles.Vehicle;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
@Document
@Data
public class Rental {
    @Id
    private String id;
    @DBRef
    private User renter;
    @DBRef
    private Vehicle vehicle;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateStart;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateEnd;

    public Rental(User renter, Vehicle vehicle, LocalDate dateStart, LocalDate dateEnd) {
        this.renter = renter;
        this.vehicle = vehicle;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    /**
     * Calculate the price of the rental according to the duration of the rental and
     * the price of car's price
     * @return
     */
    public double getTotalPrice() {
        Period period = Period.between(this.dateStart, this.dateEnd);
        return period.getDays() * this.getVehicle().getPrice();
    }
}
