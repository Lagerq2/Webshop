package se.jensen.elias.webbshop.app;

import se.jensen.elias.webbshop.models.Product;

import javax.swing.*;
import java.util.List;

public class DialogUI implements UserInterface {

    @Override
    public String input(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public String showMenu() {
        String menu = """
                      --- MENY ---
                  1. Lägg till Bok
                  2. Lägg till Film
                  3. Lägg till Penna
                  4. Skriv ut produktlista
                  5. Skriv ut en produkt
                  6. Välj annat gränssnitt
                  7. Spara och avsluta
                """;
        return JOptionPane.showInputDialog(null, menu);
    }

    @Override
    public void searchProduct(List<Product> products) {
        String id = JOptionPane.showInputDialog(null, "Ange artikelnummer: ");

        if (id == null || id.isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingen sökning gjordes.");
            return;
        }

        Product found = null;
        for (Product p : products) {
            if (p.getId().equals(id)) {
                found = p;
                break;
            }
        }
        if (found != null) {
            JOptionPane.showMessageDialog(null, "Produkten hittades:\n" + found);
        } else {
            JOptionPane.showMessageDialog(null, "Ingen produkt hittades med ID: " + id);
        }
    }
}
