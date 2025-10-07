package se.jensen.elias.webbshop.models;

public abstract class Product implements ProductInterface {
    private String name;
    private String price;

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String getInfo() {
        return "Product typ: ";
    }
}


