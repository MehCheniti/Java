public class Pinne {
	private int hoyde;
	private int[] disker;

	private int indeks;

	/* hoyde sier hvor mange disker det er */
	public Pinne(int hoyde) {
		this.hoyde = hoyde;
		disker = new int[hoyde];
	}

	/* legger paa disk, legger paa paa toppen */
	public void leggPaaDisk(int bredde) {
		disker[indeks] = bredde;
		indeks++;
	}

	/* tar av disk paa toppen og returnerer verdien til disken som er breddeverdien */
	public int taAvDisk() {
		indeks--;
		int temp = disker[indeks];
		disker[indeks] = 0;
		return temp;
	}

	/* returnerer true dersom det er 1 disk igjen paa pinnen, brukes ikke?
	public boolean enDiskIgjen() {
		return indeks == 1;
	} */

	/* henter rad paa pinnen, brukes av tooString-metoden i spillsett */
	public String hentRad(int radnummer) {
		/* bredde, regnes ut basert paa den bredeste skiven som er dobbelt saa bred
		som hoyden -1 */
		int totalBredde = 2*hoyde - 1;
		/* slack sier hvor mye mellomrom det skal vaere */
		int slack = totalBredde - disker[radnummer];

		/* resultatstringen som returneres */
		String result = "";

		/* finner ut hvor mange mellomrom foran x'ene det skal vaere*/
		for (int i=0; i<slack/2; i++) result += " ";

		/* hvis det er ingen disker skal det vaere en | midt i */
		if  (disker[radnummer] == 0) result += "|";

		/* finner ut hvor mange x'er det skal vaere basert paa diskens bredde */
		for (int i=0; i<disker[radnummer]; i++) result += "x";

		/* finner ut hvor mange mellomrom etter x'ene det skal vaere*/
		for (int i=0; i<slack/2; i++) result += " ";

		return result;
	}
}
