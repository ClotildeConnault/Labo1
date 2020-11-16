package be.technifutur.java2020.Labo1.contributor;

import be.technifutur.java2020.Labo1.ControlerType;
import be.technifutur.java2020.Labo1.MainControler;
import be.technifutur.java2020.Labo1.Vue;

public class ContributorCreationControler extends ContributorControler {

    public ContributorCreationControler() {
        type = ControlerType.CONTRIBUTORCREATIONCONTROLER;
        generalType.clear();
        generalType.add(ControlerType.CONTRIBUTOR);
    }
    @Override
    public void setVue(Vue vue) {
        this.vue = (ContributorVue)vue;
    }

    @Override
    public void run() {
        String input;
        String name;

        if (list.getList().isEmpty()) {
            vue.noStages();
            controlerList.getControler(ControlerType.CONTRIBUTORCONTROLER).run();
        }
        else {
            vue.consignePrenom();
            name = scan.nextLine();
            vue.consigneNom();
            name += " " + scan.nextLine();
            if (!contributorList.addContributor(activeStage, name)) {
                vue.doublon();
                vue.demandeModifON();
                input = scan.nextLine();
                if (input.equalsIgnoreCase("o")) {
                    //   ((ContributorEditControler)controlerList.get(ControlerType.CONTRIBUTOREDITCONTROLER)).setChosenContributor(name); //TODO reprendre ici :)
                    //   controlerList.get(ControlerType.CONTRIBUTOREDITCONTROLER).run(); //TODO gérer la suite après Edit
                }
            }
            else {
                list.addContributor(activeStage, name, contributorList.getContributor(name));
                do {
                    vue.demandeEmail();
                    input = scan.nextLine();
                } while (!isONValid(input));

                if (input.equalsIgnoreCase("o")) {
                    vue.consigneEmail();
                    contributorList.editContributor(name, EditContributor.EMAIL, scan.nextLine());
                }

                do{
                    vue.demandeClub();
                    input = scan.nextLine();
                } while (!isONValid(input));

                if (input.equalsIgnoreCase("o")) {
                    vue.consigneClub();
                    contributorList.editContributor(name, EditContributor.CLUB, scan.nextLine());
                }
        }



        }
        }

    @Override
    public String toString() {
        return "Ajouter un nouvel intervenant";
    }
}
