package src;
public class Regnskabsfunktioner {

	Scanner scan = new Scanner(System.in);

	public static void indlaesData() {
		// TODO - implement Regnskabsfunktioner.indlaesData
		throw new UnsupportedOperationException();
	}

	public static void visValgmuligheder() {
		// TODO - implement Regnskabsfunktioner.visValgmuligheder
		throw new UnsupportedOperationException();
	}

	//Finder et medlem, finder dette medlems kontingent og opdaterer seneste betalingsdato til dags dato
	public static void registrerIndbetaling() {
		System.out.println("Indtast navn på det medlem du vil registrere en indbetaling for:");
		String navn = scan.nextLine();
		for (Medlem m: MedlemListe)
		{
			if (navn.equals(m.getNavn()))
			{
				m.hentKontingent().setKontingent(LocalDate.now());
			}
		}
	}

	public static void visRestancer() {
		ArrayList<Medlem> debitorListe = new ArrayList<Medlem>();

		for (Medlem m: MedlemListe)
		{
			kontingent = m.hentKontingent();
			if (ChronoUnit.YEARS.between(kontingent.getBetalingsDato(), LocalDate.now()) > 1)
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