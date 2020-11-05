package be.technifutur.java2020.Labo1;

import java.util.TreeMap;

public class ActivityList {


    private TreeMap<String, Activity> list;

    public ActivityList() {
        list = new TreeMap<String, Activity>();
    }

    public TreeMap<String, Activity> getActivites(){
        return list;
    }

    public void add(String name) {
        this.list.put(name, new Activity(name)); //TODO message si clé déjà existante
    }

    public void remove() {

    }

    public void setName (Integer key, String name) { // à enlever?
        list.get(key).setName(name);
    }

    public void setDateDebut (String key, int year, int month, int day, int hour, int min) {
        list.get(key).setDateDebut(year, month, day, hour, min);
    }





}
