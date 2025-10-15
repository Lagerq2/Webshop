package se.jensen.elias.webbshop.app;


import se.jensen.elias.webbshop.models.Product;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements UserInterface {
    //Scanner som är final, alltså den ska inte ändras
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    //Visar menyn
    @Override
    public String showMenu() {
        System.out.println("""
                      --- MENY ---
                  1. Lägg till Bok
                  2. Lägg till Film
                  3. Lägg till Penna
                  4. Skriv ut produktlista
                  5. Skriv ut en produkt
                  6. Välj annat gränssnitt
                  7. Spara och avsluta
                """);
        return scanner.nextLine();

    }

    //metod som jämför det du sökte med objekten i listan
    @Override
    public void searchProduct(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ange artikelnummer: ");
        String id = scanner.nextLine();

        Product found = null;
        for (Product p : products) {
            if (p.getId().equals(id)) {
                found = p;
                break;
            }
        }

        if (found != null) {
            System.out.println("Produkten hittades:\n" + found);
        } else {
            System.out.println("Ingen produkt hittades med ID: " + id);
        }
    }

    //Felhanterar om man inte skriver siffror på pris.
    public double inputDouble(String message){
        while (true) {
            try {
                return Double.parseDouble(input(message));
            } catch (NumberFormatException e) {
                showMessage("Fel: Du måste skriva enbart med siffror. Försök igen!");
            }
        }
    }
}
