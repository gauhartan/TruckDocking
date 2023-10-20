package se.folkuniversitetet.mu23.truckdocking;

import java.util.HashMap;
import java.util.Map;

public class PrintHandler {
    public static void showMainMenu() {
        System.out.println("==========================");
        System.out.println(" – Avlastningsstationen dumpa mera –\n" +
                "        1. Se parkerade lastbilar\n" +
                "        2. Registrera ny avlastande lastbil\n" +
                "        3. Avsluta\n");
    }

    public static void showUserInput(int userInput) {
        System.out.println("==========================");
        System.out.println("Välj från listan: " + userInput);
    }

    public static void showVehicleTypeMenu() {
        System.out.println("==========================");
        System.out.println("Typ av lastbil:\n" +
                "1. Skåpbil\n" +
                "2. Lätt lastbil\n" +
                "3. Tung lastbil\n");
    }

    public static void showVehicleWeightMenu(String vehicleType) {
        System.out.println("==========================");
        System.out.print("Vikt på " + vehicleType + ": ");
    }

    public static void showDockingConfirmation(String dock) {
        System.out.println("==========================");
        System.out.println("Lastbil registrerad för kaj " + dock);
    }

    public static void showParkingIsFull() {
        System.out.println("==========================");
        System.out.println("Tyvärr är det fullt, hänvisa förare till stationen dumpa mest!");
    }

    public static void showParkedVehicles(HashMap<String, Vehicle> parkedVehicles) {
        System.out.println("==========================");
        for (Map.Entry<String, Vehicle> entry : parkedVehicles.entrySet()) {
            String dock = entry.getKey();
            Vehicle vehicle = entry.getValue();
            System.out.println(dock + " - " + vehicle.getType() + " [" + vehicle.getWeight() + "kg]");
        }
    }
}
