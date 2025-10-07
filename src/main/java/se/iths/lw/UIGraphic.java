package se.iths.lw;

import javax.swing.*;

public class UIGraphic implements UI{


    @Override
    public String menu() {
        Object[] functions = {"Add product", "List all products", "Show product's info.", "Exit application"};
        Object selectedFunction = JOptionPane.showInputDialog(
                null,
                "Choose the function",
                "Functions",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                functions,
                functions[0]
        );
        return selectedFunction.toString();
    }

    @Override
    public String productMenu() {
        Object[] addProduct = {"Add Book", "Add Clothes", "Add Food"};
        Object selectedProduct = JOptionPane.showInputDialog(
                null,
                "Choose the category",
                "Category",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                addProduct,
                addProduct[0]
        );
        return selectedProduct.toString();
    }
}
