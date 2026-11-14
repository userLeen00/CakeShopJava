package oopCode;

public class SaucedCake extends Cake {
	//Subclass SaucedCake

	private String sauceType;

// Constructor (SaucedCake class)
	public SaucedCake(String name, double price, String sauceType) {
		super(name, price); // Call Cake constructor
		this.sauceType = sauceType;
	}
	 // Overloaded constructor (default sauce)
    public SaucedCake(String name, double price) {
        super(name, price);
        this.sauceType= "vanilla"; // default value
    }
	// Getter for sauceType
    public String getSauceType() {
        return sauceType;
    }

    // Setter for sauceType
    public void setSauceType(String sauceType) {
        this.sauceType = sauceType;
    }

	// Override toString to include sauce info
	public String toString() {
		return getName() + " with " + sauceType + " sauce - " + getPrice() + " JD\n";

	}
}
