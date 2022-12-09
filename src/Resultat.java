package src;

import java.util.ArrayList;

public class Resultat implements Comparable<Resultat>{

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


	@Override
	public int compareTo(Resultat r) {
		if (tid == r.tid) {
			return 0;
		} else if (tid < r.tid) {
			return 1;
		} else {
			return -1;
		}
	}

	public String getDisciplin() {
		return disciplin;
	}

	public int getMedlemId() {
		return medlemId;
	}
}