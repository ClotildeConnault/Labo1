package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.activity.ActivityControler;
import be.technifutur.java2020.Labo1.activity.ActivityCreationControler;
import be.technifutur.java2020.Labo1.stage.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class MainControler extends Controler {

    private StageList list;
    private StageVue vue;
    private MenuPrincipal menu;
    private TreeMap<String, Controler> controlerList;

    public MainControler() {
        controlerList = new TreeMap<String, Controler>();
    }

    public void setModel(StageList list) {
        this.list = list;
    }
    public void setMenu(MenuPrincipal menu) {
        this.menu = menu;
    }

    public void addControler(String key, Controler controler) {
        controlerList.put(key, controler);
    }


    @Override
    public void setVue(Vue vue) {
        this.vue = (StageVue) vue;
    }

    @Override
    public void run(String key) {

    }

    @Override
    public void run() {
        String input = null;
        do {
            menu.displayMenuPrincipal();
            input = null;

            do {
                input = menu.getChoice();
                if (input == null) {
                    vue.erreurInputMenu();
                    menu.displayMenuPrincipal();
                }
            } while (input == null);

            switch (input) {
                case "1":
                    controlerList.get("1").run();
                    break;
                case "2":
                    controlerList.get("2").run();
                    break;
                case "3":
                    controlerList.get("3").run();
                    break;
                case "4":
                    vue.displayStages();
                    break;
                case "5":
                    vue.consigneChoixStage();
                    if (list.getList() != null) {
                        vue.displayStages();
                        String nomStage = scan.nextLine();
                        //test ---------------------------------------------------------------
                        System.out.println("Test" + list.getList().containsKey(nomStage));
                        //Fin Test -----------------------------------
                        if (!list.getList().containsKey(nomStage)) {
                            vue.doesNotExist();
                        }
                        else {
                            ActivityControler c = (ActivityControler)controlerList.get("5");
                            c.run(nomStage);
                        }
                    }
                    else {
                        vue.noStages();
                    }

                    break;
            }

        } while (!input.equalsIgnoreCase("q"));

        vue.messageSortie();
    }

}
