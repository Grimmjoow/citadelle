// Package "modele"
package modele;

// Déclaration de la classe "Reine" qui étend la classe "Personnage"
public class Reine extends Personnage {

    // Constructeur de la classe "Reine"
    public Reine() {
        super("Reine", 9, Caracteristiques.REINE);
    }

    // Méthode pour utiliser le pouvoir de la reine
    @Override
    public void utiliserPouvoir() {
        Joueur[] listeJ = new Joueur[this.getPlateau().getNombreJoueurs()];
        int monId = 0;

        // Initialisation de la liste des joueurs et identification de l'ID du joueur actuel
        for (int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
            listeJ[i] = this.getPlateau().getJoueur(i);
            if (this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
                monId = i;
            }
        }

        // Vérification des joueurs voisins et application du pouvoir
        if (monId == 0) {
            if (listeJ[this.getPlateau().getNombreJoueurs() - 1].getPersonnage().getRang() == 4 &&
                    !listeJ[this.getPlateau().getNombreJoueurs() - 1].getPersonnage().getAssassine() ||
                    listeJ[monId + 1].getPersonnage().getRang() == 4 &&
                            !listeJ[monId + 1].getPersonnage().getAssassine()) {
                this.getJoueur().ajouterPieces(3);
                System.out.println("3 pièces ont été ajoutées à votre trésor car vous êtes assis à côté du personnage de rang 4");
            }
        } else if (monId == this.getPlateau().getNombreJoueurs() - 1) {
            if (listeJ[monId - 1].getPersonnage().getRang() == 4 && !listeJ[monId - 1].getPersonnage().getAssassine() ||
                    listeJ[0].getPersonnage().getRang() == 4 && !listeJ[0].getPersonnage().getAssassine()) {
                this.getJoueur().ajouterPieces(3);
                System.out.println("3 pièces ont été ajoutées à votre trésor car vous êtes assis à côté du personnage de rang 4");
            }
        } else {
            if (listeJ[monId - 1].getPersonnage().getRang() == 4 && !listeJ[monId - 1].getPersonnage().getAssassine() ||
                    listeJ[monId + 1].getPersonnage().getRang() == 4 && !listeJ[monId + 1].getPersonnage().getAssassine()) {
                this.getJoueur().ajouterPieces(3);
                System.out.println("3 pièces ont été ajoutées à votre trésor car vous êtes assis à côté du personnage de rang 4");
            }
        }
    }

    // Méthode pour utiliser le pouvoir de la reine (avatar)
    @Override
    public void utiliserPouvoirAvatar() {
        Joueur[] listeJ = new Joueur[this.getPlateau().getNombreJoueurs()];
        int monId = 0;

        // Initialisation de la liste des joueurs et identification de l'ID du joueur actuel
        for (int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
            listeJ[i] = this.getPlateau().getJoueur(i);
            if (this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
                monId = i;
            }
        }

        // Vérification des joueurs voisins et application du pouvoir
        if (monId == 0) {
            if (listeJ[this.getPlateau().getNombreJoueurs() - 1].getPersonnage().getRang() == 4 &&
                    !listeJ[this.getPlateau().getNombreJoueurs() - 1].getPersonnage().getAssassine() ||
                    listeJ[monId + 1].getPersonnage().getRang() == 4 &&
                            !listeJ[monId + 1].getPersonnage().getAssassine()) {
                this.getJoueur().ajouterPieces(3);
                System.out.println("3 pièces ont été ajoutées à votre trésor car vous êtes assis à côté du personnage de rang 4");
            }
        } else if (monId == this.getPlateau().getNombreJoueurs() - 1) {
            if (listeJ[monId - 1].getPersonnage().getRang() == 4 && !listeJ[monId - 1].getPersonnage().getAssassine() ||
                    listeJ[0].getPersonnage().getRang() == 4 && !listeJ[0].getPersonnage().getAssassine()) {
                this.getJoueur().ajouterPieces(3);
                System.out.println("3 pièces ont été ajoutées à votre trésor car vous êtes assis à côté du personnage de rang 4");
            }
        } else {
            if (listeJ[monId - 1].getPersonnage().getRang() == 4 && !listeJ[monId - 1].getPersonnage().getAssassine() ||
                    listeJ[monId + 1].getPersonnage().getRang() == 4 && !listeJ[monId + 1].getPersonnage().getAssassine()) {
                this.getJoueur().ajouterPieces(3);
                System.out.println("3 pièces ont été ajoutées à votre trésor car vous êtes assis à côté du personnage de rang 4");
            }
        }
    }

    // Méthode pour l'activation du pouvoir de la sorcière (non utilisée pour la reine)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
    }
}
