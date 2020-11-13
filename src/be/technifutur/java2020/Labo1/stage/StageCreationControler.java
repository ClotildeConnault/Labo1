package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.Controler;
import be.technifutur.java2020.Labo1.ControlerType;
import be.technifutur.java2020.Labo1.MainControler;
import be.technifutur.java2020.Labo1.Vue;

import java.time.DateTimeException;
import java.util.Scanner;

public class StageCreationControler extends MainControler {

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
            ((StagePriceControler)controlerList.get(ControlerType.STAGEPRICECONTROLER)).setActiveStage(nomStage);
            controlerList.get(ControlerType.STAGEPRICECONTROLER).run();
        }

        vue.succes();
        vue.displayStage(nomStage);

    }

}