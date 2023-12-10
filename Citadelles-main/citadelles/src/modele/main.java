package modele;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import Controleur.Interaction;

public class main {
    public static void main(String[] args) {
        System.out.println("Choisi :");
        Interaction interaction = new Interaction();
        int choix = interaction.lireUnEntier(1, 2);

    }

    
}
