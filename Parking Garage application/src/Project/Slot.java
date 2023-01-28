package Project;

public class Slot {
    private int slotID;
    private int width;
    private int depth;

    private VehicleSpec container;

    public void setContainer(VehicleSpec container) {
        this.container = container;
    }

    public VehicleSpec getContainer() {
        return container;
    }


    public int getSlotID() {
        return slotID;
    }

    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }

    public void setWidth(int w){this.width=w;}
    public int getWidth(){return this.width;}
    public void setDepth(int d){this.depth=d;}
    public int getDepth(){return this.depth;}
    public void print(){
        System.out.println("Slot : " + this.slotID);
        System.out.println("Depth : " + this.depth);
        System.out.println("Width : " + this.width);
    }


}
