import java.util.*;

/**
  * PositionsAbstrait spÃ©cifie un traitement qui mÃ©morise
  * toutes les positions traitÃ©es pour ensuite y accÃ©der
  * par leur indice ou obtenir la frÃ©quence d'une position.
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */

abstract public class PositionsAbstrait extends Traitement {

	/** Obtenir le nombre de positions mÃ©morisÃ©es.
	 * @return le nombre de positions mÃ©morisÃ©es
	 */
	public abstract int nombre();

	/** Obtenir la iÃ¨me position enregistrÃ©e.
	 * @param numero numÃ©ro de la position souhaitÃ©e (0 pour la premiÃ¨re)
	 * @return la position de numÃ©ro d'ordre `numero`
	 * @exception IndexOutOfBoundsException si le numero est incorrect
	 */
	public abstract Position position(int indice);

	/** Obtenir la frÃ©quence d'une position dans les positions traitÃ©es.
	 * @param position la position dont on veut connaÃ®tre la frÃ©quence
	 * @return la frÃ©quence de la position en paramÃ¨tre
	 */
	public abstract int frequence(Position position);

}
