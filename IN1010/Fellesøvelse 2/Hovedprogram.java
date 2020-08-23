import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hovedprogram {

    private static Scanner scanner;
    private static ArrayList<Flybillett> flybilletter;
    private static ArrayList<Avgang> avganger;
    private static ArrayList<Bagasje> bagasje;

    public static void main(String... args) {
        lesFraFiler();

        Flyplass flyplass = new Flyplass(flybilletter, avganger, bagasje);
        flyplass.foretaSjekk();
    }

    private static void lesFraFiler() {
        lesAvganger();
        lesBagasje();
        lesFlybilletter();
    }

    /**
     * Denne metoden er veldig omstendelig. Det forventes ikke at dere
     * skal alltid gjøre det like omstendelig. Mange ganger er det helt
     * greit å gjøre mange antakelser.
     */
    private static void lesAvganger() {
        String filnavn = "Filer/avganger.csv";
        try {
            scanner = new Scanner(new File(filnavn));
        }
        catch (FileNotFoundException fnfe) {
            // Hvis denne slår ut, er det på grunn av "new File(...)",
            // ikke "new Scanner(...)"
            System.out.println("Kunne ikke lese fil ...  ");
            return;
        }
        // Deklarerer variabler som skal brukes mange ganger.
        String[] split;
        String fra = "Oslo lufthavn";
        String tid, til, ruteNummer, flyselskap, gate, status;
        // Fordi java er litt teit og klager på
        // "might not have been initialized"
        // Se hva som skjer hvis du kommentere vekk linjene under.
        gate = null;
        status = null;

        avganger = new ArrayList<>();

        // Leser første linje, som er en overskrift.
        String line = scanner.nextLine();

        while (scanner.hasNextLine()) {
            // Alt dette vet vi fra hvordan filen ser ut.
            line = scanner.nextLine();
            split = line.split(";");
            tid = split[0];
            til = split[1];
            ruteNummer = split[2];
            flyselskap = split[3];
            try {
                gate = split[4];
                status = split[5];
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                // Det er ikke alle som har gate og status.
                // De blir bare null, og det er greit.
                // Vi henter ut index i meldingen til unntaket.
                // Da får vi vite hvilken index den ikke klarte
                // å lese.
                int index = Integer.parseInt(aioobe.getMessage());
                if (index == 4) {
                    gate = null;
                } else if (index == 5) {
                    status = null;
                } else {
                    // Hvis ikke det er 4 eller 5, kaster vi den videre,
                    // for da er det noe annet galt.
                    throw aioobe;
                }
            }
            // Litt forenkling
            tid = "2019-02-05 " + tid;
            avganger.add(new Avgang(fra, til, tid, gate));
        }
    }

    private static void lesBagasje() {
        String filnavn = "Filer/bagasje.csv";
        try {
            scanner = new Scanner(new File(filnavn));
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("Kunne ikke lese fil ...  ");
            return;
        }
        // Deklarerer variabler som skal brukes mange ganger.
        String[] split;
        Double vekt;
        int avgangIdx;
        bagasje = new ArrayList<>();

        // Leser første linje, som er en overskrift.
        String line = scanner.nextLine();

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            split = line.split(";");
            vekt = Double.parseDouble(split[0]);
            avgangIdx = Integer.parseInt(split[1]);
            Avgang avgang = avganger.get(avgangIdx);
            // Antar at all bagasje over 20 kg er overvekt.
            if (vekt > 20) {
                bagasje.add(new Overvektsbagasje(vekt, avgang));
            }
            // Her kunne vi håndtert spesialbagasje også.
            else {
                bagasje.add(new Bagasje(vekt, avgang));
            }
        }
    }

    private static void lesFlybilletter() {
        String filnavn = "Filer/flybilletter.csv";
        try {
            scanner = new Scanner(new File(filnavn));
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("Kunne ikke lese fil ...  ");
            return;
        }
        // Deklarerer variabler som skal brukes mange ganger.
        String[] split;
        String sete;
        int avgangIdx;
        flybilletter = new ArrayList<>();

        // Leser første linje, som er en overskrift.
        String line = scanner.nextLine();

        // Litt forenkling
        String[] innenlandsArray = {
            "Trondheim", "Bergen", "Kristiansand", "Alta", "Tromsø", "Sta"
        };
        List<String> innenlands = Arrays.asList(innenlandsArray);

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            split = line.split(";");
            sete = split[0];
            avgangIdx = Integer.parseInt(split[1]);
            Avgang avgang = avganger.get(avgangIdx);
            String destinasjon = avgang.hentDestinasjon();

            if (innenlands.contains(destinasjon)) {
                // Forenkling
                if (sete.endsWith("A")) {
                    flybilletter.add(new Alenereisebillett(sete, avgang, "Fredrik"));
                } else {
                    flybilletter.add(new Innenlandsbillett(sete, avgang));
                }
            }
            else {
                flybilletter.add(new Utenlandsbillett(sete, avgang));
            }
        }
    }

}
