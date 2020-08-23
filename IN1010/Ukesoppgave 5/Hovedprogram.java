public class Hovedprogram{

  public static void main(String[] args){
    Drikke vann = new Drikke(100);
    Drikke ol = new Ol(50);

    vann.drikkGlass();
    ol.drikkGlass();

    System.out.println(vann.toString());
    System.out.println(ol.toString());
  }

}
