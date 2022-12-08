package src;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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


	public static void registrerTraening() {
		System.out.println("Hvilket medlem vil du registrere en tid for?");
		int id = Medlem.findMedlem();
		System.out.println("Hvilken disciplin?");
		String disciplin = scan.nextLine();
		System.out.println("Hvor mange hele sekunder?");
		int tid = scan.nextInt();
		System.out.println("Indtast dato for resultatet (dd-mm-yyyy)");
		String dato = scan.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate resDato = LocalDate.parse(dato, formatter);

		Traeningsresultat nytResultat = new Traeningsresultat(disciplin, tid, id, resDato);
		Resultat.resultatListe.add(nytResultat);
	}

	public static void registrerKonkurrenceResultat() throws InputMismatchException {
		System.out.println("Hvilket medlem vil du registrere en tid for?");
		int id = Medlem.findMedlem();
		System.out.println("Hvilken disciplin?");
		String disciplin = scan.nextLine();
		System.out.println("Hvor mange hele sekunder?");
		int tid = scan.nextInt();
		System.out.println("Navn på staevnet?");
		String staevnenavn = scan.nextLine();
		System.out.println("Hvilken plads fik svoemmeren?");
		int placering = scan.nextInt();

		StaevneResultat nytResultat = new StaevneResultat(disciplin, tid, id, staevnenavn, placering);
		Resultat.resultatListe.add(nytResultat);


	}

	public static void visTop5() {
		// TODO - implement KonkurrenceFunktioner.visTop5
		throw new UnsupportedOperationException();
	}

}