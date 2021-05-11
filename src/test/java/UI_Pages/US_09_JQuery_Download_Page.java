package UI_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_09_JQuery_Download_Page {

    public US_09_JQuery_Download_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='Progress Bars & Sliders']")
    public WebElement progresBarLink;

    @FindBy(xpath = "(//a[.='JQuery Download Progress bars'])[2]")
    public WebElement jqueryLInk;


    @FindBy(xpath = "//button[.='Start Download']")
    public WebElement startDownloadButton;

    @FindBy(xpath = "//div[@class='progress-label']")
    public WebElement completeText;

    @FindBy(xpath = "//div[@id='progressbar']")
    public WebElement progresBarAria;


    @FindBy(xpath = "//div[@class='ui-progressbar-value ui-corner-left ui-widget-header ui-progressbar-complete ui-corner-right']")
    public WebElement progressBarStyle;

    ///////********

    @FindBy(xpath = "(//a[.='Bootstrap Progress bar'])[2]")
    public WebElement bootstrapProgressBarLink;


    @FindBy(xpath = "//button[@id='cricle-btn']")
    public WebElement bootstrapDownloadButton;


    @FindBy(xpath = "//div[contains(text(),'%')]")
    public WebElement  yuzdelikDilim;

}
