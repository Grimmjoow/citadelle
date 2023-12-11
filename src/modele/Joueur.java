package modele;

import java.util.ArrayList;
import java.util.Random;

import application.Configuration;

public class Joueur {
    private String nom;                 // Nom du joueur
    private int tresor;                 // Nombre de pièces du joueur
    private Quartier[] cite;            // Quartiers construits dans la cité du joueur
    private int nbQuartiersReel;        // Nombre de quartiers réels dans la cité du joueur
    private int nbQuartiersMonument;    // Nombre de quartiers monument dans la cité du joueur
    private ArrayList<Quartier> main;   // Quartiers dans la main du joueur
    private boolean possedeCouronne;    // Indique si le joueur possède la couronne
    protected Personnage monPersonnage; // Personnage associé au joueur
    protected Personnage[] mesPersonnages; // Tableau des personnages du joueur
    private boolean aFini;              // Indique si le joueur a fini son tour
    private int points;                 // Points du joueur
    private boolean possedeManu;        // Indique si le joueur possède le Manoir
    private boolean possedeCarriere;    // Indique si le joueur possède la Carrière
    private boolean possedeEcoleMag;    // Indique si le joueur possède l'École de Magie

    // Constructeur
    public Joueur(String nom) {
        this.nom = nom;
        this.tresor = 0;
        this.nbQuartiersReel = 0;
        this.possedeCouronne = false;
        this.possedeCarriere = false;
        this.possedeEcoleMag = false;
        this.nbQuartiersMonument = 0;

        this.cite = new Quartier[8];
        this.main = new ArrayList<>();
        this.monPersonnage = null;
        this.mesPersonnages = new Personnage[2];
    }

    // Méthode pour définir si le joueur possède l'École de Magie
    public void setPossedeEcoleMag(boolean bool) {
        this.possedeEcoleMag = bool;
    }

    // Méthode pour obtenir si le joueur possède l'École de Magie
    public boolean getPossedeEcoleMag() {
        return this.possedeEcoleMag;
    }

    // Méthode pour obtenir si le joueur possède le Manoir
    public boolean getPossedeManu() {
        return possedeManu;
    }

    // Méthode pour définir si le joueur possède le Manoir
    public void setPossedeManu(boolean possedeManu) {
        this.possedeManu = possedeManu;
    }

    // Méthode pour définir si le joueur possède la Carrière
    public void setPossedeCarriere(boolean bool) {
        this.possedeCarriere = bool;
    }

    // Méthode pour obtenir si le joueur possède la Carrière
    public boolean getPossedeCarriere() {
        return this.possedeCarriere;
    }

    // Méthode pour obtenir les points du joueur
    public int getPoints() {
        return this.points;
    }

    // Méthode pour définir les points du joueur
    public void setPoints(int points) {
        this.points = points;
    }

    // Méthode pour obtenir si le joueur a fini son tour
    public boolean getAFini() {
        return this.aFini;
    }

    // Méthode pour définir si le joueur a fini son tour
    public void setAFini(boolean choix) {
        this.aFini = choix;
    }

    // Méthode pour obtenir le nom du joueur
    public String getNom() {
        return this.nom;
    }

    // Méthode pour obtenir le nombre de pièces du joueur
    public int nbPieces() {
        return this.tresor;
    }

    // Méthode pour obtenir le nombre de quartiers réels dans la cité du joueur
    public int nbQuartiersReelDansCite() {
        return this.nbQuartiersReel;
    }

    // Méthode pour obtenir le nombre de quartiers monument dans la cité du joueur
    public int nbQuartiersMonumentDansCite() {
        return this.nbQuartiersReel;
    }

    // Méthode pour obtenir les quartiers dans la cité du joueur
    public Quartier[] getCite() {
        return this.cite;
    }

    // Méthode pour obtenir les quartiers dans la main du joueur
    public ArrayList<Quartier> getMain() {
        return this.main;
    }

    // Méthode pour obtenir le nombre de quartiers dans la main du joueur
    public int nbQuartiersReelDansMain() {
        return this.main.size();
    }

    // Méthode pour obtenir si le joueur possède la couronne
    public boolean getPossedeCouronne() {
        return this.possedeCouronne;
    }

