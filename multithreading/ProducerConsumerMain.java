package multithreading;

import java.util.LinkedList;
import java.util.Queue;

class SharedQueue{
    private Queue<Integer> queue=new LinkedList<>();
    private int capacity;

    public SharedQueue(int capacity){
        this.capacity=capacity;
    }

    public synchronized void produce(int value) throws InterruptedException{
        while(queue.size() == capacity){
            wait();
        }

        queue.add(value);
        System.out.println("Produced: "+value);

        notifyAll();
    }
    public synchronized int consume() throws InterruptedException{
        while(queue.isEmpty()){
            wait();
        }

        int value=queue.poll();
        System.out.println("Consumed: "+value);

        notifyAll();

        return value;
    }

}

class Producer extends Thread{
    private SharedQueue sharedQueue;

    public Producer(SharedQueue sharedQueue){
        this.sharedQueue=sharedQueue;
    }

    @Override
    public void run(){
        try{
            for(int i=1;i<=10;i++){
                sharedQueue.produce(i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("Producer interrupted.");
        }
    }
}
class Consumer extends Thread{
    private SharedQueue sharedQueue;

    public Consumer(SharedQueue sharedQueue){
        this.sharedQueue=sharedQueue;
    }

    @Override
    public void run(){
        try{
            for(int i=1;i<=10;i++){
                sharedQueue.consume();
                Thread.sleep(800);
            }
        }catch(InterruptedException e){
            System.out.println("Consumer interrupted");
        }
    }
}


public class ProducerConsumerMain {
    public static void main(String[] args) {
        try{
            SharedQueue sharedQueue=new SharedQueue(5);

            Producer producer=new Producer(sharedQueue);
            Consumer counsumer=new Consumer(sharedQueue);

            producer.start();
            counsumer.start();

            producer.join();
            counsumer.join();

            System.out.println("Processing completed successfully");
        }catch (Exception e){
            System.out.println("Unexpected error occurred");
        }
    }
}
