package editeur.commande;

import editeur.Ligne;

public class CommandeSupprimerCaractere extends CommandeLigne {

    public CommandeSupprimerCaractere(Ligne l) {
        super(l);
    }
    public void executer() {
        ligne.supprimer();
    }

    public boolean estExecutable() {
        return ligne.getCurseur() > 1;
    }
}
