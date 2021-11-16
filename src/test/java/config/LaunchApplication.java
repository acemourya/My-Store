package config;

import com.webstore.ui.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LaunchApplication {

    public static WebDriver driver;
    public static Properties prop;
    public static Logger log = Logger.getLogger(LoginPage.class);

    public void launchApplication() {
        try {
            FileInputStream file = new FileInputStream("./src/test/resources/data.properties");
            prop = new Properties();
            prop.load(file);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            String url = prop.getProperty("host");
            driver.get(url);
        } catch (IOException exception) {
            log.info(exception);
        }
    }

    public void teardown() {
        try {
            driver.quit();
        } catch (Exception e) {
            log.info("Close driver failed and throw Exception: " + e);
        }
    }
}
