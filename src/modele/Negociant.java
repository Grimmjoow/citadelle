package modele;

public class Negociant extends Personnage {

    // Constructeur par défaut de la classe Negociant
    public Negociant() {
        super("Negociant", 6, Caracteristiques.NEGOCIANT);
    }

    // Méthode pour percevoir des ressources spécifiques en fonction des quartiers dans la cité
    public void percevoirRessourcesSpecifiques() {
        if (this.getAssassine()) {
            super.percevoirRessourcesSpecifiques();
        } else {
            // Parcourt la cité du joueur pour détecter les quartiers de type "COMMERCANT"
            for (int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++) {
                if (this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[3])) {
                    this.getJoueur().ajouterPieces(1); // Ajoute 1 pièce pour chaque quartier "COMMERCANT"
                }
            }
        }
    }

    // Méthode pour utiliser le pouvoir du Negociant (non implémentée ici)
    public void utiliserPouvoir() {
        // TODO Auto-generated method stub
    }

    // Méthode pour utiliser le pouvoir spécial du Negociant (non implémentée ici)
    public void utiliserPouvoirAvatar() {
        // TODO Auto-generated method stub
    }

    // Méthode d'activation du pouvoir de la sorcière (non implémentée ici)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
    }
}
