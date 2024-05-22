/**
  * SupprimerPlusPetit supprime les valeurs plus petites qu'un seuil.
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */
public class SupprimerPlusPetit extends Traitement {

    private final double seuil;

    public SupprimerPlusPetit(double seuil) {
        this.seuil = seuil;
    }

    @Override
    public void traiter(Position position, double valeur) {
        if (valeur >= seuil) {
            super.traiter(position, valeur);
        }
    }
}
