package GroceryStore;
import GroceryStore.Products.Drink;
import GroceryStore.Products.Fruit;
import GroceryStore.Products.Product;
import GroceryStore.console.UI;

public class Main {

    public static void main(String[] args) {

        Store store = new Store("Sergio's Emporium");
        UI ui = new UI();


        store.addToInventory("Soy boy", 7_99, "001", "soy boy milk", 2, "gal");
        store.addToInventory("Mega Mango", 6_99, "002", "Mango that's mega", 6, true);
        System.out.println(store.getBalance());
        System.out.println(store.getInventory());
        ui.start(store);
        System.out.println(store.getInventory());
        System.out.println(store.getBalance());
    }
}