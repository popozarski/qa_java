import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

//тестовый класс 2
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    private Feline feline;

    Animal animal;
    @Spy
    Feline spyFeline;

    @Before
    public void setUp(){
        feline = new Feline();
    }

    @Test
    public void testGetFamilyReturnFelineString(){
        String expected = "Кошачьи";
        String actual = feline.getFamily();

        assertEquals(expected, actual);
    }


    @Test
    public void testEatMeatCallsGetFood() throws Exception {
        spyFeline.eatMeat();
        Mockito.verify(spyFeline).getFood("Хищник");
    }


    @Test
    public void testEatMeatReturnsCorrectFood() throws Exception {
        //Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }



    @Test
    public void testGetKittensWithParameter(){
        feline.getKittens(3);
        assertEquals(3 ,feline.getKittens(3));
    }

    @Test
    public void testGetKittensDefaultCount() {
        assertEquals(1, feline.getKittens());
    }
}
