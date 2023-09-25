package Views.Invoices;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import Entities.Invoice.Payment_method;
import javax.swing.JButton;

public class JPanelDetails extends JPanel {
	private JTable tableItemList;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public JPanelDetails() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel panelItemList = new JPanel();
		add(panelItemList);
		panelItemList.setLayout(new BoxLayout(panelItemList, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panelItemList.add(scrollPane);
		
		tableItemList = new JTable();
		scrollPane.setViewportView(tableItemList);
		
		JPanel panelSubTotal = new JPanel();
		add(panelSubTotal);
		panelSubTotal.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
		
		JLabel lblSubTotal = new JLabel("Sub Total");
		panelSubTotal.add(lblSubTotal);
		
		textField = new JTextField();
		panelSubTotal.add(textField);
		textField.setColumns(10);
		
		JPanel panelInfo = new JPanel();
		add(panelInfo);
		GridBagLayout gbl_panelInfo = new GridBagLayout();
		gbl_panelInfo.columnWidths = new int[]{101, 103, 0, 70, 70, 0};
		gbl_panelInfo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelInfo.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelInfo.setLayout(gbl_panelInfo);
		
		JLabel lblNewLabel = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelInfo.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panelInfo.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCustomer = new JLabel("Customer");
		GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
		gbc_lblCustomer.anchor = GridBagConstraints.WEST;
		gbc_lblCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomer.gridx = 0;
		gbc_lblCustomer.gridy = 1;
		panelInfo.add(lblCustomer, gbc_lblCustomer);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 4;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 1;
		panelInfo.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSupplier = new JLabel("Supplier");
		GridBagConstraints gbc_lblSupplier = new GridBagConstraints();
		gbc_lblSupplier.anchor = GridBagConstraints.WEST;
		gbc_lblSupplier.insets = new Insets(0, 0, 5, 5);
		gbc_lblSupplier.gridx = 0;
		gbc_lblSupplier.gridy = 2;
		panelInfo.add(lblSupplier, gbc_lblSupplier);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 4;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 2;
		panelInfo.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDeliveryDate = new JLabel("Delivery Date");
		GridBagConstraints gbc_lblDeliveryDate = new GridBagConstraints();
		gbc_lblDeliveryDate.anchor = GridBagConstraints.WEST;
		gbc_lblDeliveryDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeliveryDate.gridx = 0;
		gbc_lblDeliveryDate.gridy = 3;
		panelInfo.add(lblDeliveryDate, gbc_lblDeliveryDate);
		
		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 4;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 3;
		panelInfo.add(dateChooser, gbc_dateChooser);
		
		JLabel lblDeliveryLocation = new JLabel("Delivery Location");
		GridBagConstraints gbc_lblDeliveryLocation = new GridBagConstraints();
		gbc_lblDeliveryLocation.anchor = GridBagConstraints.WEST;
		gbc_lblDeliveryLocation.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeliveryLocation.gridx = 0;
		gbc_lblDeliveryLocation.gridy = 4;
		panelInfo.add(lblDeliveryLocation, gbc_lblDeliveryLocation);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 4;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		panelInfo.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNote = new JLabel("Note");
		GridBagConstraints gbc_lblNote = new GridBagConstraints();
		gbc_lblNote.anchor = GridBagConstraints.WEST;
		gbc_lblNote.insets = new Insets(0, 0, 5, 5);
		gbc_lblNote.gridx = 0;
		gbc_lblNote.gridy = 5;
		panelInfo.add(lblNote, gbc_lblNote);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 4;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 5;
		panelInfo.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblPaymentMethod = new JLabel("Payment Method");
		GridBagConstraints gbc_lblPaymentMethod = new GridBagConstraints();
		gbc_lblPaymentMethod.anchor = GridBagConstraints.WEST;
		gbc_lblPaymentMethod.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaymentMethod.gridx = 0;
		gbc_lblPaymentMethod.gridy = 6;
		panelInfo.add(lblPaymentMethod, gbc_lblPaymentMethod);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Payment_method.values()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 6;
		panelInfo.add(comboBox, gbc_comboBox);
		
		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 3;
		gbc_btnSave.gridy = 7;
		panelInfo.add(btnSave, gbc_btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 7;
		panelInfo.add(btnCancel, gbc_btnCancel);

	}

}
