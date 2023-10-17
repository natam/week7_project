import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //Solution with my custom annotation
        Book myBook = new Book();
        myBook.setIsbn("ISBN-1-56619-909-3");
        System.out.println("Has book valid isbn: " + myBook.isValid());

        //Solution with Jakarta annotations
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        BookWithJakartaAnnotations book2 = new BookWithJakartaAnnotations("001-56619-909-3", "bhla");
        Set<ConstraintViolation<BookWithJakartaAnnotations>> violations = validator.validate(book2);
        for (ConstraintViolation<BookWithJakartaAnnotations> violation : violations) {
            System.out.println(violation.getMessage());
        }

    }
}