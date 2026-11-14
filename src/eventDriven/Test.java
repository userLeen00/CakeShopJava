package eventDriven;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JTextArea;
//import javax.swing.JTextField;

public class Test {
	

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			// frame
			JFrame Frame = new JFrame("welcom to the cake shop");
			Frame.setVisible(true);
			Frame.setSize(400, 500);
			Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// will fully close once the x sign is clicked
			JLabel Label = new JLabel("Welcome To The Cake Shop");
			Frame.add(Label);
			Label.setBounds(100, 10, 200, 100);
			Frame.setLayout(null);

			JTextArea Text = new JTextArea("Enter your name");
			Frame.add(Text);
			Text.setBounds(20, 100, 340, 40);

			Text.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						System.out.println(Text.getText());

					}
				}
			});

			// button
			JButton Butn = new JButton("double click to start to your order");
			Frame.add(Butn);
			Butn.setBounds(50, 350, 300, 70);

			Butn.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					// e.getClickCount();
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if (e.getClickCount() == 2 && !Text.getText().isBlank()) {

						
						
						JFrame Frame = new JFrame(" The cake shop");
						Frame.setVisible(true);
						Frame.setSize(500, 600);
						Frame.setDefaultCloseOperation(1);
						// 1 means that it you close this tab the main tab will not close

						// creating thr menu

						int y = 40;
						Frame.setLayout(null);

						// solid text(label)
						JLabel Label1 = new JLabel("What would you like to order?");
						Frame.add(Label1);
						Label1.setBounds(10, y, 200, 10);

						JLabel Label2 = new JLabel("Vanilla Cake (3.00)");
						Frame.add(Label2);
						Label2.setBounds(10, y + 20, 200, 100);

						JLabel Label3 = new JLabel("Cheese Cake (5.00)");
						Frame.add(Label3);
						Label3.setBounds(10, y + 40, 200, 100);

						JLabel Label4 = new JLabel("Strawberry CakeChocolate Cake (4.00)");
						Frame.add(Label4);
						Label4.setBounds(10, y + 60, 200, 100);

						JLabel Label5 = new JLabel("Strawberry Cake (3.50)");
						Frame.add(Label5);
						Label5.setBounds(10, y + 80, 200, 100);

						
						
						// button
						JButton Butn2 = new JButton("Order Now");
						Frame.add(Butn2);
						Butn2.setBounds(200, 450, 100, 70);

						Butn2.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								System.out.println("button is clicked");
								JLabel OrderCompleted = new JLabel("your order is completed");
								Frame.add(OrderCompleted);
								OrderCompleted.setBounds(180, 500, 140, 100);
							}

						});
						Butn2.addMouseMotionListener(new MouseMotionListener() {

							@Override
							public void mouseMoved(MouseEvent e) {
								// TODO Auto-generated method stub
								Butn2.setForeground(Color.green);
							}

							@Override
							public void mouseDragged(MouseEvent e) {
								// TODO Auto-generated method stub
								Butn2.setForeground(Color.black);
							}
						});

						/*// checkbox1
						JCheckBox checkBox1 = new JCheckBox("Loyalty Card", false);
						checkBox1.setBounds(370, 400, 200, 70);
						System.out.println(checkBox1.isSelected());// ;
						Frame.add(checkBox1);

						// listener for1
						checkBox1.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub

							}
						});
	*/
						// extra souce checkbox
		//				JCheckBox checkBox2 = new JCheckBox("extra souce( 0.75)", false);
					//	checkBox2.setBounds(270, 300, 200, 70);
			//			System.out.println(checkBox2.isSelected());// ;
				//		Frame.add(checkBox2);

						/*// Listener for2
						checkBox2.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub

								if (checkBox2.isSelected()) {
									JLabel Label0 = new JLabel("choose your favorit souce");
									Frame.add(Label0);
									Label0.setBounds(10, 300, 200, 50);
								}
							}
						});*/

						/*
						 * // textfield or area JTextField txt = new JTextField(); Frame.add(txt);
						 * txt.setBounds(10, 200, 200, 50); //JTextArea Text =new
						 * JTextArea("Enter your name");
						 */

					}

				}
			});

		}
	}

