package modele;

import application.Configuration;

public abstract class Personnage {
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

    public boolean getEnsorcele() {
        return ensorcele;
    }

    public Personnage(){
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

    public void setEnsorcele(boolean ensorcele) {
        this.ensorcele = ensorcele;
    }

    public Personnage(String nom, int rang, String caracteristiques){
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

    public void setPlateau(PlateauDeJeu nouveau){
        this.plateau = nouveau;
    }

    public PlateauDeJeu getPlateau(){
        return plateau;
    }

    public String getNom(){
        return nom;
    }

    public int getRang(){
        return rang;
    }

    public String getCaracteristiques(){
        return caracteristiques;
    }

    public Joueur getJoueur(){
        return joueur;
    }

    public boolean getAssassine(){
        return assassine;
    }

    public boolean getVole(){
        return vole;
    }

    public void setJoueur(Joueur joueur){
        this.joueur = joueur;
        this.joueur.monPersonnage = this;
    }

    public void setVole(){
        this.vole = true;
    }

    public void setAssassine(){
        this.assassine = true;
    }

    public void ajouterPieces(){
        if(joueur != null && !assassine){
            this.joueur.ajouterPieces(2);
        }else{
            System.out.println("impossible d'ajouter des pièces");
        }
    }

    public void ajouterQuartier(Quartier nouveau){
        if(joueur != null && !assassine){
            this.joueur.ajouterQuartierDansMain(nouveau);
        }else{
            System.out.println("impossible d'ajouter un quartier dans la main");
        }
    }

    public void construire(Quartier nouveau){
        if(joueur != null && !assassine){
            this.joueur.ajouterQuartierDansCite(nouveau);
        }else{
            System.out.println("impossible de construire un nouveau quartier dans la cité");
        }
    }

    public void percevoirRessourcesSpecifiques(){
        if(joueur != null && !assassine){
            System.out.println("aucunes ressources specifiques");
        }else{
            System.out.println("impossible de percevoir des ressources");
        }
    }

    public abstract void utiliserPouvoir();
    

    public void reinitialiser(){
        this.joueur = null; // à enlever ? 
        this.vole = false;
        this.assassine = false;
        this.ensorcele = false;
        if(this.joueur != null){
            this.joueur.monPersonnage = null;
            this.joueur.mesPersonnages[0]=null;
            this.joueur.mesPersonnages[1]=null;
        }
    }

    public void setVraiEchevin(boolean bool) {
        this.vraiEchevin = bool;
    }

    public boolean getVraiEchevin() {
        return this.vraiEchevin;
    }

    public void setFauxEchevin(boolean bool) {
        this.fauxEchevin = bool;
    }

    public boolean getFauxEchevin() {
        return this.fauxEchevin;
    }

    public void setFausseMenace(boolean bool) {
        this.fausseMenace = bool;
    }

    public boolean getFausseMenace() {
        return this.fausseMenace;
    }
    public void setVraieMenace(boolean bool) {
        this.vraieMenace = bool;
    }

    public boolean getVraieMenace() {
        return this.vraieMenace;
    }

    public abstract void utiliserPouvoirAvatar();

    public abstract void activationPouvoirSorciere(Joueur joueurSorciere);

    


    
}
