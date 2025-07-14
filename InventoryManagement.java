import java.util.*;

public class InventoryManagement {

	    String orderId;
	    String customerName;
	    String orderDate;
	    double balance;
	    String status;

	    public InventoryManagement(String orderId, String customerName, String orderDate, double balance, String status) {
	        this.orderId = orderId;
	        this.customerName = customerName;
	        this.orderDate = orderDate;
	        this.balance = balance;
	        this.status = status;
	    }

	    public void display() {
	        System.out.printf("%-10s %-11s %-12s USD %-10.2f %-10s%n", orderId, customerName, orderDate, balance, status);
	    }
	

	    public static void main(String[] args) {
	        List<InventoryManagement> orders = new ArrayList<>();


	        orders.add(new InventoryManagement("SLSODR/011", "Tony Ken", "30-07-2018", 1075.00, "Open"));
	        orders.add(new InventoryManagement("SLSODR/010", "Jon Teek", "30-07-2018", 19350.00, "Open"));
	        orders.add(new InventoryManagement("SLSODR/009", "Williams", "13-07-2018", 17415.00, "Open"));
	        orders.add(new InventoryManagement("SLSODR/008", "Brown", "08-07-2018", 4837.50, "Open"));
	        orders.add(new InventoryManagement("SLSODR/004", "Johnson", "30-07-2018", 3063.75, "Open"));
	        orders.add(new InventoryManagement("SLSODR/002", "Smith", "25-07-2018", 40312.50, "Open"));

	       
	        System.out.printf("%-10s %-15s %-12s %-13s %-10s%n", "Order ID", "Customer", "Date", "Balance", "Status");
	        System.out.println("-----------------------------------------------------------------------");

	        
	        for (InventoryManagement order : orders) {
	            order.display();
	        }
	    }
	}


