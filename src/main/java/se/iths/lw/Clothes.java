package se.iths.lw;

import javax.swing.*;
import java.util.Locale;

class Clothes extends Product {
    private String size;
    private String color;

    Clothes (String articleNumber, String title, String size, String color, double price, String description, int stock ) {
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
        return String.format (Locale.US, "%s, %s, %s, %s, %.2f, %s, %d", getArticleNumber(), getTitle(),size, color, getPrice(), getDescription(), getStock());
    }

    @Override
    Clothes addNew() {
        Clothes clothes = new Clothes (getArticleNumber(), getTitle(), size, color, getPrice(), getDescription(), getStock());
        String articleNumber = JOptionPane.showInputDialog("Enter Article Number:");
        clothes.setArticleNumber(articleNumber);
        String title = JOptionPane.showInputDialog("Enter Title: ");
        clothes.setTitle(title);
        String size = (JOptionPane.showInputDialog("Enter Size: e.g X,M,or L")).toUpperCase();
        clothes.setSize(size);
        String color = JOptionPane.showInputDialog("Enter Color: ");
        clothes.setColor(color);
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price"));
        clothes.setPrice(price);
        String description = JOptionPane.showInputDialog("Enter the description");
        clothes.setDescription(description);
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Enter the stock"));
        clothes.setStock(stock);
        return clothes;
    }
}
