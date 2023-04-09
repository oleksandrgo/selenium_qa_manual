import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {

    @Test
    public void testSum(){
        Assert.assertEquals(10,sum(5,5),"Невірна сума");
    }

    @Test
    public void testSumWithNegativeData(){
        Assert.assertEquals(-10,sum(-5,-5),"Невірна сума");
    }

    @Test
    public void testMultiply(){
        Assert.assertEquals(25,multiply(5,5),"Невірний результат множення");
    }

    @Test
    public void testMultiplyWithNegativeData(){
        Assert.assertEquals(25,multiply(-5,-5),"Невірний результат множення");
    }

    public static int multiply(int a, int b){
        return a * b;
    }

    public static int sum(int a, int b){
        return a + b;
    }
}
