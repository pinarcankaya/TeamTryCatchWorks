package UI.Test;

import UI_Pages.US01_SimpleFormDemo_Page;
import UI_Pages.US_09_JQuery_Download_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US_09_JQuery_Download {

    Actions action = new Actions(Driver.getDriver());
    US01_SimpleFormDemo_Page seleniumEasyPage = new US01_SimpleFormDemo_Page();
    US_09_JQuery_Download_Page jQuery_download_page = new US_09_JQuery_Download_Page();

    @BeforeTest
    public void setup() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seleniumEasyPage.noThanks.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        jQuery_download_page.progresBarLink.click();

    }



    //Kullanici, Advanced ==> "JQuery Download Progress bars" linkine tiklar. Acilan sayfada 'Start Download'
    // butonuna tikladiktan sonra acilan 'File Download' span'inda verinin inmeye baslandigini ve islem
    // bittikten sonrada "Complete!" textinin gorundugunu dogrular

    @Test
    public void TC0901() {
        jQuery_download_page.jqueryLInk.click();
        ReusableMethods.waitFor(1);
        jQuery_download_page.startDownloadButton.click();
        System.out.println(jQuery_download_page.completeText.getText());

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
      //  wait.until(ExpectedConditions.attributeContains(jQuery_download_page.progresBarAria,"aria-valuenow","50"));
        System.out.println(jQuery_download_page.completeText.getText());

       //jQuery_download_page.progresBarAria.getAttribute("aria-valuenow").equals("50");
       wait.until(e->jQuery_download_page.progresBarAria.getAttribute(String.valueOf("aria-valuenow"=="50")));
        System.out.println(jQuery_download_page.completeText.getText());
    }


    //Kullanici, Advanced ==> "Bootstrap Download Progress bar" linkine tikladiktan sonra acilan sayfada
    // 'Download' butonuna tiklar ve '65%' yuzdelik textinin gorundugunu ve bittikten sonra
    // 100% textinin oldugunu dogrular
    @Test
    public void TC0902() {
        jQuery_download_page.bootstrapProgressBarLink.click();
        jQuery_download_page.bootstrapDownloadButton.click();
        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        wait.until(ExpectedConditions.textToBePresentInElement(jQuery_download_page.yuzdelikDilim,"65%"));
      //  System.out.println(jQuery_download_page.yuzdelikDilim.getText());
       //wait.until(ExpectedConditions.textToBePresentInElement(jQuery_download_page.yuzdelikDilim,"99%"));
       // System.out.println(jQuery_download_page.yuzdelikDilim.getText());
      //  wait.until(ExpectedConditions.textToBe((By) jQuery_download_page.yuzdelikDilim,"65%"));
        System.out.println(jQuery_download_page.yuzdelikDilim.getText());
    }
}
