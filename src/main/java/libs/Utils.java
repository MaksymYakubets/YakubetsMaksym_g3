package libs;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class Utils {
    private final Logger logger = Logger.getLogger(getClass());

    /**
     * Taking screenshot into patch
     *
     * @param patchToScreenShot
     * @param webDriver
     */
    public void screenShot(String patchToScreenShot, WebDriver webDriver) {
        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(patchToScreenShot));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void hardWait (int seconds) {
        try{
            Thread.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
