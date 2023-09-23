package Views.Product;

import javax.swing.JPanel;
import javax.mail.internet.NewsAddress;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;

import Entities.Categories;
import Models.Categories.CategoriesModel;

import javax.swing.JComboBox;

public class AddProduct extends JPanel {
	private JTextField jtextFieldProductCode;
	private JTextField jtextfeildName;
	private JTextField jtextfeildPrice;
	private JTextField jtextfeildQuantity;
	private JTextField jtextfielDiscount;
	private JTextField jtextfieldCreated;
	private JTextField jtextfieldUnit;
	private JPanel jpanelADD;
	private JComboBox jcomboBoxCategory;

	/**
	 * Create the panel.
	 */
	public AddProduct() {
		setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("ADD PRODUCTS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);

		jpanelADD = new JPanel();
		jpanelADD.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(jpanelADD, BorderLayout.CENTER);
		GridBagLayout gbl_jpanelADD = new GridBagLayout();
		gbl_jpanelADD.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_jpanelADD.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_jpanelADD.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpanelADD.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		jpanelADD.setLayout(gbl_jpanelADD);

		JLabel lblNewLabel_1 = new JLabel("Product_Code:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		jpanelADD.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtextFieldProductCode = new JTextField();
		GridBagConstraints gbc_jtextFieldProductCode = new GridBagConstraints();
		gbc_jtextFieldProductCode.insets = new Insets(0, 0, 5, 5);
		gbc_jtextFieldProductCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldProductCode.gridx = 1;
		gbc_jtextFieldProductCode.gridy = 0;
		jpanelADD.add(jtextFieldProductCode, gbc_jtextFieldProductCode);
		jtextFieldProductCode.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Name:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		jpanelADD.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtextfeildName = new JTextField();
		GridBagConstraints gbc_jtextfeildName = new GridBagConstraints();
		gbc_jtextfeildName.insets = new Insets(0, 0, 5, 5);
		gbc_jtextfeildName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextfeildName.gridx = 1;
		gbc_jtextfeildName.gridy = 1;
		jpanelADD.add(jtextfeildName, gbc_jtextfeildName);
		jtextfeildName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Price:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		jpanelADD.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtextfeildPrice = new JTextField();
		GridBagConstraints gbc_jtextfeildPrice = new GridBagConstraints();
		gbc_jtextfeildPrice.insets = new Insets(0, 0, 5, 5);
		gbc_jtextfeildPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextfeildPrice.gridx = 1;
		gbc_jtextfeildPrice.gridy = 2;
		jpanelADD.add(jtextfeildPrice, gbc_jtextfeildPrice);
		jtextfeildPrice.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Quantity:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		jpanelADD.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtextfeildQuantity = new JTextField();
		GridBagConstraints gbc_jtextfeildQuantity = new GridBagConstraints();
		gbc_jtextfeildQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_jtextfeildQuantity.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextfeildQuantity.gridx = 1;
		gbc_jtextfeildQuantity.gridy = 3;
		jpanelADD.add(jtextfeildQuantity, gbc_jtextfeildQuantity);
		jtextfeildQuantity.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Image:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		jpanelADD.add(lblNewLabel_5, gbc_lblNewLabel_5);

		JLabel jlabelPhoto = new JLabel("aas");
		jlabelPhoto.setPreferredSize(new Dimension(500, 500));
		jlabelPhoto.setBorder(new TitledBorder(null, "Image", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_jlabelPhoto = new GridBagConstraints();
		gbc_jlabelPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_jlabelPhoto.gridx = 1;
		gbc_jlabelPhoto.gridy = 4;
		jpanelADD.add(jlabelPhoto, gbc_jlabelPhoto);

		JButton jbtnChoosePhoto = new JButton("Browser");
		GridBagConstraints gbc_jbtnChoosePhoto = new GridBagConstraints();
		gbc_jbtnChoosePhoto.insets = new Insets(0, 0, 5, 5);
		gbc_jbtnChoosePhoto.gridx = 2;
		gbc_jbtnChoosePhoto.gridy = 4;
		jpanelADD.add(jbtnChoosePhoto, gbc_jbtnChoosePhoto);

		JLabel lblNewLabel_6 = new JLabel("Discount(%):");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 5;
		jpanelADD.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtextfielDiscount = new JTextField();
		GridBagConstraints gbc_jtextfielDiscount = new GridBagConstraints();
		gbc_jtextfielDiscount.insets = new Insets(0, 0, 5, 5);
		gbc_jtextfielDiscount.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextfielDiscount.gridx = 1;
		gbc_jtextfielDiscount.gridy = 5;
		jpanelADD.add(jtextfielDiscount, gbc_jtextfielDiscount);
		jtextfielDiscount.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Status:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 6;
		jpanelADD.add(lblNewLabel_7, gbc_lblNewLabel_7);

		JCheckBox jcheckboxstatus = new JCheckBox("Enable");
		GridBagConstraints gbc_jcheckboxstatus = new GridBagConstraints();
		gbc_jcheckboxstatus.insets = new Insets(0, 0, 5, 5);
		gbc_jcheckboxstatus.gridx = 1;
		gbc_jcheckboxstatus.gridy = 6;
		jpanelADD.add(jcheckboxstatus, gbc_jcheckboxstatus);

		JLabel lblNewLabel_8 = new JLabel("Created:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 7;
		jpanelADD.add(lblNewLabel_8, gbc_lblNewLabel_8);

		jtextfieldCreated = new JTextField();
		GridBagConstraints gbc_jtextfieldCreated = new GridBagConstraints();
		gbc_jtextfieldCreated.insets = new Insets(0, 0, 5, 5);
		gbc_jtextfieldCreated.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextfieldCreated.gridx = 1;
		gbc_jtextfieldCreated.gridy = 7;
		jpanelADD.add(jtextfieldCreated, gbc_jtextfieldCreated);
		jtextfieldCreated.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Unit:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 8;
		jpanelADD.add(lblNewLabel_9, gbc_lblNewLabel_9);

		jtextfieldUnit = new JTextField();
		GridBagConstraints gbc_jtextfieldUnit = new GridBagConstraints();
		gbc_jtextfieldUnit.insets = new Insets(0, 0, 5, 5);
		gbc_jtextfieldUnit.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextfieldUnit.gridx = 1;
		gbc_jtextfieldUnit.gridy = 8;
		jpanelADD.add(jtextfieldUnit, gbc_jtextfieldUnit);
		jtextfieldUnit.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Categories:");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 9;
		jpanelADD.add(lblNewLabel_10, gbc_lblNewLabel_10);

		jcomboBoxCategory = new JComboBox();
		GridBagConstraints gbc_jcomboBoxCategory = new GridBagConstraints();
		gbc_jcomboBoxCategory.insets = new Insets(0, 0, 5, 5);
		gbc_jcomboBoxCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxCategory.gridx = 1;
		gbc_jcomboBoxCategory.gridy = 9;
		jpanelADD.add(jcomboBoxCategory, gbc_jcomboBoxCategory);

		JButton btnNewButton = new JButton("Add More");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 9;
		jpanelADD.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("Save");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 10;
		jpanelADD.add(btnNewButton_1, gbc_btnNewButton_1);
		showcombodata();
	}

	private void showcombodata() {
	    List<Categories> categories = new CategoriesModel().findAllCategories();
	    categories.forEach(categorie -> jcomboBoxCategory.addItem(categorie.getName()));
	    
//	    for(Categories categorie : categories) {
//	    	jcomboBoxCategory.addItem(categorie.getName());
//	    	}
	    
	    
	    
	}


}
