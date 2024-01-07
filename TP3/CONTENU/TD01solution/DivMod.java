/** Afficher le reste et le produit de la division entière.
  * @author	Xavier Crégut
  * @version	1.1
  */
class DivMod {
    /** Afficher le quotient (div) et le reste (mod) de la division entière de
     * deux entiers.
     * @param dividende le dividende (strictement positif)
     * @param diviseur le diviseur (positif)
     */
    public static void divMod(int dividende, int diviseur) {
	int reste = dividende;	// reste de la division entière
	int quotient = 0;	// quotient de la division entière
	while (reste >= diviseur) {
	    // Variant : reste;
	    // Invariant : diviseur * quotient + reste = dividende;
	    quotient++;
	    reste = reste - diviseur;
	}
	System.out.println("Division de " + dividende + " par " + diviseur);
	System.out.println("quotient = " + quotient);
	System.out.println("reste = " + reste);
    }

    public static void main(String[] args) {
	divMod(5, 2);	// Resultat : 2 et 1
	divMod(2, 5);	// Resultat : 0 et 2
	divMod(0, 5);	// Resultat : 0 et 0
    }
}
