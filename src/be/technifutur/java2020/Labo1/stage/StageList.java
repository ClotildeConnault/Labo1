package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.*;
import be.technifutur.java2020.Labo1.activity.ActivityList;
import be.technifutur.java2020.Labo1.contributor.Contributor;
import be.technifutur.java2020.Labo1.contributor.ContributorList;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDateTime;

import java.util.TreeMap;

public class StageList implements List, Serializable {

    private TreeMap<String, Stage> list;
    private ContributorList contributorList;

    public StageList() {
        list = new TreeMap<>();
    }

    public void setContributorList(ContributorList contributorList) {
        this.contributorList = contributorList;
    }


    public void add(String name) {
        this.list.put(name, new Stage(name)); //TODO message si clé déjà existante
    }

    public TreeMap<String, Stage> getList() {
        return list;
    }

    @Override
    public void remove() {

    }

    @Override
    public void setName(String key, String name) {
        list.get(key).setName("name");
    }

    @Override
    public void setDateDebut(String key, int year, int month, int day, int hour, int min) {
        list.get(key).setDateDebut(year, month, day, hour, min);
    }

    @Override
    public LocalDateTime getDateDebut(String stageName) {
        return list.get(stageName).getDateDebut();
    }


    public void setDateFin(String key, int year, int month, int day, int hour, int min) throws DateTimeException {

        list.get(key).setDateFin(year, month, day, hour, min);
    }


    public LocalDateTime getDateFin(String key) {
        return list.get(key).getDateFin();
    }

    public void addActivity(String key, String name) {
        list.get(key).addActivity(name);
    }

    public ActivityList getActivities(String stageName) {
        return list.get(stageName).getActivityList();
    }

    public be.technifutur.java2020.Labo1.activity.Activity getActivity(String stageName, String activityName) {
        return list.get(stageName).getActivity(activityName);
    }

    public boolean addContributor(String stageName, String name, Contributor contributor) {
        return list.get(stageName).addContributor(name, contributor);
    }

    public ContributorList getContributorList(String stageName) {
        return list.get(stageName).getContributorList();
    }

    public TreeMap<String, Contributor> getAllContributors() {
        return contributorList.getContributors();
    }

   // public void removeContributor(String name) {
   //     contributorList.removeContributor(name);
   // }
}


