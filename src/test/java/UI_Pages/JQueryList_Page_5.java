package UI_Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class JQueryList_Page_5 {

    public JQueryList_Page_5()
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
    /*
    @FindBy(xpath = "//button[.='Add']")
    public WebElement */




}