abstract class Dyr{

  public void lagLyd(){
  }

}

class Hund extends Dyr{
  @Override public void lagLyd(){
    System.out.println("Voff!");
  }
}

class Katt extends Dyr{
  @Override public void lagLyd(){
    System.out.println("Mjau!");
  }
}
