package Models.Invoice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entities.Invoice_detail;
import Models.ConnectDB;

public class InvoiceDetailModel {
	public boolean create(Invoice_detail invoice_detail) {
		boolean result = true;
		try {
			PreparedStatement prepareStatement = ConnectDB.connection().prepareStatement(
					"insert into invoice_detail(product_code, invoice_id, product_price, product_quantity, is_discount, discount_amount, is_returned, created_at) values(?,?,?,?,?,?,?,?)");
			prepareStatement.setString(1, invoice_detail.getProduct_code());
			prepareStatement.setString(2, invoice_detail.getInvoice_id());
			prepareStatement.setDouble(3, invoice_detail.getProduct_price());
			prepareStatement.setDouble(4, invoice_detail.getProduct_quantity());
			prepareStatement.setBoolean(5, invoice_detail.isIs_discount());
			prepareStatement.setDouble(6, invoice_detail.getDiscount_percent());
			prepareStatement.setBoolean(7, invoice_detail.isIs_returned());
			prepareStatement.setTimestamp(8, invoice_detail.getCreated_at());
			result = prepareStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public List<Invoice_detail> findByInvoiceId(String keyword) {
		List<Invoice_detail> invoices = new ArrayList<Invoice_detail>();
		try {
			PreparedStatement prepareStatement = ConnectDB.connection()
					.prepareStatement("select * from invoice_detail where invoice_id = ?");
			prepareStatement.setString(1, keyword);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {

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
