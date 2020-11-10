package be.technifutur.java2020.Labo1;

import java.util.Arrays;
import java.util.Iterator;

public class TestUser implements User {

    private Iterator<String> iterator;

    public TestUser(Iterator<String> iterator) {
        this.iterator = iterator;
    }

    @Override
    public String getInput() {
        String input = iterator.next();
        System.out.println(input);
        return input;
    }

}
