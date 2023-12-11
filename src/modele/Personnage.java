// Package "modele"
package modele;

// Package "application"
import application.Configuration;

// Déclaration de la classe abstraite "Personnage"
public abstract class Personnage {
    
    // Attributs de la classe
    protected String nom;
    protected int rang;
    protected String caracteristiques;
    private Joueur joueur;
    private boolean assassine;
    private boolean vole;
    private PlateauDeJeu plateau;
    protected boolean ensorcele;
    protected boolean vraiEchevin;
    protected boolean fauxEchevin;
    protected boolean vraieMenace;
    protected boolean fausseMenace;

    // Méthode pour obtenir l'état d'ensorcèlement
    public boolean getEnsorcele() {
        return ensorcele;
    }

    // Constructeur par défaut
    public Personnage() {
        this.nom = "";
        this.rang = 0;
        this.caracteristiques = "";
        this.joueur = null;
        this.assassine = false;
        this.vole = false;
        this.ensorcele = false;
        this.vraiEchevin = false;
        this.fauxEchevin = false;
        this.vraieMenace = false;
        this.fausseMenace = false;
    }

    // Méthode pour définir l'état d'ensorcèlement
    public void setEnsorcele(boolean ensorcele) {
        this.ensorcele = ensorcele;
    }

    // Constructeur avec nom, rang et caractéristiques
    public Personnage(String nom, int rang, String caracteristiques) {
        this.nom = nom;
        this.rang = rang;
        this.caracteristiques = caracteristiques;
        this.joueur = null;
        this.assassine = false;
        this.vole = false;
        this.ensorcele = false;
        this.vraiEchevin = false;
        this.fauxEchevin = false;
        this.vraieMenace = false;
        this.fausseMenace = false;
    }

    // Méthode pour définir le plateau de jeu
    public void setPlateau(PlateauDeJeu nouveau) {
        this.plateau = nouveau;
    }

    // Méthode pour obtenir le plateau de jeu
    public PlateauDeJeu getPlateau() {
        return plateau;
    }

    // Méthode pour obtenir le nom du personnage
    public String getNom() {
        return nom;
    }

    // Méthode pour obtenir le rang du personnage
    public int getRang() {
        return rang;
    }

    // Méthode pour obtenir les caractéristiques du personnage
    public String getCaracteristiques() {
        return caracteristiques;
    }

    // Méthode pour obtenir le joueur associé au personnage
    public Joueur getJoueur() {
        return joueur;
    }

    // Méthode pour obtenir l'état d'assassinat du personnage
    public boolean getAssassine() {
        return assassine;
    }

    // Méthode pour obtenir l'état de vol du personnage
    public boolean getVole() {
        return vole;
    }

    // Méthode pour définir le joueur associé au personnage
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
        this.joueur.monPersonnage = this;
    }

    // Méthode pour définir l'état de vol du personnage
    public void setVole() {
        this.vole = true;
    }

    // Méthode pour définir l'état d'assassinat du personnage
    public void setAssassine() {
        this.assassine = true;
    }

    // Méthode pour ajouter des pièces au joueur associé au personnage
    public void ajouterPieces() {
        if (joueur != null && !assassine) {
            this.joueur.ajouterPieces(2);
        } else {
            System.out.println("Impossible d'ajouter des pièces.");
        }
    }

    // Méthode pour ajouter un quartier dans la main du joueur associé au personnage
    public void ajouterQuartier(Quartier nouveau) {
        if (joueur != null && !assassine) {
            this.joueur.ajouterQuartierDansMain(nouveau);
        } else {
            System.out.println("Impossible d'ajouter un quartier dans la main.");
        }
    }

    // Méthode pour construire un nouveau quartier dans la cité du joueur associé au personnage
    public void construire(Quartier nouveau) {
        if (joueur != null && !assassine) {
            this.joueur.ajouterQuartierDansCite(nouveau);
        } else {
            System.out.println("Impossible de construire un nouveau quartier dans la cité.");
        }
    }

    // Méthode pour percevoir des ressources spécifiques (à implémenter dans les sous-classes)
    public void percevoirRessourcesSpecifiques() {
        if (joueur != null && !assassine) {
            System.out.println("Aucunes ressources spécifiques.");
        } else {
            System.out.println("Impossible de percevoir des ressources.");
        }
    }

    // Méthode abstraite pour utiliser le pouvoir du personnage (à implémenter dans les sous-classes)
    public abstract void utiliserPouvoir();

    // Méthode pour réinitialiser les états du personnage
    public void reinitialiser() {
        this.joueur = null;
        this.vole = false;
        this.assassine = false;
        this.ensorcele = false;
        if (this.joueur != null) {
            this.joueur.monPersonnage = null;
            this.joueur.mesPersonnages[0] = null;
            this.joueur.mesPersonnages[1] = null;
        }
    }

    // Méthode pour définir l'état de vrai échevin
    public void setVraiEchevin(boolean bool) {
        this.vraiEchevin = bool;
    }

    // Méthode pour obtenir l'état de vrai échevin
    public boolean getVraiEchevin() {
        return this.vraiEchevin;
    }

    // Méthode pour définir l'état de faux échevin
    public void setFauxEchevin(boolean bool) {
        this.fauxEchevin = bool;
    }

    // Méthode pour obtenir l'état de faux échevin
    public boolean getFauxEchevin() {
        return this.fauxEchevin;
    }

    // Méthode pour définir l'état de fausse menace
    public void setFausseMenace(boolean bool) {
        this.fausseMenace = bool;
    }

    // Méthode pour obtenir l'état de fausse menace
    public boolean getFausseMenace() {
        return this.fausseMenace;
    }

    // Méthode pour définir l'état de vraie menace
    public void setVraieMenace(boolean bool) {
        this.vraieMenace = bool;
    }

    // Méthode pour obtenir l'état de vraie menace
    public boolean getVraieMenace() {
        return this.vraieMenace;
    }

    // Méthode abstraite pour utiliser le pouvoir d'avatar du personnage (à implémenter dans les sous-classes)
    public abstract void utiliserPouvoirAvatar();

    // Méthode abstraite pour activer le pouvoir de sorcière du personnage (à implémenter dans les sous-classes)
    public abstract void activationPouvoirSorciere(Joueur joueurSorciere);
}
