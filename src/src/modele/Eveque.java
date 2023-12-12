package modele;

/**
 * La classe Eveque représente un personnage de type Eveque dans le jeu.
 * Il est protégé par des pouvoirs des personnages de rang 8.
 */
public class Eveque extends Personnage {

    /**
     * Constructeur de la classe Eveque.
     * Initialise le personnage avec le nom "Eveque", le rang 5, et la caractéristique EVEQUE.
     */
    public Eveque(){
        super("Eveque", 5, Caracteristiques.EVEQUE);
    }

    /**
     * Méthode pour percevoir des ressources spécifiques en fonction du personnage Eveque.
     * Si le personnage a été assassiné, affiche un message.
     * Sinon, ajoute une pièce pour chaque quartier de type "Religieux" dans la cité du joueur.
     * Ajoute également une pièce si le joueur possède la merveille "Ecole de Magie".
     */
    @Override
    public void percevoirRessourcesSpecifiques() {
        if(this.getAssassine()){
            System.out.println("Votre personnage a été assassiné");
        }else{
            for(int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++){
                if(this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[0])){
                    this.getJoueur().ajouterPieces(1);
                }
            }
            if(this.getJoueur().getPossedeEcoleMag()){//la merveille Ecole de Magie change de type a la perception des ressources
                this.getJoueur().ajouterPieces(1);
            }
        }
    }

    /**
     * Méthode pour utiliser le pouvoir du personnage Eveque.
     * TODO: Ajouter l'implémentation du pouvoir.
     */
    @Override
    public void utiliserPouvoir() {
        // TODO: Ajouter l'implémentation du pouvoir
    }

    /**
     * Méthode pour utiliser le pouvoir de l'avatar du personnage Eveque.
     * TODO: Ajouter l'implémentation du pouvoir de l'avatar.
     */
    @Override
    public void utiliserPouvoirAvatar() {
        // TODO: Ajouter l'implémentation du pouvoir de l'avatar
    }

    /**
     * Méthode pour activer le pouvoir de sorcière du personnage Eveque.
     * TODO: Ajouter l'implémentation du pouvoir de sorcière.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO: Ajouter l'implémentation du pouvoir de sorcière
    }
}
