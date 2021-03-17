package gittigidiyor;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseTest{

    protected static WebDriver driver;
    protected static WebDriverWait wait;



    @Before
    public void setup() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
            wait = new WebDriverWait(driver, 30);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



@AfterClass
public static void quit(){
        driver.quit();
}

    @Rule
    public final TestRule watchman = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }
        // This method gets invoked if the test fails for any reason:
        @Override
        protected void failed(Throwable e, Description description) {
            // Print out the error message:
            System.out.println(description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n");
            TakeScreenshot(driver);
        }

        @Override
        protected void finished(Description description) {
            if (driver != null)
                driver.quit();
        }
    };


    public static void TakeScreenshot(WebDriver driver)
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+"/Reports/"+System.currentTimeMillis()+".png";
        File destination=new File(path);
        try
        {
            FileUtils.copyFile(src, destination);
        } catch (IOException e)
        {
            System.out.println("Capture Failed "+e.getMessage());
        }

    }


    private ChromeOptions chromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-legacy-window");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--aggressive-cache-discard");
        chromeOptions.addArguments("--disable-cache");
        chromeOptions.addArguments("--disable-application-cache");
        chromeOptions.addArguments("--disable-offline-load-stale-cache");
        chromeOptions.addArguments("--disk-cache-size=0");
        chromeOptions.addArguments("--dns-prefetch-disable");
        chromeOptions.addArguments("--no-proxy-server");
        chromeOptions.addArguments("--log-level=3");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-translate");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-browser-side-navigation");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("disable-features=NetworkService");
        chromeOptions.addArguments("enable-features=NetworkServiceInProcess");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setProxy(null);
        return chromeOptions;
    }
}