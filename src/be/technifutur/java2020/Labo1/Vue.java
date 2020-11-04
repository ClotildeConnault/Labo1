package be.technifutur.java2020.Labo1;

import java.time.format.DateTimeFormatter;

public class Vue {

    private Model model;

    public void setModel(Model model){
        this.model = model;
    }

    public void afficheStages(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("Liste des stages");
        System.out.println();
        System.out.println("nom du stage" + "   " + "début du stage" + "   " + "fin du stage");
        for (Integer key : this.model.getStages().keySet()) {
            System.out.print(
                    key + " " +
                    this.model.getStages().get(key).getName() + " " +
                    this.model.getDateDebut(key).format(formatter) + " " +
                            this.model.getDateFin(key).format(formatter)
            );
            System.out.println();
        }
    }
}
