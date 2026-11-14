package proceduralCode;

public class CakeShopProcedural {

	// these are global variables which will be used across the whole class
	static String[] cakeNames = { "Chocolate Cake", "Strawberry Cake", "Cheesecake", "Vanilla Cake" };
	static double[] cakePrices = { 4.0, 3.5, 5.0, 3.0 };
	static double totalPrice = 0.0;
	static final double APPLY_DISOUNT = 15.0;// static variable

	public static void main(String[] args) {
		System.out.println("Welcome to the Cake Shop (Procedural Version)");

		sortCakesByPrice(); // once the program starts cakes will be sorted automatically
		displayMenu(); // menu will be displayed as(-number -cake -price.)

		// simulated user choices (cannot Scanner) and this is a limitation
		// This array simulates choosing cake 1, 3, and 2 then stopping
		int[] simulatedChoices = { 1, 3, 4, 0 };

		for (int choice : simulatedChoices) {
			System.out.println("Simulated input: " + choice); // Show what the simulated inputs are

			if (choice == 0) {
				// the loop will run until the simulated input is 0
				break;
			} else if (choice >= 1 && choice <= cakeNames.length) {
				addCakeToCart(choice - 1);
				// choice -1 because the array index starts from 0
			} else {
				System.out.println("Invalid choice. Please try again.");
			}
		}

		displayTotalWithDiscount(); // A method that will final total after applying discount
	}

	static void displayMenu() { // this method will display the menu with the help of the arrays
		System.out.println("\nAvailable Cakes:");
		for (int i = 0; i < cakeNames.length; i++) {
			System.out.println((i + 1) + ". " + cakeNames[i] + " - " + cakePrices[i] + " JD");
		}
	}

	static void addCakeToCart(int index) {
		totalPrice += cakePrices[index];
		System.out.println(cakeNames[index] + " is added to your cart Current total: " + totalPrice + " JD\n");
	}

	private static void displayTotalWithDiscount() { // this method will display the final total with discount if
														// implemented
		double finalPrice = calculateDiscount(totalPrice);
		System.out.println("\nFinal Total: " + finalPrice + " JD");
	}

	public static double calculateDiscount(double total) {
		/*
		 * this function includes algorithm that takes in the total cost and decides
		 * whether a discount is applicable and returns the value after the discount
		 */
		if (total > APPLY_DISOUNT) {
			double discount = total * 0.10;
			System.out.println("Discount applied: " + discount + " JD (10%)");
			return total - discount;
		} else {
			System.out.println("No discount applied. Spend more than 15 JD to get 10% off.");
			return total;
		}
	}

	/*
	 * this method is for algorithm implementation to sort the cake by price
	 * ascending
	 */
	public static void sortCakesByPrice() {
		/*
		 * two loop where they will start with the first index and compare the value in
		 * it to other values of the other indexes, it will find the minimum value
		 * between them and store it in the minimumIndex then continue to the next index
		 * and so on
		 */
		for (int i = 0; i < cakePrices.length - 1; i++) {
			int minimumIndex = i;
			for (int j = i + 1; j < cakePrices.length; j++) {
				if (cakePrices[j] < cakePrices[minimumIndex]) {
					minimumIndex = j;
				}
			}

			// starting with swapping prices
			double tempPrice = cakePrices[i];
			cakePrices[i] = cakePrices[minimumIndex];
			cakePrices[minimumIndex] = tempPrice;

			// then swaping names to match
			String tempName = cakeNames[i];
			cakeNames[i] = cakeNames[minimumIndex];
			cakeNames[minimumIndex] = tempName;
		}
		System.out.println("\n(Cakes are now sorted by price in ascending order)");

	}

}
