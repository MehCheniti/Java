import java.util.Scanner;
import java.io.*;

class Gruppeoppmoete {
    private String[] navn = new String[14];
    private boolean[] oppmoete = new boolean[14];
    int teller = 0;

    public void fill() throws Exception{
        Scanner fil = new Scanner(new File("gruppeliste.txt"));
      while (fil.hasNextLine()){
        navn[teller] = fil.nextLine();
        teller++;
        }
    }

    public void oppmote(String studentnavn){
      for (int i = 0 ; i < teller ; i++){
        if (studentnavn.equals(navn[i])){
          oppmoete[i] = true;
        }
      }
    }

    public void skrivUt(){
      for (int i=0; i<teller; i++) {
             if (oppmoete[i]) {
                 System.out.println(navn[i] + " har moett.");
             } else {
                 System.out.println(navn[i] + " har IKKE moett");
             }
    }
}
}
