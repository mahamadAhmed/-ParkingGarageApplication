package Project;

import java.util.Scanner;
import java.util.Vector;

public  class Garage {
    /**
     * Attribute vector of Slot object to save all objects slot
     */
    public static Vector<Slot> slot = new Vector<Slot>();
    /**
     * Attribute vector of Slot object to save all objects slot
     */
    public static Vector<VehicleSpec> vehicleSpec = new Vector<VehicleSpec>();
    /**
     * Attribute total income to calculate total income
     */
    public static int totalIncome;

    public static void setTotalIncome(int totalIncome) {
        Garage.totalIncome = totalIncome;
    }

    public static int getTotalIncome() {
        return totalIncome;
    }

    /**
     * Attribute no_slots  to save total number of slot
     */
    private int no_slots =0;
    /**
     * hours price attribute
     * */
    public final int hourPrice =5;

    public static IpickFreeSlot configuration;

    private int no_vehicle=0;

    public void setNo_vehicle(int no_vehicle) {
        this.no_vehicle = no_vehicle;
    }

    public int getNo_vehicle() {
        return no_vehicle;
    }

    private int total_no_vehicle=0;


    public GrageCtrlr ctrlr=new GrageCtrlr();
    Garage(int s){
        this.no_slots =s;
    }
    Garage(){

    }

    /***
     *
     * method to add new vehicle and add to vector
     * */
    public VehicleSpec addVehicle(){//**
        VehicleSpec v=new VehicleSpec();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter identification of vehicleSpec ");
        v.setIdentification(in.nextLine());
        System.out.println("Enter model name of vehicleSpec ");
        v.setModelName(in.nextLine());
        System.out.println("Enter model year of vehicleSpec ");
        v.setModelYear(in.nextLine());
        System.out.println("Enter depth of vehicleSpec ");
        v.setDepth(in.nextInt());
        System.out.println("Enter width of vehicleSpec ");
        v.setWidth(in.nextInt());
        vehicleSpec.add(v);
        no_vehicle++;
        total_no_vehicle++;
        return v;
    }
    /**
     * using to remove vehicle from system
     * */
    public boolean removeVehicle(VehicleSpec v){
        vehicleSpec.remove(v);
        return true;
    }

    /**
     * using to display available parking
     * */
    public void displayAvailableParking(Vector<Slot> slot){//**
        for (int i=0;i<slot.size();i++){
            if (slot.get(i).getContainer()==null)

                slot.get(i).print();
        }
    }
}



