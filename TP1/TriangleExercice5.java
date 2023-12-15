public class TriangleExercice5 {
    private Point p1;
    private Point p2;
    private Point p3;

    private Segment s1;
    private Segment s2;
    private Segment s3;

    public TriangleExercice5(Point point1, Point point2, Point point3) {
        this.p1 = point1;
        this.p2 = point2;
        this.p3 = point3;
        this.s1 = new Segment(point1, point2);
        this.s2 = new Segment(point2, point3);
        this.s3 = new Segment(point3, point1);
    }

    public Segment getS1() {
        return this.s1;
    }

    public Segment getS2() {
        return this.s2;
    }

    public Segment getS3() {
        return this.s3;
    }

    public Point BaryCentre() {
        double x = (this.p1.getX() + this.p2.getX() + this.p3.getX()) / 3;
        double y = (this.p1.getY() + this.p2.getY() + this.p3.getY()) / 3;
        return new Point(x, y);
    }

    public void Afficher() {
        System.out.print("Le triangle a 3 Segments : [" + getS1() + ","+getS2()+","+getS3()+"] \n et son BaryCentre est de coordonées : " + this.BaryCentre() + "\n");
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        TriangleExercice5 t1 = new TriangleExercice5(p1, p2, p3);
        t1.Afficher();
    }


}
