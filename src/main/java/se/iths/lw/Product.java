package se.iths.lw;

import javax.swing.*;

abstract class Product {
    private String articleNumber;
    private String title;
    private double price;
    private String description;
    private int stock;

    Product (String articleNumber, String title, double price, String description, int stock) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    abstract String category ();

    String getArticleNumber() {
        return articleNumber;
    }
    String getTitle() {
        return title;
    }
    double getPrice() {
        return price;
    }
    String getDescription(){
        return description;
    }
    int getStock(){
        return stock;
    }
    void setArticleNumber (String articleNumber) {
        this.articleNumber = articleNumber;
    }
    void setTitle(String title){
        this.title = title;
    }
    void setPrice(double price){
        this.price = price;
    }
    void setDescription(String description) {
        this.description = description;
    }
    void setStock(int stock) {
        this.stock = stock;
    }

    abstract String toCsvFormat();

    void addNew() {
        setArticleNumber (JOptionPane.showInputDialog("Enter Article Number:"));
        setTitle (JOptionPane.showInputDialog("Enter Title:"));
        setPrice(Double.parseDouble((JOptionPane.showInputDialog("Enter Price: ")).replace(",","."))); // Swedish decimal point
        setDescription(JOptionPane.showInputDialog("Enter Description:"));
        setStock(Integer.parseInt(JOptionPane.showInputDialog("Enter Stock Quantity: ")));
    }
}
