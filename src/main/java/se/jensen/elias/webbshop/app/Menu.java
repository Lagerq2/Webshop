package se.jensen.elias.webbshop.app;

import se.jensen.elias.webbshop.models.Book;
import se.jensen.elias.webbshop.models.Movie;
import se.jensen.elias.webbshop.models.Product;
import se.jensen.elias.webbshop.services.FileHandler;

import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private List<Product> products;
    private UserInterface ui;

    public Menu(List<Product> products) {
        this.products = products;
    }

    public void showWelcomeMenu() {

        System.out.println(
                """
                        Webbshoppen
                        ----------------
                        [1] Grafiskt gränssnitt:\s
                        [2] Konsol""");
        String uiChoice = scanner.nextLine();

        if (uiChoice.equals("2")) {
            ui = new ConsoleUI();
        } else {
            ui = new DialogUI();
        }
    }

    public void showAppMenu() {

        while (true) {
            String menu = "1. Lägg till bok\n" +
                    "2. Lägg till Bil\n" +
                    "3. Visa produkter\n" +
                    "4. Välj annat Gränssnitt\n" +
                    "5. Spara och avsluta\n" +
                    "Välj ett av alternativen: ";
            String choice = ui.input(menu);

            if (choice == null || choice.equals("0")) break;

            switch (choice) {
                case "1":
                    String bokName = ui.input("Ange Boknamn: ");
                    String bokPrice = ui.input("Ange pris: ");
                    String bokAuthor = ui.input("Ange författare: ");
                    String bokId = ui.input("Ange artikelnummer: ");
                    products.add(new Book(bokName, bokPrice, bokAuthor, bokId));
                    break;
                case "2":
                    String movieModel = ui.input("Ange filmnamn: ");
                    String moviePrice = ui.input("Ange pris: ");
                    String movieBrand = ui.input("Ange Regissör: ");
                    String movieId = ui.input("Ange artikelnummer: ");
                    products.add(new Movie(movieModel, moviePrice, movieBrand, movieId));
                    break;
                case "3":
                    StringBuilder sb = new StringBuilder("Sparade produkter: \n");
                    for (Product product : products) {
                        sb.append(product.getInfo()).append("\n");
                    }
                    if (products.isEmpty()) {
                        sb.append("Inga produkter sparade");
                    } else {
                        ui.showMessage(sb.toString());
                    }
                    break;
                case "4":
                    showWelcomeMenu();
                    break;
                case "5":
                    FileHandler.saveToFile("src/main/java/se/jensen/elias/webbshop/data/products.txt", products);
                    break;
            }
        }
    }
}
