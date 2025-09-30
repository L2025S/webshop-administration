package se.iths.lw;

import javax.swing.*;

class Main {
    public static void main(String[] args) {

        Object [] functions = { "Add product", "List all products", "Show product's info.", "Exit application"};
        Object selectedFunction = JOptionPane.showInputDialog(
                null,
                "Choose the function",
                "Functions",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                functions,
                functions[0]
        );

    }
}
