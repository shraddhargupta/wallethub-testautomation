package testcases;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;


/**
 * Created by Admin on 02-05-2021.
 */
public class FacebookLoginTests extends BaseClass {

    WebDriver driver;
    @BeforeMethod
    public  void setup()

    {
        driver= lauchBrowser(prop.getProperty("browser"),prop.getProperty("fburl"));
    }

    @Test
    public void Verify_Login(){
        boolean flag=false;
        PageFactory.initElements(driver, LoginPage.class);
        LoginPage.Enter_Username(driver,prop.getProperty("fbuname"));
        LoginPage.Enter_Password(driver,prop.getProperty("fbpwd"));
        LoginPage.click_login(driver);
        System.out.println("Login Successful");
        try {
            Thread.sleep(5000);
        }catch (Exception ex){ex.printStackTrace();}

        String current =driver.getTitle();

        if(current.contains("Facebook")){
            System.out.println("inside if condition");
            flag=true;}
        Assert.assertTrue(flag);
    }


    @AfterClass
    public  void teardown()
    {
       closeBrowser(driver);
    }
}
