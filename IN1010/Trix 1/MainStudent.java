public class MainStudent{
  public static void main(String[] args){
    Student joakim = new Student("Joakim", 0, 0);
    joakim.leggTilQuizScore(10);
    System.out.println(joakim.hentTotalScore());
  }
}
