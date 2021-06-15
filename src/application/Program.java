package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		//CLIENT REGISTER
		System.out.println("ENTER CLIENT DATA: ");
		System.out.print("Name:"); String name =  sc.next(); sc.next();
		System.out.print("Email: "); String email = sc.next();
		System.out.print("Birth date(dd/MM/yyyy): "); Date birthDate = sdf.parse(sc.next());
		Client client = new Client(name,email,birthDate);
		System.out.println();
		
		//ORDER REGISTER
		System.out.println("ENTER ORDER DATA: ");
		System.out.print("How many items to this order? "); int quantity = sc.nextInt();
		Date date = new Date(System.currentTimeMillis());
		Order order = new Order(client,date);
		for(int i=1; i <= quantity; i++) {
			System.out.println("ITEM #"+i +" DATA:");
			System.out.print("Product name: "); String productName = sc.next();
			System.out.print("Product price: "); double productPrice = sc.nextDouble();
			System.out.print("Quantity: "); int productQuantity = sc.nextInt();
			order.addItem(new OrderItem(productQuantity,new Product(productName,productPrice)));
		}
		System.out.println();
		
		//ORDER SUMARY
		System.out.println("ORDER SUMARY: ");
		System.out.println("Order Moment:" + date);
		System.out.println("Order Status: " + order.getOrderStatus());
		System.out.println(client);
		System.out.println("Order items: ");
		for(OrderItem item: order.orderList) {
		System.out.println(item.getProduct().getName()+", "+item.getPrice()+", quantity: "+item.getQuantity()+", subtotal: "+item.subTotal());
		}
		System.out.println("Total price: " + order.total());
	}

}
