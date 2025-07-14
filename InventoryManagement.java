import java.util.*;

class InventoryManagement {
        static class Shop {
	        String name;
	        String owner;
	        String orderDate;
	        double supplied = 0;
	        double sold = 0;
	        double stock = 0;
	        double pricePerKg;

	      Shop(String name, String owner, String orderDate, double pricePerKg) {
	            this.name = name;
	            this.owner = owner;
	            this.orderDate = orderDate;
	            this.pricePerKg = pricePerKg;
	        }

	      double getAmount() {
	            return sold * pricePerKg;
	        }
	    }

	      static double supplyToShop(Shop shop, double qty, double centralStock) {
	        if (centralStock >= qty) {
	            shop.supplied += qty;
	            shop.stock += qty;
	            return qty;
	        }
	        return 0;
	    }
    
	    static void sellFromShop(Shop shop, double qty) {
	        if (shop.stock >= qty) {
	            shop.sold += qty;
	            shop.stock -= qty;
	        }
	    }

	    public static void main(String[] args) {
	        double central = 25.0; 
	        // I create 4 shop with owner name,order date and give price per kg
	        Shop[] shops = {
	            new Shop("Shop A", "Ravi",    "2025-07-12", 50.0),
	            new Shop("Shop B", "Meena",   "2025-07-13", 48.0),
	            new Shop("Shop C", "Kumar",   "2025-07-13", 52.0),
	            new Shop("Shop D", "Divya",   "2025-07-14", 49.0)
	        };

	    // for ex. central=central-supplyToShop(shops[0], 5, central);
	        central -= supplyToShop(shops[0], 5, central);//central=25-5=20
	        central -= supplyToShop(shops[1], 4, central);//central=20-4=16
	        central -= supplyToShop(shops[2], 3, central);//central=16-3=13
	        central -= supplyToShop(shops[3], 2, central);//central=13-2=11

	       
	        sellFromShop(shops[0], 2);  // Shop A sold 2kg
	        sellFromShop(shops[1], 1);  // Shop B sold 1kg
	        sellFromShop(shops[2], 1);  // Shop C sold 1kg
	        sellFromShop(shops[3], 0);  // Shop D sold 0kg

	       
	        System.out.println("Shop    | Owner   | Order Date | Supplied | Sold | Balance | Amount  ");
	        System.out.println("--------+---------+------------+----------+------+---------+---------");

	        for (Shop s : shops) {
	            System.out.printf("%-7s | %-7s | %-10s | %8.1f | %4.1f | %7.1f | ₹%.2f%n",
	                    s.name, s.owner, s.orderDate, s.supplied, s.sold, s.stock, s.getAmount());
	        }

	        System.out.println("---------------------------------------------------------------------");
	        System.out.printf("Central Inventory Left: %.1f kg%n", central);
	    }
	}

