package src;
import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FormandFunktioner {

	public static void indlaesData() {
		// TODO - implement FormandFunktioner.indlaesData
		throw new UnsupportedOperationException();
	}

	public static void registrerMedlem() throws IOException {

		/*indlaes medlemmer*/
		boolean nytMedlem = false;
		Scanner input = new Scanner(System.in);

        do{
			
			//Indtast navn på personen
			System.out.println("Indtast navn");
			String navn = input.nextLine();

			//Indlaes dato og cast til LocalDate
			boolean correctDateFormat = true;
			LocalDate foedselsdato = LocalDate.of(1900, 01, 01);
			do {
			System.out.println("Indtast foedselsdato (dd-mm-yyyy)");
			String input_dato = input.nextLine();
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				foedselsdato = LocalDate.parse(input_dato, formatter);
				correctDateFormat = true;
			} catch(DateTimeParseException e) {
				System.out.println("Ugyldig dato. Prøv igen");
				correctDateFormat = false;
			}
		} while(!correctDateFormat);

			System.out.println("Har personen et aktivt medlemskab? (Ja/Nej)");
			boolean aktiv;
			String aktivt = input.nextLine();
			if(aktivt.toLowerCase().equals("ja")){
				aktiv = true;
			}
			else if(aktivt.toLowerCase().equals("nej")){
				aktiv = false;
			}
			else{
				aktiv = false;
				System.out.println("!Ugyldigt svar!");
			}

			//konkurence svømmer
			System.out.println("Er det en konkurence svoemmer? (Ja/Nej)");
			String aktivitetsform = "";
			String ja_nej = input.nextLine();
			if(ja_nej.toLowerCase().equals("ja")){
				System.out.println("Indtast diciplin");
				aktivitetsform = input.nextLine();
			} else if(ja_nej.toLowerCase().equals("nej")){
				aktivitetsform = "ikke deltagene";
			}
			

			System.out.println("Er disse oplysninger korrekte? (Ja/Nej)");
			System.out.println("Navn: " + navn + " | Fødselsdag: " + foedselsdato +  " | Aktiv: " + aktivt + " | Diciplin: " + aktivitetsform );
			System.out.println("____________________________________________________________________________");
			String korrekt = input.nextLine();
			if(korrekt.toLowerCase().equals("ja")){
				Medlem nyMedlem = new Medlem(Medlem.MedlemListe.size()+1, navn, foedselsdato, aktiv);
				Medlem.MedlemListe.add(nyMedlem);
				Kontingent nytKontingent = new Kontingent(nyMedlem);
				Kontingent.kontingentListe.add(nytKontingent);

				// Gem oplysninger til fil
				Medlem.gemMedlemsdata();
				Kontingent.gemKontingentData();

				System.out.println("-----Oplyningerne er gemt-----");
				nytMedlem = true;
			}else if(korrekt.toLowerCase().equals("nej")){
				System.out.println("Indtast oplysnigerne igen");
			}
		} while (nytMedlem == false);

	}

}