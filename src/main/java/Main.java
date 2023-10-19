import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //Solution with my custom annotation
        Book myBook = new Book(1);
        myBook.setIsbn("ISBN-1-56619-909-3");
        myBook.setTitle("Book1");
        myBook.setAuthor("natallia");
        System.out.println("Has book valid isbn: " + myBook.isValid());
        System.out.println("-------------------");

        //Solution with Jakarta annotations
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        System.out.println("Book2 validation: ");
        BookWithJakartaAnnotations book2 = new BookWithJakartaAnnotations("001-56619-909-3", "bhla");
        Set<ConstraintViolation<BookWithJakartaAnnotations>> violations = validator.validate(book2);
        for (ConstraintViolation<BookWithJakartaAnnotations> violation : violations) {
            System.out.println(violation.getMessage());
        }

        System.out.println("-------------------");
        System.out.println("Book3 validation: ");
        BookWithJakartaAnnotations book3 = new BookWithJakartaAnnotations("1-56619-909-3", "info@gmail.com");
        Set<ConstraintViolation<BookWithJakartaAnnotations>> book3Violations = validator.validate(book3);
        for (ConstraintViolation<BookWithJakartaAnnotations> violation : book3Violations) {
            System.out.println(violation.getMessage());
        }
        System.out.println("-------------------");
        //Collections
        Library myLibrary = new Library();
        myLibrary.addBook(myBook);
        myLibrary.addBook(new Book("113208098", 2, "Book2", "natallia"));
        myLibrary.addBook(new Book("1643208098", 3, "Book3", "nikita"));
        Book book4 = new Book("113245398", 4, "Book4", "nikita");
        myLibrary.addBook(book4);
        myLibrary.addBook(new Book("1132058098", 5, "Book5", "dima"));
        myLibrary.addBookToFavorites(book4);
        myLibrary.addBookToFavorites(myBook);
        myLibrary.displayBooks();
        myLibrary.displayFavorites();
        myLibrary.findBookById(5).displayBook();
        myLibrary.searchBooksByAuthor("natallia");
        myLibrary.searchBooksByTitle("Book3");
        myLibrary.deleteBook(book4);
        myLibrary.displayBooks();
        myLibrary.displayFavorites();

        System.out.println("************************");
        //Queue
        Member member1 = new Member("Nadine");
        Member member2 = new Member("Musie");
        Member member3 = new Member("Natallia");

        BorrowQueue borrowRequests = new BorrowQueue();
        borrowRequests.addRequest(new RequestToBorrow(3, member1, myLibrary.searchBookByTitle("Book2")));
        borrowRequests.addRequest(new RequestToBorrow(1, member2, myLibrary.searchBookByTitle("Book3")));
        borrowRequests.addRequest(new RequestToBorrow(5, member3, myLibrary.searchBookByTitle("Book3")));
        borrowRequests.addRequest(new RequestToBorrow(2, member3, myLibrary.searchBookByTitle("Book1")));
        borrowRequests.displayRequests();
        System.out.println("************************");
        borrowRequests.processRequest();
        borrowRequests.displayRequests();
    }
}