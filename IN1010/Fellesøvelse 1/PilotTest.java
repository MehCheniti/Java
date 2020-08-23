public class PilotTest{

  public static void main(String[] args){
    Pilot kristine = new Pilot("Kristine");
    Pilot gaute = new Pilot("Gaute");

    System.out.println(kristine.hentNavn());
    System.out.println(gaute.hentNavn());

    Pilot[] piloter = new Pilot[2];

    gaute.leggTilFlyvning(150);
    gaute.leggTilFlyvning(200);

    piloter[0] = kristine;
    piloter[1] = gaute;

    kristine.leggTilFlyvning(150);
    kristine.leggTilFlyvning(650);
    kristine.leggTilFlyvning(720);

    System.out.println("Kristines antall turer: " + kristine.hentAntallTurer() +
    ".");
    System.out.println("Gautes antall turer: " + gaute.hentAntallTurer() + ".");

    System.out.println("Kristines totale distanse: " +
    kristine.hentTotalDistanse() + ".");
    System.out.println("Gautes totale distanse: " + gaute.hentTotalDistanse() +
    ".");

    double kristineSnitt = kristine.hentGjenomsnittligDistanse();
    double gauteSnitt = gaute.hentGjenomsnittligDistanse();

    double totaltSnitt = (kristineSnitt + gauteSnitt) / 2;
    System.out.println("Totalt snitt: " + totaltSnitt);
  }

}
