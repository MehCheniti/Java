class Kvadrat extends Figurer{

double side;

  public Kvadrat(double side){
    this.side = side;
  }

  public double hentAreal(){
    return side * side;
  }

  @Override public String toString(){
    return "Kvadrat (lengde: " + side + ")";
  }

}
