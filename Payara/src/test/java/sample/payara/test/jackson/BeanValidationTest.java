package sample.payara.test.jackson;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.MessageFormat;
import java.util.Set;

public class BeanValidationTest {

    private Validator validator;

    @Before
    public void setup() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void test() {
        TestBean bean = new TestBean();
        Set<ConstraintViolation<TestBean>> constraintViolations = this.validator.validate(bean);
        constraintViolations.forEach(System.out::println);
    }

    static String message(String value) {
        return MessageFormat.format("value is {0}", value);
    }

    interface TestInterface {
        default String msg(String v) {
            return MessageFormat.format("v:{0}", v);
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    static class TestBean {
        @NotNull(message = "")
        private String name;

        @Min(1)
        @Max(30)
        private int age;
    }

}
