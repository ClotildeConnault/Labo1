package be.technifutur.java2020.Labo1.contributor;

import be.technifutur.java2020.Labo1.Controler;

import java.io.Serializable;
import java.util.TreeMap;

public class ContributorList implements Serializable {

    private static final long serialVersionUID = 6936326766871353323L;
    private TreeMap<String, Contributor> contributors;

    public ContributorList() {
        contributors = new TreeMap<>();
    }

    public boolean addContributor(String stage, String name) {
        boolean added = false;

        if (!contributors.containsKey(name)) {
            contributors.put(name, new Contributor(name));
            contributors.get(name).addStage(stage);
            added = true;
        }

        return added;
    }

    public boolean addContributor(String name, Contributor contributor) {
         boolean added = false;
         if (contributors.containsKey(name)) {
             contributors.put(name, contributor);
             added = true;
         }
         return added;
    }

    public boolean removeContributor(String name) {
        return removeContributor(name);
    }

    public Contributor getContributor(String name) {
        return contributors.get(name);
    }

    public TreeMap<String, Contributor> getContributors() {
        return contributors;
    }

    public void editContributor(String name, EditContributor edit, String input) {
        switch (edit) {
            case CLUB:
                contributors.get(name).setClub(input);
                break;
            case EMAIL:
                contributors.get(name).setEmail(input);
                break;
            case ADDSTAGE:
                contributors.get(name).addStage(input);
                break;
            case REMOVESTAGE:
                contributors.get(name).removeStage(input);
                break;
        }
    }

}
