
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

    public Normaliseur(double debut, double fin) {
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public void traiter(Position position, double valeur) {
        min = Math.min(min, valeur);
        max = Math.max(max, valeur);
        super.traiter(position, valeur);
    }

    @Override
    protected void gererFinLotLocal(String nomLot) {
        double a = (fin - debut) / (max - min);
        double b = fin - a * max;
        System.out.println(nomLot + ": a = " + a + ", b = " + b);
    }
}