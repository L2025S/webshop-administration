package se.iths.lw;

import javax.swing.*;
import java.util.Locale;

class Clothes extends Product {
    private String size;
    private String color;

    Clothes (String articleNumber, String title,double price, String description, int stock, String size, String color ) {
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

    void printProductInfo(){
        System.out.println("\n Article number:" + getArticleNumber() + "\n Title: " + getTitle() + "\n Price: " + getPrice() +
                "\n Description: " + getDescription()+ "\n Stock: " + getStock() + "\n Size: " + size + "\n Color: " + color);
    }

    @Override
    public String toCsvFormat() {
        return String.format (Locale.US, "%s, %s, %.2f, %s, %d, %s, %s ", getArticleNumber(), getTitle(), getPrice(), getDescription(), getStock(), size, color);
    }

    @Override
    void addNew() {
        super.addNew();
        setSize ((JOptionPane.showInputDialog("Enter Size: e.g X,M,or L")).toUpperCase());
        setColor(JOptionPane.showInputDialog("Enter Color: "));
    }

}
