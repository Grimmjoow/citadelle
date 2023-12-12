package modele;

import java.util.ArrayList;
import java.util.Random;

/**
 * La classe Pioche représente une pioche de cartes (objets Quartier).
 */
public class Pioche {
    private ArrayList<Quartier> liste;

    /**
     * Constructeur par défaut de la classe Pioche.
     */
    public Pioche(){
        this.liste = new ArrayList<Quartier>();
    }

    /**
     * Tire une carte de la pioche.
     *
     * @return La carte tirée, ou null si la pioche est vide.
     */
    public Quartier piocher(){
        if(liste.size() == 0){
            return null;
        } else {
            Quartier quartier = liste.get(0);
            liste.remove(0);
            return quartier;
        }
    }

    /**
     * Ajoute un nouveau quartier à la pioche.
     *
     * @param nouveau Le nouveau quartier à ajouter.
     */
    public void ajouter(Quartier nouveau){
        liste.add(nouveau);
    }

    /**
     * Obtient le nombre d'éléments dans la pioche.
     *
     * @return Le nombre d'éléments dans la pioche.
     */
    public int nombreElements(){
        return liste.size();
    }

    /**
     * Mélange les cartes dans la pioche.
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
