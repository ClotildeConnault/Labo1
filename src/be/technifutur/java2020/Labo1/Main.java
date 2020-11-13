package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.stage.StageList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {

        StageList testAfter = null;
        Factory factory = new Factory();
        factory.getMainControler().run();

        //TODO erreur si nom stage existe déjà !
        //TODO finir la serialization (regrouper les modèles dans un objet pour la sauvegarde, les récupérer et les réinjecter à l'ouverture)
//TODO regroupement du code des Event (bosser sur les toString et l'affichage)
        //TODO inscription à une activité : interdire si personne déjà inscrite à une autre activité qui a lieu en même temps

        //TODO ajouter message de réussite à la création d'un intervenant
//TODO revoir "optional" -> peut renvoyer quelque chose ou non

//TODO accepter un espace vide pour les setDate;
        //TODO créer exception dans Contributor pour un stage déjà existant et un stage non existant

    }

}
