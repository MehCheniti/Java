public class IkkeMerPlassException extends Exception{

String boktittel;

public IkkeMerPlassException(String boktittel){
  super("Det var ikke plass til å sette inn " + boktittel);
}

}
