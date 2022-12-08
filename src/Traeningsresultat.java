package src;

import java.time.LocalDate;
import java.util.ArrayList;

public class Traeningsresultat extends Resultat {

	private LocalDate dato;
	private ArrayList<Traeningsresultat> traeningsresultatListe;

	public Traeningsresultat(String disciplin, int tid, int medlemId, LocalDate dato)
	{
		(super(disciplin, int tid, int medlemId));
		this.dato = dato;

	}

}