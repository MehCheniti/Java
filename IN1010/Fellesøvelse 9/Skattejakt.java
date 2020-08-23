class Skattejakt{

int[][] kart;

  public Skattejakt(int[][] kart){
    this.kart = kart;
  }

  public String finnSkatt(){
    return finnSkatt(0, 0);
  }

  private String finnSkatt(int rad, int kolonne){
    // System.out.println(kart[rad][kolonne]);
    int heleTallet = kart[rad][kolonne];
    int tall1 = heleTallet / 10;
    int tall2 = heleTallet % 10;

    // Basistilfellet.
    if ((rad == tall1 - 1) && (kolonne == tall2 - 1)){
      return "";
    }

    return heleTallet + " -> " + finnSkatt(tall1 - 1, tall2 - 1);
  }

  public static void main(String[] args){
    // System.out.println(kart[2][3]);
    // System.out.println(34 / 10);
    // System.out.println(34 % 10);
    // System.out.println(finnSkatt(0, 0));

    int[][] kart = {{34, 21, 32, 41, 25}, {14, 42, 43, 14, 31},
    {54, 45, 52, 42, 23}, {33, 15, 51, 31, 35}, {21, 52, 33, 13, 23}};
    Skattejakt jakt = new Skattejakt(kart);
    System.out.println(jakt.finnSkatt());
  }

}
