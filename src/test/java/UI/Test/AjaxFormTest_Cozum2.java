package UI.Test;

import UI_Pages.AjaxFormPage_Cozum2_Page;
import UI_Pages.US01_SimpleFormDemo_Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import utilities.Driver;
import utilities.ReusableMethods;
import java.util.List;


    public class AjaxFormTest_Cozum2 {

        US01_SimpleFormDemo_Page page1;
        AjaxFormPage_Cozum2_Page ajaxFormPage;
        Actions actions;
        WebDriverWait wait;

        {
            page1 = new US01_SimpleFormDemo_Page();
            ajaxFormPage = new AjaxFormPage_Cozum2_Page();
            actions = new Actions(Driver.getDriver());
            wait = new WebDriverWait(Driver.getDriver(), 10);
        }

        @BeforeMethod
        public void setup() {
            Driver.getDriver().get("https://www.seleniumeasy.com/test/");

            try {
                page1.noThanks.click();
            }catch (Exception ignored) {

            }

            ajaxFormPage.intermediateArrow.click();
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        }

        @Test
        public void ajaxForm() {
            ajaxFormPage.ajaxFormLink.click();
            ajaxFormPage.title.sendKeys("Testing...");
            ajaxFormPage.descriptions.sendKeys("Some descriptions Text");
            ajaxFormPage.submitButton.click();
            wait.until(ExpectedConditions.
                    textToBePresentInElement(ajaxFormPage.massage, "Form submited Successfully!"));

            Assert.assertEquals(ajaxFormPage.massage.getText(), "Form submited Successfully!");
        }

        @Test
        public void jQuerySelectDown() {
            ajaxFormPage.jQueryLink.click();
            Select select = new Select(ajaxFormPage.countrySelectMenu);
            select.selectByValue("United States of America");
            Assert.assertEquals(select.getFirstSelectedOption().getText(), "United States of America");

            select = new Select(ajaxFormPage.stateSelectMenu);
            select.selectByVisibleText("Michigan");
            Assert.assertEquals(select.getFirstSelectedOption().getText(), "Michigan");

            select = new Select(ajaxFormPage.territorySelectMenu);
            select.selectByIndex(5);
            Assert.assertEquals(select.getFirstSelectedOption().getText(), "Virgin Islands");

            select = new Select(ajaxFormPage.filesSelectMenu);
            select.selectByVisibleText("Java");
            Assert.assertEquals(select.getFirstSelectedOption().getText(), "Java");
        }

        @Test
        public void bootstrapLink() {
            ajaxFormPage.bootstrapLink.click();

            ajaxFormPage.selectItem("bootstrap-duallist");
            ajaxFormPage.moveToRight.click();
            ajaxFormPage.selectAllCheckBox.get(1).click();
            ajaxFormPage.selectAllCheckBox.get(1).click();

            ajaxFormPage.selectItem("Cras justo odio");
            ajaxFormPage.moveToLeft.click();

            List<String> allElementText = ReusableMethods.getElementsText(ajaxFormPage.allItems);

            Assert.assertTrue(allElementText.indexOf("bootstrap-duallist") >= 5);
            Assert.assertTrue(allElementText.indexOf("Cras justo odio") <= 5);
        }

        @AfterClass
        public void tearDown() {
            Driver.closeDriver();
        }
    }

