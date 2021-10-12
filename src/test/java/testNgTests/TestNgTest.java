package testNgTests;


import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgTest {

 /*   @Factory
    public Object[] test(){
        Object[] res  = new Object[10];
        for (int i = 0; i<10; i++){
            res[i] = new test1(i);
        }
        return res;
    }*/

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class input");

    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class input");

    }

    @BeforeMethod
    public static void beforeMethod() {
        System.out.println("Before method input");

    }

    @AfterMethod
    public static void afterMethod() {
        System.out.println("After method input");

    }

    @Test(groups = "method 1")
  //  @Test(expectedExceptions = ArithmeticException.class)
    public void test1(){
        System.out.println("text");
        Assert.assertEquals("res", "res");
    }

}
