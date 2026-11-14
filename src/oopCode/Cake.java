package oopCode;

public class Cake {

	// Superclass: Cake

	private  String name;
	private double price;

	// Constructor (Cake class)
	public Cake(String name, double price) {
		this.name = name;
		this.price = price;
	}

	// Getter for name
    public String getName() {
        return name;
    }


    // Getter for price
    public double getPrice() {
        return price;
    }

	// Method to return cake description
	public String toString() {
		return name + " - " + price + " JD";
	}

}
