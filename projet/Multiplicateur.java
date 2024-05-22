/**
 * Multiplicateur transmet la valeur multipliée par un facteur.
 *
 * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
 */
public class Multiplicateur extends Traitement {

    private final double facteur;

    public Multiplicateur(double facteur) {
        this.facteur = facteur;
    }

    @Override
    public void traiter(Position position, double valeur) {
        super.traiter(position, valeur * facteur);
    }
}