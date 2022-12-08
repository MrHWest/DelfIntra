package src;
import java.util.ArrayList;

public class StaevneResultat extends Resultat {

	public static ArrayList<StaevneResultat> staevneresultatListe;
	private String staevneNavn;
	private int placering;

	public StaevneResultat(String disciplin, int tid, int medlemId, String staevneNavn, int placering)
	{
		super(disciplin, tid, medlemId)
		this.staevneNavn = staevneNavn;
		this.placering= placering;
	}

}