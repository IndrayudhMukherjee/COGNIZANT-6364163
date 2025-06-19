import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}

class Inventory {
    private HashMap<Integer, Product> inventory = new HashMap<>();

    // Time Complexity: O(1)
    public void addProduct(Product p) {
        inventory.put(p.productId, p);
    }

    // Time Complexity: O(1)
    public void updateProduct(Product p) {
        inventory.put(p.productId, p);
    }

    // Time Complexity: O(1)
    public void deleteProduct(int id) {
        inventory.remove(id);
    }

    // Time Complexity: O(n)
    public void displayAll() {
        for (Product p : inventory.values()) {
            System.out.println(p.productId + ": " + p.productName + " Qty: " + p.quantity + " Price: " + p.price);
        }
    }
}

class InventoryTest {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(123, "Mouse", 100, 4500.50));
        inv.addProduct(new Product(245, "Keyboard", 120, 8400.00));
        inv.displayAll();

        inv.updateProduct(new Product(1, "Mouse", 120, 5400.50));
        inv.deleteProduct(2);
        inv.displayAll();
    }
}