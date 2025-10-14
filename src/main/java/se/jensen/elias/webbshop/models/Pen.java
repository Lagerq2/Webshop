package se.jensen.elias.webbshop.models;

public class Pen extends Product {
    private String typeOfPen;

    public Pen(String name, double price, String typeOfPen, String id) {
        super(name, price, id);
        this.typeOfPen = typeOfPen;
    }

    public String getExtra() {
        return typeOfPen;
    }

    @Override
    public String category() {
        return "Penna";
    }

    @Override
    public String toString() {
        return super.toString() + " - Typ: " + typeOfPen;
    }
}
