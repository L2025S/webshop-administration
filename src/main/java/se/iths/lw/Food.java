package se.iths.lw;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Locale;

class Food extends Product {
    private LocalDate expirationDate;

    Food (String articleNumber, String title, double price, String description,int stock, LocalDate expirationDate){
        super(articleNumber, title, price, description, stock);
        this.expirationDate = expirationDate;
    }

    LocalDate getExpirationDate() {
        return expirationDate;
    }

    void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    String category() {
        return "Food";
    }

    @Override
    public String toCsvFormat() {
        return String.format(Locale.US, "%s, %s, %.2f, %s, %d, %s ", getArticleNumber(), getTitle(), getPrice(), getDescription(), getStock(),expirationDate);
    }
    @Override
    Food addNew() {
        Food food = new Food(getArticleNumber(), getTitle(), getPrice(), getDescription(), getStock(), expirationDate);
        String articleNumber = JOptionPane.showInputDialog("Enter Article Number:");
        food.setArticleNumber(articleNumber);
        String title = JOptionPane.showInputDialog("Enter Title:");
        food.setTitle(title);
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price: ")); // Swedish decimal point
        food.setPrice(price);
        String description = JOptionPane.showInputDialog("Enter Description:");
        food.setDescription(description);
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Enter Stock Quantity: "));
        food.setStock(stock);
        LocalDate expirationDate = LocalDate.parse(JOptionPane.showInputDialog ("Enter Expiration Date : yyyy-mm-dd"));
        food.setExpirationDate(expirationDate);
        return food;
    }

}
