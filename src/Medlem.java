package src;
import java.util.ArrayList;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Medlem {

	public static ArrayList<Medlem> MedlemListe = new ArrayList<Medlem>();
	private int id;
	private String navn;
	private LocalDate foedselsdato;
	private boolean aktiv;
	private String aktivitetsform;
	private int kontingentId;

	public Medlem(int id, String navn, LocalDate foedselsdato, boolean aktiv, String aktivitetsform) {
		this.id = id;
		this.navn = navn;
		this.foedselsdato = foedselsdato;
		this.aktiv = aktiv;
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

}