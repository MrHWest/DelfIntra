package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
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
		if (Medlem.MedlemListe.get(id) instanceof Konkurrencesvoemmer) ((Konkurrencesvoemmer) Medlem.MedlemListe.get(id)).ekstraDisciplin(disciplin);
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

		if (Medlem.MedlemListe.get(id) instanceof Konkurrencesvoemmer) ((Konkurrencesvoemmer) Medlem.MedlemListe.get(id)).ekstraDisciplin(disciplin);


	}

	public static void visTop5() {
		//hvilken disciplin skal vi finde resultater for:
		System.out.println("Indtast disciplin du vil se top 5 over");
		String dis = scan.nextLine();
		//lav liste over resultater inden for den disciplin:
		ArrayList<Resultat> resListe = new ArrayList<>();
		for (Resultat r: Resultat.resultatListe)
		{
			if (r.getDisciplin().equalsIgnoreCase(dis)){
				resListe.add(r);
			}
		}
		//sorter resListe med compareTo efter tid, laveste foerst:
		Collections.sort(resListe);

		//opret lister til top 5 hhv. junior og senior:
		ArrayList<Medlem> juniorTopFem = new ArrayList<Medlem>();
		ArrayList<Medlem> seniorTopFem = new ArrayList<Medlem>();

		//find og fordel svoemmere fra resultatlisten
		for (Resultat r: resListe)
		{
			//find medlem og tjek for duplikat
			Medlem m = Medlem.MedlemListe.get(r.getMedlemId());
			if (m.getAktivitetsform().equals("Junior"))
			{
				boolean duplikat = false;
				for (Medlem j: juniorTopFem)
				{
					if (m.compare(j))
					{
						duplikat = true;
						break;
					}
				}

				if (!duplikat) juniorTopFem.add(m);
			}
			if (m.getAktivitetsform().equals("Senior"))
			{
				boolean duplikat = false;
				for (Medlem s: seniorTopFem)
				{
					if (m.compare(s))
					{
						duplikat = true;
						break;
					}
				}

				if (!duplikat) seniorTopFem.add(m);
			}
		}

		//print top fem-lister
		System.out.println("top fem seniorer inden for disciplinen "+dis+" er:");
		if (seniorTopFem.size() < 5)
		{
			for (Medlem m: seniorTopFem)
			{
				System.out.println(m);
			}
		} else
		{
			for (int i = 0; i < 5; i++)
			{
				System.out.print(seniorTopFem.get(i));
			}
		}

		System.out.println("top fem juniorer inden for disciplinen "+dis+" er:");
		if (juniorTopFem.size() < 5)
		{
			for (Medlem m: juniorTopFem)
			{
				System.out.println(m);
			}
		} else
		{
			for (int i = 0; i < 5; i++)
			{
				System.out.print(juniorTopFem.get(i));
			}
		}
	}

	public static void gemData() throws IOException {
		Medlem.gemMedlemsdata();
		Resultat.gemResultater();
	}

}