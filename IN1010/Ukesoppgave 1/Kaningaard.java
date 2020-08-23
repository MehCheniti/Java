import java.util.Arrays;
class Kaningaard{

  private Kanin[] kaniner = new Kanin[100];

  public boolean full(){
    for (int i = 0; i < kaniner.length; i++){
      if (kaniner[i] == null){
        return false;
      }
    }
    return true;
  }

  public boolean tom(){
    for (int i = 0; i < kaniner.length; i++){
      if (kaniner[i] == null){
        return true;
      }
    }
    return false;
  }

  public void finnEn(String navn){
    for (int i = 0; i < kaniner.length; i++){
      if (navn == kaniner[i].hentNavn()){
        System.out.println("Kaninen " + navn + " finnes.");
        break;
      }
      else if (kaniner[i] == null){
        System.out.println("Kaninen finnes ikke.");
        break;
      }
    }
  }

  public void settInn(Kanin kanin){
    for (int i = 0; i < kaniner.length; i++){
      if (kaniner[i] == kanin){
        System.out.println("Ikke lov til å sette inn en kanin to ganger.");
        break;
      }
    }
    for (int i = 0; i < kaniner.length; i++){
      if (kaniner[i] != kanin){
        kaniner[i] = kanin;
        break;
      }
    }
  }

  public void fjern(String navn){
    for (int i = 0; i < kaniner.length; i++){
      if (navn == kaniner[i].hentNavn()){
        kaniner[i] = null;
        break;
      }
      else if (kaniner[i] == null){
        System.out.println("Kaninen du prøve å fjerne finnes ikke.");
        break;
      }
    }
  }

}
