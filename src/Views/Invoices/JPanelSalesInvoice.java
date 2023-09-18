package Views.Invoices;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import Entities.Products;
import Models.Product.ProductModel;
import Views.Product.Product_Detail;

import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class JPanelSalesInvoice extends JPanel {
	private ProductModel productModel = new ProductModel();
	private JPanel panelList;
	private static JPanel jpanelInformation;
	private static Products selectedProduct = new Products();
	private static List<JPanel> informationPanels = new ArrayList<>();

	public class BuyProductInfo {
		private String buyProductId;
		private String buyProductName;
		private double quantity;
		private double price;
		private double discount;

		public String getBuyProductId() {
			return buyProductId;
		}

		public void setBuyProductId(String buyProductId) {
			this.buyProductId = buyProductId;
		}

		public String getBuyProductName() {
			return buyProductName;
		}

		public void setBuyProductName(String buyProductName) {
			this.buyProductName = buyProductName;
		}

		public double getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public double getDiscount() {
			return discount;
		}

		public void setDiscount(int discount) {
			this.discount = discount;
		}

		public BuyProductInfo(String buyProductId, String buyProductName, int quantity, double price, double discount) {
			super();
			this.buyProductId = buyProductId;
			this.buyProductName = buyProductName;
			this.quantity = quantity;
			this.price = price;
			this.discount = discount;
		}
	}

	/**
	 * Create the panel.
	 */
	public JPanelSalesInvoice() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);

		panelList = new JPanel();
		panelList.setPreferredSize(new Dimension(500, 500));
		scrollPane_1.setViewportView(panelList);
		panelList.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		jpanelInformation = new JPanel();
		jpanelInformation
				.setBorder(new TitledBorder(null, "information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_jpanelInformation = new GridBagConstraints();
		gbc_jpanelInformation.insets = new Insets(0, 0, 5, 0);
		gbc_jpanelInformation.fill = GridBagConstraints.BOTH;
		gbc_jpanelInformation.gridx = 0;
		gbc_jpanelInformation.gridy = 1;
		panel.add(jpanelInformation, gbc_jpanelInformation);
		jpanelInformation.setLayout(new BoxLayout(jpanelInformation, BoxLayout.PAGE_AXIS));

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.anchor = GridBagConstraints.SOUTH;
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		panel.add(panel_4, gbc_panel_4);

		JButton jbtnProceed = new JButton("Proceed");
		jbtnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnProceed_actionPerformed(e);
			}
		});

		panel_4.add(jbtnProceed);

		initProductCard();
	}

	public void jbtnProceed_actionPerformed(ActionEvent e) {
		// Create a list to store BuyProductInfo objects
		List<BuyProductInfo> buyProducts = new ArrayList<BuyProductInfo>();
		// Iterate through the information panels
		for (JPanel infoPanel : informationPanels) {
			// Extract code, quantity, and product ID from the info panel
			JLabel buyproductID = (JLabel) infoPanel.getComponent(4);
			JTextField nameField = (JTextField) infoPanel.getComponent(1);
			JTextField quantityField = (JTextField) infoPanel.getComponent(3);
			JLabel priceLabel = (JLabel) infoPanel.getComponent(5);
			JLabel discountLabel = (JLabel) infoPanel.getComponent(6);
			// Get the values
			String id = buyproductID.getText();
			String name = nameField.getText();
			int quantity = Integer.parseInt(quantityField.getText());
			double price = Double.parseDouble(priceLabel.getText());
			double discount = Double.parseDouble(discountLabel.getText());
			// Create a BuyProductInfo object and add it to the list
			BuyProductInfo buyProductInfo = new BuyProductInfo(id, name, quantity, price, discount);
			buyProducts.add(buyProductInfo);
		}
		if (buyProducts.isEmpty()) {
			JOptionPane.showMessageDialog(null, "NO PRODUCT");
		} else {
			JFrameInvoiceDetail invoiceDetail = new JFrameInvoiceDetail(buyProducts);
			invoiceDetail.setVisible(getFocusTraversalKeysEnabled());
		}
	}

	private void initProductCard() {
		for (Products product : productModel.findAll()) {
			Product_Detail productDetail = new Product_Detail(product);
			panelList.add(productDetail);
		}
	}

	public static void getBuyProductInformation(Products buyProduct) {
		selectedProduct = buyProduct;
		/*
		 * Iterate through existing information panels to check if the product is
		 * already selected
		 */
		for (JPanel infoPanel : informationPanels) {
			// Extract the JLabel containing the product ID from the info panel
			JLabel buyProductId = (JLabel) infoPanel.getComponent(4);
			// Check if the product code matches the selected product's code
			if (selectedProduct.getProduct_code().equals(buyProductId.getText())) {
				// If found, increase the quantity by 1
				JTextField quantityField = (JTextField) infoPanel.getComponent(3);
				int quantity = Integer.parseInt(quantityField.getText());
				quantity++;
				quantityField.setText(Integer.toString(quantity));
				return; // Exit the method
			}
		}
		// Create a new panel for the selected product
		JPanel panelBuyProductItem = new JPanel(new FlowLayout(FlowLayout.LEFT));
		// Create labels, text fields, buttons, and a hidden label for product ID
		JLabel buyProductNameLabel = new JLabel("Name:");
		JTextField buyProductNameTextField = new JTextField(selectedProduct.getName());
		buyProductNameTextField.setColumns(15);
		JLabel quantityLabel = new JLabel("quantity");
		JTextField quantityTextField = new JTextField("1");
		quantityTextField.setColumns(5);
		JButton button1 = new JButton("+");
		JButton button2 = new JButton("-");
		JButton button3 = new JButton("x");
		JLabel buyProductId = new JLabel(selectedProduct.getProduct_code());
		JLabel buyProductPrice = new JLabel(String.valueOf(selectedProduct.getPrice()));
		JLabel buyProductDiscount = new JLabel(String.valueOf(selectedProduct.getDiscount_percent()));
		buyProductId.setVisible(false);
		buyProductPrice.setVisible(false);
		buyProductDiscount.setVisible(false);
		// Add components to the panel
		panelBuyProductItem.add(buyProductNameLabel);
		panelBuyProductItem.add(buyProductNameTextField);
		panelBuyProductItem.add(quantityLabel);
		panelBuyProductItem.add(quantityTextField);
		panelBuyProductItem.add(buyProductId);
		panelBuyProductItem.add(buyProductPrice);
		panelBuyProductItem.add(buyProductDiscount);
		panelBuyProductItem.add(button1);
		panelBuyProductItem.add(button2);
		panelBuyProductItem.add(button3);
		// Add action listeners for the +, -, and x buttons
		button1.addActionListener(e -> {
			int value = Integer.parseInt(quantityTextField.getText());
			value++;
			quantityTextField.setText(Integer.toString(value));
		});

		button2.addActionListener(e -> {
			int value = Integer.parseInt(quantityTextField.getText());
			if (value > 1) {
				value--;
				quantityTextField.setText(Integer.toString(value));
			}
		});

		button3.addActionListener(e -> {
			// Remove the panel from jpanelInformation
			jpanelInformation.remove(panelBuyProductItem);
			// Revalidate and repaint jpanelInformation to update the UI
			jpanelInformation.revalidate();
			jpanelInformation.repaint();
		});
		// Add the new panel to the list of information panels
		informationPanels.add(panelBuyProductItem);
		// Add the new panel to the jpanelInformation
		jpanelInformation.add(panelBuyProductItem);
		// Revalidate and repaint jpanelInformation to update the UI
		jpanelInformation.revalidate();
		jpanelInformation.repaint();
	}

	public static void clearInformationPanel() {
		for (JPanel infoPanel : informationPanels) {
			jpanelInformation.remove(infoPanel);
		}
		informationPanels.clear(); // Clear the list of information panels
		jpanelInformation.revalidate();
		jpanelInformation.repaint();
	}

}
