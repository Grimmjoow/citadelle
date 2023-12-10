package modele;

import java.util.ArrayList;
import java.util.Random;

public class Pioche {
    private ArrayList<Quartier> liste;

    public Pioche(){
        this.liste = new ArrayList<Quartier>();
    }

    public Quartier piocher(){
        if(liste.size() == 0){
            return null;
        }else{
            Quartier quartier = liste.get(0);
            liste.remove(0);
            return quartier;
        }
        
    }

    public void ajouter(Quartier nouveau){
        liste.add(nouveau);
    }

    public int nombreElements(){
        return liste.size();
    }

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
