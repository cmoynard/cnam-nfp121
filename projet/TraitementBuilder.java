import java.lang.reflect.*;
import java.util.*;

/**
  * TraitementBuilder
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */
public class TraitementBuilder {

	/** Retourne un objet de type Class correspondant au nom en paramÃ¨tre.
	 * Exemples :
	 *   - int donne int.class
	 *   - Normaliseur donne Normaliseur.class
	 */
	Class<?> analyserType(String nomType) throws ClassNotFoundException {
        return switch (nomType) {
            case "int" -> int.class;
            case "double" -> double.class;
            case "java.lang.String" -> String.class;
            default -> throw new ClassNotFoundException("Type non supporté : " + nomType);
        };
	}

	/** CrÃ©e l'objet java qui correspond au type formel en exploitant le Â« mot Â» suivant du scanner.
	 * Exemple : si formel est int.class, le mot suivant doit Ãªtre un entier et le rÃ©sulat est l'entier correspondant.
	 * Ici, on peut se limiter aux types utlisÃ©s dans le projet : int, double et String.
	 */
	static Object decoderEffectif(Class<?> formel, Scanner in) {
		return switch (formel.getName()) {
			case "int" -> in.nextInt();
			case "double" -> in.nextDouble();
			case "java.lang.String" -> in.next();
			default -> throw new IllegalArgumentException("le type n'existe pas | Type : " + formel);
		};
	}



	/** DÃ©finition de la signature, les paramÃ¨tres formels, mais aussi les paramÃ¨tres formels.  */
	static class Signature {
		Class<?>[] formels;
		Object[] effectifs;

		public Signature(Class<?>[] formels, Object[] effectifs) {
			this.formels = formels;
			this.effectifs = effectifs;
		}
	}

	/** Analyser une signature pour retrouver les paramÃ¨tres formels et les paramÃ¨tres effectifs.
	 * Exemple Â« 3 double 0.0 java.lang.String xyz int -5 Â» donne
	 *   - [double.class, String.class, int.class] pour les paramÃ¨tres effectifs et
	 *   - [0.0, "xyz", -5] pour les paramÃ¨tres formels.
	 */
	Signature analyserSignature(Scanner in) throws ClassNotFoundException {
		int nbParams = in.nextInt();

		if (nbParams != 0) {
			Signature sign = new Signature(new Class<?>[nbParams], new Object[nbParams]);
			for (int i = 0; i < nbParams; i++) {
				sign.formels[i] = analyserType(in.next());
				sign.effectifs[i] = decoderEffectif(sign.formels[i], in);
			}

			return sign;
		}

		else {
			return new Signature(new Class<?>[0], new Object[0]);
		}
	}


	/** Analyser la crÃ©ation d'un objet.
	 * Exemple : Â« Normaliseur 2 double 0.0 double 100.0 Â» consiste Ã  charger
	 * la classe Normaliseur, trouver le constructeur qui prend 2 double, et
	 * l'appeler en lui fournissant 0.0 et 100.0 comme paramÃ¨tres effectifs.
	 */
	Object analyserCreation(Scanner in)
			throws ClassNotFoundException, InvocationTargetException,
			IllegalAccessException, NoSuchMethodException,
			InstantiationException
	{
		String className = in.next();
		Class<?> laclass = Class.forName(className);

		try {
			laclass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Nom de classe incorrect: " + className, e);
		}

		Signature signature = analyserSignature(in);

		Constructor<?> constructor = laclass.getConstructor(signature.formels);
		return constructor.newInstance(signature.effectifs);
	}


	/** Analyser un traitement.
	 * Exemples :
	 *   - Â« Somme 0 0 Â»
	 *   - Â« SupprimerPlusGrand 1 double 99.99 0 Â»
	 *   - Â« Somme 0 1 Max 0 0 Â»
	 *   - Â« Somme 0 2 Max 0 0 SupprimerPlusGrand 1 double 20.0 0 Â»
	 *   - Â« Somme 0 2 Max 0 0 SupprimerPlusGrand 1 double 20.0 1 Positions 0 0 Â»
	 * @param in le scanner Ã  utiliser
	 * @param env l'environnement oÃ¹ enregistrer les nouveaux traitements
	 */

	Traitement analyserTraitement(Scanner in, Map<String, Traitement> env)
			throws ClassNotFoundException, InvocationTargetException,
			IllegalAccessException, NoSuchMethodException,
			InstantiationException
	{
		String traitementNom = in.next();
		int paramsNumber = in.nextInt();

		Class<?>[] paramsTypes = new Class<?>[paramsNumber];
		Object[] paramsValeurs = new Object[paramsNumber];

		for (int i = 0; i < paramsNumber; i++) {
			String paramType = in.next();
			switch (paramType) {
				case "int":
					paramsTypes[i] = int.class;
					paramsValeurs[i] = in.nextInt();
					break;
				case "double":
					paramsTypes[i] = double.class;
					paramsValeurs[i] = in.nextDouble();
					break;
				case "String":
				case "java.lang.String":
					paramsTypes[i] = String.class;
					paramsValeurs[i] = in.next();
					break;
				default:
					throw new IllegalArgumentException("Unsupported parameter type: " + paramType);
			}
		}

		Class<?> traitementClass = Class.forName(traitementNom);
		Constructor<?> constructor = traitementClass.getConstructor(paramsTypes);

		Traitement traitement = (Traitement) constructor.newInstance(paramsValeurs);

		int suivantsNumber = in.nextInt();
		for (int i = 0; i < suivantsNumber; i++) {
			Traitement traitementSuivant = analyserTraitement(in, env);
			traitement.ajouterSuivants(traitementSuivant);
		}

		return traitement;
	}

	/** Analyser un traitement.
	 * @param in le scanner Ã  utiliser
	 * @param env l'environnement oÃ¹ enregistrer les nouveaux traitements
	 */
	public Traitement traitement(Scanner in, Map<String, Traitement> env)
	{
		try {
			return analyserTraitement(in, env);
		} catch (Exception e) {
			throw new RuntimeException("Erreur sur l'analyse du traitement, "
					+ "voir la cause ci-dessous", e);
		}
	}

}
