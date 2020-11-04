package be.technifutur.java2020.Labo1;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vue vue = new Vue();
        Model model = new Model();
        Controler controler = new Controler();
        Scanner scan = new Scanner(System.in);

        controler.setVue(vue);
        controler.setModel(model);
        vue.setModel(model);

    controler.creationStage();






    }


}
