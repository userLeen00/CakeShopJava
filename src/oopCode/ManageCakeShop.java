package oopCode;

import java.util.ArrayList;

public class ManageCakeShop {

	// CakeShop includes menu, cart, sorting, and discount methodss

	private static ArrayList<Cake> menu = new ArrayList<>();
	private ArrayList<Cake> cart = new ArrayList<>();
	private double totalPrice = 0.0;
	private static double APPLY_DISCOUNT = 15.0;

	// Default constructor forpre-defined cakes in ManageCakeShop class
	public ManageCakeShop() {
			// Add normal cakes and sauced cakes to the menu
			menu.add(new Cake("Vanilla Cake", 3.0));
			menu.add(new Cake("Cheesecake", 5.0));
			menu.add(new SaucedCake("Chocolate Cake", 4.0, "chocolate"));
			menu.add(new SaucedCake("Strawberry Cake", 3.5, "strawberry"));
			menu.add(new SaucedCake("Red Velvet Cake", 4.5)); // so i can uses overloaded constructor


		}

	// Displays all available cakes
	public void displayMenu() {
		for (int i = 0; i < menu.size(); i++) {
			System.out.println((i + 1) + ". " + menu.get(i));
		}
	}

	// Add selected cake to cart
	public void addCakeToCart(int index) {
		Cake selectedCake = menu.get(index); // variable object
		cart.add(selectedCake);
		totalPrice += selectedCake.getPrice();
		System.out.println(selectedCake.getName() + " added to cart. Current total: " + totalPrice + " JD\n");
	}

	/*
		 * two loop where they will start with the first index and compare the value in
		 * it to other values of the other indexes, it will find the minimum value
		 * between them and store it in the minimumIndex then continue to the next index
		 * and so on
		 */
	public static void sortCakesByPrice() {
		for (int i = 0; i < menu.size() - 1; i++) {
			int minimumIndex = i;
			for (int j = i + 1; j < menu.size(); j++) {
				if (menu.get(j).getPrice() < menu.get(minimumIndex).getPrice()) {
					minimumIndex = j;
				}
			}
			Cake temp = menu.get(i);
			menu.set(i, menu.get(minimumIndex));
			menu.set(minimumIndex, temp);
		}
		System.out.println("\nCakes sorted by price (ascending):");
	}

	// Discount algorithm (if total > 15 JD, apply 10%)
	public double calculateDiscountedTotal() {
		if (totalPrice > APPLY_DISCOUNT) {
			double discount = totalPrice * 0.10;
			System.out.println("Discount applied: " + discount + " JD (10%)");
			return totalPrice - discount;
		} else {
			System.out.println("No discount applied. Spend more than 15 JD to get 10% off.");
			return totalPrice;
		}

	}

	// Final bill display
	public void printFinalTotal() {
		double finalPrice = calculateDiscountedTotal();
		System.out.println("Final total: " + finalPrice + " JD");
	}

	public int getMenuSize() {
		return menu.size();
	}

}
