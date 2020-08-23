public class Student{

  public static void main(String[] args){
  }

  private String navn;
  private int totalScore;
  private int antallQuizer;

  public Student(String navn, int totalScore, int antallQuizer){
    navn = navn;
    totalScore = totalScore;
    antallQuizer = antallQuizer;
  }

  public String getName(){
    return navn;
  }

  public int leggTilQuizScore(int score){
    totalScore += score;
    return antallQuizer + 1;
  }

  public int hentTotalScore(){
    return totalScore;
  }

  public int hentGjennomsnittligScore(){
    return totalScore / antallQuizer;
  }

}
