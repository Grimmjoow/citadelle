package modele;

import controleur.Interaction;
import Exception.SelfChosen;
import Exception.WrongInput;

import java.util.concurrent.ThreadLocalRandom;

public class Assassin extends Personnage {

    // Constructeur de la classe Assassin
    public Assassin() {
        super("Assassin", 1, Caracteristiques.ASSASSIN);
    }

    @Override
    public void utiliserPouvoir() {
        // TODO: Implémenter la méthode pour l'utilisation du pouvoir
        boolean continu = true;
        Interaction sc = new Interaction();

        System.out.println("Quel personnage voulez-vous assassiner ?");
        for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++) {
            System.out.println((i + 1) + "." + this.getPlateau().getPersonnage(i).getNom());
        }

        do {
            System.out.println("Votre choix : ");
            try {
                int j = sc.lireUnEntier(1, this.getPlateau().getNombrePersonnages());
                int k = j - 1;

                if (this.getPlateau().getPersonnage(k).equals(this)) {
                    throw new SelfChosen();
                }

                this.getPlateau().getPersonnage(k).setAssassine();
                System.out.println(this.getPlateau().getPersonnage(k).getNom() + " a été assassiné.");
                continu = false;
            } catch (SelfChosen e) {
                System.out.println("Vous ne pouvez pas vous assassiner.");
            }
        } while (continu);
    }

    @Override
    public void utiliserPouvoirAvatar() {
        // TODO: Implémenter la méthode pour l'utilisation du pouvoir de l'avatar
        boolean continu = true;

        System.out.println("Quel personnage voulez-vous assassiner ?");
        for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++) {
            System.out.println((i + 1) + "." + this.getPlateau().getPersonnage(i).getNom());
        }

        do {
            System.out.println("Choix de " + this.getJoueur().getNom() + " :");
            try {
                int j = ThreadLocalRandom.current().nextInt(1, this.getPlateau().getNombrePersonnages() + 1);
                int k = j - 1;

                if (!(this.getPlateau().getPersonnage(k) == null) && this.getPlateau().getPersonnage(k).equals(this)) {
                    throw new SelfChosen();
                } else if (this.getPlateau().getPersonnage(k) == null) {
                    throw new WrongInput();
                }

                this.getPlateau().getPersonnage(k).setAssassine();
                System.out.println(this.getPlateau().getPersonnage(k).getNom() + " a été assassiné.");
                continu = false;
            } catch (SelfChosen e) {
                // Répéter le choix en cas d'auto-sélection
            } catch (WrongInput e) {
                // Répéter le choix en cas d'entrée incorrecte
            }
        } while (continu);
    }

    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO: Implémenter la méthode pour l'activation du pouvoir de la sorcière
    }
}
