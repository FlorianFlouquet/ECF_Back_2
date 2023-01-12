package com.example.localibback.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("")
    public User save(@RequestBody User entity) {
        return userService.save(entity);
    }

    @GetMapping("{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteById(id);
    }

    @PutMapping("{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        return userService.update(user, id);
    }

    /**
     * Method to search specific users by their surname or firstname
     * @param firstname
     * @param surname
     * @return
     */
    @GetMapping("search")
    public List<User> filter(
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String surname
    ) {
        if(firstname != null) {
            return userService.findByFirstname(firstname);
        } else if (surname != null) {
            return userService.findBySurname(surname);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
