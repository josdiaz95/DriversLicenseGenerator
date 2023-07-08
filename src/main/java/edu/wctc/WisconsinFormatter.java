package edu.wctc;

public class WisconsinFormatter implements DriversLicenseFormatter {
    @Override
    public String formatLicenseNumber(DriversLicense driversLicense){
        String soundexCode = driversLicense.getSoundexCode();

        String firstNameMidInit= String.valueOf(driversLicense.getFirstNameMiddleInitial());

        int birthYear = driversLicense.getBirthYear();
        String newBirthYear = String.valueOf(birthYear);

        int birthMonDayGen= driversLicense.getBirthMonthDayGender();

        int over = driversLicense.getOverFlow();

         if (firstNameMidInit.length()< 3){
            firstNameMidInit = String.format("%3s",firstNameMidInit).replace(" ","0");
         }

        return soundexCode + "-" + firstNameMidInit + newBirthYear.charAt(2) + "-" + newBirthYear.charAt(3) + birthMonDayGen + "-" + over;
    }
}
