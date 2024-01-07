/** Afficher une longueur saisie au clavier en pouces et en centimètres.
  * @author	Xavier Crégut
  * @version	1.2
  */
class ConversionsPouceCm {

    public static void main(String[] args) {
	final double UN_POUCE = 2.54;	// centimètres

	// Saisir la longueur
	System.out.print("Longueur : ");
	double lg = Clavier.readDouble();
	Clavier.skipWhite();
	char unité = Clavier.readChar();

	// Calculer la longueur en pouces et en centimètres
	double lg_p;   	// longueur exprimée en pouces
	double lg_cm;  	// longueur exprimée en centimètres
	switch (unité) {
	    case 'p':		// la longueur a été saisie en pouces
	    case 'P':
		lg_p = lg;
		lg_cm = lg * UN_POUCE;
		break;

	    case 'm':		// la longueur a été saisie en mètres
	    case 'M':
		lg_cm = lg * 100;
		lg_p = lg_cm / UN_POUCE;
		break;
		// Remarque : On pourrait remplacer les trois lignes
		// précédentes par seulement : lg = lg * 10.
		// Mais ce ne serait vraiment pas joli !

	    case 'c':		// la longueur a été saisie en centimètres
	    case 'C':
		lg_p = lg / UN_POUCE;
		lg_cm = lg;
		break;

	    default:
		lg_p = lg_cm = 0;
	}

	// Afficher les résultats
	System.out.println(lg_p + " p = " + lg_cm + " cm");
    }

}
