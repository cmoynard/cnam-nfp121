/**
 * Maj indique pour chaque lot les positions mises Ã  jour (ou ajoutÃ©es)
 * lors du traitement de ce lot.
 *
 * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
 */
public class Maj extends Traitement {

	@Override
    protected String toStringComplement() {
        return "maj";
    }

    @Override
    public void traiter(Position position, double valeur) {
        System.out.println("Maj : " + position + " = " + valeur);
        super.traiter(position, valeur);
    }

    @Override
    public void gererFinLotLocal(String nomLot) {
        System.out.println(nomLot + ": fin lot");
    }

}
