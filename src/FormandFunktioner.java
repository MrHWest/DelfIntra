package src;
import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FormandFunktioner {

	public static void indlaesData() {
		
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
			String aktivt = input.nextLine();
			if(aktivt.equalsIgnoreCase("ja")){
				aktiv = true;
			}
			else if(aktivt.equalsIgnoreCase("nej")){
				aktiv = false;
			}
			else{
				aktiv = false;
				System.out.println("!Ugyldigt svar!");
			}

			//konkurrencesvømmer
			System.out.println("Er det en konkurrencesvoemmer? (J/N)");
			String j_n = input.nextLine();
			String type = "";
			if (j_n.equalsIgnoreCase("j")) {type = "Konkurrencesvoemmer";}
			if (j_n.equalsIgnoreCase("n")) {type = "Motionist";}
			

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


				System.out.println("Er disse oplysninger korrekte? (Ja/Nej)");
				System.out.println("Navn: " + navn + " | Fødselsdag: " + foedselsdato +  " | Aktiv: " + aktivt + " | Type: "+type );
				System.out.println("____________________________________________________________________________");
				String korrekt = input.nextLine();

					if(korrekt.equalsIgnoreCase("ja")){
						Konkurrencesvoemmer nyKonkurrencesvoemmer = new Konkurrencesvoemmer(Medlem.MedlemListe.size()+1, navn, foedselsdato, aktiv);
						Medlem.MedlemListe.add(nyKonkurrencesvoemmer);
						Kontingent nytKontingent = new Kontingent(nyKonkurrencesvoemmer);
						Kontingent.kontingentListe.add(nytKontingent);

						// Gem oplysninger til fil
						Medlem.gemMedlemsdata();
						Kontingent.gemKontingentData();

						System.out.println("-----Oplyningerne er gemt-----");
						nytMedlem = true;

						}else if(korrekt.equalsIgnoreCase("nej")){
							System.out.println("Indtast oplysnigerne igen");
						} else if(j_n.equalsIgnoreCase("nej")){

							type = "Motionist";

							System.out.println("Er disse oplysninger korrekte? (Ja/Nej)");
						System.out.println("Navn: " + navn + " | Fødselsdag: " + foedselsdato +  " | Aktiv: " + aktivt + " | Type: " +type );
						System.out.println("____________________________________________________________________________");
						String correkt = input.nextLine();
						if(correkt.equalsIgnoreCase("ja")){
							Medlem nyMedlem = new Medlem(Medlem.MedlemListe.size()+1, navn, foedselsdato, aktiv);
							Medlem.MedlemListe.add(nyMedlem);
							Kontingent nytKontingent = new Kontingent(nyMedlem);
							Kontingent.kontingentListe.add(nytKontingent);

							// Gem oplysninger til fil
							Medlem.gemMedlemsdata();
							Kontingent.gemKontingentData();

							System.out.println("-----Oplyningerne er gemt-----");
							nytMedlem = true;
						}else if(correkt.equalsIgnoreCase("nej")){
							System.out.println("Indtast oplysnigerne igen");
					}
				}
			
			} while (!nytMedlem);
		}
	}

