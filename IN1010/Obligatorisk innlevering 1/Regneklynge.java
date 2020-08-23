import java.util.*;
import java.io.*;

public class Regneklynge{

  ArrayList<Rack> regneklynge = new ArrayList<Rack>();
  int noderPerRack;

  public Regneklynge(String filnavn){
    Scanner innFil = null;
    try{
      File fil = new File(filnavn);
      innFil = new Scanner(fil);
    }
    catch(FileNotFoundException e){
      System.out.print("Kunne ikke åpne filen.");
      System.exit(0);
    }

    noderPerRack = innFil.nextInt();

    while (innFil.hasNextInt()){
      int antall = innFil.nextInt();
      int minne = innFil.nextInt();
      int processorer = innFil.nextInt();
      for(int i = 0; i < antall; i++){
      settInnNode(new Node(minne, processorer));
      }
    }
  }

  void settInnNode(Node node){
    Rack nyttRack = new Rack();
    if (antRacks() == 0){
      regneklynge.add(nyttRack);
    }
    Rack lastRack = regneklynge.get(regneklynge.size() - 1);
    if (lastRack.getAntNoder() == noderPerRack){
      regneklynge.add(nyttRack);
      nyttRack.settInn(node);
    }
    else if (lastRack.getAntNoder() < noderPerRack){
      lastRack.settInn(node);
    }
    else if (lastRack.getAntNoder() > noderPerRack){
      regneklynge.add(nyttRack);
      lastRack.settInn(node);
    }
  }

  int antProsessorer(){
    int antallProcessorer = 0;
    for (Rack rack : regneklynge){
      antallProcessorer += rack.antProsessorer();
    }
    return antallProcessorer;
  }

  int noderMedNokMinne(int paakrevdMinne){
    int noderMedNokMinne = 0;
    for (Rack rack : regneklynge){
      noderMedNokMinne += rack.noderMedNokMinne(paakrevdMinne);
    }
    return noderMedNokMinne;
  }

  int antRacks(){
    return regneklynge.size();
  }

}
