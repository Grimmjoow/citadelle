package modele;

/**
 * La classe Negociant représente un type de personnage du jeu appelé "Negociant".
 * Il hérite de la classe abstraite Personnage.
 */
public class Negociant extends Personnage{

    /**
     * Constructeur de la classe Negociant.
     * Initialise le nom, le rang et les caractéristiques du Negociant.
     */
    public Negociant() {
        super("Negociant", 6, Caracteristiques.NEGOCIANT);
    }

    /**
     * Redéfinition de la méthode percevoirRessourcesSpecifiques pour le Negociant.
     * Si le Negociant est assassiné, la méthode de la classe parente est appelée.
     * Sinon, le Negociant perçoit une pièce pour chaque quartier de type "COMMERCANT" dans sa cité.
     */
    @Override
    public void percevoirRessourcesSpecifiques() {
        if(this.getAssassine()){
            super.percevoirRessourcesSpecifiques();
        }else{
            for(int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++){
                if(this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[3])){
                    this.getJoueur().ajouterPieces(1);
                }
            }
        }
    }

    /**
     * Redéfinition de la méthode utiliserPouvoir pour le Negociant.
     * Cette méthode ne contient aucune action spécifique pour le Negociant.
     */
    @Override
    public void utiliserPouvoir() {
        // Aucune action spécifique pour le Negociant lors de l'utilisation du pouvoir
    }

    /**
     * Redéfinition de la méthode utiliserPouvoirAvatar pour le Negociant.
     * Cette méthode ne contient aucune action spécifique pour le Negociant.
     */
    @Override
    public void utiliserPouvoirAvatar() {
        // Aucune action spécifique pour le Negociant lors de l'utilisation du pouvoir Avatar
    }

    /**
     * Redéfinition de la méthode activationPouvoirSorciere pour le Negociant.
     * Cette méthode ne contient aucune action spécifique pour le Negociant.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Aucune action spécifique pour le Negociant lors de l'activation du pouvoir de sorcière
    }
}
