/**
  * Somme calcule la sommee des valeurs, quelque soit le lot.
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */

public class Somme extends SommeAbstrait {

	private double total;

	public Somme() {
		this.total = 0;
	}

	@Override
	public void traiter(Position position, double valeur) {
		this.total += valeur;
		super.traiter(position, valeur);
	}

	@Override
	public double somme() {
		return this.total;
	}


	@Override
	public void gererFinLotLocal(String nomLot) {
		System.out.println(nomLot + ": somme = " + this.somme());
	}

}
