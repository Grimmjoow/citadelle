package modele;

import java.util.Random;

import controleur.Interaction;

public class Echevin extends Personnage {
    // Constructeur par défaut de la classe Echevin
    public Echevin(){
        super("Echevin", 1, Caracteristiques.ECHEVIN);
    }

    // Méthode pour utiliser le pouvoir du personnage Echevin
    @Override
    public void utiliserPouvoir(){
        // Vérifie si le joueur associé au personnage est défini et s'il n'a pas été assassiné
        if(this.getJoueur() != null && !this.getAssassine()){
            boolean continu = true;
            System.out.println("Quels personnages voulez-vous cibler ?");

            // Affiche la liste des personnages sur le plateau
            for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++){
                Personnage personnage = this.getPlateau().getPersonnage(i);
                System.out.println((i+1) + ". " + personnage.getNom());
            }

            // Boucle pour permettre au joueur de choisir les personnages pour attribuer les mandats
            do {
                System.out.println("A qui attribuez-vous le mandat signé ?");
                int choix1 = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages());

                System.out.println("A qui attribuez-vous un mandat sans effet ?");
                int choix2 = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages());
                int choix3 = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages());

                // Obtient les références des personnages choisis
                Personnage persoC1 = this.getPlateau().getPersonnage(choix1-1);
                Personnage persoC2 = this.getPlateau().getPersonnage(choix2-1);
                Personnage persoC3 = this.getPlateau().getPersonnage(choix3-1);

                // Vérifie les conditions pour attribuer les mandats
                if((choix1 != choix2 && choix2 != choix3 && choix1 != choix3) && 
                   (persoC1.getRang() != 1 && persoC2.getRang() != 1 && persoC3.getRang() !=1)){
                    persoC1.setVraiEchevin(true);
                    persoC2.setFauxEchevin(true);
                    persoC3.setFauxEchevin(true);
                    continu = false;
                } else {
                    System.out.println("Vous ne pouvez pas vous choisir ou choisir plusieurs fois le même personnage");
                }

            } while(continu);
        }
    }

    // Méthode pour utiliser le pouvoir spécial de l'Echevin avec des cibles aléatoires
    public void utiliserPouvoirAvatar(){
        // Vérifie si le joueur associé au personnage est défini et s'il n'a pas été assassiné
        if(this.getJoueur() != null && !this.getAssassine()){
            boolean continu = true;
            System.out.println("Quels personnages voulez-vous cibler ?");

            // Affiche la liste des personnages sur le plateau
            for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++){
                Personnage personnage = this.getPlateau().getPersonnage(i);
                System.out.println((i+1) + ". " + personnage.getNom());
            }

            // Boucle pour attribuer des mandats à des cibles choisies aléatoirement
            do {
                Random ran = new Random();
                int choix1 = ran.nextInt(this.getPlateau().getNombrePersonnages());

                System.out.println("A qui attribuez-vous un mandat sans effet ?");
                int choix2 = ran.nextInt(this.getPlateau().getNombrePersonnages());
                int choix3 = ran.nextInt(this.getPlateau().getNombrePersonnages());

                // Obtient les références des personnages choisis aléatoirement
                Personnage persoC1 = this.getPlateau().getPersonnage(choix1);
                Personnage persoC2 = this.getPlateau().getPersonnage(choix2);
                Personnage persoC3 = this.getPlateau().getPersonnage(choix3);

                // Vérifie les conditions pour attribuer les mandats
                if((choix1 != choix2 && choix2 != choix3 && choix1 != choix3) && 
                   (persoC1.getRang() != 1 && persoC2.getRang() != 1 && persoC3.getRang() !=1)){
                    persoC1.setVraiEchevin(true);
                    persoC2.setFauxEchevin(true);
                    persoC3.setFauxEchevin(true);
                    continu = false;
                } else {
                    System.out.println("Vous ne pouvez pas vous choisir ou choisir plusieurs fois le même personnage");
                }

            } while(continu);
        }
    }

    // Méthode d'activation du pouvoir de la sorcière (non implémentée ici)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
        
    }
}
