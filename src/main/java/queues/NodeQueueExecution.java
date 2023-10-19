package queues;

public class NodeQueueExecution {
    public static void main(String[] args) {
        NodeQueue myQueue = new NodeQueue(2);

        System.out.println("Before enqueue():");
        System.out.println("--------------");
        myQueue.printAll();

        myQueue.enqueue(1);

        System.out.println("\n\nAfter enqueue():");
        System.out.println("-------------");
        myQueue.printAll();

        myQueue.enqueue(33);

        System.out.println("\n\nAfter enqueue():");
        System.out.println("-------------");
        myQueue.printAll();

        myQueue.deQueue();

        System.out.println("\n\nAfter dequeue():");
        System.out.println("-------------");
        myQueue.printAll();

    }
}
