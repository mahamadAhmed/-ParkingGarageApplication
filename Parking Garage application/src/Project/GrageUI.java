package Project;

import java.util.Objects;
import java.util.Scanner;

public class GrageUI {
    private Garage g=new Garage();
    /**
     * Main method which control every thing Display menu to make user choose
     */
    public void mainMethod() {

        Scanner o = new Scanner(System.in);
        System.out.println("Hello Welcome to Parking Garage application");
        System.out.println("Please enter how many slot do you have in Garage: ");
        int no_slots;
        no_slots = o.nextInt();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < no_slots; i++) {
            Slot object = new Slot();
            object.setSlotID(i+1);
            System.out.println("Slot "+object.getSlotID());
            System.out.println("Enter width of slot:");
            object.setWidth(in.nextInt());
            System.out.println("Enter depth of slot:");
            object.setDepth(in.nextInt());
            object.setSlotID(i+1);
            Garage.slot.add(object);
        }
        g.ctrlr.changeParkingConfig();

        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.println("1-park In vehicle");
            System.out.println("2-park out vehicle");
            System.out.println("3-Display the available parking slots ");
            System.out.println("4-change Parking configuration");
            System.out.println("5-Total income");
            System.out.println("6-Exit");


            int x;
            x = input.nextInt();
            Scanner inn = new Scanner(System.in);
            if (x == 1) {
                int y;
                System.out.println("Did you want to add new vehicle or there is old vehicle?");
                System.out.println("1-add new vehicle ");
                System.out.println("2-there is old vehicle ");
                y = input.nextInt();
                if (y == 1) {
                    g.ctrlr.parkIn( g.addVehicle(),g.configuration);
                } else if (y == 2) {

                    System.out.println("Enter Identification of vehicle to park in");
                    String n = inn.nextLine();

                    boolean check = false;
                    for (int i = 0; i < g.vehicleSpec.size(); i++) {
                        if (Objects.equals(g.vehicleSpec.get(i).getIdentification(), n)) {
                            g.ctrlr.parkIn(g.vehicleSpec.get(i), g.configuration);
                            check = true;
                            break;
                        }
                    }
                    if (!check) {
                        System.out.println("Failed to find this identification");
                        int m;
                        System.out.println("Did you want to add new vehicleSpec?");
                        System.out.println("1-YES ");
                        System.out.println("2-NO ");
                        m = input.nextInt();
                    }
                }


            } else if (x == 2) {
                Scanner innn = new Scanner(System.in);
                System.out.println("Enter Identification of vehicleSpec to park in");
                String n= innn.nextLine();
                boolean check=false;
                for (int i = 0; i< g.vehicleSpec.size(); i++){
                    if (Objects.equals(g.vehicleSpec.get(i).getIdentification(), n)){
                        for (int j=0;j<g.slot.size();j++){
                            if (g.slot.get(j).getContainer()== g.vehicleSpec.get(i)){

                                g.ctrlr.parkOut(g.vehicleSpec.get(i));
                                check=true;
                                break;
                            }
                        }
                        break;
                    }
                }
                if (!check)
                    System.out.println("Failed to find this identification");
            }
            else if (x == 3) {
                g.displayAvailableParking(g.slot);
            }
            else if (x == 4) {
                g.ctrlr.changeParkingConfig();
            }
            else if (x == 5) {
                System.out.println("Total income : " + g.totalIncome +" EGP");
            }
            else if (x == 6) {
                int n;
                System.out.println("Are you sure?");
                System.out.println("if you exit for application you will lost all data!!");
                System.out.println("1-Exit any way ");
                System.out.println("2-cancel ");
                n=input.nextInt();
                if (n==1){
                    System.out.println("Thank you for using this application");
                    break;}
                else if(n==2)
                    continue;
                else
                    System.out.println("Wrong input");
            }
            else {
                System.out.println("Wrong input");
            }
        }
    }


}
