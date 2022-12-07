package src;
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

//metode der beregner pris baseret på medlems alder og aktiv/passiv-status:
	public double hentPris(LocalDate foedselsdato, boolean aktiv)
	{
		//hvis medlem er passiv kan resten af beregning springes over
		double pris = 500;
		if (!aktiv) return pris;
		//ellers beregnes alder og derefter pris. Pensionistrabat som modifikation af senior-pris
		double alder = ChronoUnit.YEARS.between(foedselsdato, LocalDate.now());
		if (aktiv && alder < 18) pris = 1000;
		if (aktiv && alder >= 18) pris = 1600;
		if (aktiv && alder >= 65) pris = 75/100*pris;
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

	public static void indlaesKontingenter() {
		// TODO - implement Kontingent.indlaesKontingenter
		throw new UnsupportedOperationException();
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
}