package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.price.CouplePrice;
import be.technifutur.java2020.price.Price;
import be.technifutur.java2020.price.TeacherPrice;
import be.technifutur.java2020.price.UnemployedPrice;
import com.sun.source.tree.Tree;

import java.util.Collection;
import java.util.TreeMap;

public class ControlerList {

    private TreeMap<ControlerType, Controler> controlerList;

    public ControlerList() {
        controlerList = new TreeMap<>();
    }

    public TreeMap<ControlerType, Controler> getControlerList() {
        return controlerList;
    }

    public Controler getControler(ControlerType controlerType) {
        return controlerList.get(controlerType);
    }

    public Collection<Controler> getValues() {
        return controlerList.values();
    }

    public void addControler(Controler controler) {
        controlerList.put(controler.getType(), controler);
    }
}
