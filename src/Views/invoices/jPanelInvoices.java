package Views.Invoices;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entities.Invoice;
import Models.Invoice.InvoiceModel;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelInvoices extends JPanel {
	private JTable jtableInvoicesList;
	private JComboBox jcomboBoxInvoiceType;
	private InvoiceModel invoiceModel = new InvoiceModel();

	/**
	 * Create the panel.
	 */
	public jPanelInvoices() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel_1 = new JLabel("Invoice Type");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcomboBoxInvoiceType = new JComboBox();
		jcomboBoxInvoiceType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxInvoiceType_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_jcomboBoxInvoiceType = new GridBagConstraints();
		gbc_jcomboBoxInvoiceType.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxInvoiceType.insets = new Insets(0, 0, 5, 5);
		gbc_jcomboBoxInvoiceType.gridx = 2;
		gbc_jcomboBoxInvoiceType.gridy = 0;
		add(jcomboBoxInvoiceType, gbc_jcomboBoxInvoiceType);

		JLabel lblNewLabel = new JLabel("Invoices List");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		jtableInvoicesList = new JTable();
		scrollPane.setViewportView(jtableInvoicesList);

		initial();
	}

	public void jcomboBoxInvoiceType_actionPerformed(ActionEvent e) {
		int choice = jcomboBoxInvoiceType.getSelectedIndex();
		String keyword = "";
		switch (choice) {
		case 0:
			keyword = "supplier_id";
			break;
		case 1:
			keyword = "customer_id";
			break;
		default:
			keyword = "return_product_id";
			break;
		}

		// go to invoice model findbykeyword
		fillDataToJTable(invoiceModel.findByType(keyword));
	}

	private void fillDataToJTable(List<Invoice> invoices) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("id");
		model.addColumn("Create At");
		model.addColumn("Delete At");
		model.addColumn("delivery Date");
		model.addColumn("delivery Location");
		model.addColumn("Note");
		model.addColumn("Payment_method");
		model.addColumn("is_cancelled");
		model.addColumn("is_imported");
		model.addColumn("supplier_id");
		model.addColumn("customer_id");
		model.addColumn("return_product_id");
		model.addColumn("employee_id");
		for (Invoice invoice : invoices) {
			model.addRow(new Object[] {  });
		}
		jtableInvoicesList.setModel(model);
		jtableInvoicesList.getTableHeader().setReorderingAllowed(false);
	}

	private void initial() {
		List<String> invoiceType = new ArrayList<String>();
		invoiceType.add("Supply");
		invoiceType.add("Sale");
		invoiceType.add("Returned");
		DefaultComboBoxModel<String> invoiceTypeModel = new DefaultComboBoxModel<String>();
		invoiceTypeModel.addAll(invoiceType);
		jcomboBoxInvoiceType.setModel(invoiceTypeModel);
		jcomboBoxInvoiceType.setSelectedIndex(0);

		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("id");
		model.addColumn("Create At");
		model.addColumn("Delete At");
		model.addColumn("Create At");
		model.addColumn("Create At");
		model.addColumn("Create At");
		model.addColumn("Create At");
		model.addColumn("Create At");
		model.addColumn("Create At");
		model.addColumn("Create At");
		model.addColumn("Create At");
		model.addColumn("Create At");
		model.addColumn("Create At");

		model.addRow(new Object[] { "", "", "", "", "", "", "", "", "", "", "", "", "" });
		jtableInvoicesList.setModel(model);
		jtableInvoicesList.getTableHeader().setReorderingAllowed(false);
	}
}