public class Modulo extends Traitement {

    private final double param;

    public Modulo(double param) {
        this.param = param;
    }

    @Override
    public void traiter(Position position, double valeur) {
        double result = valeur % param;
        System.out.println("The result of the modulo operation is: " + result);

        super.traiter(position, result);
    }
}