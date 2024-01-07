/** Calculer la racine carrée d'un nombre réel.
  * @author	Xavier Crégut
  * @version	1.1
  */
class RacineCarree {
    final static double EPSILON = 1.0e-5;

    /** Obtenir la racine carrée d'un réel positif.
     * @param x le réel (>= 0)
     * @return la racine carrée de x
     */
    public static double racineCarrée(double x) {
	double resultat = 0;
	if (x != 0) {
	    double un = x;	// un terme de la suite
				// Initialisation : U$_n$ = U$_0$
	    double precedent = un;
	    do {
		precedent = un;	// terme précédent
		un = (un + x / un) / 2;
	    } while (Math.abs(un - precedent) >= EPSILON);
	    resultat = un;
	}
	return resultat;
    }

    public static void main(String[] args) {
	assert Math.abs(racineCarree(4) - 2) < EPSILON;
	assert Math.abs(racineCarree(9) - 3) < EPSILON;
	assert Math.abs(racineCarree(5) - Math.sqrt(5)) < EPSILON;
    }

}
