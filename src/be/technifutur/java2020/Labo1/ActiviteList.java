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

    public void setDateDebut (Integer key, int year, int month, int day) {
        list.get(key).setDateDebut(year, month, day);
    }



    public void setHeureDebut(Integer key, int hour, int minute){
        list.get(key).setHeureDebut(hour, minute);
    }



    public LocalDateTime getDateDebut(Integer key) {
        LocalDateTime dateDebut = LocalDateTime.of(
                list.get(key).getDateDebut().getYear(),
                list.get(key).getDateDebut().getMonth(),
                list.get(key).getDateDebut().getDayOfMonth(),
                list.get(key).getHeureDebut().getHour(),
                list.get(key).getHeureDebut().getMinute()
        );

        return dateDebut;
    }

}
