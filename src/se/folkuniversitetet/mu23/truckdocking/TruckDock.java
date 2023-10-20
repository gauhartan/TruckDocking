package se.folkuniversitetet.mu23.truckdocking;

import java.util.HashMap;

public class TruckDock {
    private static final HashMap<String, Vehicle> parkedVehicles = new HashMap<>();

    public static void parkVehicle(String dock, Vehicle vehicle) {
        parkedVehicles.put(dock, vehicle);
    }

    public static boolean isDockEmpty(String dock) {
        return parkedVehicles.get(dock) == null;
    }

    public static HashMap<String, Vehicle> getParkedVehicles() {
        return parkedVehicles;
    }

}
