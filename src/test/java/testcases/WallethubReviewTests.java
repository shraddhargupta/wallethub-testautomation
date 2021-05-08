package testcases;

import base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pageobjects.WalletHubProfilePage;
import pageobjects.WallethubTestInsuranceReviewPage;
import pageobjects.WallethubLoginPage;

/**
 * Created By Shraddha Gupta .
 * This class con
 */
public class WallethubReviewTests extends BaseClass {

    static WebDriver driver;
    ExtentReports extent = new ExtentReports();
    @BeforeClass

    public void setup()

    {
        driver= lauchBrowser(prop.getProperty("secondbrowser"),prop.getProperty("wallethub_url"));
    }

    @Test(priority = 0)
    public void login(){

        ExtentTest logger=extent.createTest("LoginTest");
        PageFactory.initElements(driver, WallethubLoginPage.class);
        WallethubLoginPage wallethubLoginPage=new WallethubLoginPage();
        if(wallethubLoginPage.isLoginLinkPresent(driver)){
            wallethubLoginPage.clickOnLoginLinkHomePage(driver);
            wallethubLoginPage.enterUserName(driver,prop.getProperty("wallethub_uname"));
            wallethubLoginPage.enterPassword(driver,prop.getProperty("wallethub_pwd"));
        }
        else{
            System.out.println("...skipping login .User is already logged in .");
        }
    }



    @Test(priority = 1)
    public void postReviewComment(){
        ExtentTest logger=extent.createTest("postReviewComment");
        String comments="Test Automation Review comments Wallethub. Review is entered using automation script using selenium.Testing for various input to verify its working.";
        PageFactory.initElements(driver, WallethubTestInsuranceReviewPage.class);
       if(WallethubTestInsuranceReviewPage.isDispayedWriteReview(driver)){
           WallethubTestInsuranceReviewPage.cilckOnWirteReview(driver);
            logger.log(Status.INFO,"Write a review button is clicked");
            WallethubTestInsuranceReviewPage.editReviewComment(driver,comments+"Revised comment");
            logger.log(Status.INFO,"Comments are updated");
            WallethubTestInsuranceReviewPage.printreviewRating(driver);

            WallethubTestInsuranceReviewPage.clickOnSubmit(driver);

           logger.log(Status.INFO,"Review is  submitted.");
        }
        else {
           WallethubTestInsuranceReviewPage.performMouseHoverOnReviewStars(driver);
            System.out.println("Mouse Hover action performed successfully on review star.");
           WallethubTestInsuranceReviewPage.postRating(driver);
            System.out.println("Rating is selected.");
           WallethubTestInsuranceReviewPage.selectInsuranceType(driver);
            System.out.println("Insurance type is selected as Health Insurance");
            WallethubTestInsuranceReviewPage.enterReviewComments(driver, comments);
            System.out.println("Review comments are entered.");
            WebElement ele=driver.findElement(By.className("btn blue fixed-w-c with-loader"));
            System.out.println("*****************"+ele.getAttribute("disabled"));
            ele.click();
            try {
                Thread.sleep(20000);
                WallethubTestInsuranceReviewPage.clickOnSubmit(driver);
            }catch (Exception x){x.printStackTrace();}

        }
    }


    @Test(priority = 2)
    public void VerifyPostedReview(){
        String URL=prop.getProperty("profileurl");

        driver.navigate().to(URL);
        PageFactory.initElements(driver, WalletHubProfilePage.class);

        if(WalletHubProfilePage.verifyProfilePage(driver)) {
            WalletHubProfilePage.getProfileName(driver);
            WalletHubProfilePage.getTotalNoOfReviewsPosted(driver);

        }
    }

    @AfterClass

    public static void teardown()
    {
      closeBrowser(driver);
    }
}
