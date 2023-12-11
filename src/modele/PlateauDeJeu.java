package modele;

public class PlateauDeJeu {
    private Personnage[] listePersonnages;
    private Joueur[] listeJoueurs;
    private Pioche pioche;
    private int nombrePersonnages;
    private int nombreJoueurs;

    public PlateauDeJeu(){
        listePersonnages = new Personnage[9];
        listeJoueurs= new Joueur[9];
        nombreJoueurs = 0;
        nombrePersonnages = 0;
        pioche = new Pioche();
    }

    public int getNombrePersonnages(){
        return nombrePersonnages;
    }

    public int getNombreJoueurs(){
        return nombreJoueurs;
    }

    public Pioche getPioche(){
        return pioche;
    }

    public void setPioche(Pioche p){
        this.pioche = p;
    }

    public Personnage getPersonnage(int i){
        if(i >= 0 && i <= (nombrePersonnages - 1)) {
            return listePersonnages[i];
        }else{
            return null;
        }
    }

    public Joueur getJoueur(int i){
        if(i >= 0 && i <= (nombreJoueurs - 1)) {
            return listeJoueurs[i];
        }else{
            return null;
        }
    }

    public void ajouterPersonnage(Personnage personnage){
        if(nombrePersonnages < 9 && personnage != null){
            listePersonnages[nombrePersonnages] = personnage;
            personnage.setPlateau(this);
            nombrePersonnages += 1;
        }else{
            System.out.println("le nombre de personnage est déjà de 9 ou la valeur renseignée en paramètre est nulle");
        }
    }

    public void ajouterJoueur(Joueur joueur){
        if(nombreJoueurs < 9 && joueur != null){
            listeJoueurs[nombreJoueurs] = joueur;
            nombreJoueurs += 1;
        }else{
            System.out.println("le nombre de joueur est déjà de 9 ou la valeur renseignée en paramètre est nulle");
        }
    }



}
