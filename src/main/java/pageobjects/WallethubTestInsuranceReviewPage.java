package pageobjects;
import base.BaseClass;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by Admin on 03-05-2021.
 */
public class WallethubTestInsuranceReviewPage extends BaseClass
{
    WebDriver driver;
    @FindBy(
            xpath = "//*[@class='rvs-svg']/div[@class='rating-box-wrapper']/*[@class='rvs-star-svg']"
    )
    static  List<WebElement> reviewStars;

    //span[@class='dropdown-placeholder mob']  --- select class parent

    //ul/li[@class='dropdown-item'][contains(text(),'Health')]  -- actual element
//    @FindBy(
//            xpath = "//span[@class='dropdown-placeholder']"
//    )
//
    @FindBy(css = "[class*='product']")
    static WebElement productLoading;
    @FindBy(xpath="//div[@class='dropdown second']")

    static WebElement policyDD;

    @FindBy(
            xpath = " //textarea[@placeholder='Write your review...']"
    )
    static WebElement reviewComments;
    @FindBy(xpath = "//*[contains(text(),'Health Insurance')]")
    static   List<WebElement> healthFromDD;
    @FindBy(xpath = "//button[@type='button'][@class='btn blue fixed-w-c with-loader']")
    static WebElement submit;

    @FindBy(xpath="//button[contains(text(),'Write a Review')]")
    static WebElement btnwirteReview;


    @FindBy(xpath="//textarea[@name='reviewcomment']")
    static WebElement editReviewCommnet;

    @FindBy(xpath ="//*[@class='rvs-svg']/div/*")
    static List<WebElement>  editreviewstars;
    public  static void  editReviewComment(WebDriver driver,String comments){
        editReviewCommnet.sendKeys(comments);
    }

    public static void printreviewRating(WebDriver driver){

        for(WebElement star: editreviewstars){
            System.out.println(star.getAttribute("fill"));
        }
    }
    public static void cilckOnWirteReview(WebDriver driver){

        btnwirteReview.click();
    }

    public static boolean isDispayedWriteReview(WebDriver driver)
    {
        try{
            if (btnwirteReview.isDisplayed()){
                return true;
            }
            else
            {
                return false;}
            }catch(ElementNotVisibleException e){
                System.out.println("Element not found : Write A Review Button");
                e.printStackTrace();
                return true;
            }
        }

    @FindBy(className = "brgm-list-title")
   static WebElement profileTitle;

    public static void clickOnProfileTitle(WebDriver driver){
        profileTitle.click();
    }


    public static void highLighterMethod(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    public  static void  performMouseHoverOnReviewStars (WebDriver driver) {
        Actions actions = new Actions(driver);

        for ( WebElement element:reviewStars) {
            actions.moveToElement(element).perform();

        }}

        public  static void postRating(WebDriver driver )
        {
            WebElement fourth_star=reviewStars.get(3);
            fourth_star.click();
        }

    public static  void clickOnSubmit(WebDriver driver )
    {   highLighterMethod(driver,submit) ;
        Actions action =new Actions(driver);
        action.moveToElement(submit).doubleClick().perform();
    }

    public static void enterReviewComments(WebDriver driver,String comments){
        reviewComments.sendKeys(comments);
    }

    public  static void selectInsuranceType (WebDriver driver)
    {   policyDD.click();
        healthFromDD.get(11).click();

}}







