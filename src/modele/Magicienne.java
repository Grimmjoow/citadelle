package modele;

import Controleur.Interaction;

import java.util.ArrayList;
import java.util.Random;

public class Magicienne extends Personnage {
    
    // Constructeur de la classe Magicienne
    public Magicienne() {
        super("Magicienne", 3, Caracteristiques.MAGICIENNE);
    }

    @Override
    public void utiliserPouvoir() {
        if (this.getJoueur() != null && !this.getAssassine()) {
            boolean continu1 = true;
            do {
                System.out.println("Voulez-vous échanger vos cartes avec celles d'un autre joueur ? (oui / o / non / n)");
                boolean oui = Interaction.lireOuiOuNon();
                boolean continu2 = true;

                if (oui) {
                    ArrayList<Quartier> copieTableauMagicienne = new ArrayList<>(this.getJoueur().getMain());
                    System.out.println("Avec quel joueur souhaitez-vous échanger vos cartes ?");
                    
                    for (int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
                        System.out.println((i + 1) + ". " + this.getPlateau().getJoueur(i).getNom()
                                + "(" + this.getPlateau().getJoueur(i).nbQuartiersReelDansMain() + " cartes).");
                    }

                    do {
                        System.out.print("Votre choix: ");
                        int choix = Interaction.lireUnEntier(1, this.getPlateau().getNombreJoueurs());

                        if (this.getPlateau().getJoueur(choix - 1).equals(this.getJoueur())) {
                            System.out.println("Vous ne pouvez pas vous choisir.");
                        } else {
                            ArrayList<Quartier> copieTableauVole =
                                    new ArrayList<>(this.getPlateau().getJoueur(choix - 1).getMain());
                            this.getJoueur().getMain().clear();
                            this.getPlateau().getJoueur(choix - 1).getMain().clear();
                            this.getJoueur().getMain().addAll(copieTableauVole);
                            this.getPlateau().getJoueur(choix - 1).getMain().addAll(copieTableauMagicienne);
                            continu2 = false;
                            continu1 = false;
                        }
                    } while (continu2);
                } else if (this.getJoueur().nbQuartiersReelDansMain() == 0) {
                    System.out.println("Vous n'avez pas de carte à échanger avec la pioche.");
                } else {
                    System.out.println("Combien de cartes voulez-vous remplacer ?");
                    int nb = Interaction.lireUnEntier(0, this.getJoueur().nbQuartiersReelDansMain());

                    if (nb == this.getJoueur().nbQuartiersReelDansMain()) {
                        int nbCarte = this.getJoueur().nbQuartiersReelDansMain();
                        ArrayList<Quartier> copieTableauMagicienne =
                                new ArrayList<>(this.getJoueur().getMain());

                        for (int i = nbCarte - 1; i >= 0; i--) {
                            this.getPlateau().getPioche().ajouter(copieTableauMagicienne.get(i));
                        }

                        this.getJoueur().getMain().clear();

                        for (int i = 0; i < nbCarte; i++) {
                            this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
                        }

                        continu1 = false;
                    } else if (nb != 0) {
                        ArrayList<Quartier> copieTableauMagicienne =
                                new ArrayList<>(this.getJoueur().getMain());

                        for (int i = 0; i < nb; i++) {
                            System.out.println("Cartes restantes dans la main :");
                            for (int j = 0; j < this.getJoueur().nbQuartiersReelDansMain(); j++) {
                                System.out.println((j + 1) + ". " + copieTableauMagicienne.get(j).getNom());
                            }

                            System.out.println("Sélectionner une carte à échanger : ");
                            int numCarte = Interaction.lireUnEntier(1, copieTableauMagicienne.size());
                            this.getPlateau().getPioche().ajouter(copieTableauMagicienne.get(numCarte - 1));
                            copieTableauMagicienne.remove(numCarte - 1);
                        }

                        for (int i = 0; i < nb; i++) {
                            copieTableauMagicienne.add(this.getPlateau().getPioche().piocher());
                        }

                        this.getJoueur().getMain().clear();
                        this.getJoueur().getMain().addAll(copieTableauMagicienne);
                        continu1 = false;
                    } else {
                        continu1 = false;
                    }
                }
            } while (continu1);
        } else if (this.getJoueur() == null) {
            System.out.println("Aucun joueur n'est attribué au personnage.");
        } else {
            System.out.println("Le personnage est assassiné.");
        }
    }

