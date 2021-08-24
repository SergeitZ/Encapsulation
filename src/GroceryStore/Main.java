package GroceryStore;
import GroceryStore.Products.Fruit;
import GroceryStore.Products.Product;

public class Main {

    public static void main(String[] args) {

        Fruit prod1 = new Fruit("Apple", 89, "001", "Red apple", 5, true);
        Fruit prod2 = new Fruit("Orange", 550, "002", "Blood Orange", 4, false);
        Product prod3 = new Product("Ipad", 2450_00, "e-001", "Tablet");

        System.out.println(prod1);
        System.out.println(prod2);
        System.out.println(prod3);
    }
}