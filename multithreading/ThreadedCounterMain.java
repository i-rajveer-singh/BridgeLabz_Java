package multithreading;

import java.util.Objects;
import java.util.Scanner;

class CounterThread extends Thread{
    private int threadId;
    private int totalThread;
    private static int limit;
    private static int counter=1;
    private static final Object lock =new Object();

    public CounterThread(int ThreadId,int totalThread,int limitValue){
        this.threadId=ThreadId;
        this.totalThread=totalThread;
        limit=limitValue;

    }

    @Override
    public void run(){
        while(true){
            synchronized (lock){
              if(counter>limit){
                  lock.notifyAll();
                  break;
              }

              if((counter-1)%totalThread==threadId){
                  System.out.println("Thread- "+threadId+" : "+counter);
                  counter++;
                  lock.notifyAll();
              }else{
                  try{
                      lock.wait();
                  }catch (InterruptedException e){
                      System.out.println("Thread interrupted");
                  }
              }
            }
        }
    }
}
public class ThreadedCounterMain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        try{
            System.out.println("Enter counting limit: ");
            int limit=scanner.nextInt();

            if(limit<=0){
                System.out.println("Invalid integer");
                return;
            }

            int numberOfThread=3;
            CounterThread[] threads=new CounterThread[numberOfThread];

            for(int i=0;i<numberOfThread;i++){
                threads[i]=new CounterThread(i,numberOfThread,limit);
                threads[i].start();
            }

            for(int i=0;i<numberOfThread;i++){
                threads[i].join();
            }

            System.out.println("Counting completed");
        }catch (Exception e){
            System.out.println("Invalid input");
        }finally {
            scanner.close();
        }


    }
}
