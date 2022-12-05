package test;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;
import src.Medlem;

public class MedlemTest {
    
    @Test
    public void gemMedlemsdataTest() {
        Medlem m1 = new Medlem(0, "Test Testesen", LocalDate.of(1997, 11, 17), null);
        Medlem m2 = new Medlem(1, "Lars Larsen", LocalDate.of(1978, 02, 05), null);

        Medlem.MedlemListe.add(m1);
        Medlem.MedlemListe.add(m2);

        Medlem.gemMedlemsdata();
    }
}
