import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/* Proveeksamen 2004 - Arne Maus
   Finner alle forekomster av et ord ut fra en riktig
   startsbokstav, men dobbeltrapporterer anagrammer.
   Arne Maus.
 */

class Ordkryss {

    char [][] ordene ={{'H','A','B','D'},
                       {'M','V','Q','K'},
                       {'P','L','U','G'},
                       {'A','S','R','D'}};
    int n = 4;
    char [] sokeOrd;
    int  [] sporRad = new int [n*n];
    int  [] sporKol = new int [n*n];
    boolean funnet = false;


	public static void main (String [] args) {
		new Ordkryss ().startSok();
	}

	void startSok () {
		String ord = JOptionPane.showInputDialog(null,
		          		"Skriv soketekst:");

		     while ( ord != null && ord.length() > 0) {

			    for (int r = 0; r < n; r++)
					for ( int k =0; k < n; k++)
						 let (ord,r,k,0);

				if ( !funnet) System.out.println("\nFant IKKE :" + ord);
			    funnet = false;
				ord = JOptionPane.showInputDialog(null,
		          		"Skriv nytt soketekst:");
			} // end while

        System.exit(0);
	} // end startSok

	void skrivUt(String ord) {
		System.out.println("\nFant :" + ord + " på plasser:");
	     for (int i = 0; i < ord.length(); i++)
				 System.out.println(sporRad[i] + "," + sporKol[i]);
	    funnet = true;
	}

	void let(String ord, int r, int k, int i) {
		if ( r >= 0 && r <n && k >=0 && k< n &&	ordene [r][k] == ord.charAt(i)) {
		   sporRad [i] = r; sporKol[i] = k;

		   if (i == ord.length() -1 )
		       skrivUt(ord);
		   else {
			    ordene[r][k]= ' ';  // sikrer at vi ikke går i lokke
				for (int k1 = -1; k1 < 2; k1++)
				   for (int r1 = -1; r1 < 2; r1++)
						if ( r1 != 0 || k1 != 0)
							let(ord,r+r1,k+k1,i+1);

				ordene[r][k] = ord.charAt(i);
			}
		 }

	  }// end let(..)

	} // end class Ordkryss
