package modele;

/**
 * La classe Patricien représente un type de personnage du jeu appelé "Patricien".
 * Il hérite de la classe abstraite Personnage.
 */
public class Patricien extends Personnage {

    /**
     * Constructeur de la classe Patricien.
     * Initialise le nom, le rang et les caractéristiques du Patricien.
     */
    public Patricien(){
        super("Patricien", 4, Caracteristiques.PATRICIEN);
    }

    /**
     * Méthode permettant l'utilisation du pouvoir du Patricien.
     * Si le Patricien n'est pas assassiné et a un joueur associé, il prend la couronne.
     * Sinon, affiche un message d'impossibilité d'utilisation du pouvoir.
     */
    public void utiliserPouvoir(){
        if(!this.getAssassine()){
            if(this.getJoueur() != null){
                System.out.println("Je prends la couronne");
                this.getJoueur().setPossedeCouronne(true);
            }else{
                System.out.println("Le joueur n'est pas défini");
            }
        }else{
            System.out.println("Vous ne pouvez pas utiliser votre pouvoir");
        }
    }

    /**
     * Redéfinition de la méthode percevoirRessourcesSpecifiques pour le Patricien.
     * Si le Patricien est assassiné, la méthode de la classe parente est appelée.
     * Sinon, le Patricien perçoit des quartiers de type "NOBLE" dans sa main.
     * Si le joueur possède l'école de magie, il pioche une carte supplémentaire.
     */
    @Override
    public void percevoirRessourcesSpecifiques(){
        if(this.getAssassine()){
            super.percevoirRessourcesSpecifiques();
        }else{
            int quartiersAjoutes = 0;
            if(this.getJoueur() != null){
                for(int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++){
                    if(this.getJoueur().getCite()[0] != null){
                        if(this.getJoueur().getCite()[i].getType().equals("NOBLE")){
                            this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
                            quartiersAjoutes++;
                        }
                    }
                }
                if(this.getJoueur().getPossedeEcoleMag()){
                    this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
                    quartiersAjoutes++;
                }
            }
            System.out.println(quartiersAjoutes + " quartier(s) ajouté(s) dans la main");
        }
    }

    /**
     * Redéfinition de la méthode utiliserPouvoirAvatar pour le Patricien.
     * Son comportement est identique à la méthode utiliserPouvoir.
     */
    @Override
    public void utiliserPouvoirAvatar() {
        if(!this.getAssassine()){
            if(this.getJoueur() != null){
                System.out.println("Je prends la couronne");
                this.getJoueur().setPossedeCouronne(true);
            }else{
                System.out.println("Le joueur n'est pas défini");
            }
        }else{
            System.out.println("Vous ne pouvez pas utiliser votre pouvoir");
        }
    }

    /**
     * Redéfinition de la méthode activationPouvoirSorciere pour le Patricien.
     * Cette méthode ne contient aucune action spécifique pour le Patricien.
     */
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Aucune action spécifique pour le Patricien lors de l'activation du pouvoir de sorcière
    }
}
