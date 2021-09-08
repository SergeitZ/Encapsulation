package GroceryStore.konsole;

import GroceryStore.Store;

public class English extends UI implements UserInterface{
    public English(Store store) {
        super(store);
        MENU = new String[] {
                "1. add product to inventory",
                "2. throw away a product",
                "3. list products available",
                "4. sell a product",
                "5. quit"
        };

        PRODUCT_TYPES = new String[] {
                "1. Drink",
                "2. Fruit"
        };

        ERROR_MESSAGES = new String[] {
                "OK",
                "Invalid number",
                "General exception",
                "Must enter something",
                "404 - Product not found"
        };

        PRODUCT_FIELDS = new String[] {
                "Name:",
                "Price:",
                "ID:",
                "Description:"
        };

        DRINK_FIELDS = new String[] {
                "Volume:",
                "Volume unit code:"
        };

        FRUIT_FIELDS = new String[] {
                "Hardness level:",
                "Is organic:"
        };

        WELCOME = "Welcome to ";
        MENU_PROMPT = "What do you want to do?";
        SELECT_PROMPT = "Enter selection:";
        PRODUCT_PROMPT = "What kind of product?";
        CANCEL_PROMPT = " press enter to cancel";
    }

}
