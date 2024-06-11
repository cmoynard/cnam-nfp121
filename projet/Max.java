/**
  * Max calcule le max des valeurs vues, quelque soit le lot.
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */

public class Max extends Traitement {

	private double maximum;

    public Max() {
        this.maximum = Double.NEGATIVE_INFINITY;
    }

    @Override
    public void traiter(Position position, double valeur) {
        if (valeur > this.maximum) {
            this.maximum = valeur;
        }
        super.traiter(position, valeur);
    }

    public double getMax() {
        return this.maximum;
    }

    @Override
    public void gererFinLotLocal(String nomLot) {
        System.out.println(nomLot + ": max = " + this.getMax());
    }

}
