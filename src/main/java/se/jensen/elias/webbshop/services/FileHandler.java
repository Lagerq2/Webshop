package se.jensen.elias.webbshop.services;

import se.jensen.elias.webbshop.models.Book;
import se.jensen.elias.webbshop.models.Movie;
import se.jensen.elias.webbshop.models.Pen;
import se.jensen.elias.webbshop.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    //Metod som returnerar en lista med produkter
    public static List<Product> readFromFile(String filename) {
        List<Product> products = new ArrayList<>();
        File file = new File("src/main/java/se/jensen/elias/webbshop/data/products.txt");


        if (!file.exists()) {
            return products;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {

                //Delar upp objekten vid ; och återskapar dem från filen
                String[] parts = line.split(";");
                if (parts.length >= 4) {
                    String type = parts[0];
                    String name = parts[1];
                    String extra = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    String id = parts[4];

                    //Avgör om det är bok eller film
                    switch (type) {
                        case "Book":
                            products.add(new Book(name, price, extra, id));
                            break;
                        case "Movie":
                            products.add(new Movie(name, price, extra, id));
                            break;
                        case "Pen":
                            products.add(new Pen(name, price, extra, id));
                    }
                }
            }

            //om något inte går som det ska
        } catch (IOException e) {
            System.out.println("Fel vid fil läsning: " + e.getMessage());
        }
        return products;
    }

    //Metod som skriver till filen
    public static void saveToFile(String filename, List<Product> products) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {

            //loopar igenom listan med produkter och sparar det i filen
            for (Product product : products) {
                String type;

                //Kontrollerar vilken typ objektet är
                if (product instanceof Book) {
                    type = "Book";
                } else if (product instanceof Movie) {
                    type = "Movie";
                } else if (product instanceof Pen) {
                    type = "Pen";
                } else {
                    continue;
                }

                bw.write(type + ";" + product.getName() + ";" + product.getExtra() + ";" + product.getPrice() + ";" + product.getId());
                bw.newLine();
            }

            //vid fel
        } catch (IOException e) {
            System.out.println("Fel vid fil skrivningen: " + e.getMessage());
        }
    }
}
