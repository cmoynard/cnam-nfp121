import java.util.*;

/**
  * SommeParPosition 
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */

import java.util.*;

public class SommeParPosition extends Traitement {
    private final Map<Position, Double> sommes;

    public SommeParPosition() {
        this.sommes = new HashMap<>();
    }

    @Override
    public void traiter(Position position, double valeur) {
        sommes.put(position, sommes.getOrDefault(position, 0.0) + valeur);
        super.traiter(position, valeur);
    }

    public Map<Position, Double> getSums() {
        return Collections.unmodifiableMap(sommes);
    }
}
