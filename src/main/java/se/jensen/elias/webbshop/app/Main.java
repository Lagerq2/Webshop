package se.jensen.elias.webbshop.app;

import se.jensen.elias.webbshop.models.Book;
import se.jensen.elias.webbshop.models.Movie;
import se.jensen.elias.webbshop.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.println("Webbshoppen");
        System.out.println("----------------");
        System.out.println("[1] Grafiskt gränssnitt: ");
        System.out.println("[2] Konsol");
        String uiChoice = scanner.nextLine();

        UserInterface ui;

        if (uiChoice.equals("2")) {
            ui = new ConsoleUI();
        } else {
            ui = new DialogUI();
        }

        while (true) {
            String menu = "1. Lägg till bok\n" +
                    "2. Lägg till Bil\n" +
                    "3. Visa produkter\n" +
                    "Välj ett av alternativen: ";
            String choice = ui.input(menu);

            if (choice == null || choice.equals("0")) break;

            switch (choice) {
                case "1":
                    String bokName = ui.input("Ange Boknamn: ");
                    String bokPrice = ui.input("Ange pris: ");
                    String bokAuthor = ui.input("Ange författare: ");
                    products.add(new Book(bokName, bokPrice, bokAuthor));
                    break;
                case "2":
                    String carModel = ui.input("Ange modell: ");
                    String carPrice = ui.input("Ange pris: ");
                    String carBrand = ui.input("Ange Märke: ");
                    products.add(new Movie(carModel, carPrice, carBrand));
                    break;
                case "3":
                    StringBuilder sb = new StringBuilder("Sparade produkter: \n");
                    for (Product product : products) {
                        sb.append(product.getInfo()).append("\n");
                    }
                    if (products.isEmpty()) {
                        sb.append("Inga produkter sparade");
                    } else {
                        ui.ShowMessage(sb.toString());
                    }
                    break;


            }
        }

    }
}
