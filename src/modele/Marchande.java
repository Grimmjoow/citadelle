package modele;

public class Marchande extends Personnage {
    // Constructeur pour la classe Marchande
    public Marchande(){
        super("Marchande", 6, Caracteristiques.MARCHANDE);
    }

    // Méthode pour percevoir des ressources spécifiques
    @Override
    public void percevoirRessourcesSpecifiques() {
        // Vérifier si le personnage a été assassiné
        if(this.getAssassine()){
            // Appeler la méthode de la superclasse en cas d'assassinat
            super.percevoirRessourcesSpecifiques();
        } else {
            // Itérer à travers la cité du joueur et ajouter des pièces pour chaque quartier commercial
            for(int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++){
                if(this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[3])){
                    this.getJoueur().ajouterPieces(1);
                }
            }
            // Vérifier si le joueur possède la merveille Ecole de Magie et ajouter une pièce supplémentaire
            if(this.getJoueur().getPossedeEcoleMag()){
                this.getJoueur().ajouterPieces(1);
            }
        }
    }

    // Méthode pour utiliser le pouvoir du personnage
    @Override
    public void utiliserPouvoir() {
        // Vérifier si le personnage n'a pas été assassiné
        if(!this.getAssassine()){
            // Ajouter une pièce au joueur
            this.getJoueur().ajouterPieces(1);
        } else {
            // Afficher un message si le personnage a été assassiné
            System.out.println("Votre personnage a été assassiné");
        }
    }

    // Méthode pour utiliser le pouvoir de l'avatar du personnage
    @Override
    public void utiliserPouvoirAvatar() {
        // Vérifier si le personnage n'a pas été assassiné
        if(!this.getAssassine()){
            // Ajouter une pièce au joueur
            this.getJoueur().ajouterPieces(1);
        } else {
            // Afficher un message si le personnage a été assassiné
            System.out.println("Votre personnage a été assassiné");
        }    
    }

    // Méthode pour l'activation du pouvoir du personnage en cas d'événement Sorcière
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
        // Aucune action spécifique pour la Marchande en cas d'événement Sorcière
    }
}