    @Override
    public void utiliserPouvoirAvatar() {
        if (this.getJoueur() != null && !this.getAssassine()) {
            boolean continu1 = true;
            do {
                System.out.println("Voulez-vous échanger vos cartes avec celles d'un autre joueur ? 0: oui 1: non");
                Random random = new Random();
                int oui = random.nextInt(2);

                System.out.println("Choix joueur: " + oui);
                boolean continu2 = true;

                if (oui == 0) {
                    ArrayList<Quartier> copieTableauMagicienne = new ArrayList<>(this.getJoueur().getMain());
                    System.out.println("Avec quel joueur souhaitez-vous échanger vos cartes ?");

                    for (int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
                        System.out.println((i + 1) + ". " + this.getPlateau().getJoueur(i).getNom());
                    }

                    do {
                        int choix = random.nextInt(this.getPlateau().getNombreJoueurs() + 1);
                        System.out.println("choix: " + choix);

                        if (this.getPlateau().getJoueur(choix - 1).equals(this.getJoueur())) {
                            System.out.println("Vous ne pouvez pas vous choisir.");
                        } else {
                            ArrayList<Quartier> copieTableauVole =
                                    new ArrayList<>(this.getPlateau().getJoueur(choix - 1).getMain());
                            this.getJoueur().getMain().clear();
                            this.getPlateau().getJoueur(choix - 1).getMain().clear();
                            this.getJoueur().getMain().addAll(copieTableauVole);
                            this.getPlateau().getJoueur(choix - 1).getMain().addAll(copieTableauMagicienne);
                            continu2 = false;
                            continu1 = false;
                        }
                    } while (continu2);
                } else if (this.getJoueur().nbQuartiersReelDansMain() == 0) {
                    System.out.println("Vous n'avez pas de carte à échanger avec la pioche.");
                } else {
                    System.out.println("Combien de cartes voulez-vous remplacer ?");
                    int nb = random.nextInt(this.getJoueur().nbQuartiersReelDansMain() + 1);
                    System.out.println("Nombre de cartes : " + nb);

                    if (nb == this.getJoueur().nbQuartiersReelDansMain()) {
                        int nbCarte = this.getJoueur().nbQuartiersReelDansMain();
                        ArrayList<Quartier> copieTableauMagicienne =
                                new ArrayList<>(this.getJoueur().getMain());

                        for (int i = nbCarte - 1; i >= 0; i--) {
                            this.getPlateau().getPioche().ajouter(copieTableauMagicienne.get(i));
                        }

                        this.getJoueur().getMain().clear();

                        for (int i = 0; i < nbCarte; i++) {
                            this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
                        }

                        continu1 = false;
                    } else if (nb != 0) {
                        ArrayList<Quartier> copieTableauMagicienne =
                                new ArrayList<>(this.getJoueur().getMain());

                        System.out.println("Cartes restantes dans la main :");
                        for (int j = 0; j < this.getJoueur().nbQuartiersReelDansMain(); j++) {
                            System.out.println((j + 1) + ". " + copieTableauMagicienne.get(j).getNom());
                        }

                        for (int i = 0; i < nb; i++) {
                            System.out.println("Sélectionner une carte à échanger : ");
                            int numCarte = random.nextInt(copieTableauMagicienne.size());
                            System.out.println(numCarte);
                            this.getPlateau().getPioche().ajouter(copieTableauMagicienne.get(numCarte));
                            copieTableauMagicienne.remove(numCarte);
                        }

                        for (int i = 0; i < nb; i++) {
                            copieTableauMagicienne.add(this.getPlateau().getPioche().piocher());
                        }

                        this.getJoueur().getMain().clear();
                        this.getJoueur().getMain().addAll(copieTableauMagicienne);
                        continu1 = false;
                    } else {
                        continu1 = false;
                    }
                }
            } while (continu1);
        } else if (this.getJoueur() == null) {
            System.out.println("Aucun joueur n'est attribué au personnage.");
        } else {
            System.out.println("Le personnage est assassiné.");
        }
    }

    @Override
    public void activationPouvoirSorciere(Joueur joueurSorciere) {
        // TODO: Implémenter la méthode pour l'activation du pouvoir de
