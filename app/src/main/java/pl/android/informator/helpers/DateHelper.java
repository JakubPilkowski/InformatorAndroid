package pl.android.informator.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelper {
    public static String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.US);
        Date date = new Date();
        return formatter.format(date);
    }

    private static String getMonth(String date) {
        return date.substring(3, 5);
    }

    static String getHour(String date) {
        return date.substring(11, 13);
    }


    static String getHourToBeginSun(String date) {
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


    static String getHourToEndSun(String date) {
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

    public static String getHour(Date date){
        SimpleDateFormat format = new SimpleDateFormat("hh-mm", Locale.US);
        String formattedDate = format.format(date);
        String firstLetter = formattedDate.substring(0,1);
        String secondLetter = formattedDate.substring(1,2);
        if(firstLetter.equals("0"))
            return secondLetter;
        else
            return firstLetter+secondLetter;
    }

    public static String getMinute(Date date){
        SimpleDateFormat format = new SimpleDateFormat("hh-mm",Locale.US);
        String formattedDate = format.format(date);
        return formattedDate.substring(3,5);
    }
}
