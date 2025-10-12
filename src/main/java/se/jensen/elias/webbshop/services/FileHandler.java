package se.jensen.elias.webbshop.services;

import se.jensen.elias.webbshop.models.Book;
import se.jensen.elias.webbshop.models.Movie;
import se.jensen.elias.webbshop.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileHandler {

    public static List<Product> readFromFile(String filename) {
        List<Product> products = new ArrayList<>();
        File file = new File("src/main/java/se/jensen/elias/webbshop/data/products.txt");


        if (!file.exists()) {
            return products;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(";");
                if (parts.length >= 4) {
                    String type = parts[0];
                    String name = parts[1];
                    String authorProducer = parts[2];
                    String price = parts[3];
                    String id = parts[4];

                    switch (type) {
                        case "Book":
                            products.add(new Book(name, price, authorProducer, id));
                            break;
                        case "Movie":
                            products.add(new Movie(name, price, authorProducer, id));
                            break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Fel vid fil läsning: " + e.getMessage());
        }
        return products;
    }

    public static void saveToFile(String filename, List<Product> products) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Product product : products) {
                String type;

                if (product instanceof Book) {
                    type = "Book";
                } else if (product instanceof Movie) {
                    type = "Movie";
                } else {
                    continue;
                }

                bw.write(type + ";" + product.getName() + ";" + product.getPrice() + ";" + product.getId());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Fel vid fil skrivningen: " + e.getMessage());

        }
    }


}
