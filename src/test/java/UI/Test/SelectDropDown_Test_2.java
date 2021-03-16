package UI.Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import UI_Pages.SelectDropDown_Page_2;
import UI_Pages.SimpleFormDemo_Page_1;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import java.util.concurrent.TimeUnit;

public class SelectDropDown_Test_2 {

    SimpleFormDemo_Page_1 seleniumEasyPage = new SimpleFormDemo_Page_1();
    Actions action = new Actions(Driver.getDriver());
    SelectDropDown_Page_2 dropDownPage=new SelectDropDown_Page_2();

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
