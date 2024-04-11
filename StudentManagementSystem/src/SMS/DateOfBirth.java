package SMS;

import java.io.Serializable;
import java.time.LocalDate;

public class DateOfBirth implements Serializable {
    private int Year;
    private int Month;
    private int Day;

    public DateOfBirth(String dateOfBirth) {
        String[] date = dateOfBirth.split("/");
        Day = Integer.parseInt(date[0]);
        Month = Integer.parseInt(date[1]);
        Year = Integer.parseInt(date[2]);
    }

    public int getAge() {
        String[] Today = LocalDate.now().toString().split("-");
        int year = Integer.parseInt(Today[0]);
        int month = Integer.parseInt(Today[1]);
        int day = Integer.parseInt(Today[2]);

        int age = year - Year;
        if (month >= Month) {
            if (day >= Day) {
                age++;
            }
        }

        age++;

        return age;
    }

    @Override
    public String toString() {
        return this.Day + "/" + this.Month + "/" + this.Year;
    }
}
