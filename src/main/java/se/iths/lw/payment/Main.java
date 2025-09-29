package se.iths.lw.payment;

import javax.swing.*;

class Main {
    public static void main(String[] args) {

        Object [] alternatives = {"Add product", "List all products", "Show info. about a product", "Exit application"};
        Object selectedValue = JOptionPane.showInputDialog (
                null,
                "Please choose",
                "Product Management",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                alternatives,
                alternatives[0]
        );
    }
}
