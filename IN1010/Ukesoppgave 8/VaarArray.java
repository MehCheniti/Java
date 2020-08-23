import java.util.Iterator;

class VaarArray<T> implements Iterable<T> {
	T [] arr;


	public VaarArray(int strl) {
    	   arr = (T[]) new Object[strl];
	}

	//Finner ledig plass og setter inn. Hvis det er plass returneres true,
	//hvis det er fullt returneres false
	public boolean settInn(T elem){
    int plassKandidat = -1;

    for (int i = 0; i < arr.length; i++){
      if (arr[i] == null && plassKandidat == -1){
        plassKandidat = i;
      }
      if (elem.equals(arr[i])){
        return false;
      }
    }
    if (plassKandidat > -1){
      arr[plassKandidat] = elem;
      return true;
    }
    return false;
  }

	//Returnerer true dersom det var mulig å fjerne, false ellers.
	public boolean fjernFraIndex(T skalFjernes){
    for (int i = 0; i < arr.length; i++){
      if (arr[i].equals(skalFjernes)){
        arr[i] = null;
        return true;
      }
    }
    return false;
  }

  public Iterator<T> iterator(){
    return new ArrayIterator();
  }

	private class ArrayIterator implements Iterator<T>{
    int pos = 0;
		//variabler..?

		public boolean hasNext(){
      for(int i = pos; i < arr.length; i++){
            	if(arr[i] != null) {
                   	   return true;
            	}
        	   }
        	   return false;
    }

		public T next(){
      for(int i = pos; i < arr.length; i++){
            	if(arr[i] != null) {
                	   T returverdi = arr[i];
                	   pos ++;
                	   return returverdi;
            	}
        	    }
        	    return null;
    }
	}
}
