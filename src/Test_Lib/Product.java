package Test_Lib;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class Product extends JFrame {

	private JPanel contentPane;
	private static String selectedValue;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product frame = new Product();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Product() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
//		
		initProductCard();
	}
	private void initProductCard() {
		for ( int i = 0; i<10;i++) {
			Product_Card product_Detail = new Product_Card(String.valueOf(i));	
			contentPane.add(product_Detail);
		}
	}
	 public static void sendValueToProduct(String value) {
	        selectedValue = value;
	  
	        System.out.println("Selected value: " + selectedValue);
	    }

}
