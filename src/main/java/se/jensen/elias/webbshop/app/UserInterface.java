package se.jensen.elias.webbshop.app;

import se.jensen.elias.webbshop.models.Product;

import java.util.List;

public interface UserInterface {
    String input(String message);

    void showMessage(String message);

    String showMenu();

    void searchProduct(List<Product> products);
}
