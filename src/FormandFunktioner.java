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
			boolean validInput = true;
			LocalDate foedselsdato = LocalDate.of(1900, 01, 01);
			do {
			System.out.println("Indtast foedselsdato (dd-mm-yyyy)");
			String input_dato = input.nextLine();
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				foedselsdato = LocalDate.parse(input_dato, formatter);
				validInput = true;
			} catch(DateTimeParseException e) {
				System.out.println("Ugyldig dato. Prøv igen");
				validInput = false;
			}
		} while(!validInput);

			boolean aktiv;
			String aktivt = "";
			do {
				System.out.println("Har personen et aktivt medlemskab? (Ja/Nej)");
				aktivt = input.nextLine();
				if(aktivt.toLowerCase().equals("ja")){
					aktiv = true;
					validInput = true;
				}
				else if(aktivt.toLowerCase().equals("nej")){
					aktiv = false;
					validInput = true;
				}
				else{
					aktiv = false;
					System.out.println("!Ugyldigt svar!");
					validInput = false;
				}
		} while (!validInput);

			//konkurence svømmer
			String aktivitetsform = "";
			do {
			System.out.println("Er det en konkurence svoemmer? (Ja/Nej)");
			aktivitetsform = "";
			String ja_nej = input.nextLine();
			if(ja_nej.toLowerCase().equals("ja")){
				validInput = true;
				System.out.println("Indtast diciplin");
				aktivitetsform = input.nextLine();
			} else if(ja_nej.toLowerCase().equals("nej")){
				aktivitetsform = "ikke deltagene";
				validInput = true;
			}
			else {
				System.out.println("Ugyldigt input!");
				validInput = false;
			}
		} while(!validInput);
			

		 do {
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
				validInput = true;
			}else if(korrekt.toLowerCase().equals("nej")){
				System.out.println("Indtast oplysnigerne igen");
				validInput = true;
		 }
		 else {
			System.out.println("Ugyldigt input!");
			validInput = false;
		 }
		} while (!validInput);
		} while (nytMedlem == false);

	}

}