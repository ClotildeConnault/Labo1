package be.technifutur.java2020.Labo1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
    protected TreeMap<String, String> options;
    protected Scanner scan = new Scanner(System.in);
    protected String input = null;

    public void displayMenu() {
        for (Map.Entry entry : options.entrySet()) {
            System.out.print(entry.getKey() + " - " + entry.getValue() + "\n");
        }
    }

    public String getChoice() {
        input = scan.nextLine().toUpperCase();
        if(!options.containsKey(input)) {
            input = null;
        }
        return input;
    }
}
