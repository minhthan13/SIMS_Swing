package Models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Entities.Products;
import Models.ConnectDB;

public class ProductModel {
	public List<Products> findAll() {
		 List<Products> products = new ArrayList<Products>();
	        try (
	        		PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT * FROM products");
	             ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                Products product = new Products();
	                product.setProduct_code(resultSet.getString("product_code"));
	                product.setName(resultSet.getString("name"));
	                product.setPrice(resultSet.getDouble("price"));
	                product.setQuantity(resultSet.getDouble("quantity"));
	                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Xác định định dạng ngày
	                product.setImage(resultSet.getBytes("image"));
	                product.setDiscount_percent(resultSet.getInt("discount_percent"));
	                product.setDisable(resultSet.getBoolean("disable"));
	                product.setCreated_at(resultSet.getDate("created_at"));
	                product.getUnit_id();
	                products.add(product);
	                
	            }
	        } 
	        
	        catch (SQLException e) {
	            e.printStackTrace();
	            products = null;
	        }finally {
	        	ConnectDB.disconnect();
			}
			return products;
}
}