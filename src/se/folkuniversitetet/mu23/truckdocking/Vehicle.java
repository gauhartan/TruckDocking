package se.folkuniversitetet.mu23.truckdocking;


public class Vehicle {
    private String type;
    private int weight;


    // Constructors


    public Vehicle() {
    }

    public Vehicle(String type) {
        this.type = type;
    }

    public Vehicle(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
