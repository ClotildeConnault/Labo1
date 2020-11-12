package be.technifutur.java2020.Labo1;

import java.time.LocalDateTime;

public interface List {

    /*protected TreeMap<String, Stage> list;

    public List(EventType type) {
        switch (type) {
            case STAGE :
                list = new TreeMap<String, Stage>();
                break;
            case ACTIVITY:
                list = new TreeMap<String, Stage>();
                break;
        }
    }*/


    public abstract void add(String name);

    public abstract void remove();

    public abstract void setName (String key, String name);

    public abstract void setDateDebut (String key, int year, int month, int day, int hour, int min);

    public abstract LocalDateTime getDateDebut(String key);





}
