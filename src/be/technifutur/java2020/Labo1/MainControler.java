package be.technifutur.java2020.Labo1;
import be.technifutur.java2020.Labo1.stage.*;
import java.time.DateTimeException;


public class MainControler extends Controler {

    protected StageList list;
    protected StageVue vue;
    protected Menu menu;

    public MainControler() {
        type = ControlerType.MAINCONTROLER;
        generalType.add(ControlerType.STAGE);
        generalType.add(ControlerType.MAIN);

    }

    public void setModel(StageList list) {
        this.list = list;
    }


    @Override
    public void setVue(Vue vue) {
        this.vue = (StageVue) vue;
    }

    @Override
    public String toString() {
        return "Menu Principal";
    }

    @Override
    public void run() {
        String input;
        menu = new Menu(controlerList.getControlerList());

        do {
            menu.displayMenu();
            input = null;

            do {
                input = menu.getChoice();
                if (input == null) {
                    vue.erreurInputMenu();
                    menu.displayMenu();
                }
            } while (input == null);

            ((Controler)menu.getOption(input)).run();

        } while (!input.equalsIgnoreCase("q"));

        vue.messageSortie();

    }

   public boolean stageExists(String key) {
        boolean exists = true;
        if(!list.getList().containsKey(key)) {
            vue.doesNotExist();
            exists = false;
        }
        return exists;
    }

    public void setDateDebut(String nomStage) {
        boolean dateTimeException = false;
        String input = null;

        do {
            dateTimeException = false;
            try {
                do {
                    vue.consigneDateDebut();
                    input = scan.nextLine();
                } while (!isDateFormatValid(input));

                list.setDateDebut(
                        nomStage,
                        Integer.valueOf(input.substring(0, 4)),
                        Integer.valueOf(input.substring(5, 7)),
                        Integer.valueOf(input.substring(8, 10)),
                        Integer.valueOf(input.substring(11, 13)),
                        Integer.valueOf(input.substring(14))
                );


            } catch (DateTimeException e){
                dateTimeException = true;
                System.out.println(e);
            }

        } while (dateTimeException);
    }

    public void setDateFin(String nomStage) {
        boolean dateTimeException = false;
        String input = null;

        do {
            dateTimeException = false;
            try {
                do {
                    vue.consigneDateFin();
                    input = scan.nextLine();
                } while (!isDateFormatValid(input));

                list.setDateFin(
                        nomStage,
                        Integer.valueOf(input.substring(0, 4)),
                        Integer.valueOf(input.substring(5, 7)),
                        Integer.valueOf(input.substring(8, 10)),
                        Integer.valueOf(input.substring(11, 13)),
                        Integer.valueOf(input.substring(14))
                );

            } catch (DateTimeException e){
                dateTimeException = true;
                System.out.println(e);
            }

        } while (dateTimeException);
    }






}
