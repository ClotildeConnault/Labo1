package be.technifutur.java2020.Labo1.contributor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Contributor {
    private String name;
    private String email;
    private String club;
    private Set<String> stages;

    public Contributor(String name){
        this.name = name;
        stages = new HashSet<>();
        email = null;
        club = null;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClub (String club) {
        this.club = club;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getClub() {
        return club;
    }

    public boolean addStage(String name) {
        return stages.add(name);
    }

    public boolean removeStage(String name) {

        return stages.remove(name);
    }

    public Set<String> getStages() {
        return stages;
    }
}