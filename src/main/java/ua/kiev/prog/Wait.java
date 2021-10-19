package ua.prog.kiev;

public class Wait {
    public static void sleep(long ms){
        try {
            Thread.sleep(ms); // wait
        } catch (Throwable e) { /*ignore*/ }

    }
}
