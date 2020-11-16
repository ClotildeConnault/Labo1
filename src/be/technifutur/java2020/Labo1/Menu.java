package be.technifutur.java2020.Labo1;

import com.sun.jdi.Value;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
    protected TreeMap<String, Object> options;
    protected Scanner scan = new Scanner(System.in);
    protected String input = null;

    public Menu() {

    }

    public Menu(Map map) {
        int i = 1;
        options = new TreeMap<>();
        for (Object value: map.values()) {
            options.put(String.valueOf(i), value);
            i++;
        }

    }

    public Object getOption(String optionNumber) {
        return options.get(optionNumber);
    }

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
