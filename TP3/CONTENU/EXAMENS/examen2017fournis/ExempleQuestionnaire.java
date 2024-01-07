/**
 * Exemple d'utilisation d'un questionnaire.
 */
public class ExempleQuestionnaire {
	public static void main(String[] args) {
		// Création d'un questionnaire
		Questionnaire qObjet = new Questionnaire();
		qObjet.ajouter(new QRC("Q1", "Accessible à tous ?", "public"));
		qObjet.ajouter(new QRC("Q2", "Non modifiable ?", "final"));
		qObjet.ajouter(new QRC("Q3", "2 * 3 + 4 ?", "10"));

		// Afficher le texte des questions
		for (IQRC question : qObjet) {
			System.out.println(question.getTexte());
		}
	}
}
