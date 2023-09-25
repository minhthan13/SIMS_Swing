package Views.Invoices;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import Entities.Invoice_detail;
import Models.Product.ProductModel;
import javax.swing.BoxLayout;

public class JFrameReturnInvoice extends JFrame {

	private JPanel contentPane;
	private List<Invoice_detail> returnList = new ArrayList<Invoice_detail>();
	private List<JPanel> returnItemPanelList = new ArrayList<>();
	private ProductModel productModel = new ProductModel();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameReturnInvoice frame = new JFrameReturnInvoice();
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
	public JFrameReturnInvoice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
	}
	
	public JFrameReturnInvoice(List<Invoice_detail> returnList) {
		this();
		this.returnList = returnList;
		init();
	}
	
	private void init() {
		createReturnList(returnList);
		createButtons();
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
	}

	public void createReturnList(List<Invoice_detail> returnList) {
		for (Invoice_detail invoice_detail : returnList) {
			// Create a new panel for the selected product
			JPanel returnedItemPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
			
			// Create labels, text fields for invoice id
			JLabel invoiceIdLabel = new JLabel("Invoice ID");
			JTextField invoiceIdTextField = new JTextField(String.valueOf(invoice_detail.getId()).trim());
			invoiceIdTextField.setPreferredSize(new Dimension(30, 30));
			invoiceIdTextField.setColumns(0);
			invoiceIdTextField.setEditable(false);
			// Create labels, text fields for Product Name
			JLabel nameLabel = new JLabel("Product Name");
			JTextField productNameTextField = new JTextField(
					productModel.findById(invoice_detail.getProduct_code()).getName());
			productNameTextField.setColumns(10);
			productNameTextField.setEditable(false);
			// Create format for quantity
			NumberFormat numberFormat = new DecimalFormat("#,###.##");
			NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
			numberFormatter.setValueClass(Double.class);
			// Create labels, text fields for quantity
			JLabel quantityLabel = new JLabel("Returned Quantity");
			JFormattedTextField quantityField = new JFormattedTextField(numberFormatter);
			quantityField.setValue(invoice_detail.getProduct_quantity());
			quantityField.setEditable(false);
			// Create labels, text fields for reason
			JLabel reason = new JLabel("reason");
			JTextField returnedReason = new JTextField("reason to return");
			invoiceIdTextField.setColumns(20);
			// Add components to the panel
			returnedItemPanel.add(invoiceIdLabel);
			returnedItemPanel.add(invoiceIdTextField);
			returnedItemPanel.add(nameLabel);
			returnedItemPanel.add(productNameTextField);
			returnedItemPanel.add(quantityLabel);
			returnedItemPanel.add(quantityField);
			returnedItemPanel.add(reason);
			returnedItemPanel.add(returnedReason);
			// Add the new panel to the list of returned Item panels
			returnItemPanelList.add(returnedItemPanel);
			// Add the new panel to the this panel
			contentPane.add(returnedItemPanel);
			// Revalidate and repaint jpanelInformation to update the UI
			contentPane.revalidate();
			contentPane.repaint();
		}
	}

	private void createButtons() {
	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
	    JButton saveButton = new JButton("Save");
	    JButton cancelButton = new JButton("Cancel");
	    // Adjust the width (75) and height (30)
	    Dimension buttonSize = new Dimension(75, 30);
	    saveButton.setPreferredSize(buttonSize);
	    cancelButton.setPreferredSize(buttonSize);
	    
		saveButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("say save");
	        }
	    });
		
	    cancelButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("say cancel");
	        }
	    });
	    
	    buttonPanel.add(saveButton);
	    buttonPanel.add(cancelButton);
	    getContentPane().add(buttonPanel);
	}


}
