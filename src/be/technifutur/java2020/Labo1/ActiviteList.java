package be.technifutur.java2020.Labo1;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class ActiviteList {


    private TreeMap<String, Activite> list;

    public ActiviteList() {
        list = new TreeMap<String, Activite>();
    }

    public TreeMap<String, Activite> getActivites(){
        return list;
    }

    public void add(String name) {
        this.list.put(name, new Activite(name)); //TODO message si clé déjà existante
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
