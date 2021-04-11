import lesson22.Main;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestBooleanMethod {
    static Main main;
    public int[] testArray;

    public TestBooleanMethod(int[] testArray) {
        this.testArray = testArray;
    }

    @BeforeClass
    public static void init() {
        main = new Main();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 1, 1, 1, 1}},
                {new int[]{4, 4, 4, 4}},
                {new int[]{1, 1, 1, 4, 2, 1, 4, 4}}
        });
    }

    @Test
    public void testBoolean() {
        Assert.assertFalse(main.numberFourAndOneInArray(testArray));
    }
}
