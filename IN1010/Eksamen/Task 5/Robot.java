public class Robot implements UserInterface{

  @Override
  public void giveStatus(String status){
    System.out.println("Robot: \t" + status);
  }

  @Override
  public int askForCommand(String question, String[] options){
    System.out.println("Robot: \t" + question);
    return ((int)(Math.random() * ((options.length - 0))));
  }

}
