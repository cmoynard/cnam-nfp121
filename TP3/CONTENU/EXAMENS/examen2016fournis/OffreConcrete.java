public class OffreConcrete implements Offre {
	private int numero;
	private int montant;
	private double taux;

	public OffreConcrete(int numero, int montant, double taux) {
		this.numero = numero;
		this.montant = montant;
		this.taux = taux;
	}

	public int getNumero() { return this.numero; }
	public int getMontant() { return this.montant; }
	public double getTaux() { return this.taux; }
	public String toString() {
		return String.format("%4d. %8d à%5.1f", this.numero, this.montant, this.taux);
	}
}
