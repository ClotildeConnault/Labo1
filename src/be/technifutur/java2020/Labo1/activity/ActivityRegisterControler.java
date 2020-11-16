package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.ControlerType;
import be.technifutur.java2020.Labo1.contributor.ContributorControler;
import be.technifutur.java2020.Labo1.contributor.ContributorList;

public class ActivityRegisterControler extends ActivityControler {

    private String activeActivity;
    private ActivityRegisterMenu menu;
    private ContributorList contributorList;

    public ActivityRegisterControler() {
        type = ControlerType.ACTIVITYREGISTERCONTROLER;
        generalType.clear();
        generalType.add(ControlerType.ACTIVITY);
    }

    public void setActiveActivity(String activityName) {
        activeActivity = activityName;
    }
    public void setContributorList(ContributorList contributorList) {
        this.contributorList = contributorList;
    }

    public void setMenu(ActivityRegisterMenu menu) {
        this.menu = menu;
    }

    public boolean existsContributor(String name) {
        boolean exists = true;
        if (!contributorList.getContributors().containsKey(name)) {
            exists = false;
            vue.doesNotExistContributor();
        }
        return exists;
    }

    public void run() {
        String input;
        vue.selectActivity();
        input = scan.nextLine();
        if (existsActivity(input)) {
            setActiveActivity(input);

            menu.displayMenu();
            switch (menu.getChoice()) {
                case "1":
                    vue.consigneContributorName();
                    input = scan.nextLine();
                    if (existsContributor(input)) {
                        activityList.register(activeActivity, contributorList.getContributor(input));
                    }

                    break;
                case "2":
                    break;
                case "3":

                    break;
                case "Q":
                    controlerList.getControler(ControlerType.MAINCONTROLER).run();
                    break;
            }

        }




    }
    @Override
    public String toString() {
        return "Gérer les inscriptions";
    }
}
