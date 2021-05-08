package pageobjects;

        import base.BaseClass;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;



/**
 * Created by Admin on 05-05-2021.
 */
public class WallethubLoginPage extends BaseClass {
    WebDriver driver;

    @FindBy(xpath="//li[@class='selected']/a[contains(text(),'Login')]")
    private WebElement lnkLogin;

    @FindBy(name="em")
    private WebElement emailId;

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement  loginLinkHomePage;
    @FindBy(xpath="//input[@type='password']")
    private WebElement password;


    @FindBy(xpath = "//button[@type='button'][@class='btn blue touch-element-cl']")
    WebElement btnLongin;

    public void enterPassword(WebDriver driver, String pwd){

        password.sendKeys(pwd);
    }

    public void enterUserName(WebDriver driver, String eid){

        emailId.sendKeys(eid);
    }


    public void clickOnLoginLink(WebDriver driver)
    {
        lnkLogin.click();
    }

    public boolean isLoginLinkPresent(WebDriver driver){
        try {
            if (loginLinkHomePage.isDisplayed()) {
                return true;
            }

        }catch (Exception ex){
            System.out.println("Elelemt not found");
           return false;
        }
        return false;
    }
    public void clickOnSubmit(WebDriver driver)
    {
        btnLongin.click();
    }

    public void clickOnLoginLinkHomePage(WebDriver driver)
    {
        loginLinkHomePage.click();
    }
}
