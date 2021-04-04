package UI_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US06_TabloPagination_Page {

    public US06_TabloPagination_Page()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//a[.='Table']")
    public WebElement tableLink;

    @FindBy(xpath ="(//a[.='Table Pagination'])[2]")
    public WebElement tabloPaginationLink;

    @FindBy(xpath ="//a[contains(@class, 'page')]")
    public List<WebElement> sayfaSayisi;

    @FindBy(xpath ="//a[contains(@style, 'display')]")
    public List<WebElement> playLink;

    @FindBy(xpath ="//td[.='Table cell']")  //78 data
    public List<WebElement>  tabloCell;

    @FindBy(xpath ="(//a[.='Table Data Search'])[2]")
    public WebElement tabloDataSearchLink;

    @FindBy(xpath ="//table[@id='task-table']/thead/tr/th")
    public List<WebElement> taskBar;

    @FindBy(xpath ="//input[@id='task-table-filter']")
    public WebElement  inputFilterBox;


    @FindBy(xpath ="//tr[contains(@style, 'display')]")
    public List<WebElement> displayStyle;

    @FindBy(xpath ="(((//tbody)[1]/tr)[2]/td)[3]")
    public WebElement mike;


    @FindBy(xpath ="//input[@class='form-control']")
    public List<WebElement> inputTextBox;

   // @FindBy(xpath ="(//tbody)[1]")
  //  public List<WebElement>  allRows;


    @FindBy(xpath ="//button[@class='btn btn-default btn-xs btn-filter']")
    public WebElement filterButton;


    @FindBy(xpath ="//input[@placeholder='First Name']")
    public WebElement firstNameTextBox;


    @FindBy(xpath ="(//tbody)[2]")
    public List<WebElement>  tbody;

  //  @FindBy(xpath ="//tbody/tr/td")  //ek
   // public List<WebElement> allRows;

}
