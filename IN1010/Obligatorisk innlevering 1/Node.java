public class Node{

  int minne;
  int antPros;

  public Node(int minne, int antPros){
  this.minne = minne;
  this.antPros = antPros;
  }

  int antProsessorer(){
    return antPros;
  }

  boolean nokMinne(int paakrevdMinne){
    if (minne >= paakrevdMinne){
      return true;
    }
    else{
      return false;
    }
  }

}
