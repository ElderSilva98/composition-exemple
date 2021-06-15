package entities;

public class OrderItem {
	
	private int quantity;
	private double price;
	private Product product;
	
	public OrderItem(int quantity,	Product product) {
		this.quantity = quantity;
		this.product = product;
		this.price = product.getPrice();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public Product getProduct() {
		return product;
	}


	public double subTotal() {
		return quantity*price;
	}
	
	

}
