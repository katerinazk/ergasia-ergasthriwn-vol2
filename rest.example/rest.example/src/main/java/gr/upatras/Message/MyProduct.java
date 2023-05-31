package gr.upatras.Message;

public class MyProduct {
	private int id;
	private String pname;
	private String batchno;
	private double price;
	private int noofMyProduct;
	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getPname() {
	return pname;
	}
	public void setPname(String pname) {
	this.pname = pname;
	}
	public String getBatchno() {
	return batchno;
	}
	public void setBatchno(String batchno) {
	this.batchno = batchno;
	}
	public double getPrice() {
	return price;
	}
	public void setPrice(double price) {
	this.price = price;
	}
	public int getNoofMyProduct() {
	return noofMyProduct;
	}
	public void setNoofMyProduct(int noofMyProduct) {
	this.noofMyProduct = noofMyProduct;
	}
	public MyProduct(int id, String pname, String batchno, double price, int noofMyProduct) {
	super();
	this.id = id;
	this.pname = pname;
	this.batchno = batchno;
	this.price = price;
	this.noofMyProduct = noofMyProduct;
	}


}
