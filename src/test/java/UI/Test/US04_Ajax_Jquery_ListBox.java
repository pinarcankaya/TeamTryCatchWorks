package UI.Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import UI_Pages.US01_SimpleFormDemo_Page;
import UI_Pages.US04_Ajax_Jquery_List_Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US04_Ajax_Jquery_ListBox {


    Actions action = new Actions(Driver.getDriver());
    US01_SimpleFormDemo_Page seleniumEasyPage = new US01_SimpleFormDemo_Page();
    US04_Ajax_Jquery_List_Page intermediatePage=new US04_Ajax_Jquery_List_Page();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 10);

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
    public void ajaxForm() {
        seleniumEasyPage.inputFormsLink.click();
        ReusableMethods.waitFor(1);
        intermediatePage.ajaxFormMenuLink.click();
        intermediatePage.nameTextBox.sendKeys("Jack");
        intermediatePage.commentTextBox.sendKeys("Hello");
        intermediatePage.submitButton.click();
        wait.until(ExpectedConditions.
                textToBePresentInElement(intermediatePage.succesMessage, "Form submited Successfully!"));
        Assert.assertTrue(intermediatePage.succesMessage.isDisplayed());

    }

    @Test
    public void jQuerySelectDown() {
        seleniumEasyPage.inputFormsLink.click();
        ReusableMethods.waitFor(1);
        intermediatePage.jQuerySelectMenuLink.click();

        Select select=new Select(intermediatePage.selectCountry);
        select.selectByValue("United States of America");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "United States of America");


        select = new Select(intermediatePage.stateSelectMenu);
        select.selectByVisibleText("Michigan");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Michigan");

        action.sendKeys(Keys.PAGE_DOWN).perform();

        select=new Select(intermediatePage.territoriesDropdownMenu);
        select.selectByIndex(5);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Virgin Islands");


       select=new Select(intermediatePage.categoryDropDown);
        select.selectByVisibleText("Java");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Java");


    }
//Kullanici, INTERMEDIATE basliginin altinda bulunan "Bootstrap List Box" linkine tiklar ve
//Dual List Box'inin sol bolumunde bulunan;
//- 'bootstrap-duallist'
//item'ini sag bolume, sag bolumde bulunan;
//- 'Cras justo odio' item'ini da sol bolume tasir ve sag ve sol bolumdeki yeni listeleri asert eder
    @Test
    public void bootstrapLink() {
        intermediatePage.listBoxMenu.click();
        intermediatePage.bootstrapListBoxMenu.click();


    }
}
