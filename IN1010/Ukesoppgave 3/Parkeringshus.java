import java.util.*;
import java.io.*;

public class Parkeringshus{

  ArrayList<Kjoretoy> parkeringsplass = new ArrayList<Kjoretoy>();

  public void settIn(Kjoretoy kjoretoy){
    try{
      parkeringsplass.add(kjoretoy);
    } catch (ArrayIndexOutOfBoundsException e){
      System.out.println("Error.");
    }
  }

}
