package be.technifutur.java2020.Labo1;

public class Activite extends Evenement{

    private int duree;

    public Activite(String name) {
        super(name);
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree){
        this.duree = duree;
    }

}
