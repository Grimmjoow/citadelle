package modele;

import java.util.Random;
import controleur.Interaction;

public class MaitreChanteuse extends Personnage {

    // Constructeur par défaut de la classe Maître-Chanteuse
    public MaitreChanteuse() {
        super("Maître-Chanteuse", 2, Caracteristiques.MAITRE_CHANTEUSE);
    }

    // Méthode pour utiliser le pouvoir du personnage Maître-Chanteuse
    @Override
    public void utiliserPouvoir() {
        if(this.getJoueur() != null && !this.getAssassine()) {
            boolean continu = true;
            System.out.println("Quels personnages voulez-vous menacer ?");

            for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++) {
                Personnage personnage = this.getPlateau().getPersonnage(i);
                System.out.println((i + 1) + ". " + personnage.getNom());
            }

            do {
                System.out.println("A qui adressez-vous la vraie menace ?");
                int choix1 = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages());

                System.out.println("A qui adressez-vous la fausse menace ?");
                int choix2 = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages());

                Personnage persoC1 = this.getPlateau().getPersonnage(choix1 - 1);
                Personnage persoC2 = this.getPlateau().getPersonnage(choix2 - 1);

                if ((choix1 != choix2) && (persoC1.getRang() != 1 && persoC2.getRang() != 1) && !persoC1.getEnsorcele() && !persoC2.getEnsorcele() && !persoC1.getAssassine() && !persoC2.getAssassine()) {
                    persoC1.setVraieMenace(true);
                    persoC2.setFausseMenace(true);
                    continu = false;
                } else {
                    System.out.println("Vous ne pouvez pas vous choisir ou choisir plusieurs fois le même personnage ou un personnage ensorcelé");
                }

            } while (continu);
        }
    }

    // Méthode pour utiliser le pouvoir spécial de la Maître-Chanteuse avec un choix aléatoire des personnages
    @Override
    public void utiliserPouvoirAvatar() {
        if(this.getJoueur() != null && !this.getAssassine()) {
            boolean continu = true;

            do {
                Random ran = new Random();
                int choix1 = ran.nextInt(this.getPlateau().getNombrePersonnages());
                int choix2 = ran.nextInt(this.getPlateau().getNombrePersonnages());

                Personnage persoC1 = this.getPlateau().getPersonnage(choix1);
                Personnage persoC2 = this.getPlateau().getPersonnage(choix2);

                if ((choix1 != choix2) && (persoC1.getRang() != 1 && persoC2.getRang() != 1) && !persoC1.getEnsorcele() && !persoC2.getEnsorcele() && !persoC2.getEnsorcele() && !persoC1.getAssassine() && !persoC2.getAssassine()) {
                    persoC1.setVraieMenace(true);
                    persoC2.setFausseMenace(true);
                    continu = false;
                } else {
                    System.out.println("Vous ne pouvez pas vous choisir ou plusieurs fois le même personnage ou un personnage ensorcelé");
                }

            } while (continu);
        }
    }

    // Méthode d'activation du pouvoir de la sorcière (non implémentée ici)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
    }
}
