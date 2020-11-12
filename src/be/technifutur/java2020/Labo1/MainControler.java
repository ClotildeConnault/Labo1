package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.activity.ActivityControler;
import be.technifutur.java2020.Labo1.contributor.ContributorControler;
import be.technifutur.java2020.Labo1.stage.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

public class MainControler extends Controler {

    protected StageList list;
    protected StageVue vue;
    private MenuPrincipal menu;
    private TreeMap<ControlerType, Controler> controlerList;

    public MainControler() {
        controlerList = new TreeMap<>();
    }

    public void setModel(StageList list) {
        this.list = list;
    }
    public void setMenu(MenuPrincipal menu) {
        this.menu = menu;
    }
    public void addControler(ControlerType key, Controler controler) {
        controlerList.put(key, controler);
    }


    @Override
    public void setVue(Vue vue) {
        this.vue = (StageVue) vue;
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
                    controlerList.get(ControlerType.STAGECREATIONCONTROLER).run();
                    break;
                case "2":
                    controlerList.get(ControlerType.STAGEMODIFCONTROLER).run();
                    break;
                case "3":
                    controlerList.get(ControlerType.STAGESUPPRESSIONCONTROLER).run();
                    break;
                case "4":
                    if (!list.getList().isEmpty()) {
                        vue.displayStages();
                    }
                    else {
                        vue.noStages();
                    }
                    break;
                case "5":
                    if (!list.getList().isEmpty()) {
                        vue.consigneActivityStage();
                        vue.displayStages();
                        String stageName = scan.nextLine();

                        if (!list.getList().containsKey(stageName)) {
                            vue.doesNotExist();
                        }
                        else {
                            ((ActivityControler)controlerList.get(ControlerType.ACTIVITYCONTROLER)).setActiveStage(stageName);
                            controlerList.get(ControlerType.ACTIVITYCONTROLER).run();
                        }
                    }
                    else {
                        vue.noStages();
                    }
                    break;
                case "6":
                    if (list.getList().isEmpty()) {
                        vue.noStages();
                    }
                    else {
                        vue.displayStages();
                        vue.consigneAffichePlanning();
                        input = scan.nextLine();
                        if (stageExists(input)) {
                            vue.displayStageSchedule(input);
                        }
                    }
                    break;
                case "7":
                    if (list.getList().isEmpty()) {
                        vue.noStages();
                    }
                    else {
                        vue.displayStages();
                        vue.consigneContributorStage();
                        input = scan.nextLine();
                        if (stageExists(input)) {
                            ((ContributorControler)controlerList.get(ControlerType.CONTRIBUTORCONTROLER)).setActiveStage(input);
                            controlerList.get(ControlerType.CONTRIBUTORCONTROLER).run();
                        }
                        else {
                            run();
                        }
                    }
                    break;
                case "8":
                        vue.displayContributors();

                    break;
            }

        } while (!input.equalsIgnoreCase("q"));

        vue.messageSortie();

        writeObjectToFile(list);
        //TODO ajouter ici l'enregistrement des données
    }

   public boolean stageExists(String key) {
        boolean exists = true;
        if(!list.getList().containsKey(key)) {
            vue.doesNotExist();
            exists = false;
        }
        return exists;
    }


    public void writeObjectToFile(Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream(Factory.filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
