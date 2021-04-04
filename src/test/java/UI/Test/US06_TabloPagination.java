package UI.Test;

import UI_Pages.US01_SimpleFormDemo_Page;
import UI_Pages.US05_JQueryList_Page;
import UI_Pages.US06_TabloPagination_Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;


import java.util.concurrent.TimeUnit;

public class US06_TabloPagination {


    Actions action = new Actions(Driver.getDriver());
    US01_SimpleFormDemo_Page seleniumEasyPage = new US01_SimpleFormDemo_Page();
    US06_TabloPagination_Page tabloPaginationPage = new US06_TabloPagination_Page();

    @BeforeTest
    public void setup() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seleniumEasyPage.noThanks.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
    }

    //Kullanici, Advanced ==> "Table Pagination" linkine tiklar ve toplam 3(uc) sayfa link oldugunu
// ve ileri geri play linklerinin calistigini  dogrular. Toplam 78 tane cell oldugunu assert ediniz.
    @Test
    public void TC0601() {
        tabloPaginationPage.tableLink.click();
        tabloPaginationPage.tabloPaginationLink.click();
        Assert.assertEquals(tabloPaginationPage.sayfaSayisi.size(), 3);

        for (WebElement w : tabloPaginationPage.playLink) {
            Assert.assertTrue(w.isEnabled());
        }

        Assert.assertEquals(tabloPaginationPage.tabloCell.size(),78);


    }


    //Kullanici, Advanced ==>  "Table Data Search" linkine tikladiktan sonra  acilan sayfada
    //'Tasks' panelinin altinda "#", ""Task"", "Assignee", "Status" basliklarinin oldugunu dogrular.
    //Input'ta (filter box)  "Filter by Task / Assignee / Status " textinin  yer aldigini ve input'a "Mike"
    //yazdiginda ekranda sadece Mike Trout'a ait satirin kaldigi assert eder.
    @Test
    public void TC0602() {
        tabloPaginationPage.tableLink.click();
        tabloPaginationPage.tabloDataSearchLink.click();
        ///**1
       //String[] taskBar = {"#", "Task", "Assignee", "Status"};
       // for (WebElement w : tabloPaginationPage.taskBar) {
            //  System.out.println(w.getText());
      //      Assert.assertTrue(Arrays.toString(taskBar).contains(w.getText()));
      //  }

        ///**2
      //  String filterBox = tabloPaginationPage.inputFilterBox.getAttribute("placeholder");
        // System.out.println(filterBox);
      //  Assert.assertEquals(filterBox, "Filter by Task / Assignee / Status ");


        ////**3----1.Yol
        //style turu sendkey yapmadan once--6
        for ( WebElement w : tabloPaginationPage.displayStyle) {
            String style1=w.getAttribute("style");
            System.out.println(w.getText());
            Assert.assertEquals(w.getText(), "display: table-row;");
        }

      tabloPaginationPage.inputFilterBox.sendKeys("Mike");

        //style turu sendkey yaptiktan sonra--1
        int count=0;
        for ( WebElement k : tabloPaginationPage.displayStyle) {
            String style2=k.getAttribute("style");
            System.out.println(style2);
            ReusableMethods.waitFor(1);
            if (style2.equals("display: none;")  && tabloPaginationPage.mike.isDisplayed()) {
                count++;
            }
            Assert.assertEquals(k.getText(), "display: none;");
        }
        System.out.println(count);


          /* int count = 0;
            for (int i = 0; i < tabloPaginationPage.displayStyle.size(); i++) {
                String styleAfter = tabloPaginationPage.displayStyle.get(i).getAttribute("style");
              //  System.out.println(styleAfter);
                if (styleAfter.equals("display: none;")) {
                    tabloPaginationPage.mike.isDisplayed();
                    count++;
                }
                Assert.assertEquals(styleAfter, "display: none;");

            }*/

          //  System.out.println(count);

        ///////**3----2.Yol
      /*  tabloPaginationPage.inputFilterBox.sendKeys("Mike");
        ReusableMethods.waitFor(1);

        for (WebElement w : tabloPaginationPage.allRows) {
            Assert.assertTrue(w.getText().contains("Mike"));

            Assert.assertTrue(tabloPaginationPage.allRows.size() == 1);

        }*/







    }



    //Kullanici, Advanced ==> "Table Data Search" linkine tikladiktan sonra acilan sayfada 'Listed Users'
    //panelinin aldindaki dort(4) tane input'un aktif olmadigini, 'Filter' butonuna tikladiktan sonra
    //bu input box'larin aktiflestigini dogrular.
    //'FirstName' input box'ina "B" karakteri girildiginde panelde sadece "Brigade" ve "Byron" isimlerine
    //ait bilgilerin kaldigi assert edilmelidir.
    @Test
    public void TC0603() {
        tabloPaginationPage.tableLink.click();
        tabloPaginationPage.tabloDataSearchLink.click();
        for (int i = 1; i <tabloPaginationPage.inputTextBox.size() ; i++) {
            Assert.assertFalse(tabloPaginationPage.inputTextBox.get(i).isEnabled());
        }
        tabloPaginationPage.filterButton.click();
        ReusableMethods.waitFor(2);
        for (int i = 1; i <tabloPaginationPage.inputTextBox.size() ; i++) {
            Assert.assertTrue(tabloPaginationPage.inputTextBox.get(i).isEnabled());
        }
        tabloPaginationPage.firstNameTextBox.sendKeys("B");


        for (WebElement w: tabloPaginationPage.tbody) {
            System.out.println(w.getText());
            Assert.assertTrue(w.getText().contains("Brigade")  && w.getText().contains("Byron"));
          //  Assert.assertTrue(w.getText().startsWith("B"));
        }

    }



}