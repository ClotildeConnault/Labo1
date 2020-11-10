package be.technifutur.java2020.Labo1.contributor;

import be.technifutur.java2020.Labo1.ControlerType;

import java.util.TreeMap;

public class ContributorEditControler extends ContributorControler{

    private String chosenContributor;
    private MenuContributorEdit menu;
    private String input;

    public String getChosenContributor() {
        return chosenContributor;
    }

    public void setChosenContributor(String contributor) {
        chosenContributor = contributor;
    }

    public ContributorEditControler() {
        controlerList = new TreeMap<>();
        menu = new MenuContributorEdit();
    }

    public void run() {
        String contributorName;
        menu.displayMenu();
        switch (menu.getChoice()) {
            case "1":
                vue.consigneEmail();
                input = scan.nextLine();
                contributorList.editContributor(chosenContributor, EditContributor.EMAIL, input); //TODO reprendre ici :)
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "Q":
                break;

        }
    }
}
