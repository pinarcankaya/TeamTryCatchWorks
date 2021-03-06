package UI_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US01_SimpleFormDemo_Page {

    public US01_SimpleFormDemo_Page(){
        PageFactory.initElements(Driver.getDriver(),this);}


    @FindBy(xpath = "//a[@id='btn_basic_example']")
    public WebElement startPractisingButton;


    @FindBy(xpath = "//a[.='Input Forms']")
    public WebElement inputFormsLink;


    @FindBy(xpath = "(//a[.='Simple Form Demo'])[2]")
    public WebElement simpleFormDemoLink;


    @FindBy(xpath = "//input[@id='user-message']")
    public WebElement textBox;


    @FindBy(xpath = "//button[.='Show Message']")
    public WebElement showMessageButton;

    @FindBy(xpath = "//a[.='No, thanks!']")
    public WebElement noThanks;

    @FindBy(xpath = "//span[@id='display']")
    public WebElement yourMessage;

    @FindBy(xpath = "//input[@id='sum1']")
   public WebElement enterA;

    @FindBy(xpath = "//input[@id='sum2']")
    public WebElement enterB;

    @FindBy(xpath = "//button[.='Get Total']")
    public WebElement getTotatlButton;

    @FindBy(xpath = "//span[@id='displayvalue']")
    public WebElement  totatlMessage;


}
