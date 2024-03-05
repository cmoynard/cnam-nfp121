package editeur.commande;

import editeur.Ligne;

public class CommandeCurseurDebut extends CommandeLigne {

    public CommandeCurseurDebut(Ligne l) {
        super(l);
    }
     public void executer() {
        ligne.raz();
    }

    public boolean estExecutable() {
        return ligne.getCurseur() > 1;
    }

}
