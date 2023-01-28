package Project;

import java.util.Date;

public class Vehicle {

    private Date arrival_time ;
    private Date departure_time;

    public void setDeparture_time(Date x) {

        this.departure_time =x;
    }
    public void setArrival_time(Date x) {

        this.arrival_time =x;
    }
    public Date getArrival_time() {
        return arrival_time;
    }

    public Date getDeparture_time() {
        return departure_time;
    }


}
