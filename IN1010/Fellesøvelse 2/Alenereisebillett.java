public class Alenereisebillett extends Innenlandsbillett{

    private String ledsager;

    public Alenereisebillett(String sete, Avgang avgang, String ledsager){
        super(sete, avgang);
        this.ledsager = ledsager;
    }

    public String hentLedsager() {
        return ledsager;
    }
    
}
