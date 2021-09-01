package GroceryStore;
import GroceryStore.Products.*;
import java.util.ArrayList;
import java.util.List;
import com.company.Util.Formatter;


public class Store {
    private List<Product> inventory = new ArrayList<>();
    private int balance = 500_00;
    private String name;

    public Store(String name) {
        this.name = name;
    }

    public void addToInventory(Product product) {
        if (product.getPrice() > balance) {
            System.out.println("Not enough funds");
            return;
        }
        balance -= product.getPrice();
        inventory.add(product);
    }

    public void addToInventory(String name, int price, String id, String description, int volume, String volumeUnit) {
        Drink drink = new Drink(name, price, id, description, volume, volumeUnit);
        addToInventory(drink);
    }

    public void addToInventory(String name, int price, String id, String description, int volume, int volumeUnit) {
        Drink drink = new Drink(name, price, id, description, volume, volumeUnit);
        addToInventory(drink);
    }

    public void addToInventory(String name, int price, String id, String description, int hardness) {
        Fruit fruit = new Fruit(name, price, id, description, hardness);
        addToInventory(fruit);
    }

    public void addToInventory(String name, int price, String id, String description, int hardness, boolean isOrganic) {
        Fruit fruit = new Fruit(name, price, id, description, hardness, isOrganic);
        addToInventory(fruit);
    }

    public void throwAway(Product product) {
        inventory.remove(product);
    }

    public void purchase (Product product) {
        balance += product.getPrice();
        throwAway(product);
    }

    public String getInventory() {
        String output = "";
        for (Product prod : inventory) {
            output += prod + "\n";
        }
        return output;
    }

    public String getBalance () {
        return Formatter.getDisplayPrice(balance);
    }

    public String getName() {
        return name;
    }

    public Product getProduct(String id) {
        for (Product product : inventory) {
            if (product.id.equals(id)) {
                return product;
            }
        }
        return null;
    }

 }
