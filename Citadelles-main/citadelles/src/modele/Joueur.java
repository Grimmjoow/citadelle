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

    

    public void setPossedeEcoleMag(boolean bool){
        this.possedeEcoleMag = bool;
    }

    public boolean getPossedeEcoleMag(){
        return this.possedeEcoleMag;
    }

    public boolean getPossedeManu() {
        return possedeManu;
    }

    public void setPossedeManu(boolean possedeManu) {
        this.possedeManu = possedeManu;
    }

    public void setPossedeCarriere(boolean bool){
        this.possedeCarriere = bool;
    }

    public boolean getPossedeCarriere(){
        return this.possedeCarriere;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public boolean getAFini(){
        return this.aFini;
    }

    public void setAFini(boolean choix){
        this.aFini = choix;
    }

    public String getNom(){
        return this.nom;
    }

    public int nbPieces(){
        return this.tresor;
    }

    public int nbQuartiersReelDansCite(){
        return this.nbQuartiersReel;
    }

    public int nbQuartiersMonumentDansCite(){
        return this.nbQuartiersReel;
    }

    public Quartier[] getCite(){
        return this.cite;
    }

    public ArrayList<Quartier> getMain(){
        return this.main;
    }

    public int nbQuartiersReelDansMain(){
        return this.main.size();
    }

    public boolean getPossedeCouronne(){
        return this.possedeCouronne;
    }

    public void setPossedeCouronne(boolean b){
        this.possedeCouronne = b;
    }

    public Personnage getPersonnage(){
        return this.monPersonnage;
    }

    public void ajouterPieces(int nb){
        if(nb >= 0){
            this.tresor += nb;
        }else{
            System.out.println("le nombre de pièces passé en paramètre n'est pas valable");
        }

    }

    public void retirerPieces(int nb){
        if(nb >= 0){
            if(tresor-nb < 0){
                System.out.println("trop grand nombre de pièces");
            }else{
                this.tresor -= nb;
            }
        }else{
            System.out.println("le nombre de pièces passé en paramètre n'est pas valable");
        }
    }

    public void ajouterQuartierDansCite(Quartier quartier){ 
        for(int i = 0; i <8; i++){
            if(cite[i] == null){
              cite[i] = quartier;
              break;  
            }
        }
        if(nbQuartiersMonument < 8 && nbQuartiersReel <8){
            cite[nbQuartiersReel] = quartier;
            nbQuartiersReel += 1;
            nbQuartiersMonument += 1;

            //Monument

            if(quartier.equals(Configuration.monument)){
                nbQuartiersMonument++;
            }

            //Monument

            
            
        }else{
            System.out.println("nombre de quartier déjà à 8");
        }
    }

    public boolean quartierPresentDansCite(String nomQuartier){
        boolean condition = false;
        for(int i = 0; i < nbQuartiersReel; i++){
            if(cite[i] != null && nomQuartier == cite[i].getNom()){
                condition = true;
            }
        }
        return condition;
    }

    public Quartier retirerQuartierDansCite(String nomQuartier){
        boolean condition = false;
        for(int i = 0; i < 8; i++){
            if(cite[i] != null && nomQuartier == cite[i].getNom()){
                Quartier quartier = cite[i];
                cite[i] = null;
                condition = true;
                nbQuartiersReel -= 1;
                nbQuartiersMonument -= 1;

                //Monument

                if(nomQuartier.equals("Monument")){
                    nbQuartiersMonument--;
                }

                //Monument

                for(int j = 1; j < 8; j++){
                    if(cite[j-1] == null){
                        cite[j-1] = cite[j];
                        cite[j] = null;
                    }
                }
                return quartier;
            } 
        }
        return null;
    }

    public void ajouterQuartierDansMain(Quartier quartier){
        //Quand la pioche est vide, on ajoute un element null dans la main, on en veut pas
        if(!(quartier==null)){
            main.add(quartier);
        }
    }

    public Quartier retirerQuartierDansMain(){
        Random generateur = new Random();
        int numeroHasard = generateur.nextInt(this.nbQuartiersReelDansMain());
        if(main.size() == 0){
            return null;
        }else{ 
            Quartier quartier = main.get(numeroHasard);
            main.remove(numeroHasard);
            return quartier;
        }
    }
/*
    public void retirerNullDansMain(){
        for(int i=0; i<main.size(); i++){
            if(main.get(i)==null){
                main.remove(i);
            }
        }
    }
*/
    public Quartier retirerQuartierDansMain(Quartier quartier){
        if(main.size() == 0){
            return null;
        }else{ 
            main.remove(quartier);
            return quartier;
        }
    }

    public void reinitialiser(){
        this.tresor = 0;
        this.main.clear();
        for(int i=0; i <8; i++){
            cite[i] = null;
        }
        this.nbQuartiersReel = 0; 
        this.nbQuartiersMonument = 0; 
        this.setAFini(false);
        this.setPoints(0);

        
    }





}
