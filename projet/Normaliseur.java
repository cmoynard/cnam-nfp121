import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
  * Normaliseur normalise les donnÃ©es d'un lot en utilisant une transformation affine.
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */
public class Normaliseur extends Traitement {
    private final double debut;
    private final double fin;
    private double min = Double.MAX_VALUE;
    private double max = -Double.MAX_VALUE;
    private List<AbstractMap.SimpleEntry<Position, Double>> lotData;

    public Normaliseur(double debut, double fin) {
        this.debut = debut;
        this.fin = fin;
        this.lotData = new ArrayList<>();
    }

    @Override
    public void traiter(Position position, double valeur) {
        min = Math.min(min, valeur);
        max = Math.max(max, valeur);
        lotData.add(new AbstractMap.SimpleEntry<>(position, valeur));
        super.traiter(position, valeur);
    }

    @Override
    protected void gererFinLotLocal(String nomLot) {
        double a = (fin - debut) / (max - min);
        double b = fin - a * max;
        System.out.println(nomLot + ": a = " + a + ", b = " + b);

        // Check if nomLot already ends with "_normalized"
        String normalizedLotName = nomLot.endsWith("_normalized") ? nomLot : nomLot + "_normalized";

        gererDebutLot(normalizedLotName);

        // Create a copy of lotData and iterate over the copy
        List<AbstractMap.SimpleEntry<Position, Double>> copyOfLotData = new ArrayList<>(lotData);
        for (AbstractMap.SimpleEntry<Position, Double> entry : copyOfLotData) {
            double normalizedValue = a * entry.getValue() + b;
            traiter(entry.getKey(), normalizedValue);
        }

        gererFinLot(normalizedLotName);

        min = Double.MAX_VALUE;
        max = -Double.MAX_VALUE;
        lotData.clear();
    }
}