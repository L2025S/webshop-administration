package se.iths.lw;

import java.time.LocalDate;

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
    public String toString() {
        super.toString(); // 这个多余了？ 还是说没有作用？
        return "Expiration Date: " + expirationDate;
    }
}
