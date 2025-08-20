import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

//тестовый класс 1
@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;

    @Mock
    Feline feline;

    @Before
    public void setUp(){
    cat = new Cat(feline);}

    @Test
    public void testCatGetSound(){
        String actualSound = cat.getSound();
        String expectedSound = "Мяу";
        assertEquals(actualSound, expectedSound);
    }

    @Test
    public void testGetFoodCallsPredatorMethod() throws Exception {
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
    @Test
    public void testGetFoodReturnAppropriateListOfFood() throws Exception {
        List<String> foodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(foodList);
        List<String> actual = cat.getFood();
        List<String> expected = foodList;
        assertEquals(expected, actual);
    }
}
