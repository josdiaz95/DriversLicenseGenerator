package edu.wctc;

public class MissingNameException extends Exception {

    public   MissingNameException(String nameType){
         super(String.format("First and/or Last name,can not be blank."));
    };
}
