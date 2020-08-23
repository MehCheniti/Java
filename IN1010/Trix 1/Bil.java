public class Bil{

    private String eier;
    private String merke;

    public Bil(String e, String m){
      eier = e;
      merke = m;
    }

    public void skrivUt(){
      System.out.println(eier);
      System.out.println(merke);
    }

}
