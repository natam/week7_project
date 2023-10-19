import annotations.BookInfo;
import annotations.ISBN;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.lang.reflect.Field;

public class Book {
    @ISBN
   //@org.hibernate.validator.constraints.ISBN
    private String isbn;
    private int id;

    @BookInfo
    private String title;
    @BookInfo
    private String author;
    @BookInfo
    private int yearPublished;

    private double price;

    public boolean isValid(){
        boolean isValid = false;
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field:fields) {
            if(field.isAnnotationPresent(ISBN.class)){
                String regex = field.getAnnotation(ISBN.class).isbnRegex();
                try {
                    if(field.get(this).toString().matches(regex)){
                        isValid = true;
                    }else {
                        return false;
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        return isValid;
    }

    public Book(String isbn, int id, String title, String author) {
        this.isbn = isbn;
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(String isbn, int id, String title, String author, int yearOfPublication, double price) {
        this.isbn = isbn;
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearOfPublication;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Book)){
            return false;
        }else {
            return this.isbn.equals(((Book) o).getIsbn());
        }
    }

    public void displayBook(){
        String separator = "; ";
        StringBuilder str = new StringBuilder();
        str.append(isbn)
                .append(separator)
                .append(id)
                .append(separator)
                .append(title)
                .append(separator)
                .append(author);
        System.out.println(str.toString());
    }
}

