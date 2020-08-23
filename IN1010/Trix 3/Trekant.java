class Trekant extends Figur{

    private double hoyde;
    private double grunnlinje;

    public Trekant(double h, double g){
        hoyde = h;
        grunnlinje = g;
    }

    public double areal(){
        return (grunnlinje*hoyde)/2;
    }
}
