package entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.STATUS;

public class Order {
	
	private Client client;
	private Date moment;
	private STATUS orderStatus;
	public List<OrderItem> orderList = new ArrayList<>();
	
	public Order(Client client, Date moment) {
		this.client = client;
		this.moment = moment;
		this.orderStatus = STATUS.PROCESSING;
	}
	
	public Client getClient() {
		return client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public STATUS getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(STATUS orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public void addItem(OrderItem item){
		orderList.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderList.remove(item);
	}
	
	public double total(){
		double sum=0;
		for(OrderItem item:orderList) {
			sum += item.subTotal();
		}
		
		return sum;
	}
	
	
	
	
	
}
