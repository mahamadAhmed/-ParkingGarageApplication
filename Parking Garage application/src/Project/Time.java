package Project;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Time {
    public Date captureTime(VehicleSpec v){
        Date x= Calendar.getInstance().getTime();
        return x;
    }
    public int TotalRunTime(VehicleSpec v) throws ParseException {

        Date startTime=v.vehicle.getArrival_time();
        Date endTime=v.vehicle.getDeparture_time();
        long difference = endTime.getTime() - startTime.getTime();

        long differenceSeconds = difference / 1000 % 60;
        long differenceMinutes = difference / (60 * 1000) % 60;
        long differenceHours = difference / (60 * 60 * 1000) % 24;
        long differenceDays = difference / (24 * 60 * 60 * 1000);
        int hours= (int) (differenceHours);
        int minutes= (int) (differenceMinutes);
        int seconds= (int) (differenceSeconds);
        if (minutes>0||seconds>0)
            hours++;

        return hours;
    }
    public String stayInTime(VehicleSpec v){


        Date startTime=v.vehicle.getArrival_time();
        Date endTime=v.vehicle.getDeparture_time();
        long difference = endTime.getTime() - startTime.getTime();

        long differenceSeconds = difference / 1000 % 60;
        long differenceMinutes = difference / (60 * 1000) % 60;
        long differenceHours = difference / (60 * 60 * 1000) % 24;
        long differenceDays = difference / (24 * 60 * 60 * 1000);
        int hours= (int) (differenceHours);
        int minutes= (int) (differenceMinutes);
        int seconds= (int) (differenceSeconds);
        String s=hours+":"+minutes+":"+seconds;

        return s;
    }
}
