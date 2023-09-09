package Entities;

import java.sql.Date;

public class Invoice {
	private String id;
	private Date created_at;
	private Date deleted_at;
	private Date delivery_date;
	private String delivery_location;
	private String Note;
	private Payment_method Payment_method;
	private Boolean is_cancelled;
	private Boolean is_imported;
	private Integer supplier_id;
	private Integer customer_id;
	private Integer return_product_id;
	private Integer employee_id;

	public enum Payment_method {
		CASH, BANK, CREDIT_CARD
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}

	public Date getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}

	public String getDelivery_location() {
		return delivery_location;
	}

	public void setDelivery_location(String delivery_location) {
		this.delivery_location = delivery_location;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public Payment_method getPayment_method() {
		return Payment_method;
	}

	public void setPayment_method(Payment_method payment_method) {
		Payment_method = payment_method;
	}

	public boolean isIs_cancelled() {
		return is_cancelled;
	}

	public void setIs_cancelled(boolean is_cancelled) {
		this.is_cancelled = is_cancelled;
	}

	public boolean isIs_imported() {
		return is_imported;
	}

	public void setIs_imported(boolean is_imported) {
		this.is_imported = is_imported;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getReturn_product_id() {
		return return_product_id;
	}

	public void setReturn_product_id(int return_product_id) {
		this.return_product_id = return_product_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public Invoice(String id, Date created_at, Date deleted_at, Date delivery_date, String delivery_location,
			String note, Entities.Invoice.Payment_method payment_method, boolean is_cancelled, boolean is_imported,
			int supplier_id, int customer_id, int return_product_id, int employee_id) {
		super();
		this.id = id;
		this.created_at = created_at;
		this.deleted_at = deleted_at;
		this.delivery_date = delivery_date;
		this.delivery_location = delivery_location;
		Note = note;
		Payment_method = payment_method;
		this.is_cancelled = is_cancelled;
		this.is_imported = is_imported;
		this.supplier_id = supplier_id;
		this.customer_id = customer_id;
		this.return_product_id = return_product_id;
		this.employee_id = employee_id;
	}

	public Invoice() {
		super();
	}

}
