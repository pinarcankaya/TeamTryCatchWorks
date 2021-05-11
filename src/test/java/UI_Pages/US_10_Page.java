package UI_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_10_Page {

    public US_10_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='Progress Bars & Sliders']")
    public WebElement progresBarLink;


    @FindBy(xpath = "(//a[.='Drag & Drop Sliders'])[2]")
    public WebElement drogDropSliderLink;


    @FindBy(xpath = "//input[@name='range']")
    public List<WebElement> sliderList;
}
