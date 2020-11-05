package be.technifutur.java2020.Labo1;

public class Activity extends Event {

    private int duree;

    public Activity(String name) {
        super(name);
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree){
        this.duree = duree;
    }

}
