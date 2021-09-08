package GroceryStore.konsole;

import GroceryStore.Store;

public class Spanish extends UI implements UserInterface{
    public Spanish(Store store) {
        super(store);
        MENU = new String[] {
                "1. agregar producto al inventario",
                "2. desechar un producto",
                "3. enumerar los productos disponibles",
                "4. vender un producto",
                "5. salir",
                "6. cambiar idioma"
        };

        PRODUCT_TYPES = new String[] {
                "1. Bebida",
                "2. Fruta"
        };

        ERROR_MESSAGES = new String[] {
                "OK",
                "Numero invalido",
                "Excepción general",
                "Debe ingresar algo",
                "404 - Producto no encontrado"
        };

        PRODUCT_FIELDS = new String[] {
                "Nombre:",
                "Precio:",
                "ID:",
                "Descripción:"
        };

        DRINK_FIELDS = new String[] {
                "Volumen:",
                "Codigo de unidad de volumen:"
        };

        FRUIT_FIELDS = new String[] {
                "Nivel de dureza:",
                "Es orgánico:"
        };

        WELCOME = "Bienvenido a ";
        MENU_PROMPT = "Que quieres hacer?";
        SELECT_PROMPT = "Ingrese selection:";
        PRODUCT_PROMPT = "Que tipo de producto?";
        CANCEL_PROMPT = " oprima enter para cancelar";
    }
}
