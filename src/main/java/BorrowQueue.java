import java.util.Comparator;
import java.util.PriorityQueue;

public class BorrowQueue {

    private PriorityQueue<RequestToBorrow> borrowQueue = new PriorityQueue<>(Comparator.comparing(RequestToBorrow::getId));

    public PriorityQueue<RequestToBorrow> getBorrowQueue() {
        return borrowQueue;
    }

    public void setBorrowQueue(PriorityQueue<RequestToBorrow> borrowQueue) {
        this.borrowQueue = borrowQueue;
    }

    public void addRequest(RequestToBorrow request){
        if(request.getRequestedBook().isAvailable()) {
            borrowQueue.add(request);
            request.getRequestedBook().setAvailable(false);
        }else {
            System.out.println("Sorry, but requested book is not available right now.");
        }
    }

    public void processRequest(){
        borrowQueue.remove();
    }

    public void displayRequests(){
        for (RequestToBorrow request: borrowQueue) {
            System.out.println("id: "+ request.getId()+" ,member: "+ request.getRequester().getName() + " ,book: " + request.getRequestedBook().getTitle());
        }
    }

}
