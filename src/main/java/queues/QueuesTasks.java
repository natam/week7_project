package queues;

import java.util.ArrayList;
import java.util.Arrays;

public class QueuesTasks<T> {
    int queueLength;
    ArrayList<T> items;
    int front= -1;
    int back = -1;

    public QueuesTasks(int queueLength) {
        this.queueLength = queueLength;
        items = new ArrayList<T>();
    }

    public boolean isEmpty(){
        return (front == -1 && back==-1);
    }

    public boolean isFull(){
        return (front == 0 && back == queueLength-1);
    }

    public void anQueue(T itemValue){
        if(isFull()){
            System.out.println("Queue is full");
        }else {
            System.out.println("front: "+front+" back: "+back);
            items.add(itemValue);
            back++;
            if(front==-1){
                front=0;
            }
        }
    }

    public void deQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty. Nothing to dequeue.");
        }else {
            System.out.println("front: "+front+" back: "+back);
            if(back==0){
                back= -1;
                front = -1;
                items.clear();
            }else {
                items.remove(front);
                back--;
            }
        }
    }

    public void display(){
        if(isEmpty()) {
            System.out.println("Queue is empty.");
        }else {
            System.out.println(items);
        }
    }

    public void peak(){
        if(isEmpty()) {
            System.out.println("Queue is empty.");
        }else {
            System.out.println(items.get(front));
        }
    }

    public static void main(String[] args) {
        QueuesTasks<String> myQueue = new QueuesTasks<String>(5);
        myQueue.deQueue();
        myQueue.anQueue("String1");
        myQueue.anQueue("String2");
        myQueue.anQueue("String3");
        myQueue.anQueue("String4");
        myQueue.anQueue("String5");
        myQueue.anQueue("String6");
        myQueue.display();
        myQueue.deQueue();
        myQueue.peak();
        myQueue.display();
        myQueue.deQueue();
        myQueue.peak();
        myQueue.display();
    }
}
