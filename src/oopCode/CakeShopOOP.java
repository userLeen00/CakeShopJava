package oopCode;

import java.util.Scanner;

public class CakeShopOOP {

	// Main class to run the cake shop system
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ManageCakeShop shop = new ManageCakeShop(); // creating an object thsst holds the menu

		System.out.println("Welcome to the Cake Shop (OOP Version)");
		ManageCakeShop.sortCakesByPrice();
		shop.displayMenu();

		while (true) {
			System.out.print("Enter cake number to add to your cart (0 to finish): ");
			int choice = scanner.nextInt();

			if (choice == 0) {
				break;
			} else if (choice >= 1 && choice <= shop.getMenuSize()) {
				shop.addCakeToCart(choice - 1);
			} else {
				System.out.println("Invalid choice. Please try again.");
			}
		}

		shop.printFinalTotal();
		scanner.close();
	}
}
