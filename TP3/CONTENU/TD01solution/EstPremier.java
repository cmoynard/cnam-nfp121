/** Indique si un nombre est premier.
  * @author	Xavier Crégut
  * @version	1.1
  */
class EstPremier {

    public static boolean estPremierSimple(int n) {
	boolean premier = n >= 2;
	int diviseur = 2;
	while (premier && diviseur <= n / diviseur) {
	    premier = n % diviseur != 0;
	    diviseur++;
	}
	return premier;
    }

    public static boolean estPremierOptimise(int n) {
	boolean premier = (n == 2) || (n >= 3  &&  n % 2 != 0);
	    // n vaut 2 ou est supérieur à 3 et non divisible par 2

	int diviseur = 3;
	while (premier && (diviseur <= n / diviseur)) {
		// n peut encore être premier
		// et il reste des diviseurs à essayer
	    premier =  n % diviseur != 0;
	    diviseur += 2;	// candidat suivant
	}
	return premier;
    }

    public static void main(String[] args) {
	assert ! estPremierSimple(0);
	assert ! estPremierSimple(1);
	assert estPremierSimple(2);
	assert estPremierSimple(3);
	assert ! estPremierSimple(4);
	assert estPremierSimple(5);
	assert ! estPremierSimple(6);
	assert estPremierSimple(7);
	assert ! estPremierSimple(8);
	assert ! estPremierSimple(9);
	assert ! estPremierSimple(10);
	assert estPremierSimple(11);
	assert ! estPremierSimple(12);
	assert estPremierSimple(13);
	assert estPremierSimple(97);

	assert ! estPremierOptimise(0);
	assert ! estPremierOptimise(1);
	assert estPremierOptimise(2);
	assert estPremierOptimise(3);
	assert ! estPremierOptimise(4);
	assert estPremierOptimise(5);
	assert ! estPremierOptimise(6);
	assert estPremierOptimise(7);
	assert ! estPremierOptimise(8);
	assert ! estPremierOptimise(9);
	assert ! estPremierOptimise(10);
	assert estPremierOptimise(11);
	assert ! estPremierOptimise(12);
	assert estPremierOptimise(13);
	assert estPremierOptimise(97);
    }

}
