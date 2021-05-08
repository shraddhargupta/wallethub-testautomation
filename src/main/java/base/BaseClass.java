package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utility.ExtentManager;

/**
 * This class will be base class for all other classes . This class has common Methods of launching browser and navigating to different URL.
 */
public class BaseClass {
    public static Properties prop;


    @BeforeSuite
    public void getPropertiesValue (){
        try {
            ExtentManager.setExtent();
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException ex){ex.printStackTrace();}
    }
    public  WebDriver lauchBrowser(String browser,String URL)
    {

        WebDriver driver=null;
        if(browser.compareToIgnoreCase("Chrome")==0) {

                //Launch Chrome Browser
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();



        }
        if(browser.compareToIgnoreCase("Opera")==0) {

            if(prop.getProperty("enablevpn")=="true"){
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.addArguments("user-data-dir=" +prop.getProperty("opera_profile"));
                WebDriverManager.operadriver().setup();
                driver =new OperaDriver(operaOptions);
            }
            else{
                WebDriverManager.operadriver().setup();
                driver =new OperaDriver();
            }

        }
        if(browser.compareToIgnoreCase("Internet Explorer")==0){
            WebDriverManager.iedriver().setup();
            driver =new ChromeDriver();
        }

        driver.get(URL);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;


    }





    public void launchURL(WebDriver driver ,String url){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    public static void closeBrowser(WebDriver driver)
    {
        driver.quit();
    }
    @AfterSuite
    public void afterSuite() {
        ExtentManager.endReport();
    }

}
