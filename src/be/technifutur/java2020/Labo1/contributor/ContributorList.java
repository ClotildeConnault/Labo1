package be.technifutur.java2020.Labo1.contributor;

import java.util.TreeMap;

public class ContributorList {

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

    public boolean removeContributor(String name) {
        return removeContributor(name);

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
