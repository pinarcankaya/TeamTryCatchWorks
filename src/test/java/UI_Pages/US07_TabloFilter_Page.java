package UI_Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US07_TabloFilter_Page {
    public US07_TabloFilter_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//a[.='Table']")
    public WebElement tableLink;

    @FindBy(xpath ="(//a[.='Table Filter '])[2]" )
    public WebElement tableFilterLink;


    @FindBy(xpath ="//tbody/tr" )
    public List<WebElement> mediaElements;


    @FindBy(xpath ="//button[.='Orange']")
    public WebElement orangeButton;


    @FindBy(xpath ="//tr[@data-status='pendiente']")
    public List<WebElement> orangeElements;


    @FindBy(xpath ="//span[.='(Orange)']")
    public List<WebElement> orangeElementsColor;

    ///////tc0702
    @FindBy(xpath ="(//a[.='Table Sort & Search'])[2]")
    public WebElement tableSortLink;

    @FindBy(xpath ="//div[.='Showing 1 to 32 of 32 entries']")
    public WebElement  showing32Text;


    @FindBy(xpath ="//tbody/tr")
    public List<WebElement> allData32;

    @FindBy(xpath ="//select")
    public WebElement  showDropDown;


    @FindBy(xpath ="//tbody/tr/td[6]")
    public List<WebElement>  salary;

    @FindBy(xpath ="//input[@type='search']")
    public WebElement  searchTextBox;

    @FindBy(xpath ="//tbody/tr/td[3]")
    public List<WebElement> tokyo;

    @FindBy(xpath ="//tbody/tr/td[4]")
    public List<WebElement> ages;

}
