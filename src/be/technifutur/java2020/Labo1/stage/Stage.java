package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.activity.Activity;
import be.technifutur.java2020.Labo1.contributor.Contributor;
import be.technifutur.java2020.Labo1.contributor.ContributorList;
import be.technifutur.java2020.Labo1.Event;
import be.technifutur.java2020.Labo1.activity.ActivityList;
import be.technifutur.java2020.price.Price;
import be.technifutur.java2020.price.PriceList;
import be.technifutur.java2020.price.StagePriceList;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDateTime;


public class Stage extends Event implements Serializable {

    private static final long serialVersionUID = -7355897603224467212L;
    private LocalDateTime dateFin;
    private ActivityList activityList;
    private ContributorList contributorList;
    private StagePriceList stagePriceList;

    public Stage(java.lang.String name){
        super(name);
        activityList = new ActivityList();
        contributorList = new ContributorList();
        stagePriceList = new StagePriceList();
    }

    public void setDateFin(int year, int month, int day, int hour, int min) throws DateTimeException {
        LocalDateTime date = LocalDateTime.of(year, month, day, hour, min);
        if (date.isBefore(this.dateDebut)) {
            throw new DateTimeException("La date de fin ne peut pas être antérieure à la date de début");
        }
        if (date.isBefore(this.dateDebut.plusHours(1))) {
            throw new DateTimeException("Le stage doit durer au moins 1h");
        }
        else {
            dateFin = date;
        }
    }

    public void addPrice(String priceName) {
        stagePriceList.addPrice(priceName);
    }

    public void setPrice() {
        double stagePrice = 10.00 + (10.00 * activityList.getList().size());
        for (Price price : stagePriceList.getStagePriceList().values()) {
            price.setPrice(stagePrice);
        }
    }

    public double getPrice(String string) {
        return stagePriceList.getStagePrice(string).getPrice();
    }

    public StagePriceList getStagePriceList() {
        return stagePriceList;
    }

    public LocalDateTime getDateFin(){
        return dateFin;
    }

    public int getDuree() {
        return duree;
    }

    public void addActivity(java.lang.String name) {
        activityList.add(name);
    }

    public ActivityList getActivityList() {
        return activityList;
    }

    public Activity getActivity(java.lang.String key) {
        return activityList.getList().get(key);
    }

    public ContributorList getContributorList() {
        return contributorList;
    }

    public boolean addContributor(java.lang.String name, Contributor contributor) {
        return contributorList.addContributor(name, contributor);
    }

    public boolean existsActivity(java.lang.String activityName) {
        return activityList.getList().containsKey(activityName);
    }
/*
    public boolean removeContributor(String name) {
        return false;
    }

    public boolean editContributor(String name) {
        return false;
    }

   */


}
