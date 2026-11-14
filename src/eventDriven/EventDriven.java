package eventDriven;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
//import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EventDriven {

	// List to store cake menu items (name and price)
	private static ArrayList<CakeItem> menu = new ArrayList<>();
	// Customer name for personalization
	private static String customerName = "";
	static Boolean visaBolean = false;

	public static void main(String[] args) {
		// Initialize cake menu items in JD
		menu.add(new CakeItem("Vanilla Cake", 2.10));
		menu.add(new CakeItem("Cheese Cake", 3.50));
		menu.add(new CakeItem("Chocolate Cake", 2.80));
		menu.add(new CakeItem("Strawberry Cake", 2.45));

		// Sort menu by price (low to high)
		sortCakesByPrice();

		// Create welcome window
		createWelcomeFrame();
	}

	// Selection sort algorithm to sort cakes by price
	private static void sortCakesByPrice() {
		// Loop through each item except last
		for (int i = 0; i < menu.size() - 1; i++) {
			// Assume current position is minimum
			int minIndex = i;

			// Find actual minimum in remaining items
			for (int j = i + 1; j < menu.size(); j++) {
				// Compare prices to find lowest
				if (menu.get(j).price < menu.get(minIndex).price) {
					minIndex = j; // Update minimum position
				}
			}

			// Swap current item with minimum found
			CakeItem temp = menu.get(i);
			menu.set(i, menu.get(minIndex));
			menu.set(minIndex, temp);
		}
	}

	// First window: Welcome screen
	private static void createWelcomeFrame() {
		// Create main window
		JFrame welcomeFrame = new JFrame("Welcome to the Cake Shop");
		welcomeFrame.setSize(400, 500);
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeFrame.setLayout(null);

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

		// Start order button
		JButton startButton = new JButton("Double click to start your order");
		startButton.setBounds(50, 350, 300, 70);
		welcomeFrame.add(startButton);

		// Mouse listener for double-click detection
		startButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// Only proceed on double-click with valid name
				if (e.getClickCount() == 2 && !nameText.getText().isBlank()) {
					customerName = nameText.getText().trim();
					welcomeFrame.dispose(); // Close welcome screen
					createOrderFrame(); // Open order screen
				}
			}
		});

		welcomeFrame.setVisible(true);
	}

	// Second window: Cake selection
	private static void createOrderFrame() {
		// Create order window
		JFrame orderFrame = new JFrame(customerName + "'s Cake Order");
		orderFrame.setSize(500, 600);
		orderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		orderFrame.setLayout(null);

		// Position tracking for UI elements
		int y = 40;

		// Create quantity fields for each cake
		ArrayList<JTextField> quantityFields = new ArrayList<>();

		// Create sorted menu display
		for (CakeItem cake : menu) {
			// Cake name and price label (JD currency)
			JLabel cakeLabel = new JLabel(cake.name + " (JD" + cake.price + ")");
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

		JCheckBox paymentMethod = new JCheckBox("Visa");
		orderFrame.add(paymentMethod);
		paymentMethod.setBounds(10, y + 40, 60, 30);
		paymentMethod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (paymentMethod.isSelected()) {
					visaBolean = true;
				}
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
				// Green text when mouse hovers
				orderButton.setForeground(Color.GREEN);
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// Black text when dragging
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
		String receipt = ""; // Using String instead of StringBuilder

		// Order header with customer name
		receipt = "Order for: " + customerName + "\n\n";
		receipt += "Your Payment Method :" + Payment(visaBolean);
		receipt += "Your order details:\n";

		// Process each cake selection
		for (int i = 0; i < menu.size(); i++) {
			try {
				// Get quantity from input field
				int quantity = Integer.parseInt(quantityFields.get(i).getText().trim());

				// Skip if quantity is 0 or negative
				if (quantity <= 0)
					continue;

				// Calculate price for this item
				double price = menu.get(i).price * quantity;
				total += price;
				itemCount++;

				// Add to receipt
				receipt += "• " + quantity + " x " + menu.get(i).name + ": JD" + String.format("%.3f", price) + "\n";
			} catch (NumberFormatException ex) {
				// Handle invalid number input
				JOptionPane.showMessageDialog(orderFrame, "Please enter a valid number for " + menu.get(i).name,
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
			return" Visa\n";
		} else {
			return" Cash\n";
		}
	}

	// Helper class to store cake items
	static class CakeItem {
		String name;
		double price;

		public CakeItem(String name, double price) {
			this.name = name;
			this.price = price;
		}
	}
}
