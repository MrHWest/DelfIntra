package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Medlem {

	public static ArrayList<Medlem> MedlemListe = new ArrayList<Medlem>();
	private int id;
	private String navn;
	private LocalDate foedselsdato;
	private boolean aktiv;
	private String aktivitetsform;
	private int kontingentId;

	static Scanner scan = new Scanner(System.in);

	public Medlem(int id, String navn, LocalDate foedselsdato, boolean aktiv) {
		this.id = id;
		this.navn = navn;
		this.foedselsdato = foedselsdato;
		this.aktiv = aktiv;

		// Vælg aktivitetsform (junior/senior) udfra aktuel alder
		if(ChronoUnit.YEARS.between(foedselsdato, LocalDate.now()) < 18) {
			this.aktivitetsform = "Junior";
		}
		else {
			this.aktivitetsform = "Senior";
		}
	}

	public Kontingent hentKontingent()
	{
		Kontingent kont = null;
		for (Kontingent k: Kontingent.kontingentListe)
		{
			if (this.id == k.getId())
			{
				kont = k;
				break;
			}
		}
		return kont;
	}

	public static void IndlaesMedlemmer() throws FileNotFoundException {
		String[] medlemmer = FileHandler.ReadFile("./medlemmer.txt");
		for(String m : medlemmer) {
			String[] medlemData = m.split(";");
			Medlem nyMedlem = new Medlem(
				Integer.parseInt(medlemData[0]), // id
				medlemData[1], // navn
				LocalDate.parse(medlemData[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")), // foedselsdato
				Boolean.parseBoolean(medlemData[3])); // Aktiv
			
			MedlemListe.add(nyMedlem);
		}
	}

	/**
	 * Gemmer medlemmerne i Medlem.MedlemListe til en fil.
	 * @throws IOException
	 */
	public static void gemMedlemsdata() throws IOException {
		String[] medlemArray = new String[MedlemListe.size()];
		int i = 0;
		for(Medlem m : MedlemListe) {
			medlemArray[i] = m.id + ";"
				+ m.navn + ";"
				+ m.foedselsdato.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";"
				+ m.aktiv + ";"
				+ m.aktivitetsform;
			i++;
		}

		FileHandler.WriteToFile("./medlemmer.txt", medlemArray);
	}

	public boolean compare(Medlem m) {
		if(this.id != m.id) return false;
		if(!this.navn.equals(m.navn)) return false;
		if(!this.foedselsdato.equals(m.foedselsdato)) return false;
		if(this.aktiv != m.aktiv) return false;
		if(!this.aktivitetsform.equals(m.aktivitetsform)) return false;

		// Begge medlemmers attributter er lige med hinanden hvis vi når hertil
		return true;
	}

public String toString(){
	return "ID: " + this.id +
		" | Navn: " + this.navn +
		" | Fødselsdag: " + foedselsdato +
		" | Aktiv: " + (this.aktiv ? "Ja" : "Nej");
	}

public static void printMedlemListe() throws FileNotFoundException {
	if(MedlemListe.size() == 0) IndlaesMedlemmer();
	for(Medlem m : MedlemListe) {
		System.out.println(m.toString());
	}
}

 public int getId() {
		return id;
	}

	public String getNavn()
	{
		return navn;
	}

	public boolean getAktiv() {
		return aktiv;
	}

	public LocalDate getFoedselsdato() {
		return foedselsdato;
	}

	//metode til at finde et medlemsid baseret på navn og foedselsdato
	public static int findId(String navn, LocalDate foedselsdato)
	{
		int fundetId = -99;
		for (Medlem m: MedlemListe)
		{
			if (m.getNavn().equals(navn) && m.getFoedselsdato() == foedselsdato) fundetId = m.getId();
		}
		return fundetId;
	}

	//funktion der tager input for at finde et medlems id og spørger igen indtil det virker
	public static int findMedlem() throws InputMismatchException
	{
		boolean idOk = false;
		int fundetId = -99;
		do
		{
			System.out.println("Indtast navn på medlemmet:");
			String n = scan.nextLine();
			String input_dato = "";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate f = LocalDate.of(1900, 12, 12);
			boolean validInput = true;
			do {
				System.out.println("Indtast foedselsdato (dd-mm-yyyy)");
				input_dato = scan.nextLine();
				try {
					f = LocalDate.parse(input_dato, formatter);
					validInput = true;
				} catch(DateTimeParseException e) {
					System.out.println("Ugyldig dato! Prøv at indtaste igen");
					validInput = false;
				}
			} while(!validInput);
			fundetId = findId(n,f);
			if (fundetId >= 0) {
				idOk = true;
			} else {
				System.out.println("Kunne ikke finde medlem, tjek din indtastning og prøv igen");
			}

		} while (!idOk);

		return fundetId;
	}
}
