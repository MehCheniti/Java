// My first Java program.
public class HelloPrinter
{
  public static void main(String[] args)
  {
    System.out.println("Hello, World!");

    for (int i = 0; i < args.length; i++)
    {
      System.out.println("["+i+"]: " + args[i]);
    }
  }
}
