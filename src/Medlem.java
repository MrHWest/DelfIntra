package src;
import java.util.ArrayList;
import java.io.FileNotFoundException;
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

	public static void IndlaesMedlemmer() throws FileNotFoundException {
		String[] medlemmer = FileHandler.ReadFile("./brugerData/medlemmer.txt");
		for(String m : medlemmer) {
			String[] medlemData = m.split(";");
			Medlem nyMedlem = new Medlem(
				Integer.parseInt(medlemData[0]), // id
				medlemData[1], // navn
				LocalDate.parse(medlemData[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")), // foedselsdato
				Boolean.parseBoolean(medlemData[3]), medlemData[4]); // aktivitetsform
			
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

		FileHandler.WriteToFile("./brugerData/medlemmer.txt", medlemArray);
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

}