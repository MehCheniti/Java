public class Sekvensiell{

  public static int finnMax(int [] original){
    int storst = 0;

    for (int i = 0; i < original.length; i++){
      if (original[0] > storst){
        storst = original[i];
      }
    }

    return storst;
  }

}
