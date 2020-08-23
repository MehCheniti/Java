class EspressoMaskin {

    public int vanntank = 1000;

    public EspressoMaskin(int vanntank){
    vanntank = vanntank;}

    // Lag espresso dersom det er nok vann
    public void lagEspresso() {
      if (vanntank > 40){
        System.out.print("En espresso er lagd.");
      }
      vanntank -= 40;
    }

    // Lag lungo dersom det er nok vann
    public void lagLungo() {
      if (vanntank > 110){
        System.out.print("En lungo er lagd.");
      }
      vanntank -= 110;
    }

    // Fyll på et gitt antall milliliter vann, dersom det er plass
    public void fyllVann(int ml) {
      if (vanntank - ml >= ml){
        vanntank += ml;
      }
    }

    // Les av målestrekene på vanntanken og tilgjengelig vann i ml
    public int hentVannmengde() {
      return vanntank;
    }
}
