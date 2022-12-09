package src;
import java.time.LocalDate;
import java.util.ArrayList;

public class Konkurrencesvoemmer extends Medlem {

	public static ArrayList<Konkurrencesvoemmer> konkurrenceSvoemmerListe;
	private ArrayList<String> aktiveDiscipliner;

	public Konkurrencesvoemmer(int id, String navn, LocalDate foedselsdato, boolean aktiv)
	{
		super(id, navn, foedselsdato, aktiv);
		ArrayList<String> aktiveDiscipliner = new ArrayList<String>();
	}

	public void ekstraDisciplin(String nyDis)
	{
		boolean duplikat = false;
		for (String s: aktiveDiscipliner)
		{
			if (nyDis.equalsIgnoreCase(s)) duplikat = true;
		}

		if (!duplikat)
		{
			this.aktiveDiscipliner.add(nyDis);
		}
	}

}