package modele;

import java.util.ArrayList;
import java.util.Random;

/**
 * La classe Pioche représente la pioche de quartiers dans le jeu.
 */
public class Pioche {
    private ArrayList<Quartier> liste;

    /**
     * Constructeur de la classe Pioche.
     * Initialise une liste de quartiers vide.
     */
    public Pioche(){
        this.liste = new ArrayList<Quartier>();
    }

    /**
     * Pioche un quartier de la pioche.
     *
     * @return Le quartier pioché ou null si la pioche est vide.
     */
    public Quartier piocher(){
        if(liste.size() == 0){
            return null;
        }else{
            Quartier quartier = liste.get(0);
            liste.remove(0);
            return quartier;
        }
    }

    /**
     * Ajoute un quartier à la pioche.
     *
     * @param nouveau Le quartier à ajouter.
     */
    public void ajouter(Quartier nouveau){
        liste.add(nouveau);
    }

    /**
     * Obtient le nombre d'éléments dans la pioche.
     *
     * @return Le nombre de quartiers dans la pioche.
     */
    public int nombreElements(){
        return liste.size();
    }

    /**
     * Mélange les quartiers dans la pioche de manière aléatoire.
     */
    public void melanger(){
        Random generateur = new Random();
        for(int i = 0; i < liste.size(); i++){
            int j = generateur.nextInt(liste.size());
            Quartier quartier = liste.get(j);
            liste.set(j, liste.get(i));
            liste.set(i, quartier);
        }
    }
}
