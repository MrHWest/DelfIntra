package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Resultat {

	public static ArrayList<Resultat> resultatListe = new ArrayList<Resultat>();
	private String disciplin;
	private int tid;
	private int medlemId;

	public Resultat(String disciplin, int tid, int medlemId)
	{
		this.disciplin = disciplin;
		this.tid = tid;
		this.medlemId = medlemId;
	}

	public static void indlaesResultater() throws FileNotFoundException {
		String[] resultater = FileHandler.ReadFile("./resultater.txt");
		for(String m : resultater) {
			String[] resultatData = m.split(";");
			Resultat nytResultat= new Resultat(
				resultatData[0], // Disciplin
				Integer.parseInt(resultatData[1]), // tid
				Integer.parseInt(resultatData[2]) // medlemId
			);
			resultatListe.add(nytResultat);
		}
	}

	public static void gemResultater() throws IOException {
		String[] resultatArray = new String[resultatListe.size()];
		int i = 0;
		for(Resultat r : resultatListe) {
			resultatArray[i] = r.disciplin + ";"
				+ r.tid + ";"
				+ r.medlemId;
			i++;
		}

		FileHandler.WriteToFile("./resultater.txt", resultatArray);
	}

}