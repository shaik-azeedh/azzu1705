import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String name;
    int quantity;
    double price;

    Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    double getTotal() {
        return quantity * price;
    }
}

class Invoice {
    String customerName;
    String customerPhone;
    ArrayList<Product> products = new ArrayList<>();

    Invoice(String customerName, String customerPhone) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    double calculateSubtotal() {
        double subtotal = 0;
        for (Product p : products) {
            subtotal += p.getTotal();
        }
        return subtotal;
    }

    double calculateTax() {
        return calculateSubtotal() * 0.18; // 18% GST
    }

    double calculateGrandTotal() {
        return calculateSubtotal() + calculateTax();
    }

    void generateInvoice() {
        System.out.println("\n========== INVOICE ==========");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Phone Number  : " + customerPhone);
        System.out.println("-----------------------------------");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Product", "Qty", "Price", "Total");

        for (Product p : products) {
            System.out.printf("%-15s %-10d %-10.2f %-10.2f\n",
                    p.name, p.quantity, p.price, p.getTotal());
        }

        System.out.println("-----------------------------------");
        System.out.printf("Subtotal     : %.2f\n", calculateSubtotal());
        System.out.printf("GST (18%%)    : %.2f\n", calculateTax());
        System.out.printf("Grand Total  : %.2f\n", calculateGrandTotal());
        System.out.println("===================================");
    }

    void saveToFile() {
        try {
            FileWriter writer = new FileWriter("invoice.txt");

            writer.write("========== INVOICE ==========\n");
            writer.write("Customer Name : " + customerName + "\n");
            writer.write("Phone Number  : " + customerPhone + "\n");
            writer.write("-----------------------------------\n");
            writer.write(String.format("%-15s %-10s %-10s %-10s\n", "Product", "Qty", "Price", "Total"));

            for (Product p : products) {
                writer.write(String.format("%-15s %-10d %-10.2f %-10.2f\n",
                        p.name, p.quantity, p.price, p.getTotal()));
            }

            writer.write("-----------------------------------\n");
            writer.write(String.format("Subtotal     : %.2f\n", calculateSubtotal()));
            writer.write(String.format("GST (18%%)    : %.2f\n", calculateTax()));
            writer.write(String.format("Grand Total  : %.2f\n", calculateGrandTotal()));
            writer.write("===================================\n");

            writer.close();
            System.out.println("Invoice saved successfully to invoice.txt");

        } catch (IOException e) {
            System.out.println("Error saving invoice.");
        }
    }
}

public class InvoiceSoftware {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== INVOICE GENERATOR SOFTWARE =====");

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Customer Phone: ");
        String customerPhone = scanner.nextLine();

        Invoice invoice = new Invoice(customerName, customerPhone);

        while (true) {
            System.out.print("Enter Product Name: ");
            String productName = scanner.nextLine();

            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();

            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            invoice.addProduct(new Product(productName, quantity, price));

            System.out.print("Add another product? (yes/no): ");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        invoice.generateInvoice();
        invoice.saveToFile();

        scanner.close();
    }
}
