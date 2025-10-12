package se.jensen.elias.webbshop.models;

public abstract class Product implements ProductInterface {
    private String name;
    private String price;
    private String id;

    public Product(String name, String price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getInfo() {
        return "Product typ: ";
    }
}


