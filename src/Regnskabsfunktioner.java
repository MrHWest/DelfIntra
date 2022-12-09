package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Regnskabsfunktioner {

	static Scanner scan = new Scanner(System.in);

	public static void indlaesData() throws FileNotFoundException {
		Medlem.IndlaesMedlemmer();
		Kontingent.indlaesKontingenter();
	}

	public static void visValgmuligheder() {
		// TODO - implement Regnskabsfunktioner.visValgmuligheder
		throw new UnsupportedOperationException();
	}

	//Finder et medlem, finder dette medlems kontingent og opdaterer seneste betalingsdato til dags dato
	public static void registrerIndbetaling() throws FileNotFoundException {
		System.out.print("\nMedlemsliste:\n\n");
		Medlem.printMedlemListe();
		boolean betalingRegistreret = false;
		do {
			System.out.println("Indtast navn på det medlem du vil registrere en indbetaling for:");
			String navn = scan.nextLine();
			for (Medlem m: Medlem.MedlemListe)
			{
				if (navn.equals(m.getNavn()))
				{
					m.hentKontingent().setBetalingsdato(LocalDate.now());
					System.out.print("\nBetaling registreret.\n");
					betalingRegistreret = true;
					break;
				}

				// Hvis vi når hertil, er intet medlem blevet fundet.
				System.out.println("Medlem blev ikke fundet. Prøv igen.");
			}
	} while(!betalingRegistreret);
	}

	public static void visRestancer() {

		for (Medlem m: Medlem.MedlemListe)
		{
			Kontingent kontingent = m.hentKontingent();
			long aar = ChronoUnit.YEARS.between(kontingent.getBetalingsDato(), LocalDate.now());
			if ( aar >= 1)
			{
				double gaeld = kontingent.getPris()*aar;
				System.out.println(m.getNavn()+" skylder "+gaeld+" kr.");
			}
		}


	}

	public static void gemData() throws IOException {
		Medlem.gemMedlemsdata();
		Kontingent.gemKontingentData();
	}

}