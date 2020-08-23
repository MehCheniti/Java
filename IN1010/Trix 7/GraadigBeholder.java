import java.util.*;

public class GraadigBeholder<T extends Comparable<T>>{

private T mittElement;

  public T settInn(T elem){
    if (mittElement == null){
      mittElement = elem;
      return null;
    } else if (elem.compareTo(mittElement) >= 0){
      T tmp = mittElement;
      mittElement = elem;
      return tmp;
    } else{
      return null;
    }
  }

}
