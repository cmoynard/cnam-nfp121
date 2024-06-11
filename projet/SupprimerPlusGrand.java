/**
  * SupprimerPlusGrand supprime les valeurs plus grandes qu'un seuil.
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */
public class SupprimerPlusGrand extends Traitement {

	private double max;

    public SupprimerPlusGrand(double seuil) {
        this.max = max;
    }

    @Override
    public void traiter(Position position, double valeur) {
        if (valeur <= this.max) {
            super.traiter(position, valeur);
        }
    }

}
