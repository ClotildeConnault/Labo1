package be.technifutur.java2020.Labo1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Evenement {
    protected String name;
    protected LocalDate dateDebut;
    protected LocalTime heureDebut;

    public Evenement(String name){
        this.name = name;
    }

    public void setDateDebut(int year, int month, int day) throws DateTimeException {
        dateDebut = LocalDate.of(year, month, day);
        if (dateDebut.isBefore(LocalDate.now())) {
            throw new DateTimeException("La date ne peut pas être antérieure à aujourd'hui");
        }
    }

    public LocalDate getDateDebut(){
        return dateDebut;
    }

    public void setHeureDebut(int hour, int minute){
        heureDebut = LocalTime.of(hour, minute);
    }

    public LocalTime getHeureDebut(){
        return heureDebut;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
