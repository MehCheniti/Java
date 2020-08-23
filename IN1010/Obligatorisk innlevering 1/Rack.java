import java.util.*;

public class Rack{

  ArrayList<Node> rack = new ArrayList<Node>();

  void settInn(Node node){
    rack.add(node);
  }

  int getAntNoder(){
    return rack.size();
  }

  int antProsessorer(){
    int antalProcessorer = 0;
    for (Node node : rack){
      antalProcessorer += node.antProsessorer();
    }
    return antalProcessorer;
  }

  int noderMedNokMinne(int paakrevdMinne){
    int noderMedNokMinne = 0;
    for (Node node : rack){
      if (node.nokMinne(paakrevdMinne)){
        noderMedNokMinne += 1;
      }
    }
    return noderMedNokMinne;
  }

}
