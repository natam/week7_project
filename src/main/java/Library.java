import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private HashSet<Member> members = new HashSet<>();
    HashMap<Integer, Book> bookMap = new HashMap<>();
    private HashSet<Book> favoriteBooks = new HashSet<>();

    public void addBook(Book newBook) {
        if(!books.contains(newBook)){
            books.add(newBook);

        }
        if(!bookMap.containsKey(newBook.getId())){
            bookMap.put(newBook.getId(), newBook);
        }
    }

    public Book findBookById(int id){
        return bookMap.get(id);
    }

    public void addMember(Member newMember) {
        members.add(newMember);
    }

    public Book findBook(Book bookToFind) {
        if (books.contains(bookToFind)) {
            for (Book book : books) {
                if (book.getIsbn().equals(bookToFind.getIsbn())) {
                    return book;
                }
            }
        }
        return null;
    }

    public Member findMember(Member memberToFind) {
        if (members.contains(memberToFind)) {
            for (Member member : members) {
                if (member.getName().equals(memberToFind.getName())) {
                    return member;
                }
            }
        }
        return null;
    }

    public void deleteMember(Member member) {
        members.remove(member);
    }

    public void deleteBook(Book book) {
        books.remove(book);
        bookMap.remove(book.getId());
        removeBookFromFavorites(book);
    }

    public void addBookToFavorites(Book book){
        favoriteBooks.add(book);
    }

    public void removeBookFromFavorites(Book book){
        favoriteBooks.remove(book);
    }

    public void searchBooksByAuthor(String authorName){
        List<Book> foundBooks = books.stream().filter(book -> book.getAuthor().equals(authorName)).toList();
        System.out.println("By your search query found " + foundBooks.size() + " results:");
        for (Book book: foundBooks){
            System.out.println(book.getTitle());
        }
    }

    public void searchBooksByTitle(String title){
        List<Book> foundBooks = books.stream().filter(book -> book.getTitle().equals(title)).toList();
        System.out.println("By your search query found " + foundBooks.size() + " results:");
        for (Book book: foundBooks){
            System.out.println(book.getTitle());
        }
    }

    public void updateBook(Book oldBook, Book newBook) {
        deleteBook(oldBook);
        addBook(newBook);
    }

    public void updateMember(Member oldMember, Member newMember) {
        deleteMember(oldMember);
        addMember(newMember);
    }

    public void displayBooks(){
        System.out.println("All books");
        for (Book book: books) {
            book.displayBook();
        }
    }

    public void displayFavorites(){
        System.out.println("Favorites");
        for (Book book: favoriteBooks) {
            book.displayBook();
        }
    }

}
