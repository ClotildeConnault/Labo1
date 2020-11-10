package be.technifutur.java2020.Labo1;

import java.util.Scanner;

public class ConsoleUser implements User {

    private Scanner scan = new Scanner(System.in);
    @Override
    public String getInput() {
        return scan.nextLine();
    }
}
