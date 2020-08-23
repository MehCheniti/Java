public class DuplikatException extends Exception{

String boktittel;

public DuplikatException(String boktittel){
  super(boktittel + " er en duplikat.");
}

}
