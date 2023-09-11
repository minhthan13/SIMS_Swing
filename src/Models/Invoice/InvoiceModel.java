package Models.Invoice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entities.Invoice;
import Entities.Invoice.Payment_method;
import Models.ConnectDB;

public class InvoiceModel {
	public List<Invoice> findByType(String keyword) {
		List<Invoice> invoices = new ArrayList<Invoice>();
		try {
			PreparedStatement prepareStatement = ConnectDB.connection().prepareStatement("select * from invoices where ? IS NOT NULL");
			prepareStatement.setString(1, keyword);
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				Invoice invoice = new Invoice();
				invoice.setId(resultSet.getString("invoice_id"));
				invoice.setDelivery_date(resultSet.getDate("delivery_date"));
				invoice.setDelivery_location(resultSet.getString("delivery_location"));
				invoice.setNote(resultSet.getString("note"));
				invoice.setPayment_method(Payment_method.valueOf(resultSet.getString("payment_method")));
				invoice.setIs_cancelled(resultSet.getBoolean("is_cancelled"));
				invoice.setIs_imported(resultSet.getBoolean("is_import"));
				invoice.setCreated_at(resultSet.getDate("created_at"));
				invoice.setDeleted_at(resultSet.getDate("deleted_at"));
				invoice.setSupplier_id(resultSet.getInt("supplier_id"));
				invoice.setCustomer_id(resultSet.getInt("customer_id"));
				invoice.setReturn_product_id(resultSet.getInt("return_id"));
				invoice.setEmployee_id(resultSet.getInt("employee_id"));
				invoices.add(invoice);
			}
		} catch (Exception e) {
			e.printStackTrace();
			invoices = null;
		} finally {
			ConnectDB.disconnect();
		}
		return invoices;
	}
}