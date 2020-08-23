public class LoopsAndArrays{

  public static void main(String[] args){

    for (int i = 0; i < 10; i++){
      System.out.println(i);
    }

    String[] navn = {"Ola", "Kari", "Amund"};
    System.out.println(navn[0]);
    navn[0] = "Hans";

    int[] partall = new int[10];
    for (int i = 1; i < 10; i++){
      partall[i] = i * 2;
    }

    for (int i : partall){
      System.out.println(i);
    }

  }

}
