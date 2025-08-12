package CatTests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Cat shred;

    @Spy
    Feline feline;

    @Before
    public void setUp(){
    shred = new Cat(feline);}

    @Test
    public void testCatGetSound(){
        String actualSound = shred.getSound();
        String expectedSound = "Мяу";
        assertEquals(actualSound, expectedSound);
    }

    @Test
    public void testCatGetFood() throws Exception {
        List<String> actualFood = shred.getFood();
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, actualFood);
    }
}
