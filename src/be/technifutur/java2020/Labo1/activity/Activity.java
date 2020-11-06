package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.Event;

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
