public class Data {
    private final int id;
    private final int abscisse;
    private final int ordonnee;
    private final double valeur;

    public Data(int id, int abscisse, int ordonnee, double valeur) {
        this.id = id;
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
        this.valeur = valeur;
        System.out.println("Data created: " + this);
    }

    @Override
    public String toString() {
        System.out.println("Converting Data to String: " + id + " " + abscisse + " " + ordonnee + " " + valeur);
        return id + " " +abscisse + " " + ordonnee + " " + valeur;
    }
}
