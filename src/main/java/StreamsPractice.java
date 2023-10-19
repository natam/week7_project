import java.security.Key;
import java.time.Year;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StreamsPractice {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("145608098", 1, "Book1", "natallia", 2008, 10.0));
        books.add(new Book("1134568098", 2, "Book2", "dmitry", 2001, 7.0));
        books.add(new Book("1134568098", 3, "Book3", "natallia", 2019, 5.0));
        books.add(new Book("11334098", 4, "Book4", "nikita", 2015, 8.50));
        books.add(new Book("113209798", 5, "ABook5", "natallia", 2023, 4.0));
        books.add(new Book("1175408098", 6, "ABook6", "dmitry", 2018, 9.0));

        long booksNumber = books.stream().count();
        System.out.println("-Books count: " + booksNumber);
        double avgPrice = books.stream().collect(Collectors.averagingDouble(Book::getPrice));
        System.out.println("-Books avg price: " + avgPrice);
        Book mostExpensiveBook = books.stream().max(Comparator.comparing(Book::getPrice)).get();
        System.out.println("-Most expensive book: ");
        mostExpensiveBook.displayBook();
        int currentYear = Year.now().getValue();
        System.out.println("-Recent books: ");
        books.stream().filter(book -> book.getYearPublished() >= currentYear -5).forEach(Book::displayBook);
        Map<String,List<Book>> groupedByAuthor = books.stream().collect(Collectors.groupingBy(Book::getAuthor));
        groupedByAuthor.entrySet().stream().forEach(e -> {System.out.println(e.getKey() + " have following books:"); e.getValue().forEach(Book::displayBook);} );
        String authorWithMostBooks = books.stream().collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting())).entrySet().stream().max(Comparator.comparing(Entry::getValue)).get().getKey();
        System.out.println("-Author with most number of books: " + authorWithMostBooks);
        long booksStartedWithA = books.stream().filter(book -> book.getTitle().startsWith("A")).count();
        System.out.println("-Books count started with A: " + booksStartedWithA);
        System.out.println("-5 Most expensive books");
        books.stream().sorted(Comparator.comparingDouble(Book::getPrice).reversed()).limit(5).forEach(Book::displayBook);
        Map<String,List<Book>> booksByDecades = books.stream().collect(Collectors.groupingBy(book -> {
            int i = book.getYearPublished() / 10;
            String key = Integer.toString(i)+"0-"+Integer.toString(i)+"9";
            return key ;}));
        booksByDecades.entrySet().forEach(entry -> System.out.println(entry.toString()));
    }
}
