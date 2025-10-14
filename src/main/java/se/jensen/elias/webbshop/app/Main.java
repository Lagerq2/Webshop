package se.jensen.elias.webbshop.app;

import se.jensen.elias.webbshop.models.Product;
import se.jensen.elias.webbshop.services.FileHandler;

import java.util.List;

public class Main {

    static void main(String[] args) {
        List<Product> products = FileHandler.readFromFile("src/main/java/se/jensen/elias/webbshop/data/products.txt");
        Menu menu = new Menu(products);
        menu.showWelcomeMenu();
        menu.showAppMenu();
    }
}
