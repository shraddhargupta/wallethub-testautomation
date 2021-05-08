package testcases;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.LoginPage;

/**
 * Created by Admin on 06-05-2021.
 */
public class WalletHubLoginTests extends BaseClass {
    WebDriver driver;
    @BeforeMethod
    public  void setup()

    {
        driver= lauchBrowser(prop.getProperty("browser"),prop.getProperty("fburl"));
    }

    @Test
    public void Verify_Login(){

        PageFactory.initElements(driver, LoginPage.class);
        LoginPage.Enter_Username(driver,prop.getProperty("fbuname"));
        LoginPage.Enter_Password(driver,prop.getProperty("fbpwd"));
        LoginPage.click_login(driver);
        System.out.println("Login Successful");
        Assert.assertEquals("HELLO", "HELLO");
    }


    @AfterClass
    public  void teardown()
    {
       closeBrowser(driver);
    }


}
