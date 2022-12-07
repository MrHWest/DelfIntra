package src;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormandFunktioner {

	public static void indlaesData() {
		throw new UnsupportedOperationException();
	}

	public static void registrerMedlem() {

		/*indlaes medlemmer*/
		boolean nytMedlem = false;
		Scanner input = new Scanner(System.in);

        do{
			
			//Indtast navn på personen
			System.out.println("Indtast navn");
			String navn = input.nextLine();

			//Indlaes dato og cast til LocalDate
			System.out.println("Indast foedselsdato (dd-mm-yyyy)");
			String input_dato = input.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate foedselsdato = LocalDate.parse(input_dato, formatter);

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

			
			System.out.println("Er det en konkurence svoemmer? (Ja/Nej)");
			String diciplin = "";
			String ja_nej = input.nextLine();

			if(ja_nej.toLowerCase().equals("ja")){
				//opretter en konkurrencesvoemmer

				System.out.println("Indtast diciplin");
				diciplin = input.nextLine();

				System.out.println("Er disse oplysninger korrekte? (Ja/Nej)");
				System.out.println("Navn: " + navn + " | Fødselsdag: " + foedselsdato +  " | Aktiv: " + aktivt + " | Diciplin: " + diciplin /*+ " | aktivitetsform: " + aktivitetsform */);
				System.out.println("____________________________________________________________________________");
				String korrekt = input.nextLine();

					if(korrekt.toLowerCase().equals("ja")){
						// Konkurrencesvoemmer nyMedlem = new Medlem(Konkurrencesvoemmer.MedlemListe.size()+1, navn, foedselsdato, aktiv, diciplin, aktivitetsform);
						// Konkurrencesvoemmer.MedlemListe.add(nyMedlem);
						System.out.println("-----Oplyningerne er gemt-----");
						nytMedlem = true;
					}else if(korrekt.toLowerCase().equals("nej")){
						System.out.println("Indtast oplysnigerne igen");
						break;
					}

				} else if(ja_nej.toLowerCase().equals("nej")){
					diciplin = "ikke deltagene";

				//opretter et nyt medlem
				System.out.println("Er disse oplysninger korrekte? (Ja/Nej)");
				System.out.println("Navn: " + navn + " | Fødselsdag: " + foedselsdato +  " | Aktiv: " + aktivt + " | Diciplin: " + diciplin /*+ " | aktivitetsform: " + aktivitetsform */);
				System.out.println("____________________________________________________________________________");
				String korrekt = input.nextLine();

				
				if(korrekt.toLowerCase().equals("ja")){
					//gemmer oplysninger til <ArrayList>
					Medlem nyMedlem = new Medlem(Medlem.MedlemListe.size()+1, navn, foedselsdato, aktiv/*, aktivitetsform */);
					Medlem.MedlemListe.add(nyMedlem);
					System.out.println("-----Oplyningerne er gemt-----");
					nytMedlem = true;

				}else if(korrekt.toLowerCase().equals("nej")){
					System.out.println("Indtast oplysnigerne igen");
				}
			}
			
		} while (nytMedlem == false);
		
	}

}