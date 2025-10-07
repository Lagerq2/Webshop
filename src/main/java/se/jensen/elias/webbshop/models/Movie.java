package se.jensen.elias.webbshop.models;

public class Movie extends Product {
    String director;

    public Movie(String name, String price, String director) {
        this.director = director;
        super(name, price);
    }

    @Override
    public String getInfo() {

        return super.getInfo() + "Film namn: " + getName() + " Regissör: " + director;
    }
}
