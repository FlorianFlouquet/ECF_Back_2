package com.example.localibback.rentals;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("rentals")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("")
    public List<Rental> findAll() {
        return rentalService.findAll();
    }

    @PostMapping("")
    public void save(@RequestBody Rental entity) {
        rentalService.save(entity);
    }

    @GetMapping("{id}")
    public Rental findById(@PathVariable String id) {
        return rentalService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        rentalService.deleteById(id);
    }
}
