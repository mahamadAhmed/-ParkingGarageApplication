package Project;

public class GrageSpec {
    public static  final  double  HourPrice=5;
    private String parkingConfig;
    private int NoSlots;



    public void setNoSlots(int noSlots) {
        NoSlots = noSlots;
    }

    public void setParkingConfig(String parkingConfig) {
        this.parkingConfig = parkingConfig;
    }

    public int getNoSlots() {
        return NoSlots;
    }

    public String getParkingConfig() {
        return parkingConfig;
    }
}
