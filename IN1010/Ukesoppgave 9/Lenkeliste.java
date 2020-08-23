public class Lenkeliste<T> {

	Node forste;

	private class Node {
		Node neste;
		T data;
	}

	/**
	 * Legger til gitt verdi bakerst i listen.
	 *
	 * @param x Verdien som skal settes inn.
	 * @return int Posisjonen som x blir satt inn på.
	 */
	public int leggTil(T x) {
		return 0;
	}

	/**
	 * Legger til gitt verdi på gitt posisjon i listen.
	 *
	 * @param x   Verdien som skal settes inn.
	 * @param pos Posisjonen som verdien skal settes inn på.
	 * @return int Posisjonen som verdien ble satt inn på.
	 */
	public int leggTil(T x, int pos) {
		return 0;
	}

	/**
	 * Henter størrelsen på lenkelisten.
	 *
	 * @return int Størrelse på lenkelisten.
	 */
	public int storrelse() {
		return 0;
	}

	/**
	 * Overskriver verdien til elementet som ligger på gitt posisjon.
	 *
	 * @param x   Verdien som skal settes.
	 * @param pos Posisjonen på elementet som skal overskrives.
	 * @return T Verdien som ble overskrevet.
	 */
	public T sett(T x, int pos) {
		return null;
	}

	/**
	 * Henter verdien som ligger i listen på gitt posisjon.
	 *
	 * @param pos Posisjonen til verdien som skal hentes.
	 * @return T Verdien som ligger på gitt posisjon.
	 */
	public T hent(int pos) {
		return null;
	}

	/**
	 * Henter String-verdiene til elementene i listen iterativt i den rekkefølgen
	 * elementene ligger, og setter disse sammen til en String. En liste med
	 * verdiene 1 2 og 3 vil gi strengen "123".
	 *
	 * @return String Verdien av hvert element sin String-verdi slått sammen i
	 *         riktig rekkefølge.
	 *
	 */
	public String toStringForlengsIterativt() {
		return null;
	}

	/**
	 * Henter String-verdiene til elementene i listen rekursivt i den rekkefølgen
	 * elementene ligger, og setter disse sammen til en String. En liste med
	 * verdiene 1 2 og 3 vil gi strengen "123".
	 *
	 * @return String Verdien av hvert element sin String-verdi slått sammen i
	 *         riktig rekkefølge.
	 *
	 */
	public String toStringForlengsRekursivt() {
		return null;
	}

	/**
	 * Henter String-verdiene til elementene i listen iterativt i motsatt rekkefølge
	 * av slik elementene ligger, og setter disse sammen til en String. En liste med
	 * verdiene 1 2 og 3 vil gi strengen "321".
	 *
	 * @return String Verdien av hvert element sin String-verdi slått sammen i
	 *         motsatt rekkefølge.
	 *
	 */
	public String toStringBaklengsIterativt() {
		return null;
	}

	/**
	 * Henter String-verdiene til elementene i listen rekursivt i motsatt rekkefølge
	 * av slik elementene ligger, og setter disse sammen til en String. En liste med
	 * verdiene 1 2 og 3 vil gi strengen "321".
	 *
	 * @return String Verdien av hvert element sin String-verdi slått sammen i
	 *         motsatt rekkefølge.
	 *
	 */
	public String toStringBaklengsRekursivt() {
		return null;
	}

}

class Testprogram {
	public static void main(String[] args) {
		Lenkeliste<String> liste = new Lenkeliste<>();

		int intreturverdi;
		String strengreturverdi;
		intreturverdi = liste.leggTil("1");

		test("leggTil(1)", intreturverdi, 0);
		intreturverdi = liste.leggTil("2");
		test("leggTil(2)", intreturverdi, 1);
		intreturverdi = liste.leggTil("3");
		test("leggTil(3)", intreturverdi, 2);

		strengreturverdi = liste.hent(0);
		test("hent(0)", strengreturverdi, "1");
		strengreturverdi = liste.hent(1);
		test("hent(0)", strengreturverdi, "2");
		strengreturverdi = liste.hent(2);
		test("hent(0)", strengreturverdi, "3");

	}

	/**
	 * Tester om inn er det samme som forventet verdi og skriver ut info.
	 *
	 * @param beskrivelse Beskrivelse av hva testen tester.
	 * @param inn         Faktisk verdi.
	 * @param forventet   Forventet verdi.
	 * @return boolean Forventet verdi lik faktisk verdi
	 */
	static boolean test(String beskrivelse, int inn, int forventet) {
		System.out.print("TEST: " + beskrivelse + ": ");
		if (inn == forventet) {
			System.out.println("RIKTIG");
			return true;
		} else {
			System.out.println("FEIL: forventet " + forventet + ", men fikk " + inn);
			return false;
		}
	}

	/**
	 * Tester om inn er det samme som forventet verdi og skriver ut info.
	 *
	 * @param beskrivelse Beskrivelse av hva testen tester.
	 * @param inn         Faktisk verdi.
	 * @param forventet   Forventet verdi.
	 * @return boolean Forventet verdi lik faktisk verdi
	 */
	static boolean test(String beskrivelse, String inn, String forventet) {
		System.out.print("TEST: " + beskrivelse + ": ");
		if (inn.equals(forventet)) {
			System.out.println("RIKTIG");
			return true;
		} else {
			System.out.println("FEIL: forventet " + forventet + ", men fikk " + inn);
			return false;
		}
	}

}
