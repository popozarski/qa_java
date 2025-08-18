import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionConstructorTestParametrized {
    private final String sex;
    private final Boolean expected;
    private final Class<?> exception;
    private final String exceptionMessage;

    @Mock
    private Feline feline;

    public LionConstructorTestParametrized(String sex, Boolean expected, Class<?> exception, String exceptionMessage) {
        this.sex = sex;
        this.expected = expected;
        this.exception = exception;
        this.exceptionMessage = exceptionMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getLionSexInfo() {
        return new Object[][] {
                {"Самец", true, null, null},
                {"Самка", false, null, null},
                {"Гермафродит", null, Exception.class, "Используйте допустимые значения пола животного - самец или самка"},
                {null, null, Exception.class, "Используйте допустимые значения пола животного - самец или самка"} // Добавлен null
        };
    }

    @Test
    public void testLionConstructorSexParameter() {
            try {
               Lion lion = new Lion(feline, sex);
                assertEquals(expected, lion.doesHaveMane());
            } catch (Exception e) {
                assertEquals(exception, e.getClass());
                assertEquals(exceptionMessage, e.getMessage());
            }

    }

}
