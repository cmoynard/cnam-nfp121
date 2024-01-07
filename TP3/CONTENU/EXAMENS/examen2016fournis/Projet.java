public interface Projet extends Iterable<Offre> {
	/** Le nom du projet. */
	String getNom() ;

	/** Le montant demandé par le projet. */
	int getMontant();

	/** Ajouter un nouvelle offre. */
	void faireOffre(int montant, double taux);
}
