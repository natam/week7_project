public class RequestToBorrow {
    int id;
    Member requester;
    Book requestedBook;

    public RequestToBorrow(int id, Member requester, Book requestedBook) {
        this.id = id;
        this.requester = requester;
        this.requestedBook = requestedBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getRequester() {
        return requester;
    }

    public void setRequester(Member requester) {
        this.requester = requester;
    }

    public Book getRequestedBook() {
        return requestedBook;
    }

    public void setRequestedBook(Book requestedBook) {
        this.requestedBook = requestedBook;
    }
}
