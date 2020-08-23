import java.io.*;
import java.util.*;

class CDAlbum implements Comparable<CDAlbum>{

String artistnavn;
String albumnavn;
String utgivelsesaar;

  public CDAlbum(String artistnavn, String albumnavn, String utgivelsesaar){
    this.artistnavn = artistnavn;
    this.albumnavn = albumnavn;
    this.utgivelsesaar = utgivelsesaar;
  }

  public String hentArtistnavn(){
    return artistnavn;
  }

  @Override public String toString(){
    return artistnavn + " " + albumnavn + " " + utgivelsesaar + ".";
  }

  public int compareTo(CDAlbum cdalbum){
    if (cdalbum.hentArtistnavn().compareTo(artistnavn) > 0){
      return 1;
    } else if (cdalbum.hentArtistnavn().compareTo(artistnavn) < 0){
      return -1;
    } else{
      return 0;
    }
  }

}

class CDSamling {
    public static void main(String[] args) {

        ArrayList<CDAlbum> cdsamling = lesOgSorter(args[0]);

        for (CDAlbum a : cdsamling) {
            System.out.println(a);
        }

        skrivTilFil(cdsamling, args[1]);
    }

    public static ArrayList<CDAlbum> lesOgSorter(String filnavn) {

        File f = new File(filnavn);
        Scanner fscan = null;
        try {
            fscan = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen!");
            return null;
        }

        ArrayList<CDAlbum> liste = new ArrayList<CDAlbum>();

        while (fscan.hasNextLine()) {
            String[] linje = fscan.nextLine().split(",");

            CDAlbum nytt = new CDAlbum(linje[0], linje[1], linje[2]);

            boolean sattInn = false;
            int teller = 0;

            while (teller < liste.size() && !sattInn) {
                if (nytt.compareTo(liste.get(teller)) < 0) {
                    liste.add(teller, nytt);
                    sattInn = true;
                }
                teller++;
            }

            if (!sattInn) {
                liste.add(nytt);
            }
        }
        return liste;
    }

    public static void skrivTilFil(ArrayList<CDAlbum> liste, String utfil) {

        File f = new File(utfil);
        try {
        PrintWriter pw = new PrintWriter(f);

        for (CDAlbum cd : liste) {
            pw.append(cd.toString()+ "\n");
        }
        pw.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
