package be.technifutur.java2020.Labo1.contributor;

import be.technifutur.java2020.Labo1.Vue;

public class ContributorVue extends Vue {
    @Override
    public void doesNotExist() {

    }

    public void consignePrenom() {
        System.out.println("Entrez le prénom du nouvel intervenant");
    }

    public void consigneNom() {
        System.out.println("Entrez le nom du nouvel intervenant");
    }

    public void demandeEmail() {
        System.out.println("Voulez-vous ajouter une adresse email ? (O/N)");
    }

    public void consigneEmail() {
        System.out.println("Entrez l'adresse email de l'intervenant"); //TODO créer regex
    }

    public void demandeClub() {
        System.out.println("Voulez-vous ajouter un club ? (O/N)");
    }

    public void consigneClub() {
        System.out.println("Entrez le nom du club");
    }

    public void consigneAjoutStage() {
        System.out.println("Entrez le nom du stage auquel cet intervenant participe"); //TODO vérifier l'existence du stage
    }

    public void doublon() {
        System.out.println("Cet intervenant existe déjà");
    }

    public void demandeModifON() {
        System.out.println("Voulez-vous modifier cet intervenant ? O/N");
    }
}
