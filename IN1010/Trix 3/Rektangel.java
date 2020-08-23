class Rektangel extends Figur{

    private double bredde;
    private double hoyde;

    public Rektangel(double b, double h){
        bredde = b;
        hoyde = h;
    }

    public double areal(){
        return hoyde*bredde;
    }
}
