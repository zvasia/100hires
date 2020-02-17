import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class DriverInit {




    public static WebDriver getDriver() throws IllegalArgumentException, SecurityException, NullPointerException {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static Capabilities getCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("name", "100hires");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("platform", "MAC");
        caps.setCapability("screenResolution", "1366x768");
        caps.setCapability("record_video", "false");

        return caps;
    }




}

