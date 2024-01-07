import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SaisirQuestionnaire {

	private JFrame fenetre = new JFrame("Saisie questionnaire");
	private Questionnaire questionnaire;
	private JTextField id = new JTextField(20);
	private JTextArea texte = new JTextArea(3, 20);
	private JTextField reponse = new JTextField(20);

	private JButton enregistrer = new JButton("Enregistrer");
	private JButton annuler = new JButton("Annuler");
	private JButton quitter = new JButton("Quitter");

	public SaisirQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;



		fenetre.pack();
		fenetre.setVisible(true);
	}


}
