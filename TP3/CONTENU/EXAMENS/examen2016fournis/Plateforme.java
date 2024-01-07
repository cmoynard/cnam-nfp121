public interface Plateforme extends Iterable<Projet> {
	/** Créer un nouveau projet à partir de son nom et du montant demandé. */
	Projet nouveauProjet(String nom, int montant);

	/** Enregistrer une offre de prêt pour un projet. */
	// On suppose que l'offre est possible.
	void faireOffre(String nom, int montant, double taux);

	/** Obtenir un projet à partir de son nom. */
	Projet getProjet(String nom);
}
