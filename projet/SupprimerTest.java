import org.junit.Test;
import static org.junit.Assert.*;

public class SupprimerTest {

    @Test
    public void testSupprimerPlusPetit() {
        double seuil = 5.0;
        SupprimerPlusPetit spp = new SupprimerPlusPetit(seuil);
        Position pos = new Position(0, 0); // Assuming Position is a valid class
        double valeur = 4.0;
        spp.traiter(pos, valeur);
    }

    @Test
    public void testSupprimerPlusGrand() {
        double seuil = 5.0;
        SupprimerPlusGrand spg = new SupprimerPlusGrand(seuil);
        Position pos = new Position(0, 0); // Assuming Position is a valid class
        double valeur = 6.0;
        spg.traiter(pos, valeur);
    }
}