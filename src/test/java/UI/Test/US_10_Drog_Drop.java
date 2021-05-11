package UI.Test;

import UI_Pages.US01_SimpleFormDemo_Page;
import UI_Pages.US_10_Drog_Drop_Page;
import UI_Pages.US_10_Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US_10_Drog_Drop {
    private static Object Convert;
    Actions action = new Actions(Driver.getDriver());
    US01_SimpleFormDemo_Page seleniumEasyPage = new US01_SimpleFormDemo_Page();
    US_10_Drog_Drop_Page sliderPage=new US_10_Drog_Drop_Page();


    @BeforeTest
    public void setup() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seleniumEasyPage.noThanks.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        sliderPage.progresBarLink.click();
        ReusableMethods.waitFor(1);
        sliderPage.drogDropSliderLink.click();
        ReusableMethods.waitFor(1);


    }

    @Test
    public void TC_01() {
        int target=50;
        sliderPage.setSlider(sliderPage.firstSlider10, sliderPage.firstOutput, target);

        String actualResult = sliderPage.firstOutput.getText();
        String expectedResult = target+"";
        Assert.assertEquals(actualResult,expectedResult);
    }


    @Test
    public void TC_02() {
        sliderPage.setSlider(sliderPage.sliders.get(2), sliderPage.outputs.get(2),33);

        String actualResult = sliderPage.outputs.get(2).getText();
        String expectedResult = "33";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void TC_03() {
        sliderPage.setSlider(sliderPage.sliders.get(3),sliderPage.outputs.get(3),100);

        String actualResult = sliderPage.outputs.get(3).getText();
        String expectedResult = "100";
        Assert.assertEquals(actualResult,expectedResult);

    }



}
