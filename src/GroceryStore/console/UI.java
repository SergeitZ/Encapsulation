package GroceryStore.console;
import GroceryStore.Products.Drink;
import GroceryStore.Products.Fruit;
import GroceryStore.Products.Product;
import GroceryStore.Store;
import java.util.Scanner;

public class UI {
    private Store store;
    private static Scanner scanner = new Scanner(System.in);
    private final static String[] MENU = new String[] {
            "1. add product to inventory",
            "2. throw away a product",
            "3. list products available",
            "4. sell a product",
            "5. quit"
    };

    private final static String[] PRODUCT_TYPES = new String[] {
            "1. Drink",
            "2. Fruit"
    };

    public static void welcome(String name) {
        System.out.println("Welcome to " + name + "!");
    }

    public static void displayOptions(String prompt, String[] options) {
        System.out.println(prompt);
        for (String option : options) {
            System.out.println(option);
        }

    }

    public void start(Store store) {
        this.store = store;
        welcome(store.getName());
        int choice = 0;
        do {
            displayOptions("What do you want to do?", MENU);
            choice = getInt(1, 5, "Enter selection between 1 and 5:");
            handleMenuSelection(choice);
        } while (choice != 5);
    }

    public static int getInt(int min, int max, String prompt) {
        int option = 0;
        do {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);
            }
            catch (Exception e) {
                System.out.println(e);
                System.out.println("Invalid entry");
            }
        } while (option < min || option > max);
        return option;
    }

    public static String getString(String prompt, boolean isRequired) {
        String input;
        do {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (isRequired && input.length() == 0) {
                System.out.println("Must enter something");
                continue;
            }
            break;
        } while (true);
        return input;
    }

    public void handleMenuSelection (int choice) {
        switch (choice) {
            case 1 -> addProduct();
            case 2 -> throwAwayProduct();
            case 3 -> displayProducts();
            case 4 -> sellProduct();
            case 5 -> System.exit(0);
            default -> System.out.println("Invalid number");
        }
    }

    public void addProduct() {
        displayOptions("What kind of product?", PRODUCT_TYPES);
        int choice = getInt(1, PRODUCT_TYPES.length, "enter a number");
        Product newProduct;
        switch (choice) {
            case 1 -> newProduct = getDrinkDetails();
            case 2 -> newProduct = getFruitDetails();
            default -> {
                System.out.println("Error bad type");
                newProduct = null;
            }
        }
        store.addToInventory(newProduct);
    }

    private static Drink getDrinkDetails() {
        return new Drink(
                getString("Drink name", true),
                getInt(1, Integer.MAX_VALUE, "Price?"),
                getString("ID: ", true),
                getString("Description", false),
                getInt(1, Integer.MAX_VALUE, "Volume"),
                getInt(0, Drink.UNITS.length - 1, "Volume Unit")
        );
    }

    private static Fruit getFruitDetails() {
        boolean isOrganic = true;
        System.out.println("Is this product organic? Yes = Organic, No = Not organic");
        String choice = scanner.nextLine();
        isOrganic = choice.equals("Yes");
        return new Fruit(
                getString("Fruit name", true),
                getInt(1, Integer.MAX_VALUE, "Price?"),
                getString("ID: ", true),
                getString("Description", false),
                getInt(1, 10, "Hardness (1 - 10)"),
                isOrganic
        );
    }

    private Product selectProduct (String prompt) {
        displayProducts();
        String choice = getString(prompt, false);
        return store.getProduct(choice);
    }

    public void sellProduct() {
        Product prod = selectProduct("Which product to sell? press enter to cancel");
        if (prod == null) {
            System.out.println("404 - Product not found");
            return;
        }
        store.purchase(prod);
    };

    private void throwAwayProduct() {
        Product prod = selectProduct("Which product id to throw away? press enter to cancel");
        if (prod == null) {
            System.out.println("404 - Product not found");
            return;
        }
        store.throwAway(prod);
    };

    private  void displayProducts() {
        System.out.println(store.getInventory());
    };

}
