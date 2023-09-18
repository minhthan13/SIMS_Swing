package Test_Lib;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.mail.internet.NewsAddress;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import javax.swing.text.Style;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;

public class Product_Card extends JPanel {
	private String textString;
	private JLabel lblNewLabel;
	/**
	 * Create the panel.
	 */
	public Product_Card() {
		setAutoscrolls(true);
		setMinimumSize(new Dimension(200, 250));
		setAlignmentY(0.0f);
		setAlignmentX(0.0f);
		setMaximumSize(new Dimension(200, 250));
		setPreferredSize(new Dimension(200, 250));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel jpanelImage = new JPanel();
		add(jpanelImage);
		jpanelImage.setLayout(new BoxLayout(jpanelImage, BoxLayout.X_AXIS));
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setPreferredSize(new Dimension(200, 150));
		lblImage.setMinimumSize(new Dimension(200, 150));
		lblImage.setMaximumSize(new Dimension(200, 150));
		lblImage.setHorizontalTextPosition(SwingConstants.CENTER);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblImage.setAlignmentY(0.0f);
		jpanelImage.add(lblImage);
		
		JPanel jpanelName = new JPanel();
		add(jpanelName);
		jpanelName.setLayout(new BoxLayout(jpanelName, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jpanelName.add(lblNewLabel_1);
		
		JPanel jpanelPrice = new JPanel();
		add(jpanelPrice);
		jpanelPrice.setLayout(new BoxLayout(jpanelPrice, BoxLayout.PAGE_AXIS));
		
		JPanel jpanelPriceDefault = new JPanel();
		jpanelPrice.add(jpanelPriceDefault);
		
		JLabel lblNewLabel_2 = new JLabel("20.000$");
		jpanelPriceDefault.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(Color.RED);
		jpanelPriceDefault.add(lblNewLabel_3);
		
		JPanel jpanelPriceDiscount = new JPanel();
		jpanelPrice.add(jpanelPriceDiscount);
		
		lblNewLabel = new JLabel("Price discount");
	
		jpanelPriceDiscount.add(lblNewLabel);

	}
	public Product_Card(String text) {
		this();
		this.textString = text;
		lblNewLabel.setText("<html><s>"+textString +"abcasjcnk"+"</s></html>");
		this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Gửi giá trị tới lớp Product khi panel được nhấp vào
                Product.sendValueToProduct(textString);
            }
        });
		

	}

}
