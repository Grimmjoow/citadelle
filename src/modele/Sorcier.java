package modele;

import java.util.Random;
import Controleur.Interaction;

// Classe représentant le personnage "Sorcier" du jeu
public class Sorcier extends Personnage {
    
    // Constructeur de la classe Sorcier
    public Sorcier(){
        // Appelle le constructeur de la classe mère (Personnage) avec des valeurs spécifiques
        super("Sorcier", 3, Caracteristiques.SORCIER);
    }
    
    // Méthode pour utiliser le pouvoir du personnage
    public void utiliserPouvoir(){

        // Affiche les joueurs non Sorcier
        for (int i=0; i<this.getPlateau().getNombreJoueurs(); i++){
            Joueur joueur = this.getPlateau().getJoueur(i);
            if(joueur.getPersonnage().getRang() != 3){
                System.out.println((i+1)+". "+ joueur.getNom());
            }
        }  

        System.out.println("Veuillez sélectionner le Joueur dont vous voulez voir la main : (0 pour ne rien faire) " );
            
        int joueurVoirMain = Interaction.lireUnEntier(0, this.getPlateau().getNombreJoueurs()) - 1;

        if(joueurVoirMain != -1 && this.getPlateau().getJoueur(joueurVoirMain).getMain() != null ){

            // Affiche la main du joueur choisi
            for(int k = 0; k < this.getPlateau().getJoueur(joueurVoirMain).getMain().size(); k++){
                System.out.println((k+1) + ". " + this.getPlateau().getJoueur(joueurVoirMain).getMain().get(k).getNom() + " (" + this.getPlateau().getJoueur(joueurVoirMain).getMain().get(k).getCout() + " piece(s))");
            }

            System.out.println("Quel quartier souhaitez-vous choisir ?");

            if(this.getPlateau().getJoueur(joueurVoirMain).nbQuartiersReelDansMain()>0){

                // Lecture du choix du quartier à prendre
                int quartierAPrendre = Interaction.lireUnEntier(1, this.getPlateau().getJoueur(joueurVoirMain).getMain().size()) - 1;

                Quartier quartierC2 = this.getPlateau().getJoueur(joueurVoirMain).getMain().get(quartierAPrendre);

                this.getPlateau().getJoueur(joueurVoirMain).getMain().remove(quartierAPrendre);

                // Vérification si le joueur a assez d'argent pour bâtir le quartier choisi
                if(this.getJoueur().nbPieces() < quartierC2.getCout()){
                    this.getJoueur().ajouterQuartierDansMain(quartierC2);
                    System.out.println("Vous n'avez pas assez d'argent pour bâtir ce quartier, il est ajouté à votre main.");
                }

                else{
                    // Affiche le coût du quartier et propose au joueur de le bâtir
                    System.out.println("Le quartier coûte : "+ quartierC2.getCout() +" piece(s) vous avez "+ this.getJoueur().nbPieces() +" piece(s) d'or, voulez-vous le bâtir ?");

                    Boolean construire = Interaction.lireOuiOuNon();

                    if(construire){
                        this.getJoueur().retirerPieces(quartierC2.getCout());
                        this.getJoueur().ajouterQuartierDansCite(quartierC2); 
                    }
                    else{
                        this.getJoueur().ajouterQuartierDansMain(quartierC2);
                        System.out.println("Le quartier va dans votre main"); 
                    }   
                }
            }else{
                System.out.println("Vous n'avez pas de quartier dans la main");
            }
        }
    }

    // Méthode pour utiliser le pouvoir de l'avatar du personnage
    public void utiliserPouvoirAvatar(){

        Random generateur = new Random();

        // Affiche les joueurs non Sorcier
        for (int i=0; i<this.getPlateau().getNombreJoueurs(); i++){
            Joueur joueur = this.getPlateau().getJoueur(i);
            if(joueur.getPersonnage().getRang() != 3){
                System.out.println((i+1)+". "+ joueur.getNom());
            }
        }  

        System.out.println("Veuillez sélectionner le Joueur dont vous voulez voir la main : (0 pour ne rien faire) " );
            
        int joueurVoirMain = generateur.nextInt(this.getPlateau().getNombreJoueurs() + 1) - 1;

        if(joueurVoirMain != -1 && this.getPlateau().getJoueur(joueurVoirMain).getMain() != null ){

            // Affiche la main du joueur choisi
            for(int k = 0; k < this.getPlateau().getJoueur(joueurVoirMain).getMain().size(); k++){
                System.out.println((k+1) + ". " + this.getPlateau().getJoueur(joueurVoirMain).getMain().get(k).getNom() + " (" + this.getPlateau().getJoueur(joueurVoirMain).getMain().get(k).getCout() + " piece(s))");
            }

            System.out.println("Quel quartier souhaitez-vous choisir ?");

            if(this.getPlateau().getJoueur(joueurVoirMain).nbQuartiersReelDansMain()>0){

                // Génère un choix aléatoire du quartier à prendre
                int quartierAPrendre = generateur.nextInt(this.getPlateau().getJoueur(joueurVoirMain).getMain().size());

                Quartier quartierC2 = this.getPlateau().getJoueur(joueurVoirMain).getMain().get(quartierAPrendre);

                this.getPlateau().getJoueur(joueurVoirMain).getMain().remove(quartierAPrendre);

                // Vérification si le joueur a assez d'argent pour bâtir le quartier choisi
                if(this.getJoueur().nbPieces() < quartierC2.getCout()){
                    this.getJoueur().ajouterQuartierDansMain(quartierC2);
                    System.out.println("Vous n'avez pas assez d'argent pour bâtir ce quartier, il est ajouté à votre main.");
                }

                else{
                    // Affiche le coût du quartier et simule la décision du joueur de le bâtir
                    System.out.println("Le quartier coûte : "+ quartierC2.getCout() +" piece(s) vous avez "+ this.getJoueur().nbPieces() +" piece(s) d'or, voulez-vous le bâtir ?");

                    Boolean construire = generateur.nextBoolean();

                    if(construire){
                        this.getJoueur().retirerPieces(quartierC2.getCout());
                        this.getJoueur().ajouterQuartierDansCite(quartierC2); 
                    }
                    else{
                        this.getJoueur().ajouterQuartierDansMain(quartierC2);
                        System.out.println("Le quartier va dans votre main"); 
                    }   
                }
            }else{
                System.out.println("Vous n'avez pas de quartier dans la main");
            }
        }
    }

    // Méthode pour activer le pouvoir de la Sorcière sur un joueur (non utilisée dans cette classe)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // Ne fait rien dans le contexte du Sorcier
    }
}
