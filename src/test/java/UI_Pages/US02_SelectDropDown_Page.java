package UI_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US02_SelectDropDown_Page {


    public US02_SelectDropDown_Page(){
        PageFactory.initElements(Driver.getDriver(),this);}


    @FindBy(xpath = "(//a[.='Select Dropdown List'])[2]")
    public WebElement selectDropDownLink;


    @FindBy(xpath = "//select[@id='select-demo']")
    public WebElement selectDayDropDown;

   /* @FindBy(xpath = "")
    public WebElement


    @FindBy(xpath = "")
    public WebElement

    @FindBy(xpath = "")
    public WebElement


    @FindBy(xpath = "")
    public WebElement

    @FindBy(xpath = "")
    public WebElement*/


}
