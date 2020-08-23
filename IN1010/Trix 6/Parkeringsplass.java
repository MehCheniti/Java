public class Parkeringsplass<T>{

private T[] innhold;
private int ant;

  @SuppressWarnings("unchecked") public Parkeringsplass(int storrelse){
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

}
