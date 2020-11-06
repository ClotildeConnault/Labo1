package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.EventType;
import be.technifutur.java2020.Labo1.List;
import be.technifutur.java2020.Labo1.stage.Stage;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class StageList extends List {


    public StageList() {
        super(EventType.STAGE);
    }


    public void add(String name) {
        this.list.put(name, new Stage(name)); //TODO message si clé déjà existante
    }

    public void removeStage() {

    }


    public void setDateFin(String key, int year, int month, int day, int hour, int min) throws DateTimeException {

        list.get(key).setDateFin(year, month, day, hour, min);
    }


    public LocalDateTime getDateFin(String key) {
        return list.get(key).getDateFin();
    }

}
