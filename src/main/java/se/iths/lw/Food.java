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
    void addNew() {
        super.addNew();
        setExpirationDate(LocalDate.parse(JOptionPane.showInputDialog ("Enter Expiration Date : yyyy-mm-dd")));

    }

}
