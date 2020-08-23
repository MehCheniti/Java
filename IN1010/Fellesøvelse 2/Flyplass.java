import java.util.List;

public class Flyplass {

    List<Flybillett> flybilletter;
    List<Avgang> avganger;
    List<Bagasje> bagasje;

    public Flyplass(List<Flybillett> flybilletter,
                    List<Avgang> avganger,
                    List<Bagasje> bagasje) {
        this.flybilletter = flybilletter;
        this.avganger = avganger;
        this.bagasje = bagasje;
    }

    public void foretaSjekk() {

        for (Flybillett billett : flybilletter) {
            sikkerhetskontroll(billett);
        }

        for (Bagasje bag : bagasje) {
                bag.hentAvgang();
        }

    }

    public void sikkerhetskontroll(Flybillett billett) {
        if (billett instanceof Utenlandsbillett) {
            Utenlandsbillett utenlandsbillett = (Utenlandsbillett) billett;
            sendTilUtenlandsterminalen(utenlandsbillett);
        } else if (billett instanceof Innenlandsbillett) {
            if (billett instanceof Alenereisebillett) {
                finnLedsager((Alenereisebillett) billett);
            }
            sendTilInnenlandsterminalen((Innenlandsbillett) billett);
        }
    }

    public void sendTilUtenlandsterminalen(Utenlandsbillett uBillett) {
        System.out.println("Sender billett til utenlandsterminal");
    }

    public void sendTilInnenlandsterminalen(Innenlandsbillett iBillett) {
        System.out.println("Sender billett til innenlandsterminal");
    }

    public void finnLedsager(Alenereisebillett aBillett) {
        System.out.println("Henter ledsager ... " + aBillett.hentLedsager());
    }

    public void sendTilLostAndFound(Bagasje bagasje) {
        System.out.println("Lost and found: Bagasje på " + bagasje.hentVekt() + " kg.");
    }
}
