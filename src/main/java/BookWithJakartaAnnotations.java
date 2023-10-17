import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.ISBN;

import java.lang.reflect.Field;

public class BookWithJakartaAnnotations {

    @ISBN
    @NotNull
    private String isbn;

    @Email
    @NotNull
    private String email;

    public BookWithJakartaAnnotations(String isbn, String email) {
        this.isbn = isbn;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

