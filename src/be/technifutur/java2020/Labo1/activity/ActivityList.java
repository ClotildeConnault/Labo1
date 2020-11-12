package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.Event;
import be.technifutur.java2020.Labo1.EventType;
import be.technifutur.java2020.Labo1.List;
import be.technifutur.java2020.Labo1.activity.Activity;
import be.technifutur.java2020.Labo1.contributor.Contributor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.TreeMap;

public class ActivityList implements List, Serializable {


    private static final long serialVersionUID = 4398595323974488505L;
    private TreeMap<String, Activity> list;

    public ActivityList() {
        list = new TreeMap<>();
    }

    public void add(String name) {
        this.list.put(name, new Activity(name)); //TODO message si clé déjà existante
    }

    public TreeMap<String, Activity> getList() {
        return list;
    }


    public void setDuree(String key, int duree) {
        list.get(key).setDuree(duree);
    }


    public void remove() {

    }

    @Override
    public void setName(String key, String name) {
        list.get(key).setName(name);
    }

    @Override
    public void setDateDebut(String key, int year, int month, int day, int hour, int min) {
        list.get(key).setDateDebut(year, month, day, hour, min);
    }

    @Override
    public LocalDateTime getDateDebut(String activityName) {
        return list.get(activityName).getDateDebut();
    }

    public boolean register(String activityName, Contributor contributor) {
        return list.get(activityName).register(contributor);
    }

    public boolean unregister(String activityName, Contributor contributor) {
        return list.get(activityName).unregister(contributor);
    }

}
