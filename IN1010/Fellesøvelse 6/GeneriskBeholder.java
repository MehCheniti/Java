public class GeneriskBeholder<T>{

private T[] innhold;
private int ant;

  @SuppressWarnings("unchecked") public GeneriskBeholder(int storrelse){
    // innhold = new T[storrelse];
    innhold = (T[]) new Object[storrelse];
    ant = 0;
    System.out.println("Lagd beholder!");
  }

  public boolean settInn(T elem){
    int plassKandidat = -1;
    for (int i = 0; i < innhold.length; i++){
      if (innhold[i] == null && plassKandidat == -1){
        plassKandidat = i;
      }
      if (elem.equals(innhold[i])){
        return false;
      }
    }
    if (plassKandidat > -1){
      innhold[plassKandidat] = elem;
      ant++;
      return true;
    }
    return false;
  }

  public void skrivAlle(){
    for (T elem : innhold){
      System.out.println(elem);
    }
  }

  public void skrivUtenNull(){
    for (T elem : innhold){
      if (elem != null){
        System.out.println(elem);
      }
    }
  }

  public boolean fjern(T skalFjernes){
    for (int i = 0; i < innhold.length; i++){
      if (innhold[i].equals(skalFjernes)){
        innhold[i] = null;
        ant--;
        return true;
      }
    }
    return false;
  }

  public boolean fjern(int index){
    if (index >= 0 && index < innhold.length && innhold[index] != null){
      innhold[index] = null;
      ant--;
      return true;
    }
    return false;
  }

}
