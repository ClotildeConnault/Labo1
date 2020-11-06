package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.stage.Stage;

import java.time.LocalDateTime;
import java.util.TreeMap;

public abstract class List {

    protected TreeMap<String, Stage> list;

    public List(EventType type) {
        switch (type) {
            case STAGE :
                list = new TreeMap<String, Stage>();
                break;
            case ACTIVITY:
                list = new TreeMap<String, Stage>();
                break;
        }
    }

    public abstract void add(String name);

    public TreeMap<String, ? extends Event> getList(){
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

    public LocalDateTime getDateDebut(String key) {
        return list.get(key).getDateDebut();
    }

    public abstract void setDateFin(String key, int year, int month, int day, int hour, int min);


}
