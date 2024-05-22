import java.util.*;

/**
  * Donnees enregistre toutes les donnÃ©es reÃ§ues, quelque soit le lot.
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */

public class Donnees extends Traitement {
    private final List<Double> data;

    public Donnees() {
        this.data = new ArrayList<>();
    }

    @Override
    public void traiter(Position position, double valeur) {
        data.add(valeur);
        super.traiter(position, valeur);
    }

    public List<Double> getData() {
        return Collections.unmodifiableList(data);
    }
}
