package modele;

public class Eveque extends Personnage {

    // Constructeur de la classe Eveque
    public Eveque() {
        super("Eveque", 5, Caracteristiques.EVEQUE); // protégé par des pouvoirs des personnages rang 8 ?
    }

    @Override
    public void percevoirRessourcesSpecifiques() {
        // TODO: Implémenter la méthode pour la perception des ressources spécifiques
        if (this.getAssassine()) {
            System.out.println("Votre personnage a été assassiné.");
        } else {
            for (int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++) {
                if (this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[0])) {
                    this.getJoueur().ajouterPieces(1);
                }
            }

            // Vérifier si le joueur possède la merveille "Ecole de Magie"
            if (this.getJoueur().getPossedeEcoleMag()) {
                // La merveille Ecole de Magie change de type à la perception des ressources
                this.getJoueur().ajouterPieces(1);
            }
        }
    }

    @Override
    public void utiliserPouvoir() {
        // TODO: Implémenter la méthode pour l'utilisation du pouvoir
        // (L'Eveque n'a pas de pouvoir à utiliser)
    }

    @Override
    public void utiliserPouvoirAvatar() {
        // TODO: Implémenter la méthode pour l'utilisation du pouvoir de l'avatar
        // (L'Eveque n'a pas de pouvoir d'avatar à utiliser)
    }

    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO: Implémenter la méthode pour l'activation du pouvoir de la sorcière
        // (L'Eveque n'est pas affecté par le pouvoir de la sorcière)
    }
}
