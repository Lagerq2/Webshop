package se.jensen.elias.webbshop.models;

public class Pen extends Product {
    private String typeOfPen;

    //Pen klass som skapar penn objekt
    public Pen(String name, double price, String typeOfPen, String id) {
        super(name, price, id);
        this.typeOfPen = typeOfPen;
    }

    //returnar klassens egna attribut
    public String getExtra() {
        return typeOfPen;
    }

    //returnar typ av objekt
    @Override
    public String category() {
        return "Penna";
    }

    //Egen toString för Pen objekt
    @Override
    public String toString() {
        return super.toString() + " - Typ: " + typeOfPen;
    }
}
