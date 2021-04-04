package UI_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US04_Ajax_Jquery_List_Page {

    public US04_Ajax_Jquery_List_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

     @FindBy(xpath ="(//a[.='Ajax Form Submit'])[2]")
      public WebElement ajaxFormMenuLink;

    @FindBy(xpath ="//input[@id='title']")
    public WebElement nameTextBox;

    @FindBy(xpath ="//textarea[@id='description']")
    public WebElement commentTextBox;

    @FindBy(xpath ="//input[@id='btn-submit']")
    public WebElement submitButton;

   @FindBy(xpath ="//div[.='Form submited Successfully!']")
    public WebElement succesMessage;

    @FindBy(xpath ="(//a[.='JQuery Select dropdown'])[2]")
    public WebElement jQuerySelectMenuLink;

    @FindBy(xpath ="//select[@id='country']")
    public WebElement selectCountry;

    @FindBy(xpath = "//select[@class='js-example-basic-multiple select2-hidden-accessible']")
    public WebElement stateSelectMenu;

    @FindBy(xpath ="//select[@class='js-example-disabled-results select2-hidden-accessible']")
    public WebElement  territoriesDropdownMenu;

    @FindBy(xpath ="//select[@name='files']")
    public WebElement categoryDropDown;

    @FindBy(xpath ="//a[.='List Box']")
    public WebElement listBoxMenu;


    @FindBy(xpath ="(//a[.='Bootstrap List Box'])[2]")
    public WebElement bootstrapListBoxMenu;
/*

    @FindBy(xpath ="//span[@title='Virgin Islands']")
    public WebElement */


}


