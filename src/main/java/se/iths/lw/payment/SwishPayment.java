package se.iths.lw.payment;

import javax.swing.*;
import java.util.Scanner;

public class SwishPayment implements Payment {

    @Override
    public void pay(double amount) {
        Scanner sc = new Scanner(System.in);
            String userInput = JOptionPane.showInputDialog(null, "Please enter your mobile number: ", "Payment: Swish", JOptionPane.QUESTION_MESSAGE);
            System.out.println("Payment is being processed...");
            System.out.println("Payment completed!");

    }
}

