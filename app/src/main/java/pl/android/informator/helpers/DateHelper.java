package pl.android.informator.helpers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getDate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return myDateObj.format(myFormatObj);
    }

    public static String getMonth(String date) {
        return date.substring(3, 5);
    }

    public static String getHour(String date) {
        return date.substring(11, 13);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getHourToBeginSun() {
        switch (getMonth(getDate())) {
            case "01":
                return "08";
            case "02":
                return "07";
            case "03":
                return "06";
            case "04":
                return "06";
            case "05":
                return "05";
            case "06":
                return "04";
            case "07":
                return "04";
            case "08":
                return "05";
            case "09":
                return "05";
            case "10":
                return "06";
            case "11":
                return "06";
            case "12":
                return "07";
        }
        return "12";
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getHourToBeginSun(String date) {
        switch (getMonth(date)) {
            case "01":
                return "08";
            case "02":
                return "07";
            case "03":
                return "06";
            case "04":
                return "06";
            case "05":
                return "05";
            case "06":
                return "04";
            case "07":
                return "04";
            case "08":
                return "05";
            case "09":
                return "05";
            case "10":
                return "06";
            case "11":
                return "06";
            case "12":
                return "07";
        }
        return "12";
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getHourToEndSun() {
        switch (getMonth(getDate())) {
            case "01":
                return "16";
            case "02":
                return "17";
            case "03":
                return "17";
            case "04":
                return "19";
            case "05":
                return "20";
            case "06":
                return "21";
            case "07":
                return "21";
            case "08":
                return "21";
            case "09":
                return "19";
            case "10":
                return "18";
            case "11":
                return "17";
            case "12":
                return "16";
        }
        return "18";
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getHourToEndSun(String date) {
        switch (getMonth(date)) {
            case "01":
                return "16";
            case "02":
                return "17";
            case "03":
                return "17";
            case "04":
                return "19";
            case "05":
                return "20";
            case "06":
                return "21";
            case "07":
                return "21";
            case "08":
                return "21";
            case "09":
                return "19";
            case "10":
                return "18";
            case "11":
                return "17";
            case "12":
                return "16";
        }
        return "18";
    }

    public static String getPolishFormatDate(String date) {
        String[] split = date.split(" ");
        String actualMonthName = split[0];
        String newMonthName = null;
        switch (actualMonthName) {
            case "January":
                newMonthName = "Styczeń ";
                break;
            case "February":
                newMonthName = "Luty ";
                break;
            case "March":
                newMonthName = "Marzec ";
                break;
            case "April":
                newMonthName = "Kwiecień ";
                break;
            case "May":
                newMonthName = "Maj ";
                break;
            case "June":
                newMonthName = "Czerwiec ";
                break;
            case "July":
                newMonthName = "Lipiec ";
                break;
            case "August":
                newMonthName = "Sierpień ";
                break;
            case "September":
                newMonthName = "Wrzesień ";
                break;
            case "October":
                newMonthName = "Październik ";
                break;
            case "November":
                newMonthName = "Listopad ";
                break;
            case "December":
                newMonthName = "Grudzień ";
                break;
        }
        return newMonthName + split[1];
    }

    public static String getDay(String date) {
        String[] dates = date.split("-");
        String day;
        if (dates[2].startsWith("0")) {
            day = dates[2].substring(1, 2);
        }
        else {
            day = dates[2];
        }
        return day;
    }

    public static String getMonthAndYear(String date) {
        String[] dates = date.split("-");
        String month = "";
        switch (dates[1]) {
            case "01":
                month = "Styczeń ";
                break;
            case "02":
                month = "Luty ";
                break;
            case "03":
                month = "Marzec ";
                break;
            case "04":
                month = "Kwiecień ";
                break;
            case "05":
                month = "Maj ";
                break;
            case "06":
                month = "Czerwiec ";
                break;
            case "07":
                month = "Lipiec ";
                break;
            case "08":
                month = "Sierpień ";
                break;
            case "09":
                month = "Wrzesień ";
                break;
            case "10":
                month = "Październik ";
                break;
            case "11":
                month = "Listopad ";
                break;
            case "12":
                month = "Grudzień ";
                break;
        }
        return month + dates[0];
    }
}
