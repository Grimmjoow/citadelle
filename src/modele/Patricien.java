package modele;

public class Patricien extends Personnage {

    // Constructeur par défaut de la classe Patricien
    public Patricien(){
        super("Patricien", 4, Caracteristiques.PATRICIEN);
    }

    // Méthode pour utiliser le pouvoir du Patricien
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

    // Méthode pour percevoir des ressources spécifiques en fonction des quartiers dans la cité
    @Override
    public void percevoirRessourcesSpecifiques(){
        if(this.getAssassine()){
            super.percevoirRessourcesSpecifiques();
        }else{
            int count = 0;
            if(this.getJoueur() != null){
                for(int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++){
                    if(this.getJoueur().getCite()[i] != null && this.getJoueur().getCite()[i].getType().equals("NOBLE")){
                        this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
                        count++;
                    }
                }
                
                // Ajout d'une carte supplémentaire si le joueur possède l'école de magie
                if(this.getJoueur().getPossedeEcoleMag()){
                    this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
                    count++;
                }
            }
            System.out.println(count + " quartier(s) ajouté(s) dans la main");
        }
    }

    // Méthode pour utiliser le pouvoir spécial du Patricien (identique à utiliserPouvoir)
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

    // Méthode d'activation du pouvoir de la sorcière (non implémentée ici)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
    }
}
