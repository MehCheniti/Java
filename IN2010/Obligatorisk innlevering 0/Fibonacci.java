// Oppgave 1 - en ineffektiv algoritme (PDF følger med)

class Fibonacci{

  public static void main(String[] args){
    Fibonacci f = new Fibonacci();
    long argument = Integer.parseInt(args[0]);

    if (argument < 0) argument = 0;

    System.out.println("f(" + argument + ") = " + f.fibonacci(argument) + ".");
  }

  long fibonacci(long n){
    if (n <= 1){
      return n;
    } else{
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

// Oppgave 2 - pseudokode

static int arrayFind(int x, int liste[]){
  int i = 0;

  for (int j = 0; j < liste.length; j++){
    while (i < j){
      if (x == liste[j]){
        return j;
      } else{
        j++;
      }
    }
  }

  return -1;
}

// Oppgave 3 - finne delliste med største sum

  static int findMaxSub(int liste[]){
    int max = 0;
    int max2 = 0;

    for (int i = 0; i < liste.length; i++){
      max2 = max2 + liste[i];
      if (max2 < 0){
        max2 = 0;
      } else if (max < max2){
        max = max2;
      }
    }

    return max;
  }

}

// Oppgave 4 - lag en oppgave selv

// Flervalgsprøve: velg minst et riktig svar.

// 1) En binær heap er:
// a) - Et mengde binære nummere.
// b) - En innsamling av tupler.
// c) - Et binærtre med et strukturkrav.

// 2) Hva har en graf G = (V, E)?
// a) - En mengde noder E, og en mengde kanter V.
// b) - Et grafisk JavaFX design.
// d) - En mengde noder V, og en mengde kanter E.

// 3) Djikstras algoritme er:
// a) - en algoritme for å finne korteste sum i en graf.
// b) - en algoritme for å finne korteste vei i en graf.
// c) - en algoritme for å finne korteste kjøretid i en graf.
