package edu.wctc;

public class UnknownGenderCodeException extends Exception {

    public UnknownGenderCodeException(char genderCode){
        super(String.format("This Gender Code is invalid: %s",genderCode));
    }

}
