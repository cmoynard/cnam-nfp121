import java.io.*;
import java.util.*;
import static java.util.AbstractMap.SimpleImmutableEntry;

/** RÃ©aliser un traitement sur les donnÃ©es d'une source. */
public class Analyseur {
	private Traitement traitement;

	public Analyseur(Traitement traitement) {
		Objects.requireNonNull(traitement);

		this.traitement = traitement;
	}

	/** Charger l'analyseur avec les donnÃ©es de la source. */
	public void traiter(Iterable<SimpleImmutableEntry<Position, Double>> source, String nom) {
		traitement.gererDebutLot(nom);
		for (SimpleImmutableEntry<Position, Double> info : source) {
			Double valeur = info.getValue();
			Position p = info.getKey();
			traitement.traiter(p, valeur);
		}
		traitement.gererFinLot(nom);
	}

}
