package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.activity.ActivityControler;
import be.technifutur.java2020.Labo1.activity.ActivityList;
import be.technifutur.java2020.Labo1.activity.ActivityMenu;
import be.technifutur.java2020.Labo1.activity.ActivityVue;
import be.technifutur.java2020.Labo1.stage.StageList;
import be.technifutur.java2020.Labo1.stage.StageVue;

public class Main {
    public static void main(String[] args) {
       /* StageVue vue = new StageVue();
        StageList list = new StageList();
        MainControler mainControler = new MainControler();
        MenuPrincipal menuPrincipal = new MenuPrincipal(); */

       /* mainControler.setVue(vue);
        mainControler.setModel(list);
        vue.setModel(list);
        mainControler.setMenu(menuPrincipal); */

        ActivityVue activityVue = new ActivityVue();
        ActivityList activityList = new ActivityList();
        ActivityMenu activityMenu = new ActivityMenu();
        ActivityControler activityControler = new ActivityControler();

        activityControler.setVue(activityVue);
        activityControler.setModel(activityList);
        activityControler.setMenu(activityMenu);
        activityVue.setModel(activityList);

        activityControler.run();



    }

//TODO relier les contrôleurs d'Activity au menu
//TODO revoir "optional" -> peut renvoyer quelque chose ou non
// TODO créer la fabrique
// TODO MainControler doit détenir un tableau avec tous les sous Controleurs

}


