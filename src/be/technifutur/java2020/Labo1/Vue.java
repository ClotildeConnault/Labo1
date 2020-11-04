package be.technifutur.java2020.Labo1;

import java.time.format.DateTimeFormatter;

public class Vue {

    private StageList stageList;

    public void setModel(StageList stageList){
        this.stageList = stageList;
    }

    public void afficheStages(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("Liste des stages");
        System.out.println();
        System.out.println("nom du stage" + "   " + "début du stage" + "   " + "fin du stage");
        for (Integer key : this.stageList.getStages().keySet()) {
            System.out.print(
                    key + " " +
                    this.stageList.getStages().get(key).getName() + " " +
                    this.stageList.getDateDebut(key).format(formatter) + " " +
                            this.stageList.getDateFin(key).format(formatter)
            );
            System.out.println();
        }
    }

    public void afficheStage(Integer key) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.print(
                        this.stageList.getStages().get(key).getName() + " " +
                        this.stageList.getDateDebut(key).format(formatter) + " " +
                        this.stageList.getDateFin(key).format(formatter)
        );
    }
}
