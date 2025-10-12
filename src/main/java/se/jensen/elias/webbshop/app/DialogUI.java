package se.jensen.elias.webbshop.app;

import javax.swing.*;

public class DialogUI implements UserInterface {

    @Override
    public String input(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
