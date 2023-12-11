package modele;

import java.util.ArrayList;
import java.util.Random;

import application.Configuration;

public class Joueur {
    private String nom;
    private int tresor;
    private Quartier[] cite;
    private int nbQuartiersReel;
    private int nbQuartiersMonument;
    private ArrayList<Quartier> main;
    private boolean possedeCouronne;
    protected Personnage monPersonnage;
    protected Personnage[] mesPersonnages;
    private boolean aFini;
    private int points;
    private boolean possedeManu;
    private boolean possedeCarriere;
    private boolean possedeEcoleMag;

    // Constructeur pour la classe Joueur
    public Joueur(String nom){
        this.nom = nom;
        this.tresor  = 0;
        this.nbQuartiersReel = 0;
        this.possedeCouronne = false;
        this.possedeCarriere = false;
        this.possedeEcoleMag = false;
        this.nbQuartiersMonument = 0;

        this.cite = new Quartier[8];
        this.main = new ArrayList<Quartier>();
        this.monPersonnage = null;
        this.mesPersonnages = new Personnage[2];
    }

    // Méthode pour définir si le joueur possède l'Ecole de Magie
    public void setPossedeEcoleMag(boolean bool){
        this.possedeEcoleMag = bool;
    }

    // Méthode pour obtenir l'information si le joueur possède l'Ecole de Magie
    public boolean getPossedeEcoleMag(){
        return this.possedeEcoleMag;
    }

    // Méthode pour obtenir l'information si le joueur possède la Manufacture
    public boolean getPossedeManu() {
        return possedeManu;
    }

    // Méthode pour définir si le joueur possède la Manufacture
    public void setPossedeManu(boolean possedeManu) {
        this.possedeManu = possedeManu;
    }

    // Méthode pour définir si le joueur possède la Carrière
    public void setPossedeCarriere(boolean bool){
        this.possedeCarriere = bool;
    }

    // Méthode pour obtenir l'information si le joueur possède la Carrière
    public boolean getPossedeCarriere(){
        return this.possedeCarriere;
    }

    // Méthode pour obtenir le nombre de points du joueur
    public int getPoints(){
        return this.points;
    }

    // Méthode pour définir le nombre de points du joueur
    public void setPoints(int points){
        this.points = points;
    }

    // Méthode pour obtenir l'information si le joueur a terminé son tour
    public boolean getAFini(){
        return this.aFini;
    }

    // Méthode pour définir si le joueur a terminé son tour
    public void setAFini(boolean choix){
        this.aFini = choix;
    }

    // Méthode pour obtenir le nom du joueur
    public String getNom(){
        return this.nom;
    }

    // Méthode pour obtenir le nombre de pièces du joueur
    public int nbPieces(){
        return this.tresor;
    }

    // Méthode pour obtenir le nombre de quartiers réels dans la cité du joueur
    public int nbQuartiersReelDansCite(){
        return this.nbQuartiersReel;
    }

    // Méthode pour obtenir le nombre de quartiers monument dans la cité du joueur
    public int nbQuartiersMonumentDansCite(){
        return this.nbQuartiersReel;
    }

    // Méthode pour obtenir les quartiers dans la cité du joueur
    public Quartier[] getCite(){
        return this.cite;
    }

    // Méthode pour obtenir les quartiers dans la main du joueur
    public ArrayList<Quartier> getMain(){
        return this.main;
    }

    // Méthode pour obtenir le nombre de quartiers réels dans la main du joueur
    public int nbQuartiersReelDansMain(){
        return this.main.size();
    }

    // Méthode pour obtenir l'information si le joueur possède la Couronne
    public boolean getPossedeCouronne(){
        return this.possedeCouronne;
    }

    // Méthode pour définir si le joueur possède la Couronne
    public void setPossedeCouronne(boolean b){
        this.possedeCouronne = b;
    }

    // Méthode pour obtenir le personnage du joueur
    public Personnage getPersonnage(){
        return this.monPersonnage;
    }

    // Méthode pour ajouter des pièces au trésor du joueur
    public void ajouterPieces(int nb){
        if(nb >= 0){
            this.tresor += nb;
        } else {
            System.out.println("Le nombre de pièces passé en paramètre n'est pas valide");
        }
    }

    // Méthode pour retirer des pièces du trésor du joueur
    public void retirerPieces(int nb){
        if(nb >= 0){
            if(tresor - nb < 0){
                System.out.println("Trop grand nombre de pièces");
            } else {
                this.tresor -= nb;
            }
        } else {
            System.out.println("Le nombre de pièces passé en paramètre n'est pas valide");
        }
    }

    // Méthode pour ajouter un quartier dans la cité du joueur
    public void ajouterQuartierDansCite(Quartier quartier){ 
        for(int i = 0; i < 8; i++){
            if(cite[i] == null){
              cite[i] = quartier;
              break;  
            }
        }
        if(nbQuartiersMonument < 8 && nbQuartiersReel < 8){
            cite[nbQuartiersReel] = quartier;
            nbQuartiersReel += 1;
            nbQuartiersMonument += 1;

            // Monument
            if(quartier.equals(Configuration.monument)){
                nbQuartiersMonument++;
            }
            // Monument
        }
