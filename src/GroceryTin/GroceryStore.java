package GroceryTin;

import java.util.*;

class Product {
    private String code;
    private String name;
    private double price;
    private int quantity;
    private double discount;

    public Product(String code, String name, double price, int quantity, double discount) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount() {
        return discount;
    }
  
   
}

class Transaction {
    private List<Product> products;
    private double totalPrice;
    

    public Transaction() {
        products = new ArrayList<>();
        totalPrice = 0.0;
        
        
    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice() * product.getQuantity() * (1 - product.getDiscount());
       
       
    }


    public void displayTransaction() {
        System.out.println("\nTransaction Details:");
        System.out.println("_______________________________________________________________________");
        System.out.println(" Code      Product        Qty        UPrice       Discount      Amount");
        System.out.println("_______________________________________________________________________");
        for (Product product : products) {
            System.out.println("  "+ product.getCode() + "       "+ product.getName() + "          " + product.getQuantity() +"           " +product.getPrice() + "         " + (product.getDiscount() * 100) + "%" + "         "+ (product.getPrice() *  product.getQuantity())* (1 - product.getDiscount()));
       
            System.out.println("--------------------------------------------------------------------------");
        }
        System.out.println("\n                                                Total : Php   "+ totalPrice);
    }
}

public class GroceryStore {
    private static Map<String, Product> productsDatabase;
    private static List<Transaction> transactionHistory;

    public static void main(String[] args) {
        initializeDatabase();
        transactionHistory = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean anotherTransaction = true;
        while (anotherTransaction) {
            Transaction transaction = new Transaction();

            System.out.println("\nEnter product code (or 'Q' to stop):");
            String productCode = scanner.nextLine();

            while (!productCode.equalsIgnoreCase("q")) {
                Product product = productsDatabase.get(productCode);
                if (product != null) {
                    System.out.println("\nProduct Details:");
                    System.out.println("____________________________________________________________");
                    System.out.println(" Product        Price        Discount       Qty");
                    System.out.println("____________________________________________________________");
                    System.out.print(product.getName() +"           " + product.getPrice() + "         " + (product.getDiscount() * 100) + "%");
               

                  System.out.print("          ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (quantity > product.getQuantity()) {
                        System.out.println("Insufficient quantity!");
                    } else {
                    	
                    	
                        product = new Product(
                                product.getCode(),
                                product.getName(),
                                product.getPrice(),
                                quantity,
                                product.getDiscount()
                                
                                
                        );
                        transaction.addProduct(product);
                        System.out.println("Product added to the transaction.");   
                      
                    }
                } 
                else 
                {
                    System.out.println("Invalid product code!");
                }

                System.out.println("\nEnter product code (or 'Q' to stop):");
                productCode = scanner.nextLine();
            }

            transaction.displayTransaction();
            transactionHistory.add(transaction);

            System.out.println("\nAnother transaction? (yes/no):");
            String another = scanner.nextLine();
            anotherTransaction = another.equalsIgnoreCase("yes");
        }

        System.out.println("\nTransaction History:");
        for (Transaction transaction : transactionHistory) {
            transaction.displayTransaction();
            System.out.println("-----------------------------------");
        }
    }

    private static void initializeDatabase() {
        productsDatabase = new HashMap<>();

        // Adding some example products to the database
        Product product1 = new Product("1", "Apple", 20.00, 10, .02);
        Product product2 = new Product("2", "Banana", 10.00, 10, .05);
        Product product3 = new Product("3", "Milk", 35.00, 10, .02);
        Product product4 = new Product("4", "Chicken", 190, 10, .02);
        Product product5 = new Product("5", "Pork", 320, 10, .05);
        Product product6 = new Product("6", "Beef", 390, 10, .02);
        Product product7 = new Product("7", "Tuna", 400, 10, .02);
        Product product8 = new Product("8", "Crab", 280, 10, .05);
        Product product9 = new Product("9", "Shrimp", 500, 10, .02);
        Product product10 = new Product("10", "Mussel", 300, 10, .02);
        System.out.println("____________________________________________________________");
        System.out.println("Code       Product        Price        Discount");
        System.out.println("____________________________________________________________");
        System.out.println("[1]	Apple           20.00           2%");
        System.out.println("[2]	Banana          10.00           5%");
        System.out.println("[3]	Milk            35.00           2%");
        System.out.println("[4]	Chicken        190.00           2%");
        System.out.println("[5]	Pork           320.00           5%");
        System.out.println("[6]	Beef           390.00           2%");
        System.out.println("[7]	Tuna           400.00           2%");
        System.out.println("[8]	Crab           280.00           5%");
        System.out.println("[9]	Shrimp         500.00           2%");
        System.out.println("[10]    Muscle         300.00           2%");
        System.out.println("____________________________________________________________");
        

        productsDatabase.put(product1.getCode(), product1);
        productsDatabase.put(product2.getCode(), product2);
        productsDatabase.put(product3.getCode(), product3);
        productsDatabase.put(product4.getCode(), product4);
        productsDatabase.put(product5.getCode(), product5);
        productsDatabase.put(product6.getCode(), product6);
        productsDatabase.put(product7.getCode(), product7);
        productsDatabase.put(product8.getCode(), product8);
        productsDatabase.put(product9.getCode(), product9);
        productsDatabase.put(product10.getCode(),product10);
    }
}
