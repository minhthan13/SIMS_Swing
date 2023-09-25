package Views.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Entities.Categories;
import Entities.Product_category;
import Entities.Products;
import Models.Categories.CategoriesModel;
import Models.Product.ProductModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JPanelProduct extends JPanel {
	private JTable jtable1;
	private JScrollPane scrollPane;
	private JPopupMenu popupMenu;
	private JTextField jtextFieldkeyword;
	private JComboBox jcomboBoxCategory;

	public JPanelProduct() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Cancel");
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Add");
		panel.add(btnNewButton_1);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Product List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		panel_1.add(lblNewLabel);

		JPanel jpanelTop = new JPanel();
		panel_1.add(jpanelTop);
		jpanelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel jlblSearch = new JLabel("Search");
		jpanelTop.add(jlblSearch);

		jtextFieldkeyword = new JTextField();
		jtextFieldkeyword.setColumns(10);
		jpanelTop.add(jtextFieldkeyword);

		JButton jbtnSearch = new JButton("Search");
		jbtnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnSearch_actionPerformed(e);
			}
		});
		jpanelTop.add(jbtnSearch);

		jcomboBoxCategory = new JComboBox();
		jcomboBoxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxCategory_actionPerformed(e);
			}
		});
		jpanelTop.add(jcomboBoxCategory);

		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innit();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(JPanelProduct.class.getResource("/Resources/Icons/Back.png")));
		panel_1.add(btnNewButton_2);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		jtable1 = new JTable();
		scrollPane.setViewportView(jtable1);

		innit();
		showcombodata();
	}

	private void innit() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("Name");
		model.addColumn("Price");
		model.addColumn("Quantity");
		model.addColumn("Image");
		List<Products> products = new ProductModel().findAll();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < products.size(); i++) {
			Products product = products.get(i);
			// Insert into collom "Image"
			ImageIcon imageIcon = new ImageIcon(product.getImage());
			model.addRow(
					new Object[] { i + 1, product.getName(), product.getPrice() + " VND", product.getQuantity(), imageIcon });
		}
		jtable1.setModel(model);

		int imageColumnIndex = model.findColumn("Image");
		int columnIndex = model.findColumn("Image");
		int desiredWidth = 100;
		jtable1.getColumnModel().getColumn(columnIndex).setPreferredWidth(desiredWidth);

		int desiredHeight = 100;
		jtable1.getColumnModel().getColumn(imageColumnIndex)
				.setCellRenderer(new ImageRenderer(desiredWidth, desiredHeight));

		rightMouse();
	}

	private Products getProductFromSelectedRow(int row) {
		DefaultTableModel model = (DefaultTableModel) jtable1.getModel();
		// Lấy dữ liệu từ hàng được chọn
		String name = model.getValueAt(row, model.findColumn("Name")).toString();
		double price = Double.parseDouble(model.getValueAt(row, model.findColumn("Price")).toString());
//        double quantity = Integer.parseInt(model.getValueAt(row, model.findColumn("Quantity")).toString());

		Products product = new Products();
		product.setName(name);
		product.setPrice(price);
//        product.setQuantity(quantity);
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		return product;

	}

	public class ImageRenderer extends DefaultTableCellRenderer {
		private int width;
		private int height;

		public ImageRenderer(int width, int height) {
			this.width = width;
			this.height = height;
		}

		@Override
		protected void setValue(Object value) {
			if (value instanceof ImageIcon) {
				ImageIcon imageIcon = (ImageIcon) value;
				Image image = imageIcon.getImage();
				Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
				setIcon(new ImageIcon(scaledImage));
			} else {
				super.setValue(value);
			}
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			table.setRowHeight(row, height);
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
	}

	public void jbtnSearch_actionPerformed(ActionEvent e) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("Name");
		model.addColumn("Price");
		model.addColumn("Quantity");
		model.addColumn("Image");
		List<Products> products = new ProductModel().findbyname(jtextFieldkeyword.getText().trim());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < products.size(); i++) {
			Products product = products.get(i);
			// Insert into collom "Image"
			ImageIcon imageIcon = new ImageIcon(product.getImage());
			model.addRow(
					new Object[] { i + 1, product.getName(), product.getPrice(), product.getQuantity(), imageIcon });
		}
		jtable1.setModel(model);

		int imageColumnIndex = model.findColumn("Image");
		int columnIndex = model.findColumn("Image");
		int desiredWidth = 100;
		jtable1.getColumnModel().getColumn(columnIndex).setPreferredWidth(desiredWidth);

		int desiredHeight = 100;
		jtable1.getColumnModel().getColumn(imageColumnIndex)
				.setCellRenderer(new ImageRenderer(desiredWidth, desiredHeight));

		rightMouse();
	}

	private void showcombodata() {
		List<Categories> categories = new CategoriesModel().findAllCategories();
//	    categories.forEach(categorie -> jcomboBoxCategory.addItem(categorie.getName()));
		jcomboBoxCategory.addItem("ALL");
		for (Categories categorie : categories) {
			jcomboBoxCategory.addItem(categorie.getName());
		}
	}

	public void jcomboBoxCategory_actionPerformed(ActionEvent e) {
		CategoriesModel categoriesModel = new CategoriesModel();
		ProductModel productModel = new ProductModel();
		String namecate = jcomboBoxCategory.getSelectedItem().toString(); // chọn category lấy được name
		int categoryID = categoriesModel.findCategoryID(namecate); // lấy name tìm được categoryID
		categoriesModel.findAllProdcutcodebycategoryID(categoryID); // list product_category
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("Name");
		model.addColumn("Price");
		model.addColumn("Quantity");
		model.addColumn("Image");
		if (namecate == "ALL") {
			innit();
		} else {
			List<Products> products = new ArrayList<>();

			for (Product_category productCategory : categoriesModel.findAllProdcutcodebycategoryID(categoryID)) {
				// Trích xuất giá trị product_code từ mỗi phần tử
				String productCode = productCategory.getProduct_code();
				products.add(productModel.findById(productCode)); // Thêm giá trị product_code vào danh sách
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			for (int i = 0; i < products.size(); i++) {
				Products product = products.get(i);
				// Insert into collom "Image"
				ImageIcon imageIcon = new ImageIcon(product.getImage());
				model.addRow(new Object[] { i + 1, product.getName(), product.getPrice(), product.getQuantity(),
						imageIcon });
			}
			jtable1.setModel(model);

			int imageColumnIndex = model.findColumn("Image");
			int columnIndex = model.findColumn("Image");
			int desiredWidth = 100;
			jtable1.getColumnModel().getColumn(columnIndex).setPreferredWidth(desiredWidth);

			int desiredHeight = 100;
			jtable1.getColumnModel().getColumn(imageColumnIndex)
					.setCellRenderer(new ImageRenderer(desiredWidth, desiredHeight));

			rightMouse();

		}
	}

	private void rightMouse() {
		// Tạo JPopupMenu và MenuItem
		popupMenu = new JPopupMenu();
		JMenuItem menuItem = new JMenuItem("ADD");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Xử lý tùy chọn khi người dùng chọn nó
				int selectedRow = jtable1.getSelectedRow();
				if (selectedRow >= 0) {
					Products selectedProduct = getProductFromSelectedRow(selectedRow);
					JOptionPane.showMessageDialog(null,
							"What do you want from " + selectedProduct.getName());
				}
			}
		});
		popupMenu.add(menuItem);

		// Thêm MouseListener để lắng nghe sự kiện chuột phải
		jtable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					int row = jtable1.rowAtPoint(e.getPoint());
					if (row >= 0) {
						jtable1.setRowSelectionInterval(row, row);
						popupMenu.show(jtable1, e.getX(), e.getY());
					}
				}
			}
		});
	}
}
