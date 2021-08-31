package GroceryStore;
import GroceryStore.Products.Drink;
import GroceryStore.Products.Fruit;
import GroceryStore.Products.Product;
import GroceryStore.console.UI;

public class Main {

    public static void main(String[] args) {

//        Product prod = new Fruit("Apple", 89, "p-001", "Red Apple", 5, true);
//        Fruit prod2 = new Fruit("Orange", 5_50, "p-002", "Bag of blood oranges", 4);
//        Product prod3 = new Drink("Milk", 4_00 , "d-001", "Whole milk Gallon", 1, "Gal");
//        Drink prod4 = new Drink("Orange Juice", 4_99, "d-002", "with pulp", 2 , 5);

        Store store = new Store("Sergio's Emporium");

//        System.out.println(store.getBalance());
//        store.addToInventory("Soy boy", 7_99, "001", "soy boy milk", 2, "gal");
//        store.addToInventory("Mega Mango", 6_99, "002", "Mango that's mega", 6, true);
//
//        System.out.println(store.getInventory());
//        System.out.println(store.getBalance());
        UI.start(store);

    }
}