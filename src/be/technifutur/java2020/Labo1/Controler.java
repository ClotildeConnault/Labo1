package be.technifutur.java2020.Labo1;

public class Controler {

    private Model model;
    private Vue vue;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public static void main(String[] args) {
        Controler c = new Controler();

    }
}
