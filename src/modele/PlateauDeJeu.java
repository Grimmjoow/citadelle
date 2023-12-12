package modele;

/**
 * La classe PlateauDeJeu représente le plateau de jeu qui contient les personnages, les joueurs et la pioche.
 */
public class PlateauDeJeu {
    private Personnage[] listePersonnages;
    private Joueur[] listeJoueurs;
    private Pioche pioche;
    private int nombrePersonnages;
    private int nombreJoueurs;

    /**
     * Constructeur de la classe PlateauDeJeu.
     * Initialise les tableaux de personnages et de joueurs, ainsi que la pioche.
     */
    public PlateauDeJeu() {
        listePersonnages = new Personnage[9];
        listeJoueurs = new Joueur[9];
        nombreJoueurs = 0;
        nombrePersonnages = 0;
        pioche = new Pioche();
    }

    /**
     * Obtient le nombre de personnages sur le plateau.
     *
     * @return Le nombre de personnages sur le plateau.
     */
    public int getNombrePersonnages() {
        return nombrePersonnages;
    }

    /**
     * Obtient le nombre de joueurs sur le plateau.
     *
     * @return Le nombre de joueurs sur le plateau.
     */
    public int getNombreJoueurs() {
        return nombreJoueurs;
    }

    /**
     * Obtient la pioche du plateau.
     *
     * @return La pioche du plateau.
     */
    public Pioche getPioche() {
        return pioche;
    }

    /**
     * Modifie la pioche du plateau.
     *
     * @param p La nouvelle pioche du plateau.
     */
    public void setPioche(Pioche p) {
        this.pioche = p;
    }

    /**
     * Obtient un personnage à une position donnée dans le tableau de personnages.
     *
     * @param i L'indice du personnage dans le tableau.
     * @return Le personnage à la position spécifiée ou null si l'indice est invalide.
     */
    public Personnage getPersonnage(int i) {
        if (i >= 0 && i <= (nombrePersonnages - 1)) {
            return listePersonnages[i];
        } else {
            return null;
        }
    }

    /**
     * Obtient un joueur à une position donnée dans le tableau de joueurs.
     *
     * @param i L'indice du joueur dans le tableau.
     * @return Le joueur à la position spécifiée ou null si l'indice est invalide.
     */
    public Joueur getJoueur(int i) {
        if (i >= 0 && i <= (nombreJoueurs - 1)) {
            return listeJoueurs[i];
        } else {
            return null;
        }
    }

    /**
     * Ajoute un personnage sur le plateau.
     *
     * @param personnage Le personnage à ajouter.
     */
    public void ajouterPersonnage(Personnage personnage) {
        if (nombrePersonnages < 9 && personnage != null) {
            listePersonnages[nombrePersonnages] = personnage;
            personnage.setPlateau(this);
            nombrePersonnages += 1;
        } else {
            System.out.println("Le nombre de personnages est déjà de 9 ou la valeur renseignée en paramètre est nulle.");
        }
    }

    /**
     * Ajoute un joueur sur le plateau.
     *
     * @param joueur Le joueur à ajouter.
     */
    public void ajouterJoueur(Joueur joueur) {
        if (nombreJoueurs < 9 && joueur != null) {
            listeJoueurs[nombreJoueurs] = joueur;
            nombreJoueurs += 1;
        } else {
            System.out.println("Le nombre de joueurs est déjà de 9 ou la valeur renseignée en paramètre est nulle.");
        }
    }
}
