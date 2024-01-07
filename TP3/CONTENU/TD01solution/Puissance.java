/** Calculer la puissance entière d'un réel
  * @author	Xavier Crégut
  * @version	1.2
  */
class Puissance {

    final static double EPSILON = 1.0e-5;

    /** Calculer la puissance entière d'un réel.  On suppose x != 0 || n >= 0.
      * @param x le nombre réel
      * @param n la puissance entière
      * @return x à la puissance n
      */
    public static double puissance(double x, int n) {
	assert x != 0 || n >= 0;
	double resultat = 0;
	if (x == 0) {	// cas trivial
	    resultat = 0;
	} else {
	    // déterminer le facteur multiplicatif et la puissance
	    double facteur = 0;	// facteur multiplicatif
	    int puissance = 0;	// abs(n)
				// On a $x^n == facteur^{puissance}$
	    if (n >= 0) {
		facteur = x;
		puissance = n;
	    } else {
		facteur = 1.0 / x;
		puissance = -n;
	    }

	    // Calculer xn par itération (accumulation)
	    resultat = 1;
	    for (int i = 1; i <= puissance; i++) {
		// Invariant : resultat == $facteur^\bgroup i\egroup$
		resultat = resultat * facteur;
	    }
	}
	return resultat;
    }

    public static void main(String[] args) {
	assert puissance(1, 1) == 1;
	assert puissance(2, 1) == 2;
	assert puissance(2, 2) == 4;
	assert puissance(3, 2) == 9;
	assert puissance(2, 3) == 8;
	assert puissance(2, -1) ==  0.5;	// Dangereux !
	assert puissance(2, -3) ==  0.125;	// Dangereux !
	assert Math.abs(puissance(2, -1) - 1.0 / 2.0) < EPSILON;
	// assert puissance(3, -1) ==  1.0 / 3.0;	// FAUSSE !!!
	assert Math.abs(puissance(3, -1) - 1.0 / 3.0) < EPSILON;
    }
}
