package modele;

import java.util.concurrent.ThreadLocalRandom;

import controleur.Interaction;

public class Abbe extends Personnage{

    // Constructeur par défaut de la classe Abbe
    public Abbe() {
        super("Abbe", 5, Caracteristiques.ABBE);
    }

    // Méthode pour utiliser le pouvoir de l'Abbé
    @Override
    public void utiliserPouvoir() {
        int count = 0;
        if(this.getAssassine()){
            System.out.println("Votre personnage a été assassiné");
        }else{
            for(int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++){
                if(this.getJoueur().getCite()[i] != null && this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[0])){
                    count++;
                }
            }
            System.out.println("Vous pouvez percevoir " + count + " ressources (pièces ou quartiers)");
            System.out.println("Veuillez saisir le nombre de pièces que vous souhaitez percevoir : "
                    + "(si vous inscrivez le nombre maximal, vous ne percevrez que des pièces,"
                    + " sinon vous percevrez le reste des ressources comme quartiers)");
            int choix = Interaction.lireUnEntier(0, count);
            this.getJoueur().ajouterPieces(choix);
            for(int i = 0; i < count - choix; i++) {
                this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
            }
            System.out.println("Vous avez reçu "+ choix + " pièces et " + (count - choix) + " quartiers");
            
            int richestPlayerId = 0;
            int maxTreasure = 0;
            String richestPlayerName = "";

            for(int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
                if(this.getPlateau().getJoueur(i).nbPieces() > maxTreasure) {
                    maxTreasure = this.getPlateau().getJoueur(i).nbPieces();
                    richestPlayerId = i;
                    richestPlayerName = this.getPlateau().getJoueur(i).getNom();
                } else if (this.getPlateau().getJoueur(i).nbPieces() == maxTreasure &&
                        this.getPlateau().getJoueur(i).nbPieces() != 0 &&
                        !this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
                    System.out.println("Deux joueurs ont le même nombre de pièces, choisissez le joueur à qui vous voulez prendre des pièces");
                    System.out.println("1 - " + richestPlayerName + "( " + maxTreasure + " )");
                    System.out.println("2 - " + this.getPlateau().getJoueur(i).getNom() + "( " + this.getPlateau().getJoueur(i).nbPieces() + " )");
                    int choicePlayer = Interaction.lireUnEntier(1, 2);
                    if(choicePlayer == 2) {
                        maxTreasure = this.getPlateau().getJoueur(i).nbPieces();
                        richestPlayerId = i;
                        richestPlayerName = this.getPlateau().getJoueur(i).getNom();
                    }
                }
            }

            if(!richestPlayerName.equals(this.getJoueur().getNom())) {
                System.out.println("Vous allez maintenant recevoir 1 pièce du joueur le plus riche");
                this.getPlateau().getJoueur(richestPlayerId).retirerPieces(1);
                this.getJoueur().ajouterPieces(1);
            } else {
                System.out.println("Vous êtes le joueur le plus riche et vous ne pouvez donc pas recevoir d'or du joueur le plus riche");
            }
        }
    }

    // Méthode pour utiliser le pouvoir de l'Abbé (version avec choix aléatoire)
    @Override
    public void utiliserPouvoirAvatar() {
        int count = 0;
        if(this.getAssassine()){
            System.out.println("Votre personnage a été assassiné");
        } else {
            for(int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++){
                if(this.getJoueur().getCite()[i] != null && this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[0])){
                    count++;
                }
            }
            System.out.println("Vous pouvez percevoir " + count + " ressources (pièces ou quartiers)");
            System.out.println("Veuillez saisir le nombre de pièces que vous souhaitez percevoir : "
                    + "(si vous inscrivez le nombre maximal, vous ne percevrez que des pièces,"
                    + " sinon vous percevrez le reste des ressources comme quartiers)");
            int choice = ThreadLocalRandom.current().nextInt(0, count + 1);
            this.getJoueur().ajouterPieces(choice);
            for(int i = 0; i < count - choice; i++) {
                this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
            }
            System.out.println("Vous avez reçu "+ choice + " pièces et " + (count - choice) + " quartiers");

            int richestPlayerId = 0;
            int maxTreasure = 0;
            String richestPlayerName = "";

            for(int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
                if(this.getPlateau().getJoueur(i).nbPieces() > maxTreasure) {
                    maxTreasure = this.getPlateau().getJoueur(i).nbPieces();
                    richestPlayerId = i;
                    richestPlayerName = this.getPlateau().getJoueur(i).getNom();
                } else if (this.getPlateau().getJoueur(i).nbPieces() == maxTreasure &&
                        this.getPlateau().getJoueur(i).nbPieces() != 0 &&
                        !this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
                    System.out.println("Deux joueurs ont le même nombre de pièces, choisissez le joueur à qui vous voulez prendre des pièces");
                    System.out.println("1 - " + richestPlayerName + "( " + maxTreasure + " )");
                    System.out.println("2 - " + this.getPlateau().getJoueur(i).getNom() + "( " + this.getPlateau().getJoueur(i).nbPieces() + " )");
                    int choicePlayer = ThreadLocalRandom.current().nextInt(1, 3);
                    if(choicePlayer == 2) {
                        maxTreasure = this.getPlateau().getJoueur(i).nbPieces();
                        richestPlayerId = i;
                        richestPlayerName = this.getPlateau().getJoueur(i).getNom();
                    }
                }
            }

            if(!richestPlayerName.equals(this.getJoueur().getNom())) {
                System.out.println("Vous allez maintenant recevoir 1 pièce du joueur le plus riche");
                this.getPlateau().getJoueur(richestPlayerId).retirerPieces(1);
                this.getJoueur().ajouterPieces(1);
            } else {
                System.out.println("Vous êtes le joueur le plus riche et vous ne pouvez donc pas recevoir d'or du joueur le plus riche");
            }
        }
    }

    // Méthode d'activation du pouvoir de la sorcière (non implémentée ici)
    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
    }
}
