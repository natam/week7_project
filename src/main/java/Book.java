import annotations.ISBN;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.lang.reflect.Field;

public class Book {
    @ISBN
   //@org.hibernate.validator.constraints.ISBN
    private String isbn;

    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

