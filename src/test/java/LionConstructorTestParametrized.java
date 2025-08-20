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

    private Feline feline;

    public LionConstructorTestParametrized(String sex, Boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getLionSexInfo() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testLionConstructorSexParameter() throws Exception {
               Lion lion = new Lion(feline, sex);
                assertEquals(expected, lion.doesHaveMane());

    }

}
