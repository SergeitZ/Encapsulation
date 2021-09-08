package GroceryStore;
import GroceryStore.konsole.English;
import GroceryStore.konsole.UserInterface;

public class Main {

    public static void main(String[] args) {

        Store store = new Store("The Grocery Store DUH");

//        UI ui = new UI(new Store("Sergio's Emporium"));
        UserInterface ui = new English(store);

        ui.start();
    }
}