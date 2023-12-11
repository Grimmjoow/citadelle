package modele;

public class Alchimiste extends Personnage {

    // Constructeur par défaut de la classe Alchimiste
    public Alchimiste() {
        super("Alchimiste", 6, Caracteristiques.ALCHIMISTE);
    }

    // Méthode pour utiliser le pouvoir de l'Alchimiste
    @Override
    public void utiliserPouvoir() {
        System.out.println("Pas de pouvoir");
    }

    // Méthode pour utiliser le pouvoir de l'Alchimiste (version avatar)
    @Override
    public void utiliserPouvoirAvatar() {
        System.out.println("Pas de pouvoir");
    }

    // Méthode d'activation du pouvoir de la sorcière (non implémentée ici)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
    }
}
