package suits;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import ua.prog.kiev.RegistrationTests;


// experimental parallel execution
public class ParallelTests {
    @Test
    public void runAllBrowserTests(){
        Class<?>[] classes =
                {
                        RegistrationTests.class
                };
        // ParallelComputer(true,true) will run all classes
        // in parallel (First arg for classes, second arg for methods
        JUnitCore.runClasses(new ParallelComputer(true,true), classes);

    }
}
