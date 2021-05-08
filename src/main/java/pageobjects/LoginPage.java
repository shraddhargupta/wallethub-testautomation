package pageobjects;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Created by Admin on 02-05-2021.
 */
public class LoginPage extends BaseClass{
    WebDriver driver;
    @FindBy(
            xpath = "//input[@id='email']"
    )
    static WebElement username;

    @FindBy(
            xpath = "//input[@id='pass']"
    )
    static WebElement password;

    @FindBy(
            xpath = "//button[@id='loginbutton']"
    )
    static WebElement btnlogin;


    @FindBy(
            xpath = "//a[contains(text(),'Sign up for Facebook')]"
    )
    static WebElement lnkSignIn;

    @FindBy(
            xpath = " //a[contains(text(),'Forgotten account')]"
    )
    static WebElement lnkforgotAccount;


    public static void Enter_Username(WebDriver driver,String value){
        username.sendKeys(value);
    }

    public static void Enter_Password(WebDriver driver,String value){
        password.sendKeys(value);

    }
    public static void click_login(WebDriver driver){
        btnlogin.click();

    }


}
