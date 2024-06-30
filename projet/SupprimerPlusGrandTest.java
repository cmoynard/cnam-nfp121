import org.junit.*;
import static org.junit.Assert.*;

public class SupprimerPlusGrandTest extends TraitementTestAbstrait {

    private static final double SEUIL = 5.0;
    private SupprimerPlusGrand supprimerPlusGrand;

    @Override
    protected SupprimerPlusGrand nouveauTraitement() {
        return new FabriqueTraitementConcrete().supprimerPlusGrand(SEUIL);
    }

    @Override
    public void setUp() {
        super.setUp();
        this.supprimerPlusGrand = nouveauTraitement();
    }

    @Test
    public void testerSupprimerPlusGrandNominal() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(3, 4);
        Position p3 = new Position(5, 6);
        Position p4 = new Position(7, 8);
        Position p5 = new Position(9, 10);
        this.supprimerPlusGrand.gererDebutLot("Lot1");
        this.supprimerPlusGrand.traiter(p1, 11);
        this.supprimerPlusGrand.traiter(p2, 7);
        this.supprimerPlusGrand.traiter(p3, 6);
        this.supprimerPlusGrand.traiter(p4, 5);
        this.supprimerPlusGrand.traiter(p5, 4);
        this.supprimerPlusGrand.gererFinLot("Lot1");
    }
}