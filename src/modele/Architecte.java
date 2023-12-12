package modele;

public class Architecte extends Personnage {

    // Constructeur de la classe Architecte
    public Architecte() {
        super("Architecte", 7, Caracteristiques.ARCHITECTE);
    }

    // Implémentation de la méthode utiliserPouvoir pour l'Architecte
    @Override
    public void utiliserPouvoir() {
        // Ajoute deux quartiers piochés à la main du joueur
        this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
        this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
        System.out.println("Vous avez pioché deux cartes.");
    }

    // Implémentation de la méthode utiliserPouvoirAvatar pour l'Architecte
    @Override
    public void utiliserPouvoirAvatar() {
        // Ajoute deux quartiers piochés à la main du joueur
        this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
        this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
        System.out.println("Vous avez pioché deux cartes.");
    }

    // Implémentation de la méthode activationPouvoirSorciere pour l'Architecte
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Le pouvoir de l'Architecte n'est pas affecté par le pouvoir de la Sorcière
        // car cette méthode ne fait rien pour l'Architecte.
    }
}
