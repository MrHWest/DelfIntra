package src;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class Kontingent {

	public static ArrayList<Kontingent> kontingentListe = new ArrayList<Kontingent>();
	private int id;
	private double pris;
	private LocalDate betalingsdato;

	public Kontingent(Medlem medlem)
	{
		this.id = medlem.getId();
		this.betalingsdato = LocalDate.now();
		this.pris = hentPris(medlem.getFoedselsdato(), medlem.getAktiv());
		kontingentListe.add(this);
	}

	// Needed for indlaesKontingenter()
	private Kontingent(int id, double pris, LocalDate betalingsdato) {
		this.id = id;
		this.pris = pris;
		this.betalingsdato = betalingsdato;
	}
//metode der beregner pris baseret på medlems alder og aktiv/passiv-status:
	public double hentPris(LocalDate foedselsdato, boolean aktiv)
	{
		//hvis medlem er passiv kan resten af beregning springes over
		double pris = 500;
		if (!aktiv) return pris;
		//ellers beregnes alder og derefter pris. Pensionistrabat som modifikation af senior-pris
		double alder = ChronoUnit.YEARS.between(foedselsdato, LocalDate.now());
		if (alder < 18) pris = 1000;
		if (alder >= 18) pris = 1600;
		if (alder >= 65) pris = 75/100*pris;
		return pris;
	}

	public LocalDate getBetalingsDato() {
		return betalingsdato;
	}

	public void setBetalingsdato(LocalDate betalingsdato) {
		this.betalingsdato = betalingsdato;
	}

	Date hentBetalingsdato() {
		// TODO - implement Kontingent.hentBetalingsdato
		throw new UnsupportedOperationException();
	}

	public static void indlaesKontingenter() throws FileNotFoundException {
		String[] contentsRead = FileHandler.ReadFile("./kontingenter.txt");
		for(String s : contentsRead) {
			String[] kontingentData = s.split(";");
			Kontingent.kontingentListe.add(new Kontingent(
				Integer.parseInt(kontingentData[0]),
				Double.parseDouble(kontingentData[1]),
				LocalDate.parse(kontingentData[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		}
	}

	public static void gemKontingentData() throws IOException {
		String[] kontingentData = new String[Kontingent.kontingentListe.size()];

		int i = 0;
		for(Kontingent k : Kontingent.kontingentListe) {
			kontingentData[i] = k.id + ";"
			+ k.pris + ";"
			+ k.betalingsdato.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			i++;
		}

		FileHandler.WriteToFile("kontingenter.txt", kontingentData);
	}

	public int getId() {
		return id;
	}

	public boolean compare(Kontingent k) {
		if (this.id != k.id) return false;
		if (this.pris != k.pris) return false;
		if (!this.betalingsdato.equals(k.betalingsdato)) return false;

		// Objects are equal if we get to this point
		return true;
	}

	public double getPris() {
		return pris;
	}
}