package GroceryStore;
import GroceryStore.Products.Drink;
import GroceryStore.Products.Fruit;
import GroceryStore.Products.Product;
import GroceryStore.console.UI;

public class Main {

    public static void main(String[] args) {


        UI ui = new UI(new Store("Sergio's Emporium"));

        ui.start();
    }
}