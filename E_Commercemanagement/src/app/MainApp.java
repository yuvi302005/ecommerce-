package app;

import java.util.Scanner;
import dao.ProductDAO;
import model.Product;

public class MainApp {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        ProductDAO dao = new ProductDAO();

	        while (true) {
	            System.out.println("\n1. Add Product");
	            System.out.println("2. View Products");
	            System.out.println("3. Delete Product");
	            System.out.println("4. Exit");

	            System.out.print("Enter choice: ");
	            int ch = sc.nextInt();

	            switch (ch) {

	                case 1:
	                    System.out.print("Enter ID: ");
	                    int id = sc.nextInt();
	                    sc.nextLine();

	                    System.out.print("Enter Name: ");
	                    String name = sc.nextLine();

	                    System.out.print("Enter Price: ");
	                    double price = sc.nextDouble();

	                    Product p = new Product(id, name, price);
	                    dao.addProduct(p);
	                    break;

	                case 2:
	                    dao.getProducts();
	                    break;

	                case 3:
	                    System.out.print("Enter ID to delete: ");
	                    int did = sc.nextInt();
	                    dao.deleteProduct(did);
	                    break;

	                case 4:
	                    System.exit(0);

	                default:
	                    System.out.println("Invalid choice!");
	            }
	        }
	    }
}
