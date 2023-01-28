package Project;

import java.text.ParseException;
import java.util.Scanner;
import java.util.Vector;

public class GrageCtrlr {

    public boolean parkIn(VehicleSpec v, IpickFreeSlot con){
        if (con.pickSlot(v)!=null)
        return true;

        return false;
    }
    public boolean parkOut(VehicleSpec vehicleSpec){
        Time t=new Time();
        vehicleSpec.vehicle.setDeparture_time(t.captureTime(vehicleSpec));
        Calculator c=new HourlyRate();

        Garage g=new Garage();

        try {
            for (int i=0;i<Garage.slot.size();i++){
                if (Garage.slot.get(i).getContainer()== vehicleSpec){
                    Garage.slot.get(i).setContainer(null);
                    System.out.println("You spend: "+t.stayInTime(vehicleSpec));
                    System.out.println("Total fees "+c.calcFees(vehicleSpec)+" EGP");
                    int no_vehicle=g.getNo_vehicle();
                    no_vehicle--;
                    g.setNo_vehicle(no_vehicle);
                    return true;
                }
            }
            return  false;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * method return available slot
     *
     * */
    public Vector<Slot> availableSlots(){
        Vector<Slot> s=new Vector<>();
        for (int i=0;i<Garage.slot.size();i++){
            if (Garage.slot.get(i).getContainer()==null)
                s.add(Garage.slot.get(i));
        }
        return s;
    }

public boolean changeParkingConfig(){
     GrageSpec space=new GrageSpec();
    while (true) {

        Scanner in = new Scanner(System.in);
        System.out.println("which type of slot configuration do you want to choose?:");
        System.out.println("1- first come first served slots");
        System.out.println("2- best-fit approach");
        System.out.println(" Enter 3 if you want to now more info abut configuration type");
        int x;
        x = in.nextInt();
        if (x == 1) {
            space.setParkingConfig("firstCome");
            Garage.configuration=new FristComeAPP();

            break;
        } else if (x == 2) {
            space.setParkingConfig("bestFit");
            Garage.configuration=new BestFitApp();

            break;
        } else if (x == 3) {
            System.out.println("1- first come first served slots:the system will use the first free slot available from the parking garage slots.");
            System.out.println("2-best-fit best-fit approach where you need to find the slot with the minimum dimension to hold the vehicleSpec");

        } else {
            System.out.println("Wrong input");
        }
    }


        return true;
}

}
