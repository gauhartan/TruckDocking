package se.folkuniversitetet.mu23.truckdocking;

import java.util.Scanner;

public class MainHandler {
    public static void start() {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            PrintHandler.showMainMenu();
            int operation = scanner.nextInt();

            PrintHandler.showUserInput(operation);

            if (operation == 1) {
                PrintHandler.showParkedVehicles(TruckDock.getParkedVehicles());
            } else if (operation == 2) {
                PrintHandler.showVehicleTypeMenu();
                int vehicleTypeId = scanner.nextInt();
                PrintHandler.showUserInput(vehicleTypeId);

                String vehicleType = getVehicleTypeById(vehicleTypeId);
                PrintHandler.showVehicleWeightMenu(vehicleType);
                int vehicleWeight = scanner.nextInt();
                Vehicle newVehicle = new Vehicle(vehicleType, vehicleWeight);
                chooseTruckDock(newVehicle);
            } else if (operation == 3) {
                exit = true;
            }
        }
    }

    private static String getVehicleTypeById(int vehicleType) {
        switch (vehicleType) {
            case 1:
                return "Skåpbil";
            case 2:
                return "Lätt lastbil";
            case 3:
                return "Tung lastbil";
            default:
                System.out.println("Looking forward to the number not bigger than 3");
        }
        return null;
    }

    private static void chooseTruckDock(Vehicle vehicle) {
        String type = vehicle.getType();
        int weight = vehicle.getWeight();
        String dock = null;
        //boolean done = true;

        if (type.equalsIgnoreCase("skåpbil")) {
            if (TruckDock.isDockEmpty("A")) {
                TruckDock.parkVehicle("A", vehicle);
                PrintHandler.showDockingConfirmation("A");
            } else if (TruckDock.isDockEmpty("B")) {
                TruckDock.parkVehicle("B", vehicle);
                PrintHandler.showDockingConfirmation("B");
            } else {
                PrintHandler.showParkingIsFull();
            }
        } else if (type.equalsIgnoreCase("lätt lastbil")) {
            if (TruckDock.isDockEmpty("A") && (weight < 5000)) {
                TruckDock.parkVehicle("A", vehicle);
                PrintHandler.showDockingConfirmation("A");
            } else if (TruckDock.isDockEmpty("C")) {
                TruckDock.parkVehicle("C", vehicle);
                PrintHandler.showDockingConfirmation("C");
            } else if (TruckDock.isDockEmpty("D")) {
                TruckDock.parkVehicle("D", vehicle);
                PrintHandler.showDockingConfirmation("D");
            } else {
                PrintHandler.showParkingIsFull();
            }
        } else if (type.equalsIgnoreCase("tung lastbil")) {
            if (TruckDock.isDockEmpty("D") && (weight < 9000)) {
                TruckDock.parkVehicle("D", vehicle);
                PrintHandler.showDockingConfirmation("D");
            } else if (TruckDock.isDockEmpty("E")) {
                TruckDock.parkVehicle("E", vehicle);
                PrintHandler.showDockingConfirmation("E");
            } else {
                PrintHandler.showParkingIsFull();
            }
        }

    }
}
