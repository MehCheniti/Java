/* Forklaring paa Hanois taarn:
Regler:
	Kun 1 skive kan flyttes om gangen (og man kan kun ta fra toppen).
	Ingen skiver kan ligge oppaa en mindre skive
Skivene nummereres fra 1 (den minste og øverste) til n (den største i bunnen)
For å flytte n antall skiver fra A til C:
	Flytt n−1 skiver fra A til B. Dette etterlater skive #n alene på A
	Flytt skive #n fra A til C
	Flytt n−1 skiver fra B til C slik at de plasseres på skive #n (Wikipedia)
Eksempel ved 5 skiver (altsaa hoyde 5 paa taarnet)
Start:
		    x          |          |
		   xxx         |          |
		  xxxxx        |          |
		 xxxxxxx       |          |
		xxxxxxxxx      |          |
Slutt:
			|          |          x
			|          |         xxx
			|          |        xxxxx
			|          |       xxxxxxx
			|          |      xxxxxxxxx
NB! Kun 1 disk kan flyttes om gangen!
*/

public class Spillsett {
	private Pinne pinne1;
	private Pinne pinne2;
	private Pinne pinne3;

	private int hoyde;

	public Spillsett(int hoyde) {
		this.hoyde = hoyde;

		pinne1 = new Pinne(hoyde);
		pinne2 = new Pinne(hoyde);
		pinne3 = new Pinne(hoyde);
	}

	/* main tar inn argumentet oppgitt og lager et nytt spillsett,
	videre initialiseres spillsettet, deretter kalles metoden som loser brettet,
	altsaa losOgVis */
	public static void main(String[] args) {
		try {
			Spillsett sp = new Spillsett(Integer.parseInt(args[0]));

			sp.initialiser();
			sp.losOgVis();

		} catch (NumberFormatException e) {
			System.out.println("Skriv et gydlig tall!");

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Oppgi hoyde paa taarn som parameter!");
		}
	}

	/* initialiser lager antall disker, minste disken er 1, nestminst 3, osv.
	lager antall disker som er oppgitt som argument */
	public void initialiser() {
		for (int i=hoyde; i>0; i--) {
			pinne1.leggPaaDisk(2*i-1);
		}
	}

	/* losOgVis kaller paa flyttTaarn med hoyden og alle tre pinnene fra
	begynnelsen av fordi vi vet at disken som ligger overst har antall disker lik
	hoyden paa taarnet */
	public void losOgVis() {
		flyttTaarn(hoyde, pinne1, pinne3, pinne2);
	}

	/* flytt sier hvilken pinne en disk skal tas av fra og flyttes til */
	private void flytt(Pinne fra, Pinne til) {
		til.leggPaaDisk(fra.taAvDisk());
	}


	/* Vaar rekursive flyttTaarn-metode */
	private void flyttTaarn(int n, Pinne fra, Pinne til, Pinne mellom) {
		/* dersom det er den minste saa flyttes den direkte */
		if (n == 1) {
			flytt(fra, til);
			//kaller print etter flytt
			statusPrint();
		} else {
		/* ellers kaller paa seg selv med n-1, som videre vil kalle paa seg selv med n-1,
		og fra-pinne er fortsatt fra, men mellom-pinnen er blitt til-pinne, og til-pinne
		er blitt mellom.
		Gjores helt til n-1 er lik 1 og if-testen slaar til */
			flyttTaarn(n-1, fra, mellom, til);

			/* deretter flyttes den fra fra-pinne til til-pinne */
			flytt(fra, til);
			//kaller print etter flytt
			statusPrint();

			/* deretter kalles flytt igjen med n-1, og fra-pinne er blitt mellom, til er
			fortsat til (dit alle skal til slutt), og fra er mellom */
			flyttTaarn(n-1, mellom, til, fra);
		}
	}


	/* denne metoden gjor slik at det ser ut som om taarnene faktisk endrer seg,
	uten denne ser man tydelig at hver flytting gir en ny utskrift. Disse to linjene
	med kode "clearer" skjermen og flytter markoeren til den foerste raden, foerste
	kolonne. Det skal fungere i de fleste UNIX terminaler/alle terminaler som stotter
	ANSI escape codes.
	NB Dette er ikke en del av inf1010-pensumet */
	private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	/* printer ut i et halvt sekund slik at vi rekker aa see, kaller paa print av this,
	da gaar den til toString-metoden */
	private void statusPrint() {
		clearScreen();

		System.out.println(this);
		/* kaller sleep med et halvt sekund slik at vi rekker aa se utskriften
		foer neste utskrift kommer */
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
	}

	/* toString-metode om printer ut taarnene rad for rad */
	public String toString() {
		String result = "";

		for (int i=hoyde-1; i>=0; i--) {
			result += pinne1.hentRad(i) + "  " + pinne2.hentRad(i) + "  " + pinne3.hentRad(i) + "\n";
		}

		return result;
	}
}
