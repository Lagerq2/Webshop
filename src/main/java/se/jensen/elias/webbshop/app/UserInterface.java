package se.jensen.elias.webbshop.app;

import se.jensen.elias.webbshop.models.Product;

import java.util.List;

//Interface för mina två grafiska gränssnitt konsol och Dialogruta
public interface UserInterface {
    String input(String message);

    void showMessage(String message);

    String showMenu();

    void searchProduct(List<Product> products);

    //Metod som ska felhantera om man skriver in något annat än siffror på pris.
    double inputDouble(String message);
}
