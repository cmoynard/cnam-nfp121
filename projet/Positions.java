import java.util.*;

/**
 * Positions enregistre toutes les positions, quelque soit le lot.
 *
 * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
 */
public class Positions extends PositionsAbstrait {

    private final List<Position> positions;

    public Positions() {
        this.positions = new ArrayList<>();
    }

    @Override
    public void traiter(Position position, double valeur) {
        positions.add(position);
        super.traiter(position, valeur);
    }

    @Override
    public int nombre() {
        return positions.size();
    }

    @Override
    public Position position(int indice) {
        return positions.get(indice);
    }

    @Override
    public int frequence(Position position) {
        return Collections.frequency(positions, position);
    }
}