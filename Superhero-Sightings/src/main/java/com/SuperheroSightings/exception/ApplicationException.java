package com.SuperheroSightings.exception;

//custom defined exception
//extends RuntimeException - unchecked exception
public class ApplicationException extends RuntimeException {

    //override the default getMessage method
    @Override
    public String getMessage(){
        return "Selected item does not exist.";
    }
}
