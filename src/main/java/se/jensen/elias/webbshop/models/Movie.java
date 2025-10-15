package se.jensen.elias.webbshop.models;

public class Movie extends Product {
    private String director;

    //Film klass som skapar film objekt
    public Movie(String name, double price, String director, String id) {
        super(name, price, id);
        this.director = director;
    }

    //Metod som returnar klassens egna attribut
    public String getExtra() {
        return director;
    }

    //returnar vilken typ av objekt det är
    @Override
    public String category() {
        return "Film";
    }

    //egen toString för just film objekt
    @Override
    public String toString() {
        return super.toString() + " - Regissör: " + director;
    }

}
