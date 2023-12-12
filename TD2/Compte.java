public class Compte{ /** création de la classe en public */
    private int solde; /** solde privé car on veut uniquement l'utiliser dans la classe */

    public Compte(int mI) { /** le constructeur en public sinon on ne peut pas y accèder et modifier le solde */
        this.solde = mI; /** this.solde devient la v d'instance et on l'initialise a mI */
    }

    public void crediter(int montant) {
        this.solde = this.solde + montant; /** fonction public pour augmenter le solde via v instance */
    }

    public void débiter(int montant) {
        this.solde = this.solde - montant; /** fonction public pour réduire le solde via v instance */
    }

    public void getSolde(): int {
        return this.solde; /** pour récupérer le solde en dehors de notre privatisation de la variable */
    }
}