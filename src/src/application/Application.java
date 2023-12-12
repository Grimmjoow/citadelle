
package application;
public class Application {
    
    // Méthode principale
    public static void main(String[] args) {
        // Création d'une instance de la classe Jeu
        Jeu jeu = new Jeu();

        // Boucle qui permet de jouer une seule fois (de 0 à 0)
        for (int i = 0; i < 1; i++) {
            // Appel de la méthode jouer() de la classe Jeu
            jeu.jouer();
        }
    }
}
