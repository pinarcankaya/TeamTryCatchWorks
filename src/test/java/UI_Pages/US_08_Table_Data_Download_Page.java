package UI_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_08_Table_Data_Download_Page {

    public US_08_Table_Data_Download_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath ="//a[.='Table']")
    public WebElement tableLink;

    @FindBy(xpath ="(//a[.='Table Data Download'])[2]")
    public WebElement tableDataDownloadLink;


    @FindBy(xpath ="//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath ="//tbody/tr/td[3]")
    public List<WebElement> cityName;
}
