package be.technifutur.java2020.Labo1;


public abstract class Vue {

    //protected List list;

    //public abstract void setModel(List list);

    public void succes() {
        System.out.print("Création réussie ");
    }

    public void erreurInputMenu() {
        System.out.println("Cette valeur ne correspond à aucune option");
    }

    public void messageSortie() {
        System.out.println("A bientôt");
    }

    public abstract void doesNotExist();
}
