package queues;

public class NodeQueue {
    private Node first;
    private Node last;

    private int length = 0;

    public NodeQueue(int value){
        Node newNode = new Node(value);
        first=newNode;
        last=newNode;
        length++;
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length>0 && last!=null){
            last.setNext(newNode);
            last = newNode;
        }else if(length==0 && last==null && first == null){
            first=newNode;
            last=newNode;
        }
        length++;
    }

    public void deQueue(){
        if(length!=0 && first!=null){
            Node temp = first.getNext();
            first = temp;
        }
    }

    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }


    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
