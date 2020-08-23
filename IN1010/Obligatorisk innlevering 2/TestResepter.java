public class TestResepter{
  public static void main(String[] args){

    PreparatA preparatA = new PreparatA("A", 100.0, 50.0, 25);
    PreparatB preparatB = new PreparatB("B", 200.0, 100.0, 50);
    PreparatC preparatC = new PreparatC("C", 250.0, 75.0);

    Lege lege = new Lege("Mehdi");

    MilitaerResepter MR = new MilitaerResepter(preparatA, lege, 0, 1);
    PResepter PR = new PResepter(preparatB, lege, 1, 3);
    BlaaResepter BR = new BlaaResepter(preparatC, lege, 2, 2);

    System.out.println("");

    // Returnerer 0.
    System.out.println(MR.hentId());
    // Returnerer A.
    System.out.println(MR.hentLegemiddel().hentNavn());
    // Returnerer Mehdi.
    System.out.println(MR.hentLege().hentNavn());
    // Returnerer 0.
    System.out.println(MR.hentPasientId());
    // Returnerer 1.
    System.out.println(MR.hentReit());
    // Returnerer true.
    System.out.println(MR.bruk());
    // Returnerer hvit.
    System.out.println(MR.farge());
    // Returnerer 0.0.
    System.out.println(MR.prisAaBetale());

    System.out.println("");

    // Returnerer 1.
    System.out.println(PR.hentId());
    // Returnerer B.
    System.out.println(PR.hentLegemiddel().hentNavn());
    // Returnerer Mehdi.
    System.out.println(PR.hentLege().hentNavn());
    // Returnerer 1.
    System.out.println(PR.hentPasientId());
    // Returnerer 3.
    System.out.println(PR.hentReit());
    // Returnerer true.
    System.out.println(PR.bruk());
    // Returnerer hvit.
    System.out.println(PR.farge());
    // Returnerer 84.0.
    System.out.println(PR.prisAaBetale());

    System.out.println("");

    // Returnerer 2.
    System.out.println(BR.hentId());
    // Returnerer C.
    System.out.println(BR.hentLegemiddel().hentNavn());
    // Returnerer Mehdi.
    System.out.println(BR.hentLege().hentNavn());
    // Returnerer 2.
    System.out.println(BR.hentPasientId());
    // Returnerer 2.
    System.out.println(BR.hentReit());
    // Returnerer true.
    System.out.println(BR.bruk());
    // Returnerer blaa.
    System.out.println(BR.farge());
    // Returnerer 62.5.
    System.out.println(BR.prisAaBetale());

  }
}
