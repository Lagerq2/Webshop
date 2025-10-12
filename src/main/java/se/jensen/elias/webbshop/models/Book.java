package se.jensen.elias.webbshop.models;

public class Book extends Product {
    private String author;

    public Book(String name, String price, String author, String id) {
        super(name, price, id);
        this.author = author;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "Bok " + "Namn: " + getName() + " Pris: " + getPrice() + "kr" + " Author: " + author;
    }
}
