package se.jensen.elias.webbshop.services;

import se.jensen.elias.webbshop.models.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    public static void saveToFile(List<Product> poducts, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Product product : poducts) {
                writer.println(product.getClass().getSimpleName() + ";" + product.getInfo());
            }

        } catch (IOException e) {
            System.out.println("Fel vid filskrivningen: " + e.getMessage());
        }
    }

    public static void readFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                System.out.println("Från fil: " + scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Fel vid läsning av fil: " + e.getMessage());
        }
    }
}
