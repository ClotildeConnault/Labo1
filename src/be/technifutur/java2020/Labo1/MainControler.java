package be.technifutur.java2020.Labo1;

public class MainControler extends Controler {

    private MenuPrincipal menu;
    private Controler c;

    public MainControler() {
       menu = new MenuPrincipal();
    }
    @Override
    public void run() {
        String input = null;
        menu.displayMenuPrincipal();
        input = null;

        do {
            input = menu.getChoice();
            if(input == null) {
                vue.erreurInputMenu();
                menu.displayMenuPrincipal();
            }
        } while (input == null);

        switch (input) {
            case "1" :
                c = new StageCreationControler();
                c.setVue(vue);
                c.setModel((StageList)list);
                c.run();
                break;
            case "2" :
                c = new StageModifControler();
                c.run();
                break;
            case "3" :
                c = new StageSuppressionControler();
                c.run();
                break;
            case "4" :
                vue.afficheStages();
                break;
            case "5" :
                break;
            case "Q" :
                vue.messageSortie();
                break;
        }
    }
}
