import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    private Feline feline;


    @Test
    public void getKittensShouldInvokeFelineGetKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.getKittens();
        verify(feline, times(1)).getKittens();
    }

    @Test
    public void getKittensShouldReturnValueFromFeline() throws Exception {
        when(feline.getKittens()).thenReturn(5);
        Lion lion = new Lion(feline, "Самка");
        assertEquals(5, lion.getKittens());
    }

    @Test
    public void getFoodShouldInvokeFelineGetFoodWithPredator() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.getFood();
        verify(feline, times(1)).getFood("Хищник");
    }

    @Test
    public void getFoodShouldReturnCorrectList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion(feline, "Самка");
        List<String> actual = lion.getFood();
        assertEquals(expectedFood, actual);
    }

    @Test(expected = Exception.class)
    public void getFoodShouldThrowException() throws Exception {
        when(feline.getFood("Хищник")).thenThrow(new Exception("Ошибка"));
        new Lion(feline, "Самец").getFood();
    }

    @Test
    public void maleLionHasMane() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void femaleLionHasNoMane() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        assertFalse(lion.doesHaveMane());
    }
}