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

    public void setDateDebut (String key, int year, int month, int day) {
        list.get(key).setDateDebut(year, month, day);
    }



    public void setHeureDebut(String key, int hour, int minute){
        list.get(key).setHeureDebut(hour, minute);
    }



    public LocalDateTime getDateDebut(String key) {
        LocalDateTime dateDebut = LocalDateTime.of(
                list.get(key).getDateDebut().getYear(),
                list.get(key).getDateDebut().getMonth(),
                list.get(key).getDateDebut().getDayOfMonth(),
                list.get(key).getHeureDebut().getHour(),
                list.get(key).getHeureDebut().getMinute()
        );

        return dateDebut;
    }

    public void setDateFin(String key, int year, int month, int day){
        list.get(key).setDateFin(year, month, day);
    }



    public void setHeureFin(String key, int hour, int minute){
        list.get(key).setHeureFin(hour, minute);
    }



    public LocalDateTime getDateFin(String key) {
        LocalDateTime dateFin = LocalDateTime.of(
                list.get(key).getDateFin().getYear(),
                list.get(key).getDateFin().getMonth(),
                list.get(key).getDateFin().getDayOfMonth(),
                list.get(key).getHeureFin().getHour(),
                list.get(key).getHeureFin().getMinute()
        );

        return dateFin;
    }

}
