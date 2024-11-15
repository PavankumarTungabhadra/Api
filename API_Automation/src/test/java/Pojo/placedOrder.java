package Pojo;

import java.util.List;

public class placedOrder {
	
	private List<orders> orders;
	private List<productOrderId>  productOrderId;
	private String message;
	
	
	public List<Pojo.orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Pojo.orders> orders) {
		this.orders = orders;
	}
	public List<Pojo.productOrderId> getProductOrderId() {
		return productOrderId;
	}
	public void setProductOrderId(List<Pojo.productOrderId> productOrderId) {
		this.productOrderId = productOrderId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
