package modele;

public class Roi extends Personnage {

    public Roi(){
        super("Roi", 4, Caracteristiques.ROI);
    }

    public void utiliserPouvoir(){
        if(!this.getAssassine()){
            if(this.getJoueur() != null){
                System.out.println("Je prend la couronne");
                this.getJoueur().setPossedeCouronne(true);
            }else{
                System.out.println("le joueur n'est pas défini");
            }
        }else{
            System.out.println("Vous ne pouvez pas utiliser votre pouvoir");
        }
    }

    @Override
    public void percevoirRessourcesSpecifiques(){
        if(this.getAssassine()){
            super.percevoirRessourcesSpecifiques();
        }else{
            int a = 0;
            if(this.getJoueur() != null){
                for(int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++){
                    if(this.getJoueur().getCite()[0] != null){
                        if(this.getJoueur().getCite()[i].getType() == "NOBLE"){
                                a += 1;
                        }
                    }
                }
                if(this.getJoueur().getPossedeEcoleMag()){//la merveille Ecole de Magie change de type a la perception des ressources
                    a+=1;
                }
                this.getJoueur().ajouterPieces(a);
            }
            System.out.println(a + " pièce(s) ajoutée(s)");
        }
     
    }

    @Override
    public void utiliserPouvoirAvatar() {
        // TODO Auto-generated method stub
        if(!this.getAssassine()){
            if(this.getJoueur() != null){
                System.out.println("Je prend la couronne");
                this.getJoueur().setPossedeCouronne(true);
            }else{
                System.out.println("le joueur n'est pas défini");
            }
        }else{
            System.out.println("Vous ne pouvez pas utiliser votre pouvoir");
        }
        
    }

    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
        
    }
}
