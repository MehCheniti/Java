class MainRektangel{
  public static void main(String[] args){

    Rektangel rektangel1 = new Rektangel(10, 20);
    Rektangel rektangel2 = new Rektangel(100, 200);

    System.out.println(rektangel1.areal());
    System.out.println(rektangel2.areal());

    rektangel1.oekLengde(17);
    rektangel2.oekBredde(20);

    System.out.println(rektangel1.omkrets());
    System.out.println(rektangel2.omkrets());

  }
}
