public class TestPreparat{
  public static void main(String[] args){

    PreparatA preparatA = new PreparatA("A", 100.0, 50.0, 25);
    PreparatB preparatB = new PreparatB("B", 200.0, 100.0, 50);
    PreparatC preparatC = new PreparatC("C", 250.0, 75.0);

    System.out.println("");

    // Returnerer 0.
    System.out.println(preparatA.hentId());
    // Returnerer A.
    System.out.println(preparatA.hentNavn());
    // Returnerer 100.0.
    System.out.println(preparatA.hentPris());
    // Returnerer 50.0.
    System.out.println(preparatA.hentVirkestoff());
    // Returnerer 25.
    System.out.println(preparatA.hentNarkotiskStyrke());
    // Bytter prisen til 150.0 og returnerer den.
    preparatA.settNyPris(150.0);
    System.out.println(preparatA.hentPris());

    System.out.println("");

    // Returnerer 1.
    System.out.println(preparatB.hentId());
    // Returnerer B.
    System.out.println(preparatB.hentNavn());
    // Returnerer 200.0.
    System.out.println(preparatB.hentPris());
    // Returnerer 100.0.
    System.out.println(preparatB.hentVirkestoff());
    // Returnerer 50.
    System.out.println(preparatB.hentVanedannendeStyrke());
    // Bytter prisen til 125.0 og returnerer den.
    preparatB.settNyPris(125.0);
    System.out.println(preparatB.hentPris());

    System.out.println("");

    // Returnerer 2.
    System.out.println(preparatC.hentId());
    // Returnerer C.
    System.out.println(preparatC.hentNavn());
    // Returnerer 250.0.
    System.out.println(preparatC.hentPris());
    // Returnerer 75.0.
    System.out.println(preparatC.hentVirkestoff());
    // Bytter prisen til 175.0 og returnerer den.
    preparatC.settNyPris(175.0);
    System.out.println(preparatC.hentPris());

  }
}
