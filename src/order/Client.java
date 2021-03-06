package order;

import java.util.ArrayList;
import java.util.Date;
import orderStatus.Status;

public class Client {
	
	private String name;
	private String email;
	Date birthDate;
	Status status;
	ArrayList<Products> listProducts = new ArrayList<Products>();
	
	
	public Client(String name, String email, Date birthDate, Status status) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.status = status;
	}
	
	public void realizeProducts(String productName, double price, int quantity) {
		listProducts.add(new Products(productName,price,quantity));
	}
	
	public ArrayList<Products> getListProducts() {
		return listProducts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
