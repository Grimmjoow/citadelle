package modele;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import Controleur.Interaction;

/**
 * La classe Empereur représente un personnage de type Empereur dans le jeu.
 * Il possède des pouvoirs permettant de transférer la couronne à un autre joueur.
 */
public class Empereur extends Personnage{

	/**
	 * Constructeur de la classe Empereur.
	 * Initialise le personnage avec le nom "Empereur", le rang 4, et la caractéristique EMPEREUR.
	 */
	public Empereur() {
		super("Empereur", 4, Caracteristiques.EMPEREUR);
	}

	/**
	 * Méthode pour utiliser le pouvoir du personnage Empereur.
	 * Permet de choisir un joueur et de lui transférer la couronne.
	 */
	@Override
	public void utiliserPouvoir() {
		ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();

		// Parcourt tous les joueurs pour récupérer ceux qui n'ont pas la couronne
		for(int i=0; i<this.getPlateau().getNombreJoueurs(); i++) {
			if(this.getPlateau().getJoueur(i).getPossedeCouronne()) {
				this.getPlateau().getJoueur(i).setPossedeCouronne(false);
			}else if(!this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
				listeJoueur.add(this.getPlateau().getJoueur(i));
			}
		}

		// Affiche la liste des joueurs sans couronne et permet au joueur couronné de choisir le nouveau détenteur
		System.out.println("Veuillez choisir à qui vous voulez donner la couronne");
		for(int j=0; j<listeJoueur.size(); j++) {
			System.out.println((j+1) + " - " + listeJoueur.get(j).getNom());
		}
		int choix = Interaction.lireUnEntier(1, listeJoueur.size() + 1) - 1;
		System.out.println("Vous avez choisi " + listeJoueur.get(choix).getNom() + ", il va recevoir la couronne");
		listeJoueur.get(choix).setPossedeCouronne(true);
	}

	/**
	 * Méthode pour utiliser le pouvoir de l'avatar du personnage Empereur.
	 * Permet de choisir aléatoirement un joueur et de lui transférer la couronne.
	 */
	@Override
	public void utiliserPouvoirAvatar() {
		ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();

		// Parcourt tous les joueurs pour récupérer ceux qui n'ont pas la couronne
		for(int i=0; i<this.getPlateau().getNombreJoueurs(); i++) {
			if(this.getPlateau().getJoueur(i).getPossedeCouronne()) {
				this.getPlateau().getJoueur(i).setPossedeCouronne(false);
			}else if(!this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
				listeJoueur.add(this.getPlateau().getJoueur(i));
			}
		}

		// Choix aléatoire d'un joueur sans couronne
		int choix = ThreadLocalRandom.current().nextInt(0, listeJoueur.size());
		System.out.println("Vous avez choisi " + listeJoueur.get(choix).getNom() + ", il va recevoir la couronne");
		listeJoueur.get(choix).setPossedeCouronne(true);
	}

	/**
	 * Méthode pour activer le pouvoir de sorcière du personnage Empereur.
	 * TODO: Ajouter l'implémentation du pouvoir de sorcière.
	 */
	@Override
	public void activationPouvoirSorciere(Joueur joueurSorciere) {
		// TODO: Ajouter l'implémentation du pouvoir de sorcière
	}
}
