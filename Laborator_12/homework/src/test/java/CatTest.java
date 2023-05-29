import org.example.cat.Cat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {


    @Test
    public static void getTest1() {
        assertEquals("testing", "Testing");
    }

    @Test
    public void getTest2() {
        assertEquals("buna ziua", "buna ziua");
    }


    @Test
    public static void getTest3(int x) {
        System.out.println("Testing method 3 si x e : " + x);
        assertEquals(2, 2);
    }

    @Test
    public static void getTest4(int x) {
        System.out.println("Testing method 4 si x e : " + x);
    }
    @Test
    public static void getTest5(int x) {
        System.out.println("Testing method 5 si x e : " + x);
    }
}
