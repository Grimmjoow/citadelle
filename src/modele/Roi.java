// Package "modele"
package modele;

// Déclaration de la classe "Roi" qui étend la classe "Personnage"
public class Roi extends Personnage {

    // Constructeur de la classe "Roi"
    public Roi() {
        super("Roi", 4, Caracteristiques.ROI);
    }

    // Méthode pour utiliser le pouvoir du roi
    public void utiliserPouvoir() {
        if (!this.getAssassine()) {
            if (this.getJoueur() != null) {
                System.out.println("Je prends la couronne");
                this.getJoueur().setPossedeCouronne(true);
            } else {
                System.out.println("Le joueur n'est pas défini");
            }
        } else {
            System.out.println("Vous ne pouvez pas utiliser votre pouvoir");
        }
    }

    // Méthode pour percevoir les ressources spécifiques du roi
    @Override
    public void percevoirRessourcesSpecifiques() {
        if (this.getAssassine()) {
            super.percevoirRessourcesSpecifiques();
        } else {
            int piecesGagnees = 0;
            if (this.getJoueur() != null) {
                for (int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++) {
                    if (this.getJoueur().getCite()[0] != null) {
                        if (this.getJoueur().getCite()[i].getType().equals("NOBLE")) {
                            piecesGagnees += 1;
                        }
                    }
                }
                if (this.getJoueur().getPossedeEcoleMag()) {
                    // La merveille École de Magie change de type à la perception des ressources
                    piecesGagnees += 1;
                }
                this.getJoueur().ajouterPieces(piecesGagnees);
            }
            System.out.println(piecesGagnees + " pièce(s) ajoutée(s)");
        }
    }

    // Méthode pour utiliser le pouvoir du roi (avatar)
    @Override
    public void utiliserPouvoirAvatar() {
        if (!this.getAssassine()) {
            if (this.getJoueur() != null) {
                System.out.println("Je prends la couronne");
                this.getJoueur().setPossedeCouronne(true);
            } else {
                System.out.println("Le joueur n'est pas défini");
            }
        } else {
            System.out.println("Vous ne pouvez pas utiliser votre pouvoir");
        }
    }

    // Méthode pour l'activation du pouvoir de la sorcière (non utilisée pour le roi)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
    }
}
