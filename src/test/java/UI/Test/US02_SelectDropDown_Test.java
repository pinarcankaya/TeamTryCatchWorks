package UI.Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import UI_Pages.US02_SelectDropDown_Page;
import UI_Pages.US01_SimpleFormDemo_Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import java.util.concurrent.TimeUnit;

public class US02_SelectDropDown_Test {

    US01_SimpleFormDemo_Page seleniumEasyPage = new US01_SimpleFormDemo_Page();
    Actions action = new Actions(Driver.getDriver());
    US02_SelectDropDown_Page dropDownPage=new US02_SelectDropDown_Page();

    @BeforeTest
    public void setup() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seleniumEasyPage.noThanks.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        seleniumEasyPage.inputFormsLink.click();
        ReusableMethods.waitFor(1);
        dropDownPage.selectDropDownLink.click();

    }

    @Test
    public void TC01() {
        Select select=new Select(dropDownPage.selectDayDropDown);
        List<WebElement> dayList=select.getAllSelectedOptions();



//        for (WebElement w: dayList){
//            System.out.println(w.getText());
//            Assert.assertTrue(w.isEnabled());
//
//        }







    }
}
