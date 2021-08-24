package GroceryStore;
import GroceryStore.Products.Drink;
import GroceryStore.Products.Fruit;
import GroceryStore.Products.Product;
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

    }

    //TODO: Drink version
    public void addToInventory() {
        Drink drink = new Drink();
        addToInventory(drink);
    }

    //TODO: Fruit version
    public void addToInventory() {
        Fruit fruit = new Fruit();
        addToInventory(fruit);
    }
 }
