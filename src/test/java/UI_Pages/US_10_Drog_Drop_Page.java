package UI_Pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.stream.IntStream;
public class US_10_Drog_Drop_Page {

    public US_10_Drog_Drop_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

//    @FindBy(xpath = "//div[@class='list-group']//a[.='Drag & Drop Sliders']")
//    public WebElement dragDropSliderPageLink;


    @FindBy(xpath = "//a[.='Progress Bars & Sliders']")
    public WebElement progresBarLink;

    @FindBy(xpath = "(//a[.='Drag & Drop Sliders'])[2]")
    public WebElement drogDropSliderLink;

    @FindBy(xpath = "(//input[@type='range'])[1]")
    public WebElement firstSlider10;

    @FindBy(xpath = "//output[@id='range']")
    public WebElement firstOutput;

    public void setSlider(WebElement slider, WebElement output, int target) {
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.waitFor(1);

        actions.clickAndHold(slider).perform();
        while (true) {
            int value = Integer.parseInt(output.getText());
            if (value == target) break;
            if (value > target) {
                actions.sendKeys(Keys.ARROW_LEFT).perform();
                System.out.println("value_left = " + value);
            } else {
                actions.sendKeys(Keys.ARROW_RIGHT).perform();
                System.out.println("value_right = " + value);
            }
        }
    }

    @FindBy(xpath = "//input[@type='range']")
    public List<WebElement> sliders;

    @FindBy(xpath = "//output")
    public List<WebElement> outputs;



}
