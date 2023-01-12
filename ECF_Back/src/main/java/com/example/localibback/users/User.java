package com.example.localibback.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class User {
    @Id
    private String id;
    private String surname;
    private String firstname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;

    public User(String surname, String firstname, LocalDate birthDate, String email, String phoneNumber) {
        this.surname = surname;
        this.firstname = firstname;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Transient
    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}
