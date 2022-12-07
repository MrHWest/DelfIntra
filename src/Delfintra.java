package src;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Delfintra {

	public static void main(String[] args) throws IOException {
		visValgmuligheder();
	}

	public static void visValgmuligheder() {
        Scanner input = new Scanner(System.in);

        int tastTal;
        /*ArrayList<Integer> valid_answers = new ArrayList<>();
        
        for (int i=1; i<=6; i++) {
            valid_answers.add(i);
        }*/
        do {

        System.out.println("-----Hvad vil du?-----");
        System.out.println("1 - Registrer medlem");
        System.out.println("2 - Registrer Indbetalling");
        System.out.println("3 - Liste over medlemmer i restance");
        System.out.println("4 - Registrer konkurrence svoemmere's (Stævne/placering/tid)");
        System.out.println("5 - Registrer træningsresultater");
        System.out.println("6 - Se top 5 svømmere for hver disciplin");
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

                visValgmuligheder();
                break;

                //Registrer indbetalling
                case 2:
                System.out.println("Du har valgt at Registrer Indbetallinger");
                Regnskabsfunktioner.registrerIndbetaling();
                break;

                //Liste af medlemmer i restance
                case 3:
                System.out.println("Du har valgt at se en liste over medlemmer i restance");
                Regnskabsfunktioner.visRestancer();
                break;

                //Konkurrence svoemmere's resultater
                case 4:
                System.out.println("Du har valgt at Registrer konkurrence svoemmere's resultater (Stævne/placering/tid)");

                break;

                //Registrer træningsresultater
                case 5:
                System.out.println("Du har valgt at Registrer træningsresultater");

                break;

                //Se top 5 liste 
                case 6:
                System.out.println("Du har valgt at se en top 5 liste");

                break;
            } //Slut paa switch

        } while (tastTal != 0);
	}

}