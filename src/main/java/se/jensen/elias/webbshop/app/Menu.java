package se.jensen.elias.webbshop.app;

import se.jensen.elias.webbshop.models.Book;
import se.jensen.elias.webbshop.models.Movie;
import se.jensen.elias.webbshop.models.Pen;
import se.jensen.elias.webbshop.models.Product;
import se.jensen.elias.webbshop.services.FileHandler;

import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private final List<Product> products;
    private UserInterface ui;

    public Menu(List<Product> products) {
        this.products = products;
    }

    public void showWelcomeMenu() {

      while(true) {
        System.out.println(
                """
                        Webbshoppen
                        ----------------
                        [1] Grafiskt gränssnitt:\s
                        [2] Konsol""");
        String uiChoice = scanner.nextLine();

        if (uiChoice.equals("2")) {
            ui = new ConsoleUI();
            return;
        } else if  (uiChoice.equals("1")) {
            ui = new DialogUI();
            return;
        } else {
            System.out.println("Välj alternativ [1] eller [2]!\nFörsök igen\n");
        }
      }
    }

    public void showAppMenu() {

        while (true) {

            String choice = ui.showMenu();

            if (choice == null || choice.equals("0")) break;

            switch (choice) {
                case "1": //lägg till bok
                    String bokName = ui.input("Ange Boknamn: ");
                    double bokPrice = ui.inputDouble("Ange pris: ");
                    String bokAuthor = ui.input("Ange författare: ");
                    String bokId = ui.input("Ange artikelnummer: ");
                    products.add(new Book(bokName, bokPrice, bokAuthor, bokId));
                    break;
                case "2": //Lägg till film
                    String movieName = ui.input("Ange filmnamn: ");
                    double moviePrice = ui.inputDouble("Ange pris: ");
                    String movieDirector = ui.input("Ange Regissör: ");
                    String movieId = ui.input("Ange artikelnummer: ");
                    products.add(new Movie(movieName, moviePrice, movieDirector, movieId));
                    break;
                case "3": //Lägg till penna
                    String penName = ui.input("Ange namnet på pennan: ");
                    double penPrice = ui.inputDouble("Ange pris: ");
                    String type = ui.input("Ange typ av penna: ");
                    String penId = ui.input("Ange artikelnummer: ");
                    products.add(new Pen(penName, penPrice, type, penId));
                    break;
                case "4": //Skriv ut produktlista
                    StringBuilder sb = new StringBuilder("Sparade produkter: \n");
                    for (Product product : products) {
                        sb.append(product).append("\n");
                    }
                    if (products.isEmpty()) {
                        sb.append("Inga produkter sparade");
                    } else {
                        ui.showMessage(sb.toString());
                    }
                    break;

                case "5": //Sök efter produkt
                    ui.searchProduct(products);
                    break;

                case "6": //Välj Gränssnitt igen
                    showWelcomeMenu();
                    break;

                case "7":  //Spara och avsluta
                    FileHandler.saveToFile("src/main/java/se/jensen/elias/webbshop/data/products.txt", products);
                    return;
            }
        }
    }
}
