package UI_Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US05_JQueryList_Page {

    public US05_JQueryList_Page()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//a[.='List Box']")
    public WebElement listBoxMenu;

    @FindBy(xpath = "(//a[.='JQuery List Box'])[2]")
    public WebElement jQueryListMenu;

    @FindBy(xpath = "//select[@class='form-control pickListSelect pickData']")
    public WebElement beforeNames;

    @FindBy(xpath = "//button[.='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//select[@class='form-control pickListSelect pickListResult']")
    public WebElement afterNames;

    @FindBy(xpath = "(//a[.='Data List Filter'])[2]")
    public WebElement dataListFilterMenu;

    @FindBy(xpath = "//span[contains(text(),'Email')]")
    public List<WebElement> emailList;

    @FindBy(xpath = "//h4[contains(text(),'Name')]")
    public List<WebElement> nameList;

    @FindBy(xpath = "//input[@id='input-search']")
    public WebElement searchAttendees;

    @FindBy(xpath = "//div[@class='searchable-container']/div")
    public List<WebElement> styleDisplayLIst;


}