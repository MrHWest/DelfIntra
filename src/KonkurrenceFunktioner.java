package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class KonkurrenceFunktioner {

	static Scanner scan = new Scanner(System.in);

	public static void indlaesData() throws FileNotFoundException {
		Medlem.IndlaesMedlemmer();
		Resultat.indlaesResultater();
	}

	public static void visValgmuligheder() {
		// TODO - implement KonkurrenceFunktioner.visValgmuligheder
		throw new UnsupportedOperationException();
	}


	public static void registrerTraening() throws IOException {
		System.out.print("\nMedlemsliste:\n\n");
		Medlem.printMedlemListe();
		
		int id = -1;
		boolean validInput = true;
		do {
			try {
				validInput = true;
				System.out.println("Hvilket medlem vil du registrere en tid for? Indtast vedkommendes ID:");
				id = scan.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Inputtet skal være et heltal!");
				scan.next();
				validInput = false;
			}
		} while(!validInput);

		System.out.println("Hvilken disciplin?");
		String disciplin = scan.next();
		int tid = -1;
		do {
			System.out.println("Hvor mange hele sekunder?");
			try {
				validInput = true;
				tid = scan.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Inputtet skal være et heltal!");
				scan.next();
				validInput = false;
			}
		} while(!validInput);

		LocalDate resDato = LocalDate.of(1900, 01, 01);
		do {
			System.out.println("Indtast dato for resultatet (dd-mm-yyyy)");
			String dato = scan.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			try {
				validInput = true;
				resDato = LocalDate.parse(dato, formatter);
			} catch(DateTimeParseException e) {
				System.out.println("Ugyldig dato!");
				validInput = false;
			}
		} while(!validInput);

		Traeningsresultat nytResultat = new Traeningsresultat(disciplin, tid, id, resDato);
		Resultat.resultatListe.add(nytResultat);
		Resultat.gemResultater();
		System.out.print("\n\nResultatet er gemt.\n\n");
	}

	public static void registrerKonkurrenceResultat() throws InputMismatchException, IOException {
		System.out.print("\nMedlemsliste:\n\n");
		Medlem.printMedlemListe();
		
		int id = -1;
		boolean validInput = true;
		do {
			try {
				validInput = true;
				System.out.println("Hvilket medlem vil du registrere en tid for? Indtast vedkommendes ID:");
				id = scan.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Inputtet skal være et heltal!");
				scan.next();
				validInput = false;
			}
		} while(!validInput);

		System.out.println("Hvilken disciplin?");
		String disciplin = scan.next();
		int tid = -1;
		do {
			System.out.println("Hvor mange hele sekunder?");
			try {
				validInput = true;
				tid = scan.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Inputtet skal være et heltal!");
				scan.next();
				validInput = false;
			}
		} while(!validInput);

		// Følgende kommenteret ud indtil implementeringen af StaevneResultat er færdig
		//
		// System.out.println("Navn på staevnet?");
		// String staevnenavn = scan.nextLine();
		// System.out.println("Hvilken plads fik svoemmeren?");
		// int placering = scan.nextInt();

		//StaevneResultat nytResultat = new StaevneResultat(disciplin, tid, id, staevnenavn, placering);

		Resultat nytResultat = new Resultat(disciplin, tid, id);
		Resultat.resultatListe.add(nytResultat);
		Resultat.gemResultater();
		System.out.print("\n\nResultatet er gemt.\n\n");


	}

	public static void visTop5() {
		// TODO - implement KonkurrenceFunktioner.visTop5
		throw new UnsupportedOperationException();
	}

}