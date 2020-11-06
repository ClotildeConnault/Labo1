package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.EventType;
import be.technifutur.java2020.Labo1.List;
import be.technifutur.java2020.Labo1.activity.Activity;

import java.util.TreeMap;

public class ActivityList extends List {


    private TreeMap<String, Activity> list;

    public ActivityList() {
        super(EventType.ACTIVITY);
        list = new TreeMap<String, Activity>();
    }

    public void add(String name) {
        this.list.put(name, new Activity(name)); //TODO message si clé déjà existante
    }

    @Override
    public void setDateFin(String key, int year, int month, int day, int hour, int min) {

    }


    public void remove() {

    }

}
