package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Products {
	private String product_code;
	private String name;
	private double price;
	private double quantity;
	private  byte[] image;
	private int discount_percent;
	private boolean disable;
	private Date created_at;
	private int unit_id;
	
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getDiscount_percent() {
		return discount_percent;
	}
	public void setDiscount_percent(int discount_percent) {
		this.discount_percent = discount_percent;
	}
	public boolean isDisable() {
		return disable;
	}
	public void setDisable(boolean disable) {
		this.disable = disable;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public int getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(int unit_id) {
		this.unit_id = unit_id;
	}
	public Products(String product_code, String name, double price, double quantity, byte[] image,
			int discount_percent, boolean disable, Date created_at, int unit_id) {
		super();
		this.product_code = product_code;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.discount_percent = discount_percent;
		this.disable = disable;
		this.created_at = created_at;
		this.unit_id = unit_id;
	}
	public Products() {
		super();
	}
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("đ/MM/yyyy");
		return "Products [product_code=" + product_code + ", name=" + name + ", price=" + price + ", quantity="
				+ quantity + ", image=" + image + ", discount_percent=" + discount_percent + ", disable=" + disable
				+ ", created_at=" + simpleDateFormat.format(created_at) + ", unit_id=" + unit_id + "]";
	}

	
	
}
