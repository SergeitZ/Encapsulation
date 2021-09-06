package GroceryStore.console;

public class English implements Language {
    @Override
    public String[] MENU() {
        return new String[] {
                "1. add product to inventory",
                "2. throw away a product",
                "3. list products available",
                "4. sell a product",
                "5. quit"
        };
    }

    @Override
    public String[] PRODUCT_TYPES() {
        return new String[] {
                "1. Drink",
                "2. Fruit"
        };
    }

    @Override
    public String WELCOME() {
        return "Welcome to ";
    }

    @Override
    public String MENU_PROMPT() {
        return "What do you want to do?";
    }

    @Override
    public String SELECT_PROMPT() {
        return "Enter selection:";
    }

    @Override
    public String PRODUCT_PROMPT() {
        return "What kind of product?";
    }

    @Override
    public String CANCEL_PROMPT() {
        return " press enter to cancel";
    }

    @Override
    public String[] ERROR_MESSAGES() {
        return new String[] {
                "OK",
                "Invalid number",
                "General exception",
                "Must enter something",
                "404 - Product not found"
        };
    }

    @Override
    public String[] PRODUCT_FIELDS() {
        return new String[] {
                "Name:",
                "Price:",
                "ID:",
                "Description:"
        };
    }

    @Override
    public String[] DRINK_FIELDS() {
        return new String[] {
                "Volume:",
                "Volume unit code:"
        };
    }

    @Override
    public String[] FRUIT_FIELDS() {
        return new String[] {
                "Hardness level:",
                "Is organic:"
        };
    }
}
