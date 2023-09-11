package Views.Product;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.ImageIcon;

import Entities.Products;
import Models.Product.ProductModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JPanelProduct extends JPanel {
    private JTable jtable1;
    private JScrollPane scrollPane;

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

        JPanel panel_2 = new JPanel();
        add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));

        scrollPane = new JScrollPane();
        panel_2.add(scrollPane, BorderLayout.CENTER);

        jtable1 = new JTable();
        scrollPane.setViewportView(jtable1);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("STT");
        model.addColumn("Product Code");
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("Image");
        model.addColumn("Discount");
        model.addColumn("Disable");
        model.addColumn("Created");
        model.addColumn("unit_id");

        List<Products> products = new ProductModel().findAll();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < products.size(); i++) {
            Products product = products.get(i);
            // Chèn hình ảnh vào cột "Image"
            ImageIcon imageIcon = new ImageIcon(product.getImage());
            model.addRow(new Object[] { i + 1, product.getProduct_code(), product.getName(), product.getPrice(),
                    product.getQuantity(), imageIcon, product.getDiscount_percent(), product.isDisable(),
                    simpleDateFormat.format(product.getCreated_at()), product.getUnit_id() });
        }
        jtable1.setModel(model);

        // Áp dụng Renderer cho cột "Image"
        int imageColumnIndex = model.findColumn("Image");
        int desiredWidth = 300; // Độ rộng mong muốn
        int desiredHeight = 300; // Độ cao mong muốn
        jtable1.getColumnModel().getColumn(imageColumnIndex).setCellRenderer(new ImageRenderer(desiredWidth, desiredHeight));

    }

    public class ImageRenderer extends DefaultTableCellRenderer {
        private int width;  // Độ rộng mong muốn cho hình ảnh
        private int height; // Độ cao mong muốn cho hình ảnh

        public ImageRenderer(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        protected void setValue(Object value) {
            if (value instanceof ImageIcon) {
                ImageIcon imageIcon = (ImageIcon) value;
                // Điều chỉnh kích thước ảnh theo độ rộng và độ cao mong muốn
                Image image = imageIcon.getImage();
                Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                setIcon(new ImageIcon(scaledImage));
            } else {
                super.setValue(value);
            }
        }
    }}

