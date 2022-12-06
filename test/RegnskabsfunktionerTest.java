package test;
import org.junit.Test;
import src.Regnskabsfunktioner;
import src.Kontingent;
import src.Medlem;


public class RegnskabsfunktionerTest
{
    @Test
    public void visRestancerTest()
    {
        //generer medlemmer og put på MedlemListe
        Medlem m1 = new Medlem(0, "Test Testesen", LocalDate.of(1997, 11, 17), true);
        Medlem m2 = new Medlem(1, "Lars Larsen", LocalDate.of(1978, 02, 05), true);
        MedlemListe.add(m1);
        MedlemListe.add(m2);

        //generer kontingenter og kom på kontingentListe
        Kontingent k1 = new Kontingent(m1);
        Kontingent k2 = new Kontingent(m2);
        kontingentListe.add(k1);
        kontingentListe.add(k2);

        Regnskabsfunktioner.visRestancer();

        assert()
    }
}