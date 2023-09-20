package com.SuperheroSightings.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

//making use of Lombok
@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code
public class ErrorDto {

    private String errorMessage;
    private HttpStatus errorCode;
    private LocalDateTime errorDateTime;
}
