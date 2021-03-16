package UI_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AjaxFormPage_Cozum2_Page {
    public AjaxFormPage_Cozum2_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a [@id='inter_example']")
    public WebElement intermediateArrow;

    @FindBy(xpath = "//div[@class='list-group']//a[.='Ajax Form Submit']")
    public WebElement ajaxFormLink;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement title;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement descriptions;

    @FindBy(xpath = "//input[@id='btn-submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@id='submit-control']")
    public WebElement massage;

    @FindBy(xpath = "(//a[.='JQuery Select dropdown'])[3]")
    public WebElement jQueryLink;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement countrySelectMenu;

    @FindBy(xpath = "//select[@class='js-example-basic-multiple select2-hidden-accessible']")
    public WebElement stateSelectMenu;

    @FindBy(xpath = "//select[@class='js-example-disabled-results select2-hidden-accessible']")
    public WebElement territorySelectMenu;

    @FindBy(xpath = "//select[@id='files']")
    public WebElement filesSelectMenu;

    @FindBy(xpath = "//div[@class='list-group']//a[.='Bootstrap List Box']")
    public WebElement bootstrapLink;

    @FindBy(xpath = "//li[@class='list-group-item']")
    public List<WebElement> allItems;

    public void selectItem(String item) {
        for(WebElement w : allItems) {
            if(w.getText().trim().equals(item)) {
                w.click();
                break;
            }
        }
    }

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm move-left']")
    public WebElement moveToLeft;


    @FindBy(xpath = "//button[@class='btn btn-default btn-sm move-right']")
    public WebElement moveToRight;

    @FindBy(xpath = "//a[@title='select all']")
    public List<WebElement> selectAllCheckBox;

}