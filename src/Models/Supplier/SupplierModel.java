package Models.Supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.mysql.cj.protocol.Resultset;

import Entities.Suppliers;
import Models.ConnectDB;

public class SupplierModel {
	public boolean createSupplier(Suppliers suppliers) {
	    boolean Status = true;
	    try {
	        PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
	            "INSERT INTO suppliers (name, email, tel, website, created_at) VALUES (?, ?, ?, ?, ?)"
	        );

	        preparedStatement.setString(1, suppliers.getName());
	        preparedStatement.setString(2, suppliers.getMail());
	        preparedStatement.setInt(3, suppliers.getTel());
	        preparedStatement.setString(4, suppliers.getWebsite());

	        // Assuming suppliers.getCreated_at() returns a java.util.Date, convert it to java.sql.Date
	        java.util.Date utilDate = suppliers.getCreated_at();
	        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	        preparedStatement.setDate(5, sqlDate);

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected == 0) {
	            Status = false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        Status = false;
	    } finally {
	        ConnectDB.disconnect();
	    }
	    return Status;
	}

}
