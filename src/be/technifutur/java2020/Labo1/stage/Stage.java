package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.contributor.ContributorList;
import be.technifutur.java2020.Labo1.Event;
import be.technifutur.java2020.Labo1.activity.ActivityList;

import java.time.DateTimeException;
import java.time.LocalDateTime;


public class Stage extends Event {

    private LocalDateTime dateFin;
    private ActivityList activityList;
    private ContributorList contributorList;

    public Stage(String name){
        super(name);
        activityList = new ActivityList();
        contributorList = new ContributorList();
    }

    public void setDateFin(int year, int month, int day, int hour, int min) throws DateTimeException {
        LocalDateTime date = LocalDateTime.of(year, month, day, hour, min);
        if (date.isBefore(this.dateDebut)) {
            throw new DateTimeException("La date de fin est incohérente par rapport à la date de début");
        }
        else {
            dateFin = date;
        }
    }

    public LocalDateTime getDateFin(){
        return dateFin;
    }


    public int getDuree() {
        return duree;
    }

    public void addActivity(String name) {
        activityList.add(name);
    }

    public ActivityList getActivityList() {
        return activityList;
    }

  /*  public boolean addContributor(String name, Contributor contributor) {

    }

    public boolean removeContributor(String name) {
        return false;
    }

    public boolean editContributor(String name) {
        return false;
    }

   */


}
