package Views.Invoices;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.BoxLayout;
import Entities.Invoice;
import Entities.Invoice_detail;
import Models.Customer.CustomerModel;
import Models.Employees.EmployeeModel;
import Models.Invoice.InvoiceDetailModel;
import Models.Invoice.InvoiceModel;
import Models.Product.ProductModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPanelListInvoice extends JPanel {
	private JComboBox comboBoxType;
	private JTable tableInvoiceList;
	private String keyword = "";
	private JPopupMenu popupMenu;
	private static JDialog dialog = new JDialog();

	/**
	 * Create the panel.
	 */
	public JPanelListInvoice() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JPanel panelSearch = new JPanel();
		add(panelSearch);

		comboBoxType = new JComboBox();
		comboBoxType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxType_actionPerformed(e);
			}
		});
		comboBoxType.setModel(new DefaultComboBoxModel(new String[] { "All", "Supply", "Returned", "Sales" }));
		panelSearch.add(comboBoxType);

		JPanel panelList = new JPanel();
		add(panelList);
		panelList.setLayout(new BoxLayout(panelList, BoxLayout.PAGE_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panelList.add(scrollPane);

		tableInvoiceList = new JTable();
		tableInvoiceList.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showPopupMenu(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				showPopupMenu(e);
			}
		});
		scrollPane.setViewportView(tableInvoiceList);
		
		popupMenu = new JPopupMenu();
		JMenuItem menuItemDetail = new JMenuItem("Detail"); // Add your menu items here
		menuItemDetail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuItemDetail_actionPerformed(e);
			}
		});
		
		JMenuItem menuItemDelete = new JMenuItem("Delete");
		menuItemDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuItemDelete_actionPerformed(e);
			}
		});
		
		popupMenu.add(menuItemDetail);
		popupMenu.add(menuItemDelete);
		
		JPanel panelNothing = new JPanel();
		add(panelNothing);
		panelNothing.setLayout(new BorderLayout(0, 0));
		init();
	}

	private void init() {
		InvoiceModel invoiceModel = new InvoiceModel();
		fillDataToTable(invoiceModel.find(keyword));
	}

	public void comboBoxType_actionPerformed(ActionEvent e) {
		InvoiceModel invoiceModel = new InvoiceModel();
		int choice = comboBoxType.getSelectedIndex();

		switch (choice) {
		case 1:
			keyword = "supplier_id";
			break;
		case 2:
			keyword = "is_returned";
			break;
		case 3:
			keyword = "customer_id";
			break;
		default:
			keyword = "";
			break;
		}
		fillDataToTable(invoiceModel.find(keyword));
	}

	private void fillDataToTable(List<Invoice> invoiceList) {
		// Create a new DefaultTableModel and Add columns to the model
		CustomerModel customerModel = new CustomerModel();
		EmployeeModel employeeModel = new EmployeeModel();

		DefaultTableModel model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

		};
		model.addColumn("invoice_id");
		model.addColumn("delivery_date");
		model.addColumn("delivery_location");
		model.addColumn("note");
		model.addColumn("payment_method");
		model.addColumn("created_at");
		model.addColumn("supplier");
		model.addColumn("customer");
		model.addColumn("is_returned");
		model.addColumn("employee");

		for (Invoice invoice : invoiceList) {
			model.addRow(new Object[] { invoice.getInvoice_id(), invoice.getDelivery_date(),
					invoice.getDelivery_location(), invoice.getNote(), invoice.getPayment_method().toString(),
					invoice.getCreated_at(), invoice.getSupplier_id(),
					customerModel.findById(invoice.getCustomer_id()).getName(), invoice.getIs_returned(),
					employeeModel.FindByEmployeeID(invoice.getEmployee_id()).getUsername() });
		}
		// Set the model as the data source for the table
		tableInvoiceList.setModel(model);
		tableInvoiceList.getTableHeader().setReorderingAllowed(false);
	}

	public void menuItemDetail_actionPerformed(ActionEvent e) {
		int selectedRowIndex = tableInvoiceList.getSelectedRow();
		String invoice_id = (String) tableInvoiceList.getValueAt(selectedRowIndex, 0);		
		
		InvoiceModel invoiceModel = new InvoiceModel();
		Invoice invoice = invoiceModel.findByID(invoice_id);
		
		InvoiceDetailModel invoiceDetailModel = new InvoiceDetailModel();		
		List<Invoice_detail> details = invoiceDetailModel.findByInvoiceId(invoice_id);
		
		dialog = new JDialog();
		dialog.setTitle("Invoice Detail");
		dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

		JFrameInvoiceDetail invoiceDetail = new JFrameInvoiceDetail(details, invoice);
		dialog.getContentPane().add(invoiceDetail.getContentPane());
		dialog.pack();
		dialog.setVisible(true);
		
	}
	
	public void menuItemDelete_actionPerformed(ActionEvent e) {
		// Implement the action for Delete menu item
	}
	
	private void showPopupMenu(MouseEvent e) {
		if (e.isPopupTrigger() && tableInvoiceList.getSelectedRow() != -1) {
			// Get the selected row index
			int row = tableInvoiceList.getSelectedRow();

			// Show the popup menu at the mouse position
			popupMenu.show(tableInvoiceList, e.getX(), e.getY());
		}
	}

	public static void dispose() {
		dialog.dispose();
	}
}
