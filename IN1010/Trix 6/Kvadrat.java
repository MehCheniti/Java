class Kvadrat extends Figur{

double side;

  public Kvadrat(double side){
    this.side = side;
  }

  public double areal(){
    return side * side;
  }

}
