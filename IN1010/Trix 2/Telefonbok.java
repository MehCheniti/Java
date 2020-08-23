import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;

public class Telefonbok{
  public static void main(String[] args){
    HashMap<String, String> hashMap = new HashMap<String, String>();
    hashMap.put("Arne", "22334455");
    hashMap.put("Lisa", "95959595");
    hashMap.put("Jonas", "97959795");
    hashMap.put("Peder", "12345678");
    Scanner inp = new Scanner(System.in);
    System.out.println("Navn? ");
    String navn = inp.nextLine();
    if (hashMap.containsKey(navn)){
      System.out.println(hashMap.get(navn));
    }
  }
}
