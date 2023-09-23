package Views.Invoices;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import Entities.Invoice;
import Entities.Invoice.Payment_method;
import Entities.Invoice_detail;
import Models.Invoice.InvoiceDetailModel;
import Models.Invoice.InvoiceModel;
import Views.Invoices.JPanelSalesInvoice.BuyProductInfo;

import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.awt.event.ActionEvent;

public class JFrameInvoiceDetail extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDeliveryLocation;
	private JTextField textFieldNote;
	private JTable tableBuyItem;
	private List<BuyProductInfo> buyProducts = new ArrayList<>();
	private JTextField textFieldSubTotal;
	private JComboBox comboBoxPaymentMethod;
	private JDateChooser dateChooserDeliveryDate;
	private JLabel lblCustomer;
	private JTextField textFieldSupplier;
	private JTextField textFieldCustomer;
	private UUID invoiceId = UUID.randomUUID();
	private String message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameInvoiceDetail frame = new JFrameInvoiceDetail();
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
	public JFrameInvoiceDetail() {
		setPreferredSize(new Dimension(400, 550));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 401, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

		JPanel panelBuyList = new JPanel();
		contentPane.add(panelBuyList);
		panelBuyList.setLayout(new BoxLayout(panelBuyList, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panelBuyList.add(scrollPane);

		tableBuyItem = new JTable();
		scrollPane.setViewportView(tableBuyItem);

		JPanel panelSubTotal = new JPanel();
		contentPane.add(panelSubTotal);
		panelSubTotal.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));

		JLabel lblNewLabel = new JLabel("Sub Total");
		panelSubTotal.add(lblNewLabel);

		textFieldSubTotal = new JTextField();
		textFieldSubTotal.setEditable(false);
		panelSubTotal.add(textFieldSubTotal);
		textFieldSubTotal.setColumns(10);

		JPanel panelInfo = new JPanel();
		contentPane.add(panelInfo);
		GridBagLayout gbl_panelInfo = new GridBagLayout();
		gbl_panelInfo.columnWidths = new int[] { 104, 73, 0, 75, 0, 0 };
		gbl_panelInfo.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelInfo.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelInfo.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelInfo.setLayout(gbl_panelInfo);

		lblCustomer = new JLabel("Customer");
		GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
		gbc_lblCustomer.anchor = GridBagConstraints.WEST;
		gbc_lblCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomer.gridx = 0;
		gbc_lblCustomer.gridy = 0;
		panelInfo.add(lblCustomer, gbc_lblCustomer);

		textFieldCustomer = new JTextField();
		GridBagConstraints gbc_textFieldCustomer = new GridBagConstraints();
		gbc_textFieldCustomer.gridwidth = 4;
		gbc_textFieldCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCustomer.gridx = 1;
		gbc_textFieldCustomer.gridy = 0;
		panelInfo.add(textFieldCustomer, gbc_textFieldCustomer);
		textFieldCustomer.setColumns(10);

		JLabel lblSupplier = new JLabel("Supplier");
		GridBagConstraints gbc_lblSupplier = new GridBagConstraints();
		gbc_lblSupplier.anchor = GridBagConstraints.WEST;
		gbc_lblSupplier.insets = new Insets(0, 0, 5, 5);
		gbc_lblSupplier.gridx = 0;
		gbc_lblSupplier.gridy = 1;
		panelInfo.add(lblSupplier, gbc_lblSupplier);

		textFieldSupplier = new JTextField();
		GridBagConstraints gbc_textFieldSupplier = new GridBagConstraints();
		gbc_textFieldSupplier.gridwidth = 4;
		gbc_textFieldSupplier.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSupplier.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSupplier.gridx = 1;
		gbc_textFieldSupplier.gridy = 1;
		panelInfo.add(textFieldSupplier, gbc_textFieldSupplier);
		textFieldSupplier.setColumns(10);

		JLabel lblDeliveryDate = new JLabel("Delivery Date");
		GridBagConstraints gbc_lblDeliveryDate = new GridBagConstraints();
		gbc_lblDeliveryDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeliveryDate.anchor = GridBagConstraints.WEST;
		gbc_lblDeliveryDate.gridx = 0;
		gbc_lblDeliveryDate.gridy = 2;
		panelInfo.add(lblDeliveryDate, gbc_lblDeliveryDate);

		dateChooserDeliveryDate = new JDateChooser();
		dateChooserDeliveryDate.setDateFormatString("dd-MM-yyyy");
		GridBagConstraints gbc_dateChooserDeliveryDate = new GridBagConstraints();
		gbc_dateChooserDeliveryDate.gridwidth = 4;
		gbc_dateChooserDeliveryDate.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooserDeliveryDate.fill = GridBagConstraints.BOTH;
		gbc_dateChooserDeliveryDate.gridx = 1;
		gbc_dateChooserDeliveryDate.gridy = 2;
		panelInfo.add(dateChooserDeliveryDate, gbc_dateChooserDeliveryDate);

		JLabel lblDeliveryLocation = new JLabel("Delivery Location");
		GridBagConstraints gbc_lblDeliveryLocation = new GridBagConstraints();
		gbc_lblDeliveryLocation.anchor = GridBagConstraints.WEST;
		gbc_lblDeliveryLocation.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeliveryLocation.gridx = 0;
		gbc_lblDeliveryLocation.gridy = 3;
		panelInfo.add(lblDeliveryLocation, gbc_lblDeliveryLocation);

		textFieldDeliveryLocation = new JTextField();
		GridBagConstraints gbc_textFieldDeliveryLocation = new GridBagConstraints();
		gbc_textFieldDeliveryLocation.gridwidth = 4;
		gbc_textFieldDeliveryLocation.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDeliveryLocation.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDeliveryLocation.gridx = 1;
		gbc_textFieldDeliveryLocation.gridy = 3;
		panelInfo.add(textFieldDeliveryLocation, gbc_textFieldDeliveryLocation);
		textFieldDeliveryLocation.setColumns(10);

		JLabel lblNote = new JLabel("Note");
		GridBagConstraints gbc_lblNote = new GridBagConstraints();
		gbc_lblNote.anchor = GridBagConstraints.WEST;
		gbc_lblNote.insets = new Insets(0, 0, 5, 5);
		gbc_lblNote.gridx = 0;
		gbc_lblNote.gridy = 4;
		panelInfo.add(lblNote, gbc_lblNote);

		textFieldNote = new JTextField();
		GridBagConstraints gbc_textFieldNote = new GridBagConstraints();
		gbc_textFieldNote.gridwidth = 4;
		gbc_textFieldNote.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNote.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNote.gridx = 1;
		gbc_textFieldNote.gridy = 4;
		panelInfo.add(textFieldNote, gbc_textFieldNote);
		textFieldNote.setColumns(10);

		JLabel lblPaymentMethod = new JLabel("Payment Method");
		GridBagConstraints gbc_lblPaymentMethod = new GridBagConstraints();
		gbc_lblPaymentMethod.anchor = GridBagConstraints.WEST;
		gbc_lblPaymentMethod.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaymentMethod.gridx = 0;
		gbc_lblPaymentMethod.gridy = 5;
		panelInfo.add(lblPaymentMethod, gbc_lblPaymentMethod);

		comboBoxPaymentMethod = new JComboBox();
		comboBoxPaymentMethod.setModel(new DefaultComboBoxModel(Payment_method.values()));
		comboBoxPaymentMethod.setSelectedIndex(0);
		GridBagConstraints gbc_comboBoxPaymentMethod = new GridBagConstraints();
		gbc_comboBoxPaymentMethod.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPaymentMethod.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPaymentMethod.gridx = 1;
		gbc_comboBoxPaymentMethod.gridy = 5;
		panelInfo.add(comboBoxPaymentMethod, gbc_comboBoxPaymentMethod);

		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPay_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnPay = new GridBagConstraints();
		gbc_btnPay.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPay.insets = new Insets(0, 0, 0, 5);
		gbc_btnPay.gridx = 3;
		gbc_btnPay.gridy = 6;
		panelInfo.add(btnPay, gbc_btnPay);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 6;
		panelInfo.add(btnCancel, gbc_btnCancel);
	}

	public JFrameInvoiceDetail(List<BuyProductInfo> buyProducts) {
		this();
		this.buyProducts = buyProducts;
		initJFrame();

	}

	private void initJFrame() {
		fillDataToTable();
		calculateSubTotal();
	}

	public void btnCancel_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

	public void btnPay_actionPerformed(ActionEvent e) {
		createInvoice();
		createInvoiceDetail();
		if (message.equalsIgnoreCase("Done!")) {
			JOptionPane.showMessageDialog(null, message);
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, message);
		}

	}

	private void createInvoiceDetail() {
		// Create an instance of Invoice_detail and invoice_detail_model
		InvoiceDetailModel invoiceDetailModel = new InvoiceDetailModel();
		// set attribute of invoice detail per row
		for (int i = 0; i < tableBuyItem.getRowCount(); i++) {
			String product_code = (String) tableBuyItem.getValueAt(i,
					getColumnIndexByName(tableBuyItem, "productCode"));
			double product_price = (double) tableBuyItem.getValueAt(i, getColumnIndexByName(tableBuyItem, "Price"));
			double product_quantity = (double) tableBuyItem.getValueAt(i,
					getColumnIndexByName(tableBuyItem, "Quantity"));
			int product_Discount = (int) tableBuyItem.getValueAt(i, getColumnIndexByName(tableBuyItem, "Discount"));
			Invoice_detail invoiceDetail = new Invoice_detail();
			invoiceDetail.setCreated_at(Timestamp.valueOf(LocalDateTime.now()));
			invoiceDetail.setProduct_price(product_price);
			invoiceDetail.setDiscount_percent(product_Discount);
			invoiceDetail.setProduct_quantity(product_quantity);
			invoiceDetail.setIs_returned(false);
			invoiceDetail.setIs_discount(product_Discount > 0 ? true : false);
			invoiceDetail.setProduct_code(product_code);
			invoiceDetail.setInvoice_id(invoiceId.toString());
			// add to database
			if (invoiceDetailModel.create(invoiceDetail)) {
				message = "Done!";
			} else {
				message = "Failed!";
			}
		}
	}

	// Function to create a new Invoice
	private void createInvoice() {
		// Create a new Invoice object
		Invoice invoice = new Invoice();
		// Create an instance of the InvoiceModel class to work with invoices
		InvoiceModel invoiceModel = new InvoiceModel();
		try {
			invoice.setInvoice_id(invoiceId.toString());
			invoice.setCreated_at(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
			invoice.setDelivery_date(dateChooserDeliveryDate.getDate());
			invoice.setDelivery_location(textFieldDeliveryLocation.getText());
			invoice.setNote(textFieldNote.getText());
			invoice.setPayment_method((Payment_method) comboBoxPaymentMethod.getSelectedItem());
			invoice.setIs_cancelled(false);
			invoice.setIs_imported(false);
			invoice.setSupplier_id(null);
			invoice.setCustomer_id(null);
			invoice.setReturn_id(null);
			invoice.setEmployee_id(1);// not null
			// Create the invoice in the database
			invoiceModel.create(invoice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Set various fields of the invoice object

	}

	// Function to get the column index by column name in a JTable
	private int getColumnIndexByName(JTable table, String columnName) {
		for (int i = 0; i < table.getColumnCount(); i++) {
			if (table.getColumnName(i).equals(columnName)) {
				return i;// Return the column index when the column name matches
			}
		}
		return -1;// Return -1 if the column name is not found
	}

	// Function to get a concatenated string value of a specific column in a JTable
	private String getStringValue(String columnName, JTable tableModel) {
		int columnIndex = getColumnIndexByName(tableModel, columnName);
		if (columnIndex != -1) {
			StringBuilder result = new StringBuilder();
			// Iterate through the rows of the table
			for (int row = 0; row < tableModel.getRowCount(); row++) {
				Object cellValue = tableModel.getValueAt(row, columnIndex);
				result.append(cellValue);

				if (row < tableModel.getRowCount() - 1) {
					result.append(", "); // Separate values with a comma and space
				}
			}

			return result.toString();// Return the concatenated string
		} else {
			return ""; // Column not found
		}
	}

	// Function to get an array of double values from a specific column in a JTable
	private double[] getDoubleValue(String columnName, JTable tableModel) {
		int columnIndex = getColumnIndexByName(tableModel, columnName);

		if (columnIndex != -1) {
			int rowCount = tableModel.getRowCount();
			double[] quantityValues = new double[rowCount];

			for (int row = 0; row < rowCount; row++) {
				Object cellValue = tableModel.getValueAt(row, columnIndex);
				quantityValues[row] = (Double) cellValue;
			}
			return quantityValues; // Return the array of double values
		} else {
			return null; // Return null if the column is not found
		}
	}

	// Function to populate data into the JTable
	private void fillDataToTable() {
		// Create a new DefaultTableModel and Add columns to the model
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("Price");
		model.addColumn("Quantity");
		model.addColumn("Discount");
		model.addColumn("Total");
		model.addColumn("productCode");
		// Iterate through the BuyProductInfo items and add rows to the model
		for (BuyProductInfo item : buyProducts) {
			model.addRow(new Object[] { item.getBuyProductName(), item.getPrice(), item.getQuantity(),
					item.getDiscount(), item.getPrice() * item.getQuantity(), item.getBuyProductId() });
		}
		// Set the model as the data source for the table
		tableBuyItem.setModel(model);
		tableBuyItem.getTableHeader().setReorderingAllowed(false);

		// Hide the product_Code column by setting its width to zero
		tableBuyItem.getColumnModel().getColumn(5).setMinWidth(0);
		tableBuyItem.getColumnModel().getColumn(5).setMaxWidth(0);
		tableBuyItem.getColumnModel().getColumn(5).setWidth(0);
	}

	// Function to calculate and display the subtotal of the items in the table
	private void calculateSubTotal() {
		double subTotal = 0;
		int rowCount = tableBuyItem.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			subTotal += (double) tableBuyItem.getValueAt(i, 4);
		}
		textFieldSubTotal.setText(String.valueOf(subTotal));
	}

}
