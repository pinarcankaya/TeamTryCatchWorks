package UI.Test;

import UI_Pages.US01_SimpleFormDemo_Page;
import UI_Pages.US07_TabloFilter_Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US07_TabloFilter {

    Actions action = new Actions(Driver.getDriver());
    US01_SimpleFormDemo_Page seleniumEasyPage = new US01_SimpleFormDemo_Page();
    US07_TabloFilter_Page tabloFilterPage = new US07_TabloFilter_Page();


    @BeforeTest
    public void setup() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seleniumEasyPage.noThanks.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
    }

    //Kullanici, Advanced ==> "Table Filter" linkine tiklar ve 'Filter Records' basligi altindaki conteynir'da
    // toplam 5 tane element bulundugunu "Orange" butonuna tikladiktan sonra  2 element kaldigini assert eder.
    @Test
    public void TC0701() {
        tabloFilterPage.tableLink.click();
        tabloFilterPage.tableFilterLink.click();
        Assert.assertEquals(tabloFilterPage.mediaElements.size(), 5);

        tabloFilterPage.orangeButton.click();
        //Assert.assertEquals(tabloFilterPage.orangeElements.size(),2);

        int count = 0;
        for (WebElement w : tabloFilterPage.mediaElements) {
            tabloFilterPage.orangeButton.click();
            if (!w.getAttribute("style").equals("display: none;")) {
                count++;

            }
        }
      //  System.out.println("count :" + count);
        // System.out.println("list" + list1.size());

      //  int count2=0;
       for (WebElement w : tabloFilterPage.orangeElementsColor) {
           String colorActual = w.getCssValue("color");

           String color = Color.fromString(colorActual).asHex();

           System.out.println(colorActual + " " + color);

           if (color == "#f0ad4e") {
              // count2++;
           }
         //  System.out.println(count2);
           //  Assert.assertEquals(color, "#f0ad4e");


       }

    }

    //Kullanici, Advanced ==>  "Table Sort & Search" linkine tikladiktan sonra  acilan sayfada toplam 32
// kisiye ait bilgi oldugunu ve en altta "Showing 1 to 32 of 32 entries" yazisini dogrular.
    @Test
    public void TC0702() {
        tabloFilterPage.tableLink.click();
        tabloFilterPage.tableSortLink.click();

        Select select = new Select(tabloFilterPage.showDropDown);
        select.selectByValue("50");
        Assert.assertEquals(tabloFilterPage.allData32.size(), 32);
        Assert.assertTrue(tabloFilterPage.showing32Text.isDisplayed());

    }

    //Kullanici, Advanced ==>  "Table Sort & Search" linkine tikladiktan sonra  acilan sayfada
    //maasi(salary) 200,000 binden fazla olan olan 18 kisinin oldugu,  4 kisinin Tokyo'da
    //calistigini dogrular. Ayrica calisanlarin yas ortalamasini bulur.////avg>40 assertion olabilir
    @Test
    public void TC0703() {
        tabloFilterPage.tableLink.click();
        tabloFilterPage.tableSortLink.click();

        Select select = new Select(tabloFilterPage.showDropDown);
        select.selectByValue("50");

       int count=0;
        for (WebElement w : tabloFilterPage.salary){
            int  allSalary=Integer.parseInt(w.getText().substring(1,w.getText().length()-2).replace(",",""));

         if(allSalary>=200000){
            // System.out.println(w.getText().substring(1,w.getText().length()-2).replace(",",""));
             count++;
             System.out.println(allSalary);
            }
        }
       System.out.println(count);
        Assert.assertEquals(count,18);


        //avgAge
        int sum = 0;


        for (WebElement w : tabloFilterPage.ages) {
            int age = Integer.parseInt(w.getText());
            sum += age;
        }
        int avgAge=sum/tabloFilterPage.ages.size();
        System.out.println(avgAge);
        Assert.assertTrue(avgAge==41);

        ////tokyo
        tabloFilterPage.searchTextBox.sendKeys("Tokyo");
        Assert.assertEquals(tabloFilterPage.tokyo.size(),4);

    }
}
