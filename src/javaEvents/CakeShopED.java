package javaEvents;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class CakeShopED {

	// List to store cake menu items (name and price)
	private static ArrayList<String> cakeNames = new ArrayList<>();
	private static ArrayList<Double> cakePrices = new ArrayList<>();
	// Customer name for personalization
	private static String customerName = "";
	static Boolean visaBolean = false;

	public static void main(String[] args) {
		// Initialize cake menu items in JD
		cakeNames.add("Vanilla Cake");
		cakePrices.add(2.10);
		cakeNames.add("Cheese Cake");
		cakePrices.add(3.50);
		cakeNames.add("Chocolate Cake");
		cakePrices.add(2.80);
		cakeNames.add("Strawberry Cake");
		cakePrices.add(2.45);

		// for sorting menu by price (low to high)
		sortCakesByPrice();

		// Creating welcome window
		createWelcomeFrame();
	}

	// Selection sort algorithm to sort cakes by price
	private static void sortCakesByPrice() {
		/*
		 * two nested loops where they will start with the first index and compare the
		 * value in it to other values of the other indexes, it will find the minimum
		 * value between them and store it in the minimumIndex then continue to the next
		 * index and so on
		 */
		for (int i = 0; i < cakePrices.size() - 1; i++) {
			// Assume current position is minimum
			int minIndex = i;

			// Find actual minimum in remaining items
			for (int j = i + 1; j < cakePrices.size(); j++) {
				// Compare prices to find lowest
				if (cakePrices.get(j) < cakePrices.get(minIndex)) {
					minIndex = j; // Update minimum position
				}
			}

			// Swap current item with minimum found (both name and price)
			double tempPrice = cakePrices.get(i);
			cakePrices.set(i, cakePrices.get(minIndex));
			cakePrices.set(minIndex, tempPrice);

			String tempName = cakeNames.get(i);
			cakeNames.set(i, cakeNames.get(minIndex));
			cakeNames.set(minIndex, tempName);
		}
	}

	// First window: Welcome screen
	private static void createWelcomeFrame() {
		// Create main window
		JFrame welcomeFrame = new JFrame("Welcome to the Cake Shop");
		welcomeFrame.setSize(400, 500);
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeFrame.setLayout(null);
		System.out.println("user intered the welcome frame");

		// Welcome message
		JLabel welcomeLabel = new JLabel("Welcome To The Cake Shop");
		welcomeLabel.setBounds(100, 10, 200, 100);
		welcomeFrame.add(welcomeLabel);

		// Name input area
		JTextArea nameText = new JTextArea("Enter your name");
		nameText.setBounds(20, 100, 340, 40);
		welcomeFrame.add(nameText);

		// Key listener for name input
		nameText.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// Capture name when Enter is pressed
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					customerName = nameText.getText().trim();
				}
			}
		});

		//the order button
		JButton startButton = new JButton("Double click to start your order");
		startButton.setBounds(50, 350, 300, 70);
		welcomeFrame.add(startButton);



		startButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			System.out.println("user clicked the button once");
			}


			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			// Mouse listener for double-click detection
			public void mouseClicked(MouseEvent e) {
				// Only proceed on double-click with valid name
				if (e.getClickCount() == 2 && !nameText.getText().isBlank()) {
					System.out.println("user double clicked the button once");

					customerName = nameText.getText().trim();
					welcomeFrame.dispose(); // Close welcome screen
					createOrderFrame(); // Open order screen
				}
			}
		});

		welcomeFrame.setVisible(true);
	}

	// starting with the second window: Cake selection
	private static void createOrderFrame() {
		// Creating order window
		JFrame orderFrame = new JFrame(customerName + "'s Cake Order");
		orderFrame.setSize(500, 600);
		orderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		orderFrame.setLayout(null);

		// to track UI elements
		int y = 40;

		// creating quantity fields for each cake
		ArrayList<JTextField> quantityFields = new ArrayList<>();

		// Create sorted menu display
		for (int i = 0; i < cakeNames.size(); i++) {
			// Cake name and price label
				JLabel cakeLabel = new JLabel(cakeNames.get(i) + " (JD" + cakePrices.get(i) + ")");
				cakeLabel.setBounds(10, y, 200, 30);
				orderFrame.add(cakeLabel);

				// Quantity label
			JLabel qtyLabel = new JLabel("Quantity:");
			qtyLabel.setBounds(220, y, 60, 30);
			orderFrame.add(qtyLabel);

			// Quantity input field (default 0)
			JTextField qtyField = new JTextField("0");
			qtyField.setBounds(290, y, 50, 30);
			orderFrame.add(qtyField);
			quantityFields.add(qtyField);

			y += 40; // Move down for next item
		}
			//choosing payment method
		JCheckBox paymentMethod = new JCheckBox("Visa");
		orderFrame.add(paymentMethod);
		paymentMethod.setBounds(10, y + 40, 60, 30);
		paymentMethod.addActionListener(new ActionListener() {
			@Override
			//checK box listener
			public void actionPerformed(ActionEvent e) {

					visaBolean =  paymentMethod.isSelected();;

			}
		});

		// Order button
		JButton orderButton = new JButton("Order Now");
		orderButton.setBounds(200, y + 40 + 50, 100, 70);
		orderFrame.add(orderButton);

		// Mouse motion listener for button color effect
		orderButton.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				//  text will be green when mouse hovers
				orderButton.setForeground(Color.GREEN);
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// text will Black when dragging with the mouse
				orderButton.setForeground(Color.BLACK);
			}
		});

		// Order button action listener
		orderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Processing the order and showing the receipt
				confirmOrder(quantityFields, orderFrame, visaBolean);
			}
		});

		orderFrame.setVisible(true);
	}

	// Third function: Order confirmation and receipt
	private static void confirmOrder(ArrayList<JTextField> quantityFields, JFrame orderFrame, Boolean visaBolean) {
		double total = 0.0;
		int itemCount = 0;
		String receipt = ""; // Using String

		// Order header with customer name
		receipt = "Order for: " + customerName + "\n\n";
		receipt += "Your Payment Method :" + Payment(visaBolean);
		receipt += "Your order details:\n";

		// processing each cake selection
		for (int i = 0; i < cakeNames.size(); i++) {
			// try and catch prevents the app from crashing due to user mistakes ( using
			// letters instead of numbers)
			try {
				// Get quantity from input field
				int quantity = Integer.parseInt(quantityFields.get(i).getText().trim());

				// to skip if quantity is 0 or negative
				if (quantity <= 0)
					continue;

				// Calculate price for this item
				double price = cakePrices.get(i) * quantity;
				total += price;
				itemCount++;

				// Add to receipt
				receipt += quantity + " x " + cakeNames.get(i) + ": JD" + String.format("%.2f", price) + "\n";
			} catch (NumberFormatException ex) {
				// Handle invalid number input
				JOptionPane.showMessageDialog(orderFrame, "Please enter a valid number for " + cakeNames.get(i),
						"Input Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		// Check if any items were selected
		if (itemCount == 0) {
			JOptionPane.showMessageDialog(orderFrame, "Please select at least one cake", "Empty Order",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		// Add total to receipt and payment method
		receipt += "\nTOTAL: JD" + String.format("%.3f", total);
		// receipt += "\nPAYMENT METHOD:"
		receipt += "\n\nYour order is being processed!";

		// Show receipt in dialog
		JOptionPane.showMessageDialog(orderFrame, receipt, "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);
	}

	private static String Payment(Boolean visaBolean) {
		// TODO Auto-generated method stub
		if (visaBolean) {
			return " Visa\n";
		} else {
			return " Cash\n";
		}
	}
}
