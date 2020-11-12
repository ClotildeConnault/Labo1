package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.ControlerType;
import be.technifutur.java2020.Labo1.contributor.ContributorControler;

public class ActivityRegisterControler extends ActivityControler {

    private String activeActivity;
    private ActivityRegisterMenu menu;

    public void setActiveActivity(String activityName) {
        activeActivity = activityName;
    }

    public void setMenu(ActivityRegisterMenu menu) {
        this.menu = menu;
    }

    public void run() {
        String input;
        menu.displayMenu();
        switch (menu.getChoice()) {
            case "1":
                vue.consigneContributorName();
                input = scan.nextLine();
                if (((ContributorControler)controlerList.get(ControlerType.CONTRIBUTORCONTROLER)).existsContributor(input)) {
                    stageList.getActivity(activeStage, activeActivity).register(
                    ((ContributorControler)controlerList.get(ControlerType.CONTRIBUTORCONTROLER)).getContributorList().getContributor(input)
                    );
                }

                break;
            case "2":
                break;
            case "3":

                break;
            case "Q":
                super.run();
                break;
        }
    }
}
