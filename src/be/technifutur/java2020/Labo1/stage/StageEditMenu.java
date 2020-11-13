package be.technifutur.java2020.Labo1.stage;

import java.util.TreeMap;
import be.technifutur.java2020.Labo1.Menu;

public class StageEditMenu extends Menu {

    public StageEditMenu() {
        options = new TreeMap<>();
        options.put("1", "Changer le nom du stage");
        options.put("2", "Changer les dates ");
        options.put("3", "Ajouter ou supprimer des réductions");
        options.put("Q", "Retour");
    }


}
