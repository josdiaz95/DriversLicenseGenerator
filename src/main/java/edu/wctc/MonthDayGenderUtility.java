package edu.wctc;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MonthDayGenderUtility {

    private final int MOD_MALE = 0;
    private final int MOD_FEMALE = 500;
    private final char CODE_MALE = 'M';
    private final char CODE_FEMALE = 'F';

    public int encodeMonthDayGender(int year, int month, int day, char genderCode) throws UnknownGenderCodeException,InvalidBirthdayException {

        Date date = null;
        String birthDate = String.format("%s-%s-%s",month,day,year);
        try {
            DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
            formatter.setLenient(false);
            date = formatter.parse(birthDate);
        } catch (ParseException e) {
            throw new InvalidBirthdayException(year,month,day);
        }

        if (!(CODE_MALE == genderCode || CODE_FEMALE == genderCode)) {
            throw new UnknownGenderCodeException(genderCode);
        } else if (genderCode == CODE_FEMALE) {
            return (month - 1) * 40 + day + MOD_FEMALE;
        } else {
            return (month - 1) * 40 + day + MOD_MALE;
        }
    }

}
