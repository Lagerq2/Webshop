package se.jensen.elias.webbshop.app;

import java.util.Scanner;

public class ConsoleUI implements UserInterface {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
