import java.io.File;

public class Filtre{

String filbane;

    public Filtre(String filbane){
      this.filbane = filbane;
    }

    public void visTre(File mappe, String prefiks){
      File[] innhold = mappe.listFiles();

      for(File fil : innhold){
        if (fil.isDirectory()){
          System.out.println(prefiks + fil.getName() + "/");
          visTre(fil, " " + prefiks);
        } else{
          System.out.println(prefiks + fil.getName());
        }
      }
      return;
    }

    public void visTre(){
      visTre(new File(filbane), "");
    }

    public static void main(String[] args){
      // Filtre treet = new Filtre(System.getProperty("user.dir"));
      Filtre treet = new Filtre(System.getProperty("user.dir") + "/../");
      treet.visTre();
    }

}
