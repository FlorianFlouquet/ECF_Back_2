package com.example.localibback.users;

import com.example.localibback.rentals.RentalService;
import com.example.localibback.vehicles.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Find and return all users from the DB
     * @return
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Create a user in the DB
     * @param entity
     * @return
     */
    public User save(User entity) {
        logger.info("The user has been successfully created : " + entity.toString());
        return userRepository.save(entity);
    }

    /**
     * Find and return a user by his id
     * @param id
     * @return
     */
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    /**
     * Update a user fond by his id
     * @param user
     * @param id
     * @return
     */
    public User update(User user, String id) {
        User userFromDB = this.findById(id);
        if(userFromDB != null) {
            userFromDB.setEmail(user.getEmail());
            userFromDB.setFirstname(user.getFirstname());
            userFromDB.setSurname(user.getSurname());
            userFromDB.setBirthDate(user.getBirthDate());
            userFromDB.setPhoneNumber(user.getPhoneNumber());
        }
        return this.save(userFromDB);
    }

    /**
     * Delete a user from the DB by his id
     * @param id
     */
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    /*
     * Methods for filtering vehicles
     */

    /**
     * Find and return all vehicles with a surname matching the parameter
     * @param surname
     * @return
     */
    public List<User> findBySurname(String surname) {
        return userRepository.findUsersBySurname(surname);
    }

    /**
     * Find and return all vehicles with a firstname matching the parameter
     * @param firstname
     * @return
     */
    public List<User> findByFirstname(String firstname) {
        return userRepository.findUsersByFirstname(firstname);
    }

    /**
     * Delete all users from the database
     */
    public void deleteAll() {
        this.userRepository.deleteAll();
    }

}
