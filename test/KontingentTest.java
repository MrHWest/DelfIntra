package test;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import src.FileHandler;
import src.Kontingent;
import src.Medlem;

public class KontingentTest {
    @Test
    public void gemKontingentDataTest() throws IOException {
        // Clear kontingent list
        if(Kontingent.kontingentListe.size() != 0) {
            Kontingent.kontingentListe.clear();
        }

        // Add dummy kontingenter
        Medlem m1 = new Medlem(1, "Test Testesen", LocalDate.of(1997, 11, 17), false);
        Medlem m2 = new Medlem(2, "Jens Jensen", LocalDate.of(1979, 12, 24), true);
        Kontingent k1 = new Kontingent(m1);
        Kontingent k2 = new Kontingent(m2);

        // Write dummy kontingenter to file
        Kontingent.gemKontingentData();

        // Read file
        String[] fileContents = FileHandler.ReadFile("./kontingenter.txt");

        // Assertions
        assert(fileContents.length == 2);
        assert(fileContents[0].equals("1;500.0;" + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        assert(fileContents[1].equals("2;1600.0;" + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }

    @Test
    public void indlaesKontingenterTest() throws IOException {
        // Clear kontingent list
        if(Kontingent.kontingentListe.size() != 0) {
            Kontingent.kontingentListe.clear();
        }

        // Add dummy kontingenter
        Medlem m1 = new Medlem(1, "Test Testesen", LocalDate.of(1997, 11, 17), false);
        Medlem m2 = new Medlem(2, "Jens Jensen", LocalDate.of(1979, 12, 24), true);
        Kontingent k1 = new Kontingent(m1);
        Kontingent k2 = new Kontingent(m2);

        // Write dummy kontingenter to file
        Kontingent.gemKontingentData();

        // clear kontingent list again
        Kontingent.kontingentListe.clear();

        // Read contents of file
        Kontingent.indlaesKontingenter();

        // Assertions
        assert(Kontingent.kontingentListe.size() == 2);
        assert(Kontingent.kontingentListe.get(0).compare(k1));
        assert(Kontingent.kontingentListe.get(1).compare(k2));
    }
}
