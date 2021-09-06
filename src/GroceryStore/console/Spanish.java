package GroceryStore.console;

public class Spanish implements Language {
    @Override
    public String[] MENU() {
        return new String[] {
                "1. agregar producto al inventario",
                "2. desechar un producto",
                "3. enumerar los productos disponibles",
                "4. vender un producto",
                "5. salir",
                "6. cambiar idioma"
        };
    }

    @Override
    public String[] PRODUCT_TYPES() {
        return new String[] {
                "1. Bebida",
                "2. Fruta"
        };
    }

    @Override
    public String WELCOME() {
        return "Bienvenido a ";
    }

    @Override
    public String MENU_PROMPT() {
        return "Que quieres hacer?";
    }

    @Override
    public String SELECT_PROMPT() {
        return "Ingrese selection:";
    }

    @Override
    public String PRODUCT_PROMPT() {
        return "Que tipo de producto?";
    }

    @Override
    public String CANCEL_PROMPT() {
        return " oprima enter para cancelar";
    }

    @Override
    public String[] ERROR_MESSAGES() {
        return new String[] {
                "OK",
                "Numero invalido",
                "Excepción general",
                "Debe ingresar algo",
                "404 - Producto no encontrado"
        };
    }

    @Override
    public String[] PRODUCT_FIELDS() {
        return new String[] {
                "Nombre:",
                "Precio:",
                "ID:",
                "Descripción:"
        };
    }

    @Override
    public String[] DRINK_FIELDS() {
        return new String[] {
                "Volumen:",
                "Codigo de unidad de volumen:"
        };
    }

    @Override
    public String[] FRUIT_FIELDS() {
        return new String[] {
                "Nivel de dureza:",
                "Es orgánico:"
        };
    }
}
