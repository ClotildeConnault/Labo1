package be.technifutur.java2020.Labo1;

public class Main {
    public static void main(String[] args) {
        Vue vue = new Vue();
        Model model = new Model();
        Controler controler = new Controler();

        controler.setVue(vue);
        controler.setModel(model);
        vue.setModel(model);
    }


}
