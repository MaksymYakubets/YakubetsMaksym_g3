package junitTests;

import org.junit.*;
import org.junit.rules.Timeout;

import java.util.NoSuchElementException;


public class JunitTests {
    @Rule
    public final Timeout timeout = new Timeout(1000);

    @Before
    public static void beforeClass() {
        System.out.println("Before class input");

    }

    @After
    public static void afterClass() {
        System.out.println("After class input");

    }

    @Before
    public static void beforeMethod() {
        System.out.println("Before method input");

    }

    @After
    public static void afterMethod() {
        System.out.println("After method input");

    }

    @Test
    public void test(){
        System.out.println("text");
        Assert.assertEquals("res", "res");
    }

    @Test(timeout = 1000)
  //  @Test(expected = NoSuchElementException.class)
  //  @Ignore
    public void test2(){
        System.out.println("text2");
        Assert.assertEquals("res2", "res2");
    }
}