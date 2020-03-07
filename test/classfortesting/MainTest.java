package classfortesting;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class MainTest {
    private static Main getAfter = null;

    private int[] resultArray;
    private int number1;
    private int[] array1;

    private boolean resultBoolean;
    private int number2;
    private int number3;
    private int[] array2;

    public MainTest(int[] resultArray, int number1, int[] array1, boolean resultBoolean, int number2, int number3, int[] array2) {
        this.resultArray = resultArray;
        this.number1 = number1;
        this.array1 = array1;

        this.resultBoolean = resultBoolean;
        this.number2 = number2;
        this.number3 = number3;
        this.array2 = array2;
    }

    @Parameterized.Parameters
    public static Collection getCollection() {
        return Arrays.asList(new Object[][]{
                {new int[] {5, 6, 7, 8}, 4, new int[] {1, 2, 4, 4, 5, 6, 7, 8}, true, 1, 4, new int[] {1, 1, 2, 3, 4, 5}},
                {new int[] {7, 8}, 6, new int[] {1, 2, 4, 4, 5, 6, 7, 8}, true, 1, 4, new int[] {1, 2, 3, 4, 4, 5}},
                {new int[] {}, 9, new int[] {1, 2, 4, 4, 5, 6, 7, 8}, false, 1, 4, new int[] {2, 3, 5, 6, 7, 8}}
        });
    }

    @Test
    public void testAfterLast() {
        Assert.assertArrayEquals(resultArray, getAfter.getAfterLast(number1, array1));
    }

    @Test
    public void testIfContains() {
        Assert.assertEquals(resultBoolean, getAfter.ifContains(number2, number3, array2));
    }

    @Before
    public void init() {
        System.out.println("Init main");
        getAfter = new Main();
    }

    @After
    public void tearDown() {
        getAfter = null;
    }
}
