package modele;

/**
 * La classe Cardinal représente un personnage de type Cardinal dans le jeu.
 * Il possède des pouvoirs liés à la perception de ressources spécifiques.
 */
public class Cardinal extends Personnage {

    /**
     * Constructeur de la classe Cardinal.
     * Initialise le personnage avec le nom "Cardinal", le rang 5, et la caractéristique CARDINAL.
     */
    public Cardinal() {
        super("Cardinal", 5, Caracteristiques.CARDINAL);
    }

    /**
     * Méthode pour percevoir des ressources spécifiques.
     * Permet au joueur d'ajouter des pièces d'or en fonction des quartiers religieux dans sa cité.
     */
    public void percevoirRessourcesSpecifiques() {
        if(this.getJoueur() != null && !this.getAssassine()){
            for(int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++){
                if(this.getJoueur().getCite()[i] != null && this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[0])){
                    this.getJoueur().ajouterPieces(1);
                }
            }
            // La merveille Ecole de Magie change de type à la perception des ressources
            if(this.getJoueur().getPossedeEcoleMag()){
                this.getJoueur().ajouterPieces(1);
            }
        }
    }    

    /**
     * Méthode pour utiliser le pouvoir du personnage Cardinal.
     * TODO: Ajouter l'implémentation du pouvoir du Cardinal.
     */
    public void utiliserPouvoir() {
        // TODO: Ajouter l'implémentation du pouvoir du Cardinal
    }

    /**
     * Méthode pour utiliser le pouvoir de l'avatar du Cardinal.
     * TODO: Ajouter l'implémentation du pouvoir de l'avatar du Cardinal.
     */
    public void utiliserPouvoirAvatar() {
        // TODO: Ajouter l'implémentation du pouvoir de l'avatar du Cardinal
    }

    /**
     * Méthode pour activer le pouvoir de sorcière du personnage Cardinal.
     * TODO: Ajouter l'implémentation du pouvoir de sorcière.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO: Ajouter l'implémentation du pouvoir de sorcière
    }
}
