package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

/**
 * Created by Shraddha Gupta on 04-05-2021.
 */
public class WalletHubProfilePage {





    @FindBy(className = "profile-name")
    private static WebElement profileName;

    public static void getProfileName(WebDriver driver){
        String profname=profileName.getText();
        System.out.println("Profile Name is : "+profname);
    }


    @FindBy(className = "pr-rec-container")
    private List<WebElement> reviewTable;

    @FindBy(xpath = "//*[@class='pr-rec-container']/div")
    private static List<WebElement>  allReviws;

    public static void getTotalNoOfReviewsPosted(WebDriver driver){
       Integer totalNoOfReviews= allReviws.size();
       System.out.println("Total Number of Reviews Posted are :"+totalNoOfReviews);
    }
    public static boolean  verifyProfilePage(WebDriver driver){
        if(profileName.isDisplayed()){
            System.out.println("Profile Page is open");
            return true;
        }
        else{
            System.out.println("profile page is not loaded");
            return  false;
        }
    }


}
