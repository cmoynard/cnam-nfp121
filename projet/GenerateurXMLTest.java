import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GenerateurXMLTest extends TraitementTestAbstrait {

    private static final double EPSILON = 1e-8;

    private GenerateurXML generateur;
    private Dernier dernier;

    @Override
    protected GenerateurXML nouveauTraitement() {
        return new GenerateurXML("test.xml");
    }

    @Override
    public void setUp() {
        super.setUp();
        this.generateur = nouveauTraitement();
        this.dernier = new Dernier();
        this.generateur.ajouterSuivants(this.dernier);
    }

    @Test
    public void testerGenerateurXMLNominal() {
        Position p1 = new Position(1, 2);
        this.generateur.gererDebutLot("Lot1");
        this.generateur.traiter(p1, 11);
        assertEquals(11, this.dernier.valeur, EPSILON);
        assertSame(p1, this.dernier.position);

        this.generateur.traiter(p1, 7);
        assertEquals(7, this.dernier.valeur, EPSILON);
        assertSame(p1, this.dernier.position);

        this.generateur.gererFinLot("Lot1");

        // Check if the file was created
        File file = new File("test.xml");
        assertTrue(file.exists() && !file.isDirectory());

        // Check if the file is not empty
        try {
            String content = new String(Files.readAllBytes(Paths.get("test.xml")));
            assertFalse(content.isEmpty());
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

//    @After
//    public void tearDown() {
//        // Delete the test file
//        File file = new File("test.xml");
//        if (file.exists() && !file.isDirectory()) {
//            file.delete();
//        }
//    }
}