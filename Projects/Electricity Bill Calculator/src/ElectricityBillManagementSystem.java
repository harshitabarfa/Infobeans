import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

class Consumer {
    private String id;
    private String name;
    private String category;
    private int units;

    public Consumer(String id, String name, String category, int units) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.units = units;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getUnits() {
        return units;
    }
}

class Tariff {
    public static double getFixedCharge(String category) {
        if (category.equalsIgnoreCase("Domestic"))
            return 50;
        else if (category.equalsIgnoreCase("Commercial"))
            return 100;
        else
            return 0;
    }

    public static double getEnergyCharge(String category, int units) {
        double energy = 0;
        if (category.equalsIgnoreCase("Domestic")) {
            if (units <= 100)
                energy = units * 1.5;
            else if (units <= 200)
                energy = 100 * 1.5 + (units - 100) * 2.5;
            else if (units <= 300)
                energy = 100 * 1.5 + 100 * 2.5 + (units - 200) * 4.0;
            else
                energy = 100 * 1.5 + 100 * 2.5 + 100 * 4.0 + (units - 300) * 6.0;
        } else if (category.equalsIgnoreCase("Commercial")) {
            if (units <= 100)
                energy = units * 2.5;
            else if (units <= 200)
                energy = 100 * 2.5 + (units - 100) * 4.0;
            else if (units <= 300)
                energy = 100 * 2.5 + 100 * 4.0 + (units - 200) * 5.0;
            else
                energy = 100 * 2.5 + 100 * 4.0 + 100 * 5.0 + (units - 300) * 7.0;
        }
        return energy;
    }
}

class Bill {
    private Consumer consumer;
    private double fixedCharge;
    private double energyCharge;
    private double total;
    private Date date;

    public Bill(Consumer c) {
        this.consumer = c;
        this.fixedCharge = Tariff.getFixedCharge(c.getCategory());
        this.energyCharge = Tariff.getEnergyCharge(c.getCategory(), c.getUnits());
        this.total = fixedCharge + energyCharge;
        this.date = new Date();
    }

    public String getBillText() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------ ELECTRICITY BILL ------\n");
        sb.append("Consumer Name : ").append(consumer.getName()).append("\n");
        sb.append("Consumer ID   : ").append(consumer.getId()).append("\n");
        sb.append("Category      : ").append(consumer.getCategory()).append("\n");
        sb.append("Units Consumed: ").append(consumer.getUnits()).append("\n");
        sb.append("------------------------------------\n");
        sb.append("Fixed Charges : Rs.").append(String.format("%.2f", fixedCharge)).append("\n");
        sb.append("Energy Charges: Rs.").append(String.format("%.2f", energyCharge)).append("\n");
        sb.append("------------------------------------\n");
        sb.append("TOTAL BILL    : Rs.").append(String.format("%.2f", total)).append("\n");
        sb.append("------------------------------------\n");
        return sb.toString();
    }

    public double getTotal() {
        return total;
    }
}

class BillStorage {
    private static final String FILE_NAME = "bills.txt";

    public static void saveBill(Bill bill) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)))) {
            out.println(bill.getBillText());
        } catch (IOException e) {
            System.out.println("Error saving bill: " + e.getMessage());
        }
    }

    public static void viewAllBills() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int billNo = 1;
            System.out.println("\n------ ALL SAVED BILLS ------\n");
            while ((line = br.readLine()) != null) {
                if (line.contains("------ ELECTRICITY BILL ------")) {
                    System.out.println("Bill #" + billNo++);
                }
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No bills found. File not created yet.");
        } catch (IOException e) {
            System.out.println("Error reading bills: " + e.getMessage());
        }
    }
}

public class ElectricityBillManagementSystem {
    private static Scanner sc = new Scanner(System.in);

    private static Consumer inputConsumer() {
        try {
            System.out.println("\n------ ENTER CONSUMER DETAILS ------");
            System.out.print("Enter consumer name: ");
            String name = sc.nextLine();
            if (name.trim().isEmpty())
                throw new Exception("Name cannot be empty!");

            System.out.print("Enter consumer ID: ");
            String id = sc.nextLine();
            if (id.trim().isEmpty())
                throw new Exception("Consumer ID cannot be empty!");

            System.out.print("Enter category (Domestic/Commercial): ");
            String category = sc.nextLine();
            if (!(category.equalsIgnoreCase("Domestic") || category.equalsIgnoreCase("Commercial")))
                throw new Exception("Invalid category! Must be Domestic or Commercial.");

            System.out.print("Enter units consumed: ");
            int units = Integer.parseInt(sc.nextLine());
            if (units < 0) {
                System.out.println("Invalid input! Units must be a positive number.\nPlease try again.");
                return null;
            }

            return new Consumer(id, name, category, units);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Enter numeric units.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static void generateBill() {
        Consumer c = inputConsumer();
        if (c != null) {
            Bill bill = new Bill(c);
            System.out.println("\nBill calculated successfully!");
            System.out.println(bill.getBillText());
            BillStorage.saveBill(bill);
            System.out.println("Bill has been saved to file successfully!");
            System.out.println("Press Enter to continue...");
            sc.nextLine();
        }
    }

    private static void menu() {
        int choice = 0;
        do {
            System.out.println("\n===========================================");
            System.out.println("     ELECTRICITY BILL MANAGEMENT SYSTEM    ");
            System.out.println("===========================================\n");
            System.out.println("1. Generate New Bill");
            System.out.println("2. View All Bills");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        generateBill();
                        break;
                    case 2:
                        BillStorage.viewAllBills();
                        System.out.println("\nPress Enter to continue...");
                        sc.nextLine();
                        break;
                    case 3:
                        System.out.println("\nThank you for using Electricity Bill Management System.\nGoodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        } while (choice != 3);
    }

    public static void main(String[] args) {
        menu();
    }
}