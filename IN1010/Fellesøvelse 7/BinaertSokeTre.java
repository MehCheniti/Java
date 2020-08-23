class BinaertSokeTre{

  private class Node{

  Node hoyreBarn, venstreBarn;
  int verdi;

    public Node(int verdi){
      this.verdi = verdi;
    }

  }

private Node roten;

  public void settInn(int tall){
    if (roten == null){
      roten = new Node(tall);
    } else{
      settInn(roten, tall);
    }
  }

  private void settInn(Node gjeldende, int tall){
    if (tall < gjeldende.verdi){
      if (gjeldende.venstreBarn == null){
        gjeldende.venstreBarn = new Node(tall);
      } else{
        settInn(gjeldende.venstreBarn, tall);
      }
    } else{
      if (gjeldende.hoyreBarn == null){
        gjeldende.hoyreBarn = new Node(tall);
      } else{
        settInn(gjeldende.hoyreBarn, tall);
      }
    }
  }

  public void skrivUt(){
    skrivUt(roten);
  }

  private void skrivUt(Node gjeldende){
    if (gjeldende == null){
      return;
    }
    skrivUt(gjeldende.venstreBarn);
    System.out.println(gjeldende.verdi);
    skrivUt(gjeldende.hoyreBarn);
  }

  public int storrelse(){
    return storrelse(roten);
  }

  private int storrelse(Node gjeldende){
    if (gjeldende == null){
      return 0;
    }
    return 1 + storrelse(gjeldende.venstreBarn) +
    storrelse(gjeldende.hoyreBarn);
  }

}
