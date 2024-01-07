import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OffreSwing {
	final private Projet projet;
	final JFrame fenetre;
	final private JTextField valeurMontant = new JTextField(6);
	final private JTextField valeurTaux = new JTextField(6);
	final private JButton boutonAnnuler = new JButton("Annuler");
	final private JButton boutonPreter = new JButton("Prêter");
	final private JTextArea offres = new JTextArea();

	public OffreSwing(Projet projet) {
		this.projet = projet;
		this.fenetre =  new JFrame("Offre de prêt");
		offres.setEditable(false);

		fenetre.pack();
		fenetre.setVisible(true);
	}
}
