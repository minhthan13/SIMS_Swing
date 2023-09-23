package Entities;

import java.sql.Timestamp;
import java.util.Arrays;

public class Invoice_detail {
	private int id;
	private String product_code;
	private String invoice_id;
	private double product_price;
	private double product_quantity;
	private boolean is_discount;
	private int discount_percent;
	private boolean is_returned;
	private Timestamp created_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(String invoice_id) {
		this.invoice_id = invoice_id;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public double getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(double product_quantity) {
		this.product_quantity = product_quantity;
	}

	public boolean isIs_discount() {
		return is_discount;
	}

	public void setIs_discount(boolean is_discount) {
		this.is_discount = is_discount;
	}

	public int getDiscount_percent() {
		return discount_percent;
	}

	public void setDiscount_percent(int discount_percent) {
		this.discount_percent = discount_percent;
	}

	public boolean isIs_returned() {
		return is_returned;
	}

	public void setIs_returned(boolean is_returned) {
		this.is_returned = is_returned;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Invoice_detail(int id, String product_code, String invoice_id, double product_price, double product_quantity,
			boolean is_discount, int discount_percent, boolean is_returned, Timestamp created_at) {
		super();
		this.id = id;
		this.product_code = product_code;
		this.invoice_id = invoice_id;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.is_discount = is_discount;
		this.discount_percent = discount_percent;
		this.is_returned = is_returned;
		this.created_at = created_at;
	}

	public Invoice_detail() {
		super();
	}

	@Override
	public String toString() {
		return "Invoice_detail [id=" + id + ", product_code=" + product_code + ", invoice_id=" + invoice_id
				+ ", product_price=" + product_price + ", product_quantity=" + product_quantity + ", is_discount="
				+ is_discount + ", discount_amount=" + discount_percent + ", is_returned=" + is_returned
				+ ", created_at=" + created_at + "]";
	}

}
