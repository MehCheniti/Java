import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class Samlebaand{

int kapasitet;
int antallPlagg;
Lock laas = new ReentrantLock();
Condition ikkeTomt = laas.newCondition();
Condition ikkeFullt = laas.newCondition();

    public Samlebaand(int kapasitet){
        this.kapasitet = kapasitet;
        antallPlagg = 0;
    }

    public void taAvBaand(){
      laas.lock();

      try{
        while (antallPlagg == 0){
          ikkeTomt.await();
        }
        antallPlagg--;
        ikkeFullt.signalAll();

        // Skje ting.

      } catch (InterruptedException e){

      } finally{
        laas.unlock();
      }
    }

    public void leggPaaBaand(){
      laas.lock();

      try{
        while (antallPlagg == kapasitet){
          ikkeFullt.await();
        }
        antallPlagg++;
        ikkeTomt.signalAll();

        // Skje ting.
        
      } catch (InterruptedException e){

      } finally{
        laas.unlock();
      }
    }

}
