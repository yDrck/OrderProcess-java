package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import order.Client;
import order.Products;
import orderStatus.Status;

public class App {
	
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		double total = 0;
		
		System.out.println("Enter cliente data");
		System.out.println();
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter email: ");
		String email = sc.nextLine();
		System.out.print("Enter birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		System.out.println("Enter order data: ");
		System.out.print("Status [PENDING_PAYMENT, PROCESSING, SHIPPED,	DELIVERED]: ");
		Status status = Status.valueOf(sc.next());
		
		Client client = new Client(name, email, birthDate,status);
		Date moment = new Date();	
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for (int i = 1; i<=n; ++i) {
			System.out.println();
			System.out.println("Enter #"+i+" item data");
			sc.nextLine();
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			client.realizeProducts(productName, price, quantity);
			
		}	
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("ORDER SUMMARY");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Order moment: "+ sdf.format(moment));
		System.out.println("Order status: "+ client.getStatus());
		System.out.println("Client: "+ client.getName() + ", Birth date: "+ sdf.format(client.getBirthDate())+
				" - " + client.getEmail());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("ORDER ITEMS");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (Products elem: client.getListProducts()) {
			System.out.println("Product: "+ elem.getProductName()+ ", Value: R$"+ elem.getPrice()+
					", Quantity: " + elem.getQuantity()+ ". Subtotal: R$"+ (elem.getPrice()*elem.getQuantity()));
			total += elem.getPrice()*elem.getQuantity();
		}
		System.out.println("Total price: R$"+ total);
		sc.close();
	}
}
