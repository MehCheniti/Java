class Sirkel extends Figurer{

private double radius;

  public Sirkel(double radius){
    this.radius = radius;
  }

  public double hentAreal(){
    return radius * radius * Math.PI;
  }

  @Override public String toString(){
    return "Sirkel (lengde: " + radius + ")";
  }

}
