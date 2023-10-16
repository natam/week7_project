import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Book myBook = new Book();
        myBook.setIsbn("ISBN-1-56619-909-3");
        System.out.println(myBook.isValid());

    }
}