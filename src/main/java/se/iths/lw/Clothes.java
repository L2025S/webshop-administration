package se.iths.lw;

import java.util.Locale;

class Clothes extends Product {
    private String size;
    private String color;

    Clothes (String articleNumber, String title, String size, String color, double price,String description, int stock ) {
        super (articleNumber, title, price, description, stock);
        this.size = size;
        this.color = color;
    }
    String getSize () {
        return size;
    }
    String getColor(){
        return color;
    }
    void setSize (String size) {
        this.size = size;
    }
    void setColor (String color) {
        this.color = color;
    }

    @Override
    String category(){
        return "Clothes";
    }

    @Override
    public String toCsvFormat() {
        return String.format (Locale.US, "%s, %s, %s, %s, %.2f, %s, %d", getArticleNumber(), getTitle(),size, color, getPrice(),getDescription(), getStock());
    }
}
