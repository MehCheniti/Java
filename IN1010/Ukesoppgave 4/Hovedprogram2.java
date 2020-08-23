public class Hovedprogram2{

  public static void main(String[] args){
    Person person1 = new Person();
    Person person2 = new Student();
    Person person3 = new Person();

    person1.registrerPerson("Mehdi");
    person2.registrerPerson("Mehdi2", "17");
    person3.registrerPerson("Mehdi3");

    person1.skrivPerson();
    person2.skrivPerson();
    person3.skrivPerson();
  }

}
