package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.Event;
import be.technifutur.java2020.Labo1.contributor.Contributor;
import be.technifutur.java2020.Labo1.contributor.ContributorList;

import java.io.Serializable;

public class Activity extends Event implements Serializable {

    private ContributorList registeredList;
    private String stageName;
    private int duree;

    public Activity(String name) {
        super(name);
        registeredList = new ContributorList();
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageName() {
        return stageName;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree){
        this.duree = duree;
    }

    public ContributorList getRegisteredList() {
        return registeredList;
    }

    public boolean register(Contributor contributor) {
        return registeredList.addContributor(contributor.getName(), contributor);
    }

    public boolean unregister(Contributor contributor) {
        return registeredList.removeContributor(contributor.getName());
    }

}
