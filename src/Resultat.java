package src;

import java.time.Duration;
import java.util.ArrayList;

public class Resultat {

	public static ArrayList<Resultat> resultatListe;
	private String disciplin;
	private Duration tid;
	private int medlemId;

	public Resultat(String disciplin, Duration tid, int medlemId)
	{
		this.disciplin = disciplin;
		this.tid = tid;
		this.medlemId = medlemId;
	}

	public static void indlaesResultater() {
		// TODO - implement Resultat.indlaesResultater
		throw new UnsupportedOperationException();
	}

	public static void gemResultater() {
		// TODO - implement Resultat.gemResultater
		throw new UnsupportedOperationException();
	}

}