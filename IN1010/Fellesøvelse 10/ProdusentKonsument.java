class ProdusentKonsument{

  public static void main(String[] args){
    int antallKlippere = 4;
    int antallSyersker = 3;

    int kapasitet = 2;
    int maal = 12;

    int klippemaal = maal / antallKlippere;
    int syMaal = maal / antallSyersker;

    Samlebaand baand = new Samlebaand(kapasitet);
    Runnable klippejobb = new KlippTil(baand, klippemaal);
    Runnable syJobb = new SySammen(baand, syMaal);

    for (int i = 0; i < antallKlippere; i++){
      Thread klipper = new Thread(klippejobb);
      klipper.start();
    }

    for (int i = 0; i < antallSyersker; i++){
      new Thread(syJobb).start();
    }
  }

}
