public class Hovedprogram{

  public static void main(String[] args){
    Katt pus = new Katt("Pus", 1);
    Husdyr bjarte = new Hund("Bjarte", 2);

    Husdyr[] beholder = new Husdyr[3];
    beholder[0] = pus;
    beholder[1] = bjarte;
    beholder[2] = new Hund("Stine", 4);

    for (int i = 0; i < beholder.length; i++){
      System.out.println(beholder[i]);
      beholder[i].lagLyd();
    }

    HarAlder[] beholder2 = new HarAlder[3];
    Bil bilen = new Bil("AB123", 3);
    beholder2[0] = bilen;
    beholder2[1] = pus;
    beholder2[2] = beholder[2];

    for (int i = 0; i < beholder2.length; i++){
      System.out.println(beholder2[i].hentAlder());
    }
  }

}
