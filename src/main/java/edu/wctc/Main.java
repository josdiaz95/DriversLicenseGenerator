package edu.wctc;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Last Name >> ");
        String lastName = keyboard.nextLine().toUpperCase();
        System.out.print("First Name >> ");
        String firstName = keyboard.nextLine().toUpperCase();
        System.out.print("Middle Initial >> ");
        String middleInitial = keyboard.nextLine().toUpperCase();
        System.out.print("Month of birth (1 - 12) >> ");
        int month = Integer.parseInt(keyboard.nextLine());
        System.out.print("Day of birth (1 - 31) >> ");
        int day = Integer.parseInt(keyboard.nextLine());
        System.out.print("Year of birth (YYYY) >> ");
        int year = Integer.parseInt(keyboard.nextLine());
        System.out.print("Gender (M/F) >> ");
        char genderCode = keyboard.nextLine().toUpperCase().charAt(0);
        try {
            DriversLicense driversLicense = new DriversLicense();
            driversLicense.setSoundexCode(new
                    LastNameUtility().encodeLastName(lastName));
            driversLicense.setFirstNameMiddleInitial(new
                    FirstNameUtility().encodeFirstName(firstName, middleInitial));
            driversLicense.setBirthYear(year);
            driversLicense.setBirthMonthDayGender(new
                    MonthDayGenderUtility().encodeMonthDayGender(year, month, day, genderCode));
            driversLicense.setOverFlow(0);
            System.out.println("Wisconsin: " + new
                    WisconsinFormatter().formatLicenseNumber(driversLicense));
            System.out.println("Florida: " + new
                    FloridaFormatter().formatLicenseNumber(driversLicense));
        } catch (InvalidBirthdayException | MissingNameException |
                 UnknownGenderCodeException e) {
            System.out.println(e.getMessage());
            System.out.println("Invalid input detected. Program will exit.");
        }
    }
}