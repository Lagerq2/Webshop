package se.jensen.elias.webbshop.models;

public class Movie extends Product {
    private String director;

    public Movie(String name, double price, String director, String id) {
        super(name, price, id);
        this.director = director;
    }

    public String getExtra() {
        return director;
    }

    @Override
    public String category() {
        return "Film";
    }

    @Override
    public String toString() {
        return super.toString() + " - Regissör: " + director;
    }

}
