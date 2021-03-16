package UI.Test;

import UI_Pages.JQueryList_Page_5;
import UI_Pages.SimpleFormDemo_Page_1;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JQueryList_Test {


    Actions action = new Actions(Driver.getDriver());
    SimpleFormDemo_Page_1 seleniumEasyPage = new SimpleFormDemo_Page_1();
    JQueryList_Page_5 jQueryListPage5=new JQueryList_Page_5();

    @BeforeTest
    public void setup() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seleniumEasyPage.noThanks.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
    }

    @Test
    public void TC01() {
    jQueryListPage5.listBoxMenu.click();
    jQueryListPage5.jQueryListMenu.click();

    Select beforeselect=new Select(jQueryListPage5.beforeNames);

        beforeselect.selectByVisibleText("Valentina");
        beforeselect.selectByVisibleText("Giovanna");
        beforeselect.selectByVisibleText("Helena");
        beforeselect.selectByVisibleText("Lara");
        beforeselect.selectByVisibleText("Julia");
        jQueryListPage5.addButton.click();


        int beforeSelectSize=beforeselect.getOptions().size();
        System.out.println(beforeSelectSize);

        Select afterSelect=new Select(jQueryListPage5.beforeNames);
        int afterSelectSize=afterSelect.getOptions().size();
        System.out.println(afterSelectSize);
    }
}
