
public class Car extends Vehicle {
	public Car() {}

    public String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setCarOwner(String colour, String name, String model, int wheels, String owner) {
        this.owner = owner;
    }

    public void displayVehicleOwner() {
        System.out.println("Owner: " + owner);
    }
}	
