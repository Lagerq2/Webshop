package se.jensen.elias.webbshop.models;

public class Book extends Product {
    private String author;

    //Bok klass som skapar bok objekt, extends den abstrakta Product klassen
    public Book(String name, double price, String author, String id) {
        super(name, price, id);
        this.author = author;
    }

    //getter metod som returns objektets egna fält/attribut
    public String getExtra() {
        return author;
    }

    //Returnar typ av objekt
    @Override
    public String category() {
        return "Bok";
    }

    //En egen toString för bok objekten
    @Override
    public String toString() {
        return super.toString() + " - Författare: " + author;
    }
}
