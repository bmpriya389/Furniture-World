package FW;

import java.util.Date;

public class Order {
int orderid;
Date orderdate;
Date shipdate;
String uname;
int trackingid;
String status;
int productid;
String productname;
int quantity;
float unitprice;
String address;
String stype;
float scost;
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public Date getOrderdate() {
	return orderdate;
}
public void setOrderdate(Date orderdate) {
	this.orderdate = orderdate;
}
public Date getShipdate() {
	return shipdate;
}
public void setShipdate(Date shipdate) {
	this.shipdate = shipdate;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public int getTrackingid() {
	return trackingid;
}
public void setTrackingid(int trackingid) {
	this.trackingid = trackingid;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public float getUnitprice() {
	return unitprice;
}
public void setUnitprice(float unitprice) {
	this.unitprice = unitprice;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getStype() {
	return stype;
}
public void setStype(String stype) {
	this.stype = stype;
}
public float getScost() {
	return scost;
}
public void setScost(float scost) {
	this.scost = scost;
}

}
