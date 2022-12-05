package test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import org.junit.Test;
import src.Medlem;

public class MedlemTest {
    
    @Test
    public void indlaesMedlemmerTest() throws IOException {
        // Generate file with test members
        Medlem m1 = new Medlem(0, "Test Testesen", LocalDate.of(1997, 11, 17), true, "Senior");
        Medlem m2 = new Medlem(1, "Lars Larsen", LocalDate.of(1978, 02, 05), true, "Senior");

        Medlem.MedlemListe.add(m1);
        Medlem.MedlemListe.add(m2);

        Medlem.gemMedlemsdata();

        // Clear MedlemListe and read test file
        Medlem.MedlemListe.clear();
        Medlem.IndlaesMedlemmer();

        // New MedlemListe will be generated after this.
        // Check if size and contents of new list is OK
        assert(Medlem.MedlemListe.size() == 2);
        assert(Medlem.MedlemListe.get(0).compare(m1));
        assert(Medlem.MedlemListe.get(1).compare(m2));
    }
    @Test
    public void gemMedlemsdataTest() throws IOException {
        Medlem.MedlemListe.clear();
        Medlem m1 = new Medlem(0, "Test Testesen", LocalDate.of(1997, 11, 17), true, null);
        Medlem m2 = new Medlem(1, "Lars Larsen", LocalDate.of(1978, 02, 05), true, null);

        Medlem.MedlemListe.add(m1);
        Medlem.MedlemListe.add(m2);

        Medlem.gemMedlemsdata();

        // Read file. Confirm that content is OK.
        String content = "";
        Scanner scan = new Scanner(new File("./medlemmer.txt"));
        scan.useDelimiter("\n");
        while(scan.hasNext()) {
            content += scan.next();
        }

        assert(content.equals("0;Test Testesen;17/11/1997;true;null1;Lars Larsen;05/02/1978;true;null"));
    }
}
