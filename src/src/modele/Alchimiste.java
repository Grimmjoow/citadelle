package modele;

/**
 * La classe Alchimiste représente un personnage de type Alchimiste dans le jeu.
 * Il n'a pas de pouvoir spécial.
 */
public class Alchimiste extends Personnage {

    /**
     * Constructeur de la classe Alchimiste.
     * Initialise le personnage avec le nom "Alchimiste", le rang 6, et la caractéristique ALCHIMISTE.
     */
    public Alchimiste() {
        super("Alchimiste", 6, Caracteristiques.ALCHIMISTE);
    }

    /**
     * Méthode pour utiliser le pouvoir du Alchimiste.
     * Le Alchimiste n'a pas de pouvoir spécifique, affiche simplement "Pas de pouvoir".
     */
    @Override
    public void utiliserPouvoir() {
        System.out.println("Pas de pouvoir");
    }

    /**
     * Méthode pour utiliser le pouvoir spécial du Alchimiste.
     * Le Alchimiste n'a pas de pouvoir spécial, affiche simplement "Pas de pouvoir".
     */
    @Override
    public void utiliserPouvoirAvatar() {
        System.out.println("Pas de pouvoir");
    }

    /**
     * Méthode pour l'activation du pouvoir face à la sorcière.
     * Non implémentée pour le Alchimiste.
     * @param joueurSorciere Joueur cible de la sorcière.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Non implémenté pour le Alchimiste
    }
}
