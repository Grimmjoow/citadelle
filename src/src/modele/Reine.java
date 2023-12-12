package modele;

// Classe représentant le personnage "Reine" du jeu
public class Reine extends Personnage{

    // Constructeur de la classe Reine
    public Reine() {
        // Appelle le constructeur de la classe mère (Personnage) avec des valeurs spécifiques
        super("Reine", 9, Caracteristiques.REINE);
    }

    // Méthode pour utiliser le pouvoir du personnage Reine
    @Override
    public void utiliserPouvoir() {
        // Tableau pour stocker les joueurs
        Joueur[] listeJ = new Joueur[this.getPlateau().getNombreJoueurs()];
        int monId = 0;

        // Remplir le tableau et trouver l'index du joueur actuel
        for(int i=0; i<this.getPlateau().getNombreJoueurs(); i++) {
            listeJ[i] = this.getPlateau().getJoueur(i);
            if(this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())){
                monId = i;
            }
        }

        // Vérifier les joueurs à côté et ajouter des pièces si nécessaire
        if(monId == 0) {
            if(listeJ[this.getPlateau().getNombreJoueurs()-1].getPersonnage().getRang() == 4 && !listeJ[this.getPlateau().getNombreJoueurs()-1].getPersonnage().getAssassine() 
                    || listeJ[monId+1].getPersonnage().getRang() == 4 && !listeJ[monId+1].getPersonnage().getAssassine()) {
                this.getJoueur().ajouterPieces(3);
                System.out.println("3 pièces ont été ajoutées à votre trésor car vous êtes assis à côté du personnage de rang 4");
            }
        } else if(monId == this.getPlateau().getNombreJoueurs()-1){
            if(listeJ[monId-1].getPersonnage().getRang() == 4 && !listeJ[monId-1].getPersonnage().getAssassine() 
                    || listeJ[0].getPersonnage().getRang() == 4 && !listeJ[0].getPersonnage().getAssassine()) {
                this.getJoueur().ajouterPieces(3);
                System.out.println("3 pièces ont été ajoutées à votre trésor car vous êtes assis à côté du personnage de rang 4");
            }
        } else {
            if(listeJ[monId-1].getPersonnage().getRang() == 4 && !listeJ[monId-1].getPersonnage().getAssassine() ||
                    listeJ[monId+1].getPersonnage().getRang() == 4 && !listeJ[monId+1].getPersonnage().getAssassine()) {
                this.getJoueur().ajouterPieces(3);
                System.out.println("3 pièces ont été ajoutées à votre trésor car vous êtes assis à côté du personnage de rang 4");
            }
        }
    }

    // Méthode pour utiliser le pouvoir de l'avatar de la Reine
    @Override
    public void utiliserPouvoirAvatar() {
        // Le pouvoir de l'avatar est le même que celui de la Reine elle-même
        utiliserPouvoir();
    }

    // Méthode pour activer le pouvoir de la Sorcière sur un joueur (non utilisée dans cette classe)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Ne fait rien dans le contexte de la Reine
    }
}
