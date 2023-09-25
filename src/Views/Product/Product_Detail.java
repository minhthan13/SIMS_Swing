package Views.Product;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.text.Style;

import Entities.Products;
import Models.Product.ProductModel;
import Views.Invoices.JPanelSalesInvoice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Product_Detail extends JPanel {
	private Products buyProduct;
	private JLabel JpanelDiscount;
	private JLabel lblImage;
	private JLabel jlabelProductname;
	private JLabel jlabelCost;
	private JLabel jlabeltag;
	private JPanel jpanelquantyti;
	private JLabel jlabelQuantyti;
	private JLabel lblNewLabel;
	private JLabel jlabelVND2;

	/**
	 * Create the panel.
	 */
	public Product_Detail() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setAutoscrolls(true);
		setMinimumSize(new Dimension(200, 250));
		setAlignmentY(0.0f);
		setAlignmentX(0.0f);
		setMaximumSize(new Dimension(200, 250));
		setPreferredSize(new Dimension(200, 260));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JPanel jpanelImage = new JPanel();
		add(jpanelImage);
		jpanelImage.setLayout(new BoxLayout(jpanelImage, BoxLayout.X_AXIS));

		lblImage = new JLabel("");
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

		jlabelProductname = new JLabel("Product Name");
		jlabelProductname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jpanelName.add(jlabelProductname);

		JPanel jpanelPrice = new JPanel();
		add(jpanelPrice);
		jpanelPrice.setLayout(new BoxLayout(jpanelPrice, BoxLayout.PAGE_AXIS));

		jpanelquantyti = new JPanel();
		jpanelPrice.add(jpanelquantyti);

		jlabelQuantyti = new JLabel("New label");
		jpanelquantyti.add(jlabelQuantyti);

		JPanel jpanelPriceDefault = new JPanel();
		jpanelPrice.add(jpanelPriceDefault);

		jlabelCost = new JLabel("20.000");
		jpanelPriceDefault.add(jlabelCost);

		lblNewLabel = new JLabel("VNĐ");
		jpanelPriceDefault.add(lblNewLabel);

		jlabeltag = new JLabel("");
		jlabeltag.setIcon(new ImageIcon(Product_Detail.class.getResource("/Resources/sale_791968.png")));
		jlabeltag.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabeltag.setForeground(Color.RED);
		jpanelPriceDefault.add(jlabeltag);

		JPanel jpanelPriceDiscount = new JPanel();
		jpanelPrice.add(jpanelPriceDiscount);

		JpanelDiscount = new JLabel("Price discount");

		jpanelPriceDiscount.add(JpanelDiscount);

		jlabelVND2 = new JLabel("VNĐ");
		jpanelPriceDiscount.add(jlabelVND2);

	}

	public Product_Detail(Products products) {
		this();
		this.buyProduct = products;
		ImageIcon originalImageIcon = new ImageIcon(buyProduct.getImage());

		// Điều chỉnh kích thước ảnh theo kích thước mong muốn
		int desiredWidth = 200; // Kích thước rộng mong muốn
		int desiredHeight = 150; // Kích thước cao mong muốn
		Image scaledImage = originalImageIcon.getImage().getScaledInstance(desiredWidth, desiredHeight,
				Image.SCALE_SMOOTH);
		ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

		// Đặt ảnh vào JLabel
		lblImage.setIcon(scaledImageIcon);
		jlabelProductname.setText(buyProduct.getName());
		jlabelCost.setText(Double.toString(buyProduct.getPrice()));
		if (buyProduct.getQuantity() <= 0) {
			jlabelQuantyti.setText("Out of stock");
		} else {
			jlabelQuantyti.setText(Double.toString(buyProduct.getQuantity()));
		}

		// Kiểm tra giảm giá
		if (String.valueOf(buyProduct.getDiscount_percent()).equals("") || buyProduct.getDiscount_percent() == 0) {
			jlabeltag.setVisible(false);
			jlabelVND2.setVisible(false);
		} else {
			jlabeltag.setVisible(true);
			jlabelVND2.setVisible(true);
			jlabeltag.setText(String.valueOf(buyProduct.getDiscount_percent()) + "%");
			double resultDouble = (buyProduct.getPrice() * buyProduct.getDiscount_percent()) / 100;
			Double totalprice = buyProduct.getPrice() - resultDouble;
			JpanelDiscount.setText(Double.toString(totalprice));
		}

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (jlabelQuantyti.getText().equalsIgnoreCase("Out of stock")) {
					return;
				}
				JPanelSalesInvoice.getBuyProductInformation(buyProduct);
			}
		});

	}

}
