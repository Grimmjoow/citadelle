package modele;

/**
 * La classe Architecte représente un personnage de type Architecte dans le jeu.
 * Il possède des pouvoirs liés à la pioche de cartes.
 */
public class Architecte extends Personnage {

    /**
     * Constructeur de la classe Architecte.
     * Initialise le personnage avec le nom "Architecte", le rang 7, et la caractéristique ARCHITECTE.
     */
    public Architecte(){
        super("Architecte", 7, Caracteristiques.ARCHITECTE);
    }

    /**
     * Méthode pour utiliser le pouvoir du Architecte.
     * Permet au joueur de piocher deux cartes depuis la pioche et de les ajouter à sa main.
     */
    @Override
    public void utiliserPouvoir() {
        this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
        this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
        System.out.println("Vous avez pioché deux cartes.");
    }

    /**
     * Méthode pour utiliser le pouvoir spécial du Architecte.
     * Permet au joueur de piocher deux cartes depuis la pioche et de les ajouter à sa main.
     */
    @Override
    public void utiliserPouvoirAvatar() {
        this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
        this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
        System.out.println("Vous avez pioché deux cartes.");
    }

    /**
     * Méthode pour l'activation du pouvoir face à la sorcière.
     * Non implémentée pour le Architecte.
     * @param joueurSorciere Joueur cible de la sorcière.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Non implémenté pour le Architecte
    }
}
