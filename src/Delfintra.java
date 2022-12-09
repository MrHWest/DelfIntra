package src;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Delfintra {

	public static void main(String[] args) throws Exception {
        try {
            visValgmuligheder();
        } catch(Exception e) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
            String currentTime = LocalDateTime.now().format(dtf);
            String fileName = "fejl_log_"+ currentTime + ".txt";
            System.out.print("\n\nDer opstod en fejl.\nSe '"+ fileName + "' for mere info.\n\nProgrammet lukker nu.");

            // Print error to log
            File f = new File(fileName);
            FileOutputStream fs = new FileOutputStream(f);
            PrintStream ps = new PrintStream(fs);
            e.printStackTrace(ps);
            fs.close();
            ps.close();

        }
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
        System.out.println("4 - Registrer konkurrencessvoemmere's resultater (Staevne/placering/tid)");
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
                System.out.println("Du har valgt at registrere et medlem");
                FormandFunktioner.indlaesData();
                FormandFunktioner.registrerMedlem();
                break;

                //Registrer indbetalling
                case 2:
                System.out.println("Du har valgt at Registrere en indbetaling");
                Regnskabsfunktioner.indlaesData();
                Regnskabsfunktioner.registrerIndbetaling();
                Regnskabsfunktioner.gemData();
                break;

                //Liste af medlemmer i restance
                case 3:
                System.out.println("Du har valgt at se en liste over medlemmer i restance");
                Regnskabsfunktioner.indlaesData();
                Regnskabsfunktioner.visRestancer();

                break;

                //Konkurrence svoemmere's resultater
                case 4:

                System.out.println("Du har valgt at registrere et konkurrenceresultat");
                System.out.println();
                KonkurrenceFunktioner.indlaesData();
                KonkurrenceFunktioner.registrerKonkurrenceResultat();
                KonkurrenceFunktioner.gemData();

                break;


                //Registrer træningsresultater
                case 5:

                System.out.println("Du har valgt at registrere et træningsresultat");
                System.out.println();
                KonkurrenceFunktioner.indlaesData();

                KonkurrenceFunktioner.registrerTraening();
                KonkurrenceFunktioner.gemData();

                break;

                //Se top 5 liste 
                case 6:
                System.out.println("Du har valgt at se en top 5 liste");
                KonkurrenceFunktioner.indlaesData();
                KonkurrenceFunktioner.visTop5();


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