package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.*;
import be.technifutur.java2020.Labo1.activity.ActivityList;
import be.technifutur.java2020.Labo1.contributor.Contributor;
import be.technifutur.java2020.Labo1.contributor.ContributorList;
import be.technifutur.java2020.price.StagePriceList;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDateTime;

import java.util.TreeMap;

public class StageList implements List, Serializable {

    private static final long serialVersionUID = -3967376817906637661L;
    private TreeMap<java.lang.String, Stage> list;
    private ContributorList contributorList;

    public StageList() {
        list = new TreeMap<>();
    }

    public void setContributorList(ContributorList contributorList) {
        this.contributorList = contributorList;
    }


    public void add(java.lang.String name) {
        this.list.put(name, new Stage(name)); //TODO message si clé déjà existante
    }

    public TreeMap<java.lang.String, Stage> getList() {
        return list;
    }

    @Override
    public void remove() {

    }

    public void addPrice(java.lang.String stageName, String string) {
        list.get(stageName).addPrice(string);
    }

    public StagePriceList getPriceList(String stage) {
        return list.get(stage).getStagePriceList();
    }

    @Override
    public void setName(java.lang.String key, java.lang.String name) {
        list.get(key).setName("name");
    }

    @Override
    public void setDateDebut(java.lang.String key, int year, int month, int day, int hour, int min) {
        list.get(key).setDateDebut(year, month, day, hour, min);
    }

    @Override
    public LocalDateTime getDateDebut(java.lang.String stageName) {
        return list.get(stageName).getDateDebut();
    }


    public void setDateFin(java.lang.String key, int year, int month, int day, int hour, int min) throws DateTimeException {

        list.get(key).setDateFin(year, month, day, hour, min);
    }


    public LocalDateTime getDateFin(java.lang.String key) {
        return list.get(key).getDateFin();
    }

    public void addActivity(java.lang.String key, java.lang.String name) {
        list.get(key).addActivity(name);
    }

    public ActivityList getActivities(java.lang.String stageName) {
        return list.get(stageName).getActivityList();
    }

    public be.technifutur.java2020.Labo1.activity.Activity getActivity(java.lang.String stageName, java.lang.String activityName) {
        return list.get(stageName).getActivity(activityName);
    }

    public boolean addContributor(java.lang.String stageName, java.lang.String name, Contributor contributor) {
        return list.get(stageName).addContributor(name, contributor);
    }

    public ContributorList getContributorList(java.lang.String stageName) {
        return list.get(stageName).getContributorList();
    }

    public TreeMap<java.lang.String, Contributor> getAllContributors() {
        return contributorList.getContributors();
    }

   // public void removeContributor(String name) {
   //     contributorList.removeContributor(name);
   // }
}


