package Project;

public class FristComeAPP implements IpickFreeSlot{
    @Override
    public Slot pickSlot(VehicleSpec vehicleSpec) {
        for (int i = 0; i < Garage.slot.size(); i++) {
            Time t=new Time();
            if (vehicleSpec.getDepth() <= Garage.slot.get(i).getDepth() && vehicleSpec.getWidth() <= Garage.slot.get(i).getWidth() && Garage.slot.get(i).getContainer()==null) {
                vehicleSpec.vehicle.setArrival_time(t.captureTime(vehicleSpec));
                Garage.slot.get(i).setContainer(vehicleSpec);
                System.out.println("Parking in slot " + (Garage.slot.get(i).getSlotID()) + " successfully! \n");
                return  Garage.slot.get(i);
            }
        }
        System.out.println("There is no available slot in parking garage!!\n");
        return null;
    }
}
