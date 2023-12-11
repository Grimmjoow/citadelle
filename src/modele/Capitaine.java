package modele;

import java.util.ArrayList;

import Exception.CantChoose;
import Exception.SelfChosen;
import Controleur.Interaction;
import Exception.SelfChosen;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.PrimitiveIterator.OfInt;

/**
 * La classe Capitaine représente le personnage Capitaine du jeu.
 */
public class Capitaine extends Personnage {

    Interaction scan = new Interaction();

    /**
     * Constructeur de la classe Capitaine.
     */
    public Capitaine() {
        super("Capitaine", 8, Caracteristiques.CAPITAINE);
        // TODO Auto-generated constructor stub
    }

    /**
     * Perçoit des ressources spécifiques en fonction de son état assassiné ou non.
     */
    public void percevoirRessourcesSpecifiques() {
        // TODO Auto-generated method stub    
        if (this.getAssassine()) {
            super.percevoirRessourcesSpecifiques();
        } else {
            for (int i = 0; i < this.getJoueur().nbQuartiersReelDansCite(); i++) {
                if (this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[1])) {
                    this.getJoueur().ajouterPieces(1);
                }
            }
        }
    }

    /**
     * Utilise le pouvoir du Capitaine pour choisir un quartier d'un autre joueur.
     */
    @Override
    public void utiliserPouvoir() {
        System.out.println("Vous pouvez choisir un quartier dans la cité d'un joueur avec un coût inférieur à 3");
        System.out.println("Vous pouvez l'ajouter à votre cité en payant le coût de construction à son propriétaire");

        // Implémentation de la merveille donjon
        // Implémentation de la merveille Grande Muraille
        boolean aGrandeMuraille = false;
        int prixEnPlus = 0;
        boolean repeter = false;

        do {
            try {
                System.out.println("Veuillez choisir le joueur dont vous voulez prendre une carte (0 pour ne rien faire)");

                for (int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
                    System.out.println((i + 1) + "." + this.getPlateau().getJoueur(i).getNom() + " : " +
                            this.getPlateau().getJoueur(i).nbQuartiersReelDansCite() + " carte(s).");
                }

                int choix = Interaction.lireUnEntier(0, this.getPlateau().getNombreJoueurs()) - 1;

                if (choix != -1) {
                    if (this.getPlateau().getPersonnage(choix).nom.equals(this.nom)) {
                        throw new SelfChosen();
                    } else if (this.getPlateau().getPersonnage(choix).nom.equals("Eveque")) {
                        throw new CantChoose();
                    }

                    Quartier[] citeJoueur = this.getPlateau().getJoueur(choix).getCite();

                    for (int i = 0; i < this.getPlateau().getJoueur(choix).nbQuartiersReelDansCite(); i++) {
                        if (citeJoueur[i].getNom().equals("Grande Muraille")) {
                            aGrandeMuraille = true;
                        }
                    }

                    if (aGrandeMuraille) {
                        System.out.println("Vous avez choisi un joueur possédant la merveille Grande Muraille, " +
                                "les quartiers que vous essayerez de détruire auront un coût d'une pièce en plus.\n");
                        prixEnPlus = 1;
                    }

                    ArrayList<Quartier> copie = new ArrayList<Quartier>();
                    for (int i = 0; i < this.getPlateau().getJoueur(choix).nbQuartiersReelDansCite(); i++) {
                        if (citeJoueur[i].getCout() <= 3 && !this.getJoueur().quartierPresentDansCite(citeJoueur[i].getNom())) {
                            copie.add(citeJoueur[i]);
                        }
                    }

                    if (copie.size() == 0) {
                        System.out.println("Ce joueur n'a pas de quartier répondant aux critères de votre pouvoir");
                        repeter = true;
                    } else {
                        boolean continu = false;
                        do {
                            for (int i = 0; i < copie.size(); i++) {
                                System.out.println((i + 1) + " - " + copie.get(i).getNom() + "[ " +
                                        copie.get(i).getType() + ", " + copie.get(i).getCout() + " ]");
                            }

                            System.out.println("Veuillez choisir le quartier à prendre (0 pour ne rien faire)");
                            int choix1 = scan.lireUnEntier(1, copie.size()) - 1;

                            if (choix1 != -1) {
                                if (this.getPlateau().getJoueur(choix).getCite()[choix1].getNom().equals("Donjon")) {
                                    System.out.println("Vous ne pouvez pas choisir le Donjon");
                                    continu = true;
                                } else {
                                    System.out.println("Voulez-vous construire " +
                                            this.getPlateau().getJoueur(choix).getCite()[choix1].getNom() + " ?");
                                    Boolean choixConstruct = scan.lireOuiOuNon();

                                    if (choixConstruct) {
                                        if (this.getJoueur().nbPieces() >=
                                                this.getPlateau().getJoueur(choix).getCite()[choix1].getCout()) {
                                            this.getJoueur().ajouterQuartierDansCite(
                                                    this.getPlateau().getJoueur(choix).getCite()[choix1]);
                                            this.getJoueur().retirerPieces(
                                                    this.getPlateau().getJoueur(choix).getCite()[choix1].getCout() + prixEnPlus);
                                            this.getPlateau().getJoueur(choix).ajouterPieces(
                                                    this.getPlateau().getJoueur(choix).getCite()[choix1].getCout() + prixEnPlus);
                                            this.getPlateau().getJoueur(choix).retirerQuartierDansCite(
                                                    this.getPlateau().getJoueur(choix).getCite()[choix1].getNom());
                                            continu = false;
                                        } else {
                                            System.out.println("Votre trésor n'est pas suffisant pour construire ce quartier");
                                            continu = true;
                                        }
                                    }
                                }
                            } else {
                                continu = false;
                                repeter = false;
                            }
                        } while (continu);

                        repeter = false;
                    }
                } else {
                    repeter = false;
                }
            } catch (SelfChosen e) {
                System.out.println("Vous ne pouvez pas vous choisir.");
                repeter = true;
            } catch (CantChoose e) {
                System.out.println("Vous ne pouvez pas choisir l'Eveque.");
                repeter = true;
            }
        } while (repeter);
    }

    /**
     * Utilise le pouvoir du Capitaine pour choisir un quartier d'un autre joueur en mode Avatar.
     */
    @Override
    public void utiliserPouvoirAvatar() {
        // Implémentation de la merveille donjon
        // Implémentation de la merveille Grande Muraille
        boolean aGrandeMuraille = false;
        int prixEnPlus = 0;

        Random generateur = new Random();
        System.out.println("Vous pouvez choisir un quartier dans la cité d'un joueur avec un coût inférieur à 3");
        System.out.println("Vous pouvez l'ajouter à votre cité en payant le coût de construction à son propriétaire");
        System.out.println("Veuillez choisir le joueur dont vous voulez prendre une carte");

        boolean repeter = false;
        do {
            try {
                for (int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
                    System.out.println((i + 1) + "." + this.getPlateau().getJoueur(i).getNom() + " : " +
                            this.getPlateau().getJoueur(i).nbQuartiersReelDansCite() + " carte(s).");
                }

                int choix = ThreadLocalRandom.current().nextInt(0, this.getPlateau().getNombreJoueurs() + 1) - 1;

                if (choix != -1) {
                    if (this.getPlateau().getPersonnage(choix).nom.equals(this.nom)) {
                        throw new SelfChosen();
                    } else if (this.getPlateau().getPersonnage(choix).nom.equals("Eveque")) {
                        throw new CantChoose();
                    }

                    Quartier[] citeJoueur = this.getPlateau().getJoueur(choix).getCite();

                    for (int i = 0; i < this.getPlateau().getJoueur(choix).nbQuartiersReelDansCite(); i++) {
                        if (citeJoueur[i].getNom().equals("Grande Muraille")) {
                            aGrandeMuraille = true;
                        }
                    }

                    if (aGrandeMuraille) {
                        System.out.println("Vous avez choisi un joueur possédant la merveille Grande Muraille, " +
                                "les quartiers que vous essayerez de déplacer auront un coût d'une pièce en plus.\n");
                        prixEnPlus = 1;
                    }

                    ArrayList<Quartier> copie = new ArrayList<Quartier>();
                    for (int i = 0; i < this.getPlateau().getJoueur(choix).nbQuartiersReelDansCite(); i++) {
                        if (citeJoueur[i].getCout() <= 3 &&
                                !this.getJoueur().quartierPresentDansCite(citeJoueur[i].getNom())) {
                            copie.add(citeJoueur[i]);
                        }
                    }

                    if (copie.size() == 0) {
                        System.out.println("Ce joueur n'a pas de quartier répondant aux critères de votre pouvoir");
                        repeter = true;
                    } else {
                        boolean continu = false;
                        do {
                            for (int i = 0; i < copie.size(); i++) {
                                System.out.println((i + 1) + " - " + copie.get(i).getNom() + "[ " +
                                        copie.get(i).getType() + ", " + copie.get(i).getCout() + " ]");
                            }

                            System.out.println("Veuillez choisir le quartier à prendre (0 pour ne rien faire)");
                            int choix1 = generateur.nextInt(copie.size() + 1) - 1;

                            if (choix1 != -1) {
                                if (this.getPlateau().getJoueur(choix).getCite()[choix1].getNom().equals("Donjon")) {
                                    System.out.println("Vous ne pouvez pas choisir le Donjon");
                                    continu = true;
                                } else {
                                    System.out.println("Voulez-vous construire " +
                                            this.getPlateau().getJoueur(choix).getCite()[choix1].getNom() + " ?");
                                    Boolean choixConstruct = generateur.nextBoolean();

                                    if (choixConstruct) {
                                        if (this.getJoueur().nbPieces() >=
                                                this.getPlateau().getJoueur(choix).getCite()[choix1].getCout()) {
                                            this.getJoueur().ajouterQuartierDansCite(
                                                    this.getPlateau().getJoueur(choix).getCite()[choix1]);
                                            this.getJoueur().retirerPieces(
                                                    this.getPlateau().getJoueur(choix).getCite()[choix1].getCout() + prixEnPlus);
                                            this.getPlateau().getJoueur(choix).ajouterPieces(
                                                    this.getPlateau().getJoueur(choix).getCite()[choix1].getCout() + prixEnPlus);
                                            this.getPlateau().getJoueur(choix).retirerQuartierDansCite(
                                                    this.getPlateau().getJoueur(choix).getCite()[choix1].getNom());
                                            continu = false;
                                        } else {
                                            System.out.println("Votre trésor n'est pas suffisant pour construire ce quartier");
                                            continu = true;
                                        }
                                    }
                                }
                            } else {
                                continu = false;
                                repeter = false;
                            }
                        } while (continu);

                        repeter = false;
                    }
                } else {
                    repeter = false;
                }
            } catch (SelfChosen e) {
                System.out.println("Vous ne pouvez pas vous choisir.");
                repeter = true;
            } catch (CantChoose e) {
                System.out.println("Vous ne pouvez pas choisir l'Eveque.");
                repeter = true;
            }
        } while (repeter);
    }

    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO Auto-generated method stub
    }
}
