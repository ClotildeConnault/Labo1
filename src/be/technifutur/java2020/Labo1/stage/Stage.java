package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.activity.Activity;
import be.technifutur.java2020.Labo1.contributor.Contributor;
import be.technifutur.java2020.Labo1.contributor.ContributorList;
import be.technifutur.java2020.Labo1.Event;
import be.technifutur.java2020.Labo1.activity.ActivityList;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDateTime;


public class Stage extends Event implements Serializable {

    private static final long serialVersionUID = -3742135449695740510L;
    private LocalDateTime dateFin;
    private ActivityList activityList;
    private ContributorList contributorList;

    public Stage(String name){
        super(name);
        activityList = new ActivityList();
        contributorList = new ContributorList();
    }

    public void setDateFin(int year, int month, int day, int hour, int min) throws DateTimeException {
        LocalDateTime date = LocalDateTime.of(year, month, day, hour, min);
        if (date.isBefore(this.dateDebut.plusHours(1))) {
            throw new DateTimeException("Le stage doit durer au moins 1h");
        }
        else {
            dateFin = date;
        }
    }

    public LocalDateTime getDateFin(){
        return dateFin;
    }

    public int getDuree() {
        return duree;
    }

    public void addActivity(String name) {
        activityList.add(name);
    }

    public ActivityList getActivityList() {
        return activityList;
    }

    public Activity getActivity(String key) {
        return activityList.getList().get(key);
    }

    public ContributorList getContributorList() {
        return contributorList;
    }

    public boolean addContributor(String name, Contributor contributor) {
        return contributorList.addContributor(name, contributor);
    }

    public boolean existsActivity(String activityName) {
        return activityList.getList().containsKey(activityName);
    }
/*
    public boolean removeContributor(String name) {
        return false;
    }

    public boolean editContributor(String name) {
        return false;
    }

   */


}
