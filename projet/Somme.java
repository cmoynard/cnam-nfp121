/**
  * Somme calcule la sommee des valeurs, quelque soit le lot.
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */

public class Somme extends SommeAbstrait {

	// TODO Ã  faire...


	@Override
	public void gererFinLotLocal(String nomLot) {
		System.out.println(nomLot + ": somme = " + this.somme());
	}

}
