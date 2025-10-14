package se.jensen.elias.webbshop.models;

public class Book extends Product {
    private String author;

    public Book(String name, double price, String author, String id) {
        super(name, price, id);
        this.author = author;
    }

    public String getExtra() {
        return author;
    }

    @Override
    public String category() {
        return "Bok";
    }

    @Override
    public String toString() {
        return super.toString() + " - Författare: " + author;
    }
}
