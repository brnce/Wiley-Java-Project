
public class Vehicle {
	String colour;
	String name;
	String model;
	int wheels;
	
	
	public Vehicle(String colour, String name, String model, int wheels) {
		//super();
		this.colour = colour;
		this.name = name;
		this.model = model;
		this.wheels = wheels;
	}

	
	public Vehicle() {

    }

	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getWheels() {
		return wheels;
	}


	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	
	public void display() {
        System.out.println("Colour: " + colour);
        System.out.println("Name: " + name);
        System.out.println("Model: " + model);
        System.out.println("Number of Wheels: " + wheels);
    }
	
	
	

}
