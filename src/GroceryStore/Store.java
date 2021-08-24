package GroceryStore;
import GroceryStore.Products.*;
import java.util.ArrayList;
import java.util.List;


public class Store {
    private List<Product> inventory = new ArrayList<>();
    private int balance = 500_00;
    private String name;

    public Store(String name) {
        this.name = name;
    }

    //TODO: add to the given collection
    public void addToInventory(Product product) {
        inventory.add(product);
    }

    //TODO: Drink version
    public void addToInventory(String name, int price, String id, String description, int volume, String volumeUnit) {
        Drink drink = new Drink(name, price, id, description, volume, volumeUnit);
        addToInventory(drink);
    }

    public void addToInventory(String name, int price, String id, String description, int volume, int volumeUnit) {
        Drink drink = new Drink(name, price, id, description, volume, volumeUnit);
        addToInventory(drink);
    }

    //TODO: Fruit version
    public void addToInventory(String name, int price, String id, String description, int hardness) {
        Fruit fruit = new Fruit(name, price, id, description, hardness);
        addToInventory(fruit);
    }

    public void addToInventory(String name, int price, String id, String description, int hardness, boolean isOrganic) {
        Fruit fruit = new Fruit(name, price, id, description, hardness, isOrganic);
        addToInventory(fruit);
    }

    public void displayInventory() {
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

 }
