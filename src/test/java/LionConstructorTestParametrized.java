import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionConstructorTestParametrized {
    private String sex;
    private Boolean expected;
    private Object exception;
    private Object exceptionMessage;
    @Mock
    Feline feline;

    public LionConstructorTestParametrized(String sex, Boolean expected, Object exception, Object exceptionMessage){
        this.sex = sex;
        this.expected = expected;
        this.exception = exception;
        this.exceptionMessage = exceptionMessage;

    }

    @Parameterized.Parameters
    public static Object[][] getLionSexInfo(){
        return new Object[][] {
                {"Самец", true, null, null},
                {"Самка", false, null, null},
                {"Гермафродит", null, new Exception(), "Используйте допустимые значения пола животного - самец или самка"}
        };
    }

    @Test
    public void testLionConstructorSexParameter() throws Exception {
        try {
            Lion lion = new Lion(feline, sex);
            assertEquals(expected, lion.doesHaveMane());
        }
        catch (Exception e){
            assertEquals(exception.getClass(), e.getClass());
            assertEquals(exceptionMessage, e.getMessage());
        }
    }
}
