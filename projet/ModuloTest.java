import org.junit.*;
import static org.junit.Assert.*;

public class ModuloTest extends TraitementTestAbstrait {

    private static final double EPSILON = 1e-8;

    private Modulo modulo;
    private TraitementTestAbstrait.Dernier dernier;

    @Override
    protected Modulo nouveauTraitement() {
        return new Modulo(10.0);
    }

    @Override
    public void setUp() {
        super.setUp();
        this.modulo = nouveauTraitement();
        this.dernier = new TraitementTestAbstrait.Dernier();
        this.modulo.ajouterSuivants(this.dernier);
    }

    @Test
    public void testerModuloNominal() {
        Position p1 = new Position(1, 2);
        this.modulo.gererDebutLot("Lot1");
        this.modulo.traiter(p1, 11);
        assertEquals(1, this.dernier.valeur, EPSILON);
        assertSame(p1, this.dernier.position);

        this.modulo.traiter(p1, 7);
        assertEquals(7, this.dernier.valeur, EPSILON);
        assertSame(p1, this.dernier.position);

        this.modulo.gererFinLot("Lot1");
    }
}