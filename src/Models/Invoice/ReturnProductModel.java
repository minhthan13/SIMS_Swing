package Models.Invoice;

import java.sql.PreparedStatement;
import Entities.Return_product;
import Models.ConnectDB;

public class ReturnProductModel {
	public boolean create(Return_product returnProduct) {
		boolean result = true;
		try {
			PreparedStatement prepareStatement = ConnectDB.connection().prepareStatement(
					"insert into return_product(invoice_detail_id, reason, returned_at) values(?,?,?)");
			prepareStatement.setInt(1, returnProduct.getInvoice_detail_id());
			prepareStatement.setString(2, returnProduct.getReason());
			prepareStatement.setDate(3, new java.sql.Date(returnProduct.getReturned_at().getDate()));
			result = prepareStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

}
