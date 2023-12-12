package modele;

/**
 * La classe Marchande représente un type de personnage du jeu appelé "Marchande".
 * Elle hérite de la classe abstraite Personnage.
 */
public class Marchande extends Personnage {

    /**
     * Constructeur de la classe Marchande.
     * Initialise le nom, le rang et les caractéristiques de la Marchande.
     */
    public Marchande() {
        super("Marchande", 6, Caracteristiques.MARCHANDE);
    }

    /**
     * Redéfinition de la méthode percevoirRessourcesSpecifiques pour la Marchande.
     * Ajoute 1 pièce pour chaque quartier de type "COMMERCANT" dans la cité du joueur.
     * Si le joueur possède la merveille "Ecole de Magie", ajoute une pièce supplémentaire.
     */
    @Override
    public void percevoirRessourcesSpecifiques() {
        if (this.getAssassine()) {
            super.percevoirRessourcesSpecifiques();
        } else {
            for (int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++) {
                if (this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[3])) {
                    this.getJoueur().ajouterPieces(1);
                }
            }
            if (this.getJoueur().getPossedeEcoleMag()) {
                this.getJoueur().ajouterPieces(1);
            }
        }
    }

    /**
     * Redéfinition de la méthode utiliserPouvoir pour la Marchande.
     * Ajoute 1 pièce au trésor du joueur si elle n'est pas assassinée.
     * Affiche un message si le personnage a été assassiné.
     */
    @Override
    public void utiliserPouvoir() {
        if (!this.getAssassine()) {
            this.getJoueur().ajouterPieces(1);
        } else {
            System.out.println("Votre personnage a été assassiné");
        }
    }

    /**
     * Redéfinition de la méthode utiliserPouvoirAvatar pour la Marchande.
     * Ajoute 1 pièce au trésor du joueur si elle n'est pas assassinée.
     * Affiche un message si le personnage a été assassiné.
     */
    @Override
    public void utiliserPouvoirAvatar() {
        if (!this.getAssassine()) {
            this.getJoueur().ajouterPieces(1);
        } else {
            System.out.println("Votre personnage a été assassiné");
        }
    }

    /**
     * Redéfinition de la méthode activationPouvoirSorciere pour la Marchande.
     * Cette méthode ne contient aucune action spécifique pour la Marchande.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Aucune action spécifique pour la Marchande lors de l'activation du pouvoir de sorcière
    }
}
