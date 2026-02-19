import java.util.*;

class Product {
    String name;
    double price;
    String category;
    int stockQuantity;

    public Product(String name, double price, String category, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Category: " + category);
        System.out.println("Stock: " +
                stockQuantity);
    }
}

public class Ass1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] p = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for product " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.print("Category: ");
            String category = sc.nextLine();

            System.out.print("Stock Quantity: ");
            int stock = sc.nextInt();
            sc.nextLine();

            p[i] = new Product(name, price, category, stock);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Menu:");
            System.out.println("1. Display all products");
            System.out.println("2. Display products above a certain price");
            System.out.println("3. Display products of a specific category");
            System.out.println("4. Display products that are out of stock");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("All Products:");

                    for (Product p1 : p) {
                        p1.display();
                    }
                    break;

                case 2:
                    System.out.print("Enter price to filter: ");
                    double minPrice = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Filtered Products (Price above " + minPrice + "):");

                    for (Product p1 : p) {
                        if (p1.price > minPrice) {
                            p1.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter category to filter: ");
                    String categoryFilter = sc.nextLine();
                    System.out.println("Filtered Products (Category: " + categoryFilter + "):");

                    for (Product p1 : p) {
                        if (p1.category.equalsIgnoreCase(categoryFilter)) {
                            p1.display();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Out of Stock Products:");

                    for (Product p1 : p) {
                        if (p1.stockQuantity == 0) {
                            p1.display();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

    }
}
