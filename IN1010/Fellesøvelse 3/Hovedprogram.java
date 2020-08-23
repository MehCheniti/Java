class Hovedprogram{

public static void main(String[] args){
  Emne emne1 = new Emne("IN1010", "OOP: Java", false);
  Emne emne2 = new Emne("IN5010", "Masterkos", true);
  //System.out.println(emne1);
  //Student stud = new Student("Kari", 20);

  Person rektor = new Person("Rolf", 17);
  Masterstudent master = new Masterstudent("Daniel", 24, rektor);
  Bachelorstudent bach = new Bachelorstudent("Kai", 25);

  bach.registrer(emne2);

  System.out.println(rektor);
  System.out.println(master);

  Masterstudent masterstud = (Masterstudent) master;

  masterstud.registrer(emne1);

  Student pers1 = (Masterstudent) masterstud;

  //ma.registrer(emne1);
  //System.out.println(ma);
}

}
