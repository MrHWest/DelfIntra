package src;
import java.io.IOException;
import java.util.Scanner;

public class Delfintra {

	public static void main(String[] args) throws IOException {
		visValgmuligheder();
	}

	public static void visValgmuligheder() {
		String newLine = System.getProperty("line.separator");
        Scanner input = new Scanner(System.in);

        System.out.println("Hvad vil du?" + newLine);
        System.out.println("1 - Registrer Aktivitetsform" + newLine + "2 - Registrer Stamoplysninger" + newLine + "3 - Registrer Indbetalling");
        System.out.println("4 - Liste over medlemmer i restance" + newLine + "5 - Registrer konkurrence svoemmere's (Stævne/placering/tid)");
        System.out.println("6 - Registrer træningsresultater" + newLine + "7 - Top 5 svømmere for hver disciplin" + newLine);

        int tastTal = input.nextInt();
        if(tastTal > 7 || tastTal < 1){System.out.println("Venligst indtast et gyldigt tal");}
          
        switch(tastTal){
            //Registrer Aktivitetsform
            case 1:
            System.out.println("Du har valgt at Registrer Aktivitesform");
            //indtast kode her  
            break;

            //Registrer Stamoplysninger
            case 2:
            System.out.println("Du har valgt at Registrer Stamoplysninger");

            break;

            //Registrer indbetalling
            case 3:
            System.out.println("Du har valgt at Registrer Indbetallinger");

            break;

            //Liste af medlemmer i restance
            case 4:
            System.out.println("Du har valgt at se en liste over medlemmer i restance");

            break;

            //Konkurrence svoemmere's resultater
            case 5:
            System.out.println("Du har valgt at Registrer konkurrence svoemmere's resultater (Stævne/placering/tid)");

            break;

            //Registrer træningsresultater
            case 6:
            System.out.println("Du har valgt at Registrer træningsresultater");

            break;

            //top 5 liste 
            case 7:
            System.out.println("Du har valgt at se en top 5 liste");

            break;

        }//Slut paa switch
	}

}