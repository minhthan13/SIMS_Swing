package Models.Invoice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Entities.Invoice;
import Entities.Invoice.Payment_method;
import Models.ConnectDB;

public class InvoiceModel {
	public List<Invoice> find(String keyword) {
		List<Invoice> invoices = new ArrayList<Invoice>();
		try {
			PreparedStatement prepareStatement = null;
			if (keyword == "") {
				prepareStatement = ConnectDB.connection().prepareStatement("select * from invoices");
			} else {
				prepareStatement = ConnectDB.connection().prepareStatement("select * from invoices where " + keyword + " IS NOT NULL");
			}

			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Invoice invoice = new Invoice();
				invoice.setInvoice_id(resultSet.getString("invoice_id"));
				invoice.setDelivery_date(resultSet.getDate("delivery_date"));
				invoice.setDelivery_location(resultSet.getString("delivery_location"));
				invoice.setNote(resultSet.getString("note"));

				String paymentMethodString = resultSet.getString("payment_method");
				Payment_method paymentMethod = parsePaymentMethod(paymentMethodString);
				invoice.setPayment_method(paymentMethod);

				invoice.setIs_cancelled(resultSet.getBoolean("is_cancelled"));
				invoice.setIs_imported(resultSet.getBoolean("is_import"));
				invoice.setCreated_at(resultSet.getDate("created_at"));
				invoice.setDeleted_at(resultSet.getDate("deleted_at"));
				invoice.setSupplier_id(resultSet.getInt("supplier_id"));
				invoice.setCustomer_id(resultSet.getInt("customer_id"));
				invoice.setIs_returned(resultSet.getBoolean("is_returned"));
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

	public List<Invoice> findAll() {
		List<Invoice> invoices = new ArrayList<Invoice>();
		try {
			PreparedStatement prepareStatement = ConnectDB.connection().prepareStatement("select * from invoices");
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Invoice invoice = new Invoice();
				invoice.setInvoice_id(resultSet.getString("invoice_id"));
				invoice.setDelivery_date(resultSet.getDate("delivery_date"));
				invoice.setDelivery_location(resultSet.getString("delivery_location"));
				invoice.setNote(resultSet.getString("note"));

				String paymentMethodString = resultSet.getString("payment_method");
				Payment_method paymentMethod = parsePaymentMethod(paymentMethodString);
				invoice.setPayment_method(paymentMethod);

				invoice.setIs_cancelled(resultSet.getBoolean("is_cancelled"));
				invoice.setIs_imported(resultSet.getBoolean("is_import"));
				invoice.setCreated_at(resultSet.getDate("created_at"));
				invoice.setDeleted_at(resultSet.getDate("deleted_at"));
				invoice.setSupplier_id(resultSet.getInt("supplier_id"));
				invoice.setCustomer_id(resultSet.getInt("customer_id"));
				invoice.setIs_returned(resultSet.getBoolean("is_returned"));
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

	public Invoice findByID(String keyword) {
		Invoice invoice = null;
		try {
			PreparedStatement prepareStatement = ConnectDB.connection()
					.prepareStatement("select * from invoices where invoice_id = ?");
			prepareStatement.setString(1, keyword);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				invoice = new Invoice();
				invoice.setInvoice_id(resultSet.getString("invoice_id"));
				invoice.setDelivery_date(resultSet.getDate("delivery_date"));
				invoice.setDelivery_location(resultSet.getString("delivery_location"));
				invoice.setNote(resultSet.getString("note"));

				String paymentMethodString = resultSet.getString("payment_method");
				Payment_method paymentMethod = parsePaymentMethod(paymentMethodString);
				invoice.setPayment_method(paymentMethod);

				invoice.setIs_cancelled(resultSet.getBoolean("is_cancelled"));
				invoice.setIs_imported(resultSet.getBoolean("is_import"));
				invoice.setCreated_at(resultSet.getDate("created_at"));
				invoice.setDeleted_at(resultSet.getDate("deleted_at"));
				invoice.setSupplier_id(resultSet.getInt("supplier_id"));
				invoice.setCustomer_id(resultSet.getInt("customer_id"));
				invoice.setIs_returned(resultSet.getBoolean("is_returned"));
				invoice.setEmployee_id(resultSet.getInt("employee_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			invoice = null;
		} finally {
			ConnectDB.disconnect();
		}
		return invoice;
	}

	public boolean create(Invoice invoice) {
		boolean result = true;
		try {
			PreparedStatement prepareStatement = ConnectDB.connection().prepareStatement(
					"insert into invoices(invoice_id, delivery_date, delivery_location, note, payment_method, is_cancelled, 					is_import, created_at, deleted_at, supplier_id, customer_id, return_id, employee_id) values 					(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			prepareStatement.setString(1, invoice.getInvoice_id());

			if (invoice.getDelivery_date() != null) {
				prepareStatement.setDate(2, new java.sql.Date(invoice.getDelivery_date().getTime()));
			} else {
				prepareStatement.setNull(2, Types.DATE);
			}

			prepareStatement.setString(3, invoice.getDelivery_location());
			prepareStatement.setString(4, invoice.getNote());
			prepareStatement.setString(5, invoice.getPayment_method().toString());
			prepareStatement.setBoolean(6, invoice.getIs_cancelled());
			prepareStatement.setBoolean(7, invoice.getIs_imported());
			prepareStatement.setTimestamp(8, new Timestamp(invoice.getCreated_at().getTime()));

			if (invoice.getDeleted_at() != null) {
				prepareStatement.setTimestamp(9, new Timestamp(invoice.getDeleted_at().getTime()));
			} else {
				prepareStatement.setNull(9, Types.TIMESTAMP);
			}

			if (invoice.getSupplier_id() != null) {
				prepareStatement.setInt(10, invoice.getSupplier_id());
			} else {
				prepareStatement.setNull(10, Types.INTEGER);
			}

			if (invoice.getCustomer_id() != null) {
				prepareStatement.setInt(11, invoice.getCustomer_id());
			} else {
				prepareStatement.setNull(11, Types.INTEGER);
			}

			if (invoice.getIs_returned() != null) {
				prepareStatement.setBoolean(12, invoice.getIs_returned());
			} else {
				prepareStatement.setNull(12, Types.BOOLEAN);
			}

			prepareStatement.setInt(13, invoice.getEmployee_id());
			result = prepareStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	// Handle case-insensitive enum mapping
	private Payment_method parsePaymentMethod(String input) {
		for (Payment_method method : Payment_method.values()) {
			if (method.name().equalsIgnoreCase(input)) {
				return method;
			}
		}
		// Handle the case where the input doesn't match any enum constant
		// You can choose to return a default value or throw an exception here
		// For example, you can return Payment_method.UNKNOWN or throw an exception
		throw new IllegalArgumentException("Invalid payment method: " + input);
	}

//	public boolean update(Invoice invoice,String keyword) {
//		boolean result = true;
//		try {
//			PreparedStatement prepareStatement = ConnectDB.connection().prepareStatement(
//					"insert into invoices(invoice_id, delivery_date, delivery_location, note, payment_method, is_cancelled, 					is_imported, created_at, deleted_at, supplier_id, customer_id, return_id, employee_id) values 					(?,?,?,?,?,?,?,?,?,?,?,?,?)");
//			prepareStatement.setString(1, invoice.getInvoice_id());
//			prepareStatement.setDate(2, new java.sql.Date(invoice.getDelivery_date().getDate()));
//			prepareStatement.setString(3, invoice.getDelivery_location());
//			prepareStatement.setString(4, invoice.getNote());
//			prepareStatement.setObject(5, invoice.getPayment_method());
//			prepareStatement.setBoolean(6, invoice.getIs_cancelled());
//			prepareStatement.setBoolean(7, invoice.getIs_imported());
//			prepareStatement.setDate(8, new java.sql.Date(invoice.getCreated_at().getDate()));
//			prepareStatement.setDate(9, new java.sql.Date(invoice.getDeleted_at().getDate()));
//			prepareStatement.setInt(10, invoice.getSupplier_id());
//			prepareStatement.setInt(11, invoice.getCustomer_id());
//			prepareStatement.setInt(12, invoice.getReturn_id());
//			prepareStatement.setInt(13, invoice.getEmployee_id());
//			result = prepareStatement.executeUpdate() > 0;
//		} catch (Exception e) {
//			e.printStackTrace();
//			result = false;
//		} finally {
//			ConnectDB.disconnect();
//		}
//		return result;
//	}
}