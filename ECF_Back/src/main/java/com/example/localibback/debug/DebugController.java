package com.example.localibback.debug;

import com.example.localibback.rentals.Rental;
import com.example.localibback.rentals.RentalService;
import com.example.localibback.users.User;
import com.example.localibback.users.UserService;
import com.example.localibback.vehicles.Vehicle;
import com.example.localibback.vehicles.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("debugg")
public class DebugController {
    private final UserService userService;
    private final RentalService rentalService;
    private final VehicleService vehicleService;

    public DebugController(UserService userService, RentalService rentalService, VehicleService vehicleService) {
        this.userService = userService;
        this.rentalService = rentalService;
        this.vehicleService = vehicleService;
    }

    @DeleteMapping ("clear")
    public void deleteAll() {
       this.userService.deleteAll();
       this.vehicleService.deleteAll();
       this.rentalService.deleteAll();
    }

    /**
     * Initialize the database with 2 users, 2 vehicles and 1 rental
     */
    @PostMapping("init")
    public void generate() {
        User user1 = new User("Lebon", "Jacques", LocalDate.of(1989,5,12), "lebon.jacques@mail.com", "0666666666");
        User user2 = new User("Lemauvais", "Augustin", LocalDate.of(1960,1,30), "lemauvais.augustin.com", "0655555555");
        this.userService.save(user1);
        this.userService.save(user2);

        Vehicle vehicle1 = new Vehicle("Peugeot", "305", "Good", "X55-GFT8-88", "car", 28.00, true);
        Vehicle vehicle2 = new Vehicle("Renault", "Grosse Twingo", "Very good", "98T-GAT1-ZZ", "utility", 40.00, true);
        this.vehicleService.save(vehicle1);
        this.vehicleService.save(vehicle2);

        List<Vehicle> vehicles = this.vehicleService.findAll();
        List<User> users = this.userService.findAll();
        Rental rental = new Rental(users.get(0), vehicles.get(0), LocalDate.of(2022,12,30), LocalDate.of(2023, 01, 20));
        this.rentalService.save(rental);
    }
}
