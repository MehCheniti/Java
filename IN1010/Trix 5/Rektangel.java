class Rektangel implements Figur {

    private double hoyde;
    private double bredde;

    public Rektangel(double h, double b) {
        hoyde = h;
        bredde = b;
    }

    public double beregnAreal(){
        return hoyde * bredde;

    }

    public double beregnOmkrets(){
        return hoyde * 2 + bredde * 2;
    }
}
