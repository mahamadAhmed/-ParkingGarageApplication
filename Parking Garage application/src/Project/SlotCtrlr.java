package Project;

public class SlotCtrlr {
    public boolean getIn(Slot s , VehicleSpec v){
        if (isEmpty(s)){
            if(fit(s,v)){
                return true;
            }
            return false;
        }
        return false;
    }
    public boolean getOuttIn(Slot s){
        if ( isEmpty(s)) {
            s.setContainer(null);
            return true;
        }
        return false ;
    }
    public boolean fit(Slot s ,VehicleSpec v){
        if (s.getWidth()== v.getWidth()&&v.getDepth()==s.getDepth())
            return true;

        return false;

    }
    public boolean isEmpty(Slot s){
        return (s.getContainer()==null);
    }
}