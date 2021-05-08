package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Admin on 04-05-2021.
 */
public class ReviewConfrimationPage_WalletHub {
    WebDriver driver;

    @FindBy(xpath = "//div/*[contains(text(),'Awesome!')]")
    WebElement review_text;

    @FindBy(xpath = "//*[contains(text(),'Your review has been posted')]")
    WebElement review_confirmation_text;

    @FindBy(xpath = "//*[contains(text(),'Continue')]")
    WebElement btnContinue;




}
