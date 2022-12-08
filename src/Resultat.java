package src;

import java.util.ArrayList;

public class Resultat {

	public static ArrayList<Resultat> resultatListe;
	private String disciplin;
	private int tid;
	private int medlemId;

	public Resultat(String disciplin, int tid, int medlemId)
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