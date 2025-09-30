package se.iths.lw;

import java.time.LocalDate;
import java.util.Locale;

class Food extends Product {
    private LocalDate expirationDate;

    Food (String articleNumber, String title, double price, String description, LocalDate expirationDate,int stock){
        super(articleNumber,title,price, description, stock);
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
        return String.format(Locale.US, "%s, %s, %.2f, %s, %s ", getExpirationDate(), getTitle(), getPrice(), expirationDate, getStock());
    }


}
