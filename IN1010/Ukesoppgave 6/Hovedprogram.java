public class Hovedprogram{

  public static void main(String[] args){
    Node forste = new Node("Hei");
    Node andre = new Node("paa");
    Node tredje = new Node("deg!");
    forste.settNeste(andre);
    forste.hentNeste().settNeste(tredje);

    Node i = forste;
    while (i != null){
      System.out.println(i.hentData());
      i = i.hentNeste();
    }
  }

}
