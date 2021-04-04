package UI.Test;

import UI_Pages.US05_JQueryList_Page;
import UI_Pages.US01_SimpleFormDemo_Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US05_JQueryList_Test {


    Actions action = new Actions(Driver.getDriver());
    US01_SimpleFormDemo_Page seleniumEasyPage = new US01_SimpleFormDemo_Page();
    US05_JQueryList_Page jQueryListPage5 = new US05_JQueryList_Page();

    @BeforeTest
    public void setup() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seleniumEasyPage.noThanks.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
    }

    //Kullanici, INTERMEDIATE ==> "JQuery List Box" linkine tiklar ve 'Pick List" panelinde bulunan
    //'Valentina', 'Giovanna', 'Helena', 'Lara' ve 'Julia' option'larini alarak, sag panele ekler ve
    // sol panelde 10 options, sag panelde de 5 options oldugunu dogrular.
    @Test
    public void TC0501() {
        jQueryListPage5.listBoxMenu.click();
        jQueryListPage5.jQueryListMenu.click();

        Select beforeselect = new Select(jQueryListPage5.beforeNames);

        beforeselect.selectByVisibleText("Valentina");
        beforeselect.selectByVisibleText("Giovanna");
        beforeselect.selectByVisibleText("Helena");
        beforeselect.selectByVisibleText("Lara");
        beforeselect.selectByVisibleText("Julia");
        jQueryListPage5.addButton.click();

        Select before = new Select(jQueryListPage5.beforeNames);
        int beforeSelectSize = beforeselect.getOptions().size();
        Assert.assertEquals(beforeselect.getOptions().size(), 10);

        Select afterSelect = new Select(jQueryListPage5.afterNames);
        int afterSelectSize = afterSelect.getOptions().size();
        Assert.assertEquals(afterSelect.getOptions().size(), 5);
    }

    //Kullanici, INTERMEDIATE ==> "Data List Filter" linkine tikladiktan sonra  acilan sayfada
    // herbir kisiye ait Email adresinin oldugunu ve 'Search Attendees...' search box'ina
    // "Brian Hoyies" yazdiginda sayfada sadece O'na ait bilgilerin kaldigini dogrular.
    @Test
    public void TC0502() {
        jQueryListPage5.listBoxMenu.click();
        ReusableMethods.waitFor(1);
        jQueryListPage5.dataListFilterMenu.click();
        System.out.println(jQueryListPage5.nameList.size());
        System.out.println(jQueryListPage5.emailList.size());
        Assert.assertEquals(jQueryListPage5.nameList.size(), jQueryListPage5.emailList.size());

        jQueryListPage5.searchAttendees.sendKeys("Brian Hoyies");


        int count=0;

        for (int i = 0; i < jQueryListPage5.styleDisplayLIst.size() ; i++) {
           String style=jQueryListPage5.styleDisplayLIst.get(i).getAttribute("style");
            System.out.println(style);
          if(style.equals("display: block;")){
                count++;
          }
        }
        System.out.println(count);
        Assert.assertEquals(count,1);
    }
//Kullanici, INTERMEDIATE ==> File Download linkine tiklar. 'Enter Data' textarea'ya
//"Selenium practice yapiyorum!" seklinde yazdiginda textarea'nin hemen altindaki satirda
//472 karekter daha kaldigini dogrular.
//'Generate File' butonuna tikladiktan sonra cikan 'Download' linkine tiklar.
//"Selenium practice yapiyorum!" cumlesinin download edildigini dogrular.
    @Test
    public void testName() {

    }
}
