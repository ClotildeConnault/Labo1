package be.technifutur.java2020.Labo1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StageList {

    private HashMap<Integer, Stage> stages = new HashMap<Integer, Stage>();

    public void addStage(String name) {
        stages.put(stages.size()+1, new Stage(name));
    }

    public HashMap<Integer, Stage> getStages(){
        return stages;
    }
    public void removeStage() {

    }

    public void setName (Integer key, String name) {
        stages.get(key).setName(name);
    }

    public void setDateDebut (Integer key, int year, int month, int day) {
        stages.get(key).setDateDebut(year, month, day);
    }

    public void setDateFin(Integer key, int year, int month, int day){
        stages.get(key).setDateFin(year, month, day);
    }

    public void setHeureDebut(Integer key, int hour, int minute){
        stages.get(key).setHeureDebut(hour, minute);
    }

    public void setHeureFin(Integer key, int hour, int minute){
        stages.get(key).setHeureFin(hour, minute);
    }

    public LocalDateTime getDateDebut(Integer key) {
        LocalDateTime dateDebut = LocalDateTime.of(
                stages.get(key).getDateDebut().getYear(),
                stages.get(key).getDateDebut().getMonth(),
                stages.get(key).getDateDebut().getDayOfMonth(),
                stages.get(key).getHeureDebut().getHour(),
                stages.get(key).getHeureDebut().getMinute()
        );

        return dateDebut;
    }

    public LocalDateTime getDateFin(Integer key) {
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
