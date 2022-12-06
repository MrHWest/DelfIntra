package src;
import java.util.ArrayList;
import java.util.Date;

public class Kontingent {

	public static ArrayList<Kontingent> kontingentListe;
	private int Id;
	private double pris;
	private LocalDate betalingsdato;

	public Kontingent(Medlem medlem)
	{
		this.Id = medlem.getId();
		this.betalingsdato = LocalDate.now();
		this.pris = hentPris(medlem.foedseldag, medlem.aktiv);

	}

//metode der beregner pris baseret på medlems alder og aktiv/passiv-status:
	public double hentPris(LocalDate foedselsdag, boolean aktiv)
	{
		//hvis medlem er passiv kan resten af beregning springes over
		double pris = 500;
		if (!aktiv) return pris;
		//ellers beregnes alder og derefter pris. Pensionistrabat som modifikation af senior-pris
		alder = ChronoUnit.YEARS.between(foedselsdato, LocalDate.now());
		if (aktiv && alder < 18) pris = 1000;
		if (aktiv && alder >= 18) pris = 1600;
		if (aktiv && alder >= 65) pris = 75/100*pris;
		return pris;
	}

	public LocalDate getBetalingsdato() {
		return betalingsdato;
	}


	Date hentBetalingsdato() {
		// TODO - implement Kontingent.hentBetalingsdato
		throw new UnsupportedOperationException();
	}

	public static void indlaesKontingenter() {
		// TODO - implement Kontingent.indlaesKontingenter
		throw new UnsupportedOperationException();
	}

	public static void gemKontingentData() {
		// TODO - implement Kontingent.gemKontingentData
		throw new UnsupportedOperationException();
	}

}