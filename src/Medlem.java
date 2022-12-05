package src;
import java.util.ArrayList;
import java.time.LocalDate;

public class Medlem {

	public static ArrayList<Medlem> MedlemListe;
	private int id;
	private String navn;
	private LocalDate foedselsdato;
	private String aktivitetsform;
	private int kontingentId;

	public Medlem(int id, String navn, LocalDate foedselsdato, String aktivitetsform) {
		this.id = id;
		this.navn = navn;
		this.foedselsdato = foedselsdato;
		this.aktivitetsform = aktivitetsform;
	}

	public Kontingent hentKontingent() {
		// TODO - implement Medlem.hentKontingent
		throw new UnsupportedOperationException();
	}

	public static void IndlaesMedlemmer() {
		// TODO - implement Medlem.IndlaesMedlemmer
		throw new UnsupportedOperationException();
	}

	public static void gemMedlemsdata() {
		// TODO - implement Medlem.gemMedlemsdata
		throw new UnsupportedOperationException();
	}

}