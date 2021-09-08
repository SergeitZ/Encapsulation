package GroceryStore.konsole;

import GroceryStore.Products.Drink;
import GroceryStore.Products.Fruit;
import GroceryStore.Products.Product;
import GroceryStore.Store;

import java.util.Scanner;

public abstract class UI {
    public String[] MENU;
    public String[] PRODUCT_TYPES;
    public String[] ERROR_MESSAGES;
    public String[] PRODUCT_FIELDS;
    public String[] DRINK_FIELDS;
    public String[] FRUIT_FIELDS;
    public String   WELCOME;
    public String   MENU_PROMPT;
    public String   SELECT_PROMPT;
    public String   PRODUCT_PROMPT;
    public String   CANCEL_PROMPT;
    protected Store store;
    
    protected static Scanner scanner = new Scanner(System.in);
    
    public UI(Store store) {
        this.store = store;
    }

    public void welcome(String name) {
        System.out.println(WELCOME + name + "!");
    }

    public static void displayOptions(String prompt, String[] options) {
        System.out.println(prompt);
        for (String option : options) {
            System.out.println(option);
        }
    }
    
    public void start() {
        welcome(store.getName());
        int choice = 0;
        do {
            displayOptions(MENU_PROMPT, MENU);
            choice = getInt(1, 5, SELECT_PROMPT, ERROR_MESSAGES[1]);
            handleMenuSelection(choice);
        } while (choice != 5);
    }
    
    public static int getInt(int min, int max, String prompt, String errorMsg) {
        int option = min - 1;
        do {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException err) {
                System.out.println(errorMsg);
            } 
        } while (option < min || option > max);
        return option;
    }
    
    public String getString(String prompt, boolean isRequired) {
        String input;
        do {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (isRequired && input.length() == 0) {
                System.out.println(ERROR_MESSAGES[3]);
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
            default -> System.out.println(ERROR_MESSAGES[1]);
        }
    }
    
    public void addProduct() {
        displayOptions(PRODUCT_PROMPT, PRODUCT_TYPES);
        int choice = getInt(1, PRODUCT_TYPES.length, SELECT_PROMPT, ERROR_MESSAGES[1]);
        Product newProduct;
        switch (choice) {
            case 1 -> newProduct = getDrinkDetails();
            case 2 -> newProduct = getFruitDetails();
            default -> {
                System.out.println(ERROR_MESSAGES[1]);
                newProduct = null;
            }
        }
        store.addToInventory(newProduct);
    }
    
    private Drink getDrinkDetails() {
        return new Drink(
                getString(PRODUCT_FIELDS[0], true),
                getInt(1, Integer.MAX_VALUE, PRODUCT_FIELDS[1],ERROR_MESSAGES[1]),
                getString(PRODUCT_FIELDS[2], true),
                getString(PRODUCT_FIELDS[3], false),
                getInt(1, Integer.MAX_VALUE, DRINK_FIELDS[0], ERROR_MESSAGES[1]),
                getInt(0, Drink.UNITS.length - 1, DRINK_FIELDS[1], ERROR_MESSAGES[1])
        );
    }

    private Fruit getFruitDetails() {
        return new Fruit(
                getString(PRODUCT_FIELDS[0], true),
                getInt(1, Integer.MAX_VALUE, PRODUCT_FIELDS[1],ERROR_MESSAGES[1]),
                getString(PRODUCT_FIELDS[2], true),
                getString(PRODUCT_FIELDS[3], false),
                getInt(1, 10, FRUIT_FIELDS[0], ERROR_MESSAGES[1])
        );
    }

    private  void displayProducts() {
        System.out.println(store.getInventory());
    };

    private Product selectProduct (String prompt) {
        displayProducts();
        String choice = getString(prompt, false);
        return store.getProduct(choice);
    }
    
    private void throwAwayProduct() {
        Product prod = selectProduct(SELECT_PROMPT + CANCEL_PROMPT);
        if (prod == null) {
            System.out.println(ERROR_MESSAGES[4]);
            return;
        }
        store.throwAway(prod);
    }

    public void sellProduct() {
        Product prod = selectProduct(SELECT_PROMPT + CANCEL_PROMPT);
        if (prod == null) {
            System.out.println(ERROR_MESSAGES[4]);
            return;
        }
        store.purchase(prod);
    };
}
