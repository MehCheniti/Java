class Sirkel implements Figur {

    private double radius;

    public Sirkel (double r) {
        radius = r;
    }

    public double beregnAreal(){
        return radius * radius * Math.PI;
    }

    public double beregnOmkrets(){
        return radius * 2 * Math.PI;
    }
}
