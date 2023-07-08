package edu.wctc;

public class InvalidBirthdayException extends Exception {

 public InvalidBirthdayException(int year, int month , int day){
     super(String.format("This date is invalid: %s/%s/%s",month,day,year));
 }

}