    // Méthode pour définir si le joueur possède la couronne
    public void setPossedeCouronne(boolean b) {
        this.possedeCouronne = b;
    }

    // Méthode pour obtenir le personnage du joueur
    public Personnage getPersonnage() {
        return this.monPersonnage;
    }

    // Méthode pour ajouter des pièces au joueur
    public void ajouterPieces(int nb) {
        if (nb >= 0) {
            this.tresor += nb;
        } else {
            System.out.println("Le nombre de pièces passé en paramètre n'est pas valable");
        }
    }

    // Méthode pour retirer des pièces au joueur
    public void retirerPieces(int nb) {
        if (nb >= 0) {
            if (tresor - nb < 0) {
                System.out.println("Trop grand nombre de pièces");
            } else {
                this.tresor -= nb;
            }
        } else {
            System.out.println("Le nombre de pièces passé en paramètre n'est pas valable");
        }
    }

    // Méthode pour ajouter un quartier dans la cité du joueur
    public void ajouterQuartierDansCite(Quartier quartier) {
        for (int i = 0; i < 8; i++) {
            if (cite[i] == null) {
                cite[i] = quartier;
                break;
            }
        }
        if (nbQuartiersMonument < 8 && nbQuartiersReel < 8) {
            cite[nbQuartiersReel] = quartier;
            nbQuartiersReel += 1;
            nbQuartiersMonument += 1;

            // Gestion des quartiers Monument
            if (quartier.equals(Configuration.monument)) {
                nbQuartiersMonument++;
            }
        } else {
            System.out.println("Nombre de quartiers déjà à 8");
        }
    }

    // Méthode pour vérifier si un quartier est présent dans la cité du joueur
    public boolean quartierPresentDansCite(String nomQuartier) {
        boolean condition = false;
        for (int i = 0; i < nbQuartiersReel; i++) {
            if (cite[i] != null && nomQuartier.equals(cite[i].getNom())) {
                condition = true;
            }
        }
        return condition;
    }

    // Méthode pour retirer un quartier de la cité du joueur
    public Quartier retirerQuartierDansCite(String nomQuartier) {
        boolean condition = false;
        for (int i = 0; i < 8; i++) {
            if (cite[i] != null && nomQuartier.equals(cite[i].getNom())) {
                Quartier quartier = cite[i];
                cite[i] = null;
                condition = true;
                nbQuartiersReel -= 1;
                nbQuartiersMonument -= 1;

                // Gestion des quartiers Monument
                if (nomQuartier.equals("Monument")) {
                    nbQuartiersMonument--;
                }

                // Réorganisation des quartiers dans la cité
                for (int j = 1; j < 8; j++) {
                    if (cite[j - 1] == null) {
                        cite[j - 1] = cite[j];
                        cite[j] = null;
                    }
                }
                return quartier;
            }
        }
        return null;
    }

    // Méthode pour ajouter un quartier dans la main du joueur
    public void ajouterQuartierDansMain(Quartier quartier) {
        // Quand la pioche est vide, on ajoute un élément null dans la main, on n'en veut pas
        if (!(quartier == null)) {
            main.add(quartier);
        }
    }

    // Méthode pour retirer un quartier aléatoire de la main du joueur
    public Quartier retirerQuartierDansMain() {
        Random generateur = new Random();
        int numeroHasard = generateur.nextInt(this.nbQuartiersReelDansMain());
        if (main.size() == 0) {
            return null;
        } else {
            Quartier quartier = main.get(numeroHasard);
            main.remove(numeroHasard);
            return quartier;
        }
    }

    // Méthode pour retirer un quartier spécifique de la main du joueur
    public Quartier retirerQuartierDansMain(Quartier quartier) {
        if (main.size() == 0) {
            return null;
        } else {
            main.remove(quartier);
            return quartier;
        }
    }

    // Méthode pour réinitialiser les données du joueur
    public void reinitialiser() {
        this.tresor = 0;
        this.main.clear();
        for (int i = 0; i < 8; i++) {
            cite[i] = null;
        }
        this.nbQuartiersReel = 0;
        this.nbQuartiersMonument = 0;
        this.setAFini(false);
        this.setPoints(0);
    }
}
