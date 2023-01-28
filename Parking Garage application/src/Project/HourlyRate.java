package Project;

import java.text.ParseException;

public class HourlyRate implements Calculator{
    @Override
    /**
     * method calculet fees
     */
    public double calcFees(VehicleSpec vehicleSpec) throws ParseException {
        Time t=new Time();
        int x=t.TotalRunTime(vehicleSpec);
        Garage.totalIncome +=GrageSpec.HourPrice*x;
        return GrageSpec.HourPrice*x;
    }

}
