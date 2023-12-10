package Controleur;

import java.util.InputMismatchException;
import java.util.Scanner;

import Exception.NulleString;
import Exception.OutOufBounds;
import Exception.WrongInput;

public class Interaction {
	private static Scanner sc = new Scanner(System.in);

	public static int lireUnEntier() {
		int i = 0;
		boolean continu = true;
		do {
			try {
				i = sc.nextInt();
				continu = false;
			} catch (InputMismatchException e) {
				System.out.print("Veuillez rentrer un entier : ");
				sc.next(); // passe l'entier pour éviter de boucler
			}
		} while(continu);
		return i;
	}

	// renvoie un entier lu au clavier compris dans l'intervalle
	//     [borneMin, borneMax[
	public static int lireUnEntier(int borneMin, int borneMax) {
		int i = 0;
		boolean continu = true;
		do {
			try {
				i = sc.nextInt();
				if(i< borneMin || i>borneMax){
					throw new OutOufBounds();
				}
				continu = false;
			} catch (InputMismatchException e) {
				System.out.print("Veuillez rentrer un entier : ");
				sc.next();
			} catch (OutOufBounds e){
				System.out.println("Veuillez rentrer un entier compris entre " + borneMin + " et " + borneMax);
			}
		} while(continu);
		return i;
	}

	// lit les réponses "oui", "non", "o" ou "n" et renvoie un bool en
	public static boolean lireOuiOuNon() {
		boolean retour = true;
		boolean continu = true;
		String i;
		do {
			try {
				i = sc.nextLine();
				if(!i.equals("o") && !i.equals("oui") && !i.equals("non") && !i.equals("n")){
					throw new WrongInput();
				}else if(i.equals("o") || i.equals("oui")){
					retour = true;
				}else{
					retour = false;
				}
				continu = false;
			} catch (WrongInput e) {
				System.out.print("Veuillez rentrer (o)ui ou (n)on : ");
			}
		} while(continu);
		System.out.println(retour);
		return retour;
	}

	// renvoie une chaîne de caractère lue au clavier:
	public static String lireUneChaine() {
		String retour = "";
		boolean reponse = false;
		boolean continu = true;
		do {
			try {
				retour = sc.nextLine();
				if(retour.equals("")){
					throw new NulleString();
				}
				continu = false;
			} catch (InputMismatchException e) {
				if(!reponse){
					System.out.print("Veuillez rentrer un mot : ");
					reponse = true;
				}
			}catch (NulleString e){
				System.out.println("Les entrées vides ne sont pas valables, veuillez rentrer un mot : ");
			}
		} while(continu);
		return retour;
	}


	
}