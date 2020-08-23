class Person{

    String navn = "ikke registrert.";
    String adresse = "ikke registrert.";

    public void registrerPerson(String n){
        navn = n;
    }

    public void registrerPerson(String n, String a){
        navn = n;
        adresse = a;
    }

    public void skrivPerson(){
        System.out.println("Navn: " + navn + ", adresse: " + adresse);
    }

}

class Student extends Person{
    String idnr = "ikke registrert.";

    @Override public void registrerPerson(String n, String i){
        navn = n;
        idnr = i;
    }

    public void registrerPerson(String n, String i, String a){
        navn = n;
        idnr = i;
        adresse = a;
    }

    @Override public void skrivPerson(){
        System.out.println("Navn: " + navn + ", studentnr: " + idnr +
        ", adresse: " + adresse);
    }

}
