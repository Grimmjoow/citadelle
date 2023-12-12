package modele;

// Classe représentant le personnage "Roi" du jeu
public class Roi extends Personnage {

    // Constructeur de la classe Roi
    public Roi(){
        // Appelle le constructeur de la classe mère (Personnage) avec des valeurs spécifiques
        super("Roi", 4, Caracteristiques.ROI);
    }

    // Méthode pour utiliser le pouvoir du personnage
    public void utiliserPouvoir(){
        // Vérifie si le Roi n'a pas été assassiné
        if(!this.getAssassine()){
            // Vérifie si le joueur associé au Roi n'est pas null
            if(this.getJoueur() != null){
                System.out.println("Je prends la couronne");
                // Définit que le joueur possède la couronne
                this.getJoueur().setPossedeCouronne(true);
            }else{
                System.out.println("Le joueur n'est pas défini");
            }
        }else{
            System.out.println("Vous ne pouvez pas utiliser votre pouvoir");
        }
    }

    // Méthode pour percevoir les ressources spécifiques au Roi
    @Override
    public void percevoirRessourcesSpecifiques(){
        // Vérifie si le Roi a été assassiné
        if(this.getAssassine()){
            // Appelle la méthode de la classe mère pour percevoir les ressources spécifiques
            super.percevoirRessourcesSpecifiques();
        }else{
            int a = 0;
            // Vérifie si le joueur associé au Roi n'est pas null
            if(this.getJoueur() != null){
                // Parcourt la cité du joueur et compte le nombre de quartiers nobles
                for(int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++){
                    if(this.getJoueur().getCite()[0] != null){
                        if(this.getJoueur().getCite()[i].getType() == "NOBLE"){
                                a += 1;
                        }
                    }
                }
                // Si le joueur possède l'école de magie, ajoute une pièce supplémentaire
                if(this.getJoueur().getPossedeEcoleMag()){
                    a+=1;
                }
                // Ajoute les pièces au joueur
                this.getJoueur().ajouterPieces(a);
            }
            System.out.println(a + " pièce(s) ajoutée(s)");
        }
    }

    // Méthode pour utiliser le pouvoir de l'avatar du personnage
    @Override
    public void utiliserPouvoirAvatar() {
        // Appelle la méthode utiliserPouvoir car l'avatar du Roi a le même pouvoir que le Roi lui-même
        utiliserPouvoir();
    }

    // Méthode pour activer le pouvoir de la Sorcière sur un joueur (non utilisée dans cette classe)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Ne fait rien dans le contexte du Roi
    }
}
