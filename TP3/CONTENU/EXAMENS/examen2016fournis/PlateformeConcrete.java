import java.util.*;

public class PlateformeConcrete implements Plateforme {
	...

	public Projet nouveauProjet(String nom, int montant) {
		...
	}

	public void faireOffre(String nom, int montant, double taux) {
		...
	}

	public Projet getProjet(String nom) {
		...
	}

	public Iterator<Projet> iterator() {
		...
	}
	
	@Override public String toString() {
		StringBuilder result = new StringBuilder();
		for (Projet projet : this) {
			result.append("\n" + projet);
		}
		return result.toString();
	}
}
