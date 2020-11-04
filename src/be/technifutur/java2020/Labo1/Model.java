package be.technifutur.java2020.Labo1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Model {

    private HashMap<String, Stage> stages = new HashMap<String, Stage>();

    public void addStage() {

    }

    public void removeStage() {

    }

    public void setName (String key, String name) {
        stages.get(key).setName(name);
    }

    public void setDateDebut(String key, int year, int month, int day){
        stages.get(key).setDateDebut(year, month, day);
    }

    public void setDateFin(String key, int year, int month, int day){
        stages.get(key).setDateFin(year, month, day);
    }

    public void setHeureDebut(String key, int hour, int minute){
        stages.get(key).setHeureDebut(hour, minute);
    }

    public void setHeureFin(String key, int hour, int minute){
        stages.get(key).setHeureFin(hour, minute);
    }

    public LocalDateTime getDateDebut(String key) {
        LocalDateTime dateDebut = LocalDateTime.of(
                stages.get(key).getDateDebut().getYear(),
                stages.get(key).getDateDebut().getMonth(),
                stages.get(key).getDateDebut().getDayOfMonth(),
                stages.get(key).getHeureDebut().getHour(),
                stages.get(key).getHeureDebut().getMinute()
        );

        return dateDebut;
    }

    public LocalDateTime getDateFin(String key) {
        LocalDateTime dateDebut = LocalDateTime.of(
                stages.get(key).getDateFin().getYear(),
                stages.get(key).getDateFin().getMonth(),
                stages.get(key).getDateFin().getDayOfMonth(),
                stages.get(key).getHeureFin().getHour(),
                stages.get(key).getHeureFin().getMinute()
        );

        return dateDebut;
    }

}
