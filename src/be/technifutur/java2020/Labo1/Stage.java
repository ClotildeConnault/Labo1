package be.technifutur.java2020.Labo1;

import java.time.LocalDate;
import java.time.LocalTime;


public class Stage {

    private String name;
    private LocalDate dateDebut;
    private LocalTime heureDebut;
    private LocalDate dateFin;
    private LocalTime heureFin;

    public Stage(String name){
        this.name = name;
    }

    public void setDateDebut(int year, int month, int day){
        dateDebut = LocalDate.of(year, month, day);
    }

    public LocalDate getDateDebut(){
        return dateDebut;
    }

    public void setDateFin(int year, int month, int day){
        dateFin = LocalDate.of(year, month, day);
    }

    public LocalDate getDateFin(){
        return dateFin;
    }

    public void setHeureDebut(int hour, int minute){
        heureDebut = LocalTime.of(hour, minute);
    }

    public LocalTime getHeureDebut(){
        return heureDebut;
    }

    public void setHeureFin(int hour, int minute){
        heureFin = LocalTime.of(hour, minute);
    }

    public LocalTime getHeureFin(){
        return heureFin;
    }


}
