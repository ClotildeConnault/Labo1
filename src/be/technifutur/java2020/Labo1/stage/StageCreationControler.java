package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.ControlerType;
import be.technifutur.java2020.Labo1.MainControler;

import java.util.Scanner;

public class StageCreationControler extends MainControler {

    public StageCreationControler() {
        type = ControlerType.STAGECREATIONCONTROLER;
        generalType.clear();
        generalType.add(ControlerType.STAGE);
    }
    public void run(){

        Scanner scan = new Scanner(System.in);
        vue.consigneCreaStage();
        vue.consigneNomStage();
        String nomStage = scan.nextLine();
        list.add(nomStage);
        boolean dateTimeException = false;
        String input = null;

        setDateDebut(nomStage);
        setDateFin(nomStage);


        do {
            vue.demandeDiscount();
            input = scan.nextLine();
        } while (!isONValid(input));

        if (input.equalsIgnoreCase("o")) {
            ((StagePriceControler) controlerList.getControler(ControlerType.STAGEPRICECONTROLER)).setActiveStage(nomStage);
            controlerList.getControler(ControlerType.STAGEPRICECONTROLER).run();
        }

        vue.succes();
        vue.displayStage(nomStage);

    }

    @Override
    public String toString() {
        return "Créer un stage";
    }

}