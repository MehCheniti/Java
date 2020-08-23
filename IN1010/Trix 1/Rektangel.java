class Rektangel {

  public static void main(String[] args){
  }

  private double l;
  private double b;

  public Rektangel (double l, double b) {   // Konstruktør
  l = l;
  b = b;
}

  public void oekLengde (int okning) {    // Oek lengden som angitt
  l += okning;}

  public void oekBredde (int okning) {    // Oek bredden som angitt
  b += okning;}

  public double areal () {     // Beregn mitt areal
  return l * b;}

  public double omkrets () {   // Beregn min omkrets
  return l + b;}
}
