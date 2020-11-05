package be.technifutur.java2020.Labo1;

import com.sun.source.tree.Tree;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class StageList {

    private TreeMap<String, Stage> list;

    public StageList() {
        list = new TreeMap<String, Stage>();
    }

    public void add(String name) {
        this.list.put(name, new Stage(name)); //TODO message si clé déjà existante
    }

    public TreeMap<String, Stage> getStages(){
        return list;
    }

    public void removeStage() {

    }

    public void setName (String key, String name) {
        list.get(key).setName(name);
    }

    public void setDateDebut (String key, int year, int month, int day, int hour, int min) {
        list.get(key).setDateDebut(year, month, day, hour, min);
    }


    public void setDateFin(String key, int year, int month, int day, int hour, int min) throws DateTimeException {

        list.get(key).setDateFin(year, month, day, hour, min);
    }

    public LocalDateTime getDateDebut(String key) {
        return list.get(key).getDateDebut();
    }

    public LocalDateTime getDateFin(String key) {
        return list.get(key).getDateFin();
    }



}
