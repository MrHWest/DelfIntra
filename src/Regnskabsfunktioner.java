package src;
public class Regnskabsfunktioner {

	public static void indlaesData() {
		// TODO - implement Regnskabsfunktioner.indlaesData
		throw new UnsupportedOperationException();
	}

	public static void visValgmuligheder() {
		// TODO - implement Regnskabsfunktioner.visValgmuligheder
		throw new UnsupportedOperationException();
	}

	public static void registrerIndbetaling() {
		// TODO - implement Regnskabsfunktioner.registrerIndbetaling
		throw new UnsupportedOperationException();
	}

	public static void visRestancer() {
		ArrayList<Medlem> debitorListe = new ArrayList<Medlem>();

		for (Medlem m: MedlemListe)
		{
			kontingent = m.hentKontingent();
			if (ChronoUnit.YEARS.between(kontingent.getBetalingsDato()), LocalDate.now() > 1)
			{
				debitorListe.add(m);
			}
		}

		for (Medlem m: debitorListe)
		{
			System.out.println(m);
		}
	}

}