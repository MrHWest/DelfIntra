package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Delfintra {

	public static void main(String[] args) throws Exception {
		visValgmuligheder();
	}

	public static void visValgmuligheder() throws Exception {
        Scanner input = new Scanner(System.in);

        int tastTal = -1;
        /*ArrayList<Integer> valid_answers = new ArrayList<>();
        
        for (int i=1; i<=6; i++) {
            valid_answers.add(i);
        }*/
        do {

        try {
        System.out.println();
        System.out.println("-----Hvad vil du?-----");
        System.out.println("1 - Registrer medlem");
        System.out.println("2 - Registrer Indbetalling");
        System.out.println("3 - Se liste over medlemmer i restance");
        System.out.println("4 - Registrer konkurrencessvoemmere's resultater (Stævne/placering/tid)");
        System.out.println("5 - Registrer traeningsresultater");
        System.out.println("6 - Se top 5 svoemmere for hver disciplin");
        System.out.println("7 - Print medlem liste");
        System.out.println("Tryk 0 for at lukke programmet");

            tastTal = input.nextInt();
            
            if(tastTal > 7 || tastTal < 0){
                System.out.println("Venligst indtast et gyldigt tal");
            }

            switch(tastTal){
                //Registrer medlem
                case 1:
                System.out.println("Du har valgt at registrer et medlem");
                FormandFunktioner.registrerMedlem();
                break;

                //Registrer indbetalling
                case 2:
                System.out.println("Du har valgt at Registrer Indbetallinger");
                Regnskabsfunktioner.indlaesData();
                Regnskabsfunktioner.registrerIndbetaling();
                break;

                //Liste af medlemmer i restance
                case 3:
                System.out.println("Du har valgt at se en liste over medlemmer i restance");
                Regnskabsfunktioner.indlaesData();
                Regnskabsfunktioner.visRestancer();
                break;

                //Konkurrence svoemmere's resultater
                case 4:
                System.out.println("Du har valgt at Registrer konkurrencessvoemmere's resultater (Stævne/placering/tid)");
                KonkurrenceFunktioner.registrerTraening();
                break;

                //Registrer træningsresultater
                case 5:
                System.out.println("Du har valgt at Registrer træningsresultater");

                break;

                //Se top 5 liste 
                case 6:
                System.out.println("Du har valgt at se en top 5 liste");

                break;

                case 7:
                System.out.println("Du har valgt at se medlemslisten");
                Medlem.printMedlemListe();
                break;
            } //Slut paa switch
        } catch(InputMismatchException e) {
            System.out.println("Du har indtastet forkert slags input. Prøv igen.");
            input.next();
        }
        } while (tastTal != 0);
        System.out.println("Programmet lukker nu");
	}

}