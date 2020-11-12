package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.*;
import be.technifutur.java2020.Labo1.activity.ActivityList;
import be.technifutur.java2020.Labo1.contributor.Contributor;
import be.technifutur.java2020.Labo1.contributor.EditContributor;
import be.technifutur.java2020.Labo1.contributor.ContributorList;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.TreeMap;

public class StageList implements List {

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
    public LocalDateTime getDateDebut(String key) {
        return list.get(key).getDateDebut();
    }


    public void setDateFin(String key, int year, int month, int day, int hour, int min) throws DateTimeException {

        list.get(key).setDateFin(year, month, day, hour, min);
    }


    public LocalDateTime getDateFin(String key) {
        return list.get(key).getDateFin();
    }

    public void addActivity(String key, String name) {
        System.out.println("StageList.addActivity");
        System.out.println(list.getClass());
        System.out.println(list.size());
        System.out.println(list.firstKey());
        System.out.println(key);
        System.out.println(list.containsKey(key));
        list.get(key).addActivity(name);
    }

    public ActivityList getActivities(String key) {
        return list.get(key).getActivityList();
    }

    public boolean addContributor(String stageName, String name, Contributor contributor) {
        return list.get(stageName).addContributor(name, contributor);
    }

   // public void removeContributor(String name) {
   //     contributorList.removeContributor(name);
   // }
}


