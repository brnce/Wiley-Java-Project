
public class Road {
    public static void main(String[] args) {
    	Vehicle myVehicle = new Vehicle("Blue", "Tucson", "Hyundai", 4);
        Car myCar = new Car();
        myCar.setCarOwner("Blue", "Tucson", "Hyundai", 4, "Joe Cool");
        myCar.displayVehicleOwner();
        myVehicle.display();
    }
}

