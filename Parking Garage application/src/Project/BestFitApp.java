package Project;

public class BestFitApp implements IpickFreeSlot {
private double desiredRatio=10000;

    public void setDesiredRatio(double desiredRatio) {
        this.desiredRatio = desiredRatio;
    }

    public double getDesiredRatio() {
        return desiredRatio;
    }
    public double calcRatio(VehicleSpec vehicleSpec, Slot slot){


        return (vehicleSpec.getWidth() * slot.getDepth()) + (vehicleSpec.getDepth()  * slot.getWidth() );
    }

    @Override
    public Slot pickSlot(VehicleSpec vehicleSpec) {
        int j=0;
        boolean check=false;
        for (int i=0;i<Garage.slot.size();i++) {
            if (vehicleSpec.getDepth() <= Garage.slot.get(i).getDepth() && vehicleSpec.getWidth() <= Garage.slot.get(i).getWidth() && Garage.slot.get(i).getContainer()==null){
                if (calcRatio(vehicleSpec,Garage.slot.get(i))<getDesiredRatio()){
                    j=i;
                    setDesiredRatio(calcRatio(vehicleSpec,Garage.slot.get(i)));
                    check=true;
                }
            }
        }
        if (check){
            Time t=new Time();
            vehicleSpec.vehicle.setArrival_time(t.captureTime(vehicleSpec));
            Garage.slot.get(j).setContainer(vehicleSpec);
            System.out.println("Parking in slot " + (Garage.slot.get(j).getSlotID()) + " successfully! \n");
            setDesiredRatio(1000);
            return  Garage.slot.get(j);
        }


        System.out.println("There is no available slot in parking garage!!\n");
        return null;
    }
}
