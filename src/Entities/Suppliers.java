package Entities;

import java.util.Date;

public class Suppliers {
	private String name;
	private String mail;
	private int tel;
	private String website;
	private Date created_at;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Suppliers(String name, String mail, int tel, String website, Date created_at) {
		super();
		this.name = name;
		this.mail = mail;
		this.tel = tel;
		this.website = website;
		this.created_at = created_at;
	}

	public Suppliers() {
		super();
	}

	@Override
	public String toString() {
		return "SupplierModel [name=" + name + ", mail=" + mail + ", tel=" + tel + ", website=" + website
				+ ", created_at=" + created_at + "]";
	}

}
