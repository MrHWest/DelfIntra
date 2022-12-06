package src;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormandFunktioner {

	public static void indlaesData() {
		// TODO - implement FormandFunktioner.indlaesData
		throw new UnsupportedOperationException();
	}

	public static void registrerMedlem() {

		/*indlaes medlemmer*/
		boolean nytMedlem = false;

        do{
		Scanner input = new Scanner(System.in);

		// lav funktionen hvor man skal vælge imellem konkurrence svoemmer og normal svoemmer
			
			//Indtast navn på personen
			System.out.println("Indtast navn");
			String navn = input.nextLine();

			//Indlaes dato og cast til LocalDate
			System.out.println("Indast foedselsdato");
			String input_dato = input.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate foedselsdato = LocalDate.parse(input_dato, formatter);

			System.out.println("Har personen et aktivt medlemskab?");
			String aktivt = input.next();
			if(aktivt.toLowerCase().equals("ja")){
				boolean aktiv = true;
			}
			else if(aktivt.toLowerCase().equals("nej")){
				boolean aktiv = false;
			}
			else{System.out.println("!Ugyldigt svar!");}

			//konkurence svømmer
			System.out.println("Er det en konkurence svoemmer?");
			String aktivitetsform;
			String ja_nej = input.nextLine();
			if(ja_nej.toLowerCase().equals("ja")){
				aktivitetsform = input.nextLine();
			} else if(ja_nej.toLowerCase().equals("nej")){
				aktivitetsform = "ikke deltagene";
			}

			System.out.println("Er disse oplysninger korrekte? \nNavn: " + navn + " | Fødselsdag: " + foedselsdato +  " | Aktiv: " + aktivt + " | Diciplin: " + aktivitetsform );
			String korrekt = input.next();
			if(korrekt.toLowerCase().equals("ja")){
				/*gem medlemsdata til en arraylist */
				nytMedlem = true; 
			}else if(korrekt.toLowerCase().equals("nej")){
				System.out.println("Indtast oplysnigerne igen");
			}
		} while (nytMedlem == false);
		


	}

}