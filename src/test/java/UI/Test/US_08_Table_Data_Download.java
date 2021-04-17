package UI.Test;

import UI_Pages.US01_SimpleFormDemo_Page;
import UI_Pages.US_08_Table_Data_Download_Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class US_08_Table_Data_Download {

    Actions action = new Actions(Driver.getDriver());
    US01_SimpleFormDemo_Page seleniumEasyPage = new US01_SimpleFormDemo_Page();
    US_08_Table_Data_Download_Page tableDataDownloadPage = new US_08_Table_Data_Download_Page();

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
        tableDataDownloadPage.tableLink.click();
        tableDataDownloadPage.tableDataDownloadLink.click();
        ReusableMethods.waitFor(1);
        tableDataDownloadPage.searchBox.sendKeys("2012");

        ReusableMethods.waitFor(1);
//
       List<String> list = new ArrayList<>();
        for (WebElement w : tableDataDownloadPage.cityName) {
            list.add(w.getText());
        }
//
   //     Set<String> set = new HashSet<String>(list);//TC sonucu bu
        //System.out.println(set.size());
//        Assert.assertEquals(set.size(), 4);

        //!!!!!!!!!!!!!!!!!hangi sehirden kac tane
        System.out.println("List of elements: "+list);
        System.out.println("\n Hangi sehirden kac tane:");
        Set<String> uniqueSet = new HashSet<String>(list);
        for (String w : uniqueSet) {
            System.out.println(w + ": " + Collections.frequency(list, w));
        }

//        int count =0;
//        List<String> list1 = new ArrayList<>();
//      for(WebElement w:tableDataDownloadPage.cityName) {
//          list1.add(w.getText());
//          if (!list1.contains(w.getText())) {
//              count++;
//          }
//      }
//          System.out.println(count);
        //  System.out.println(Collections.frequency(list1, w.getText()));





        ////******ONEMLI BILGI==>frequency methodu tekrar eden elemani sayar
    /*ArrayList<Character> list = new ArrayList<Character>();
list.add('a');
list.add('a');
list.add('a');
list.add('a');
list.add('b');
list.add('b');
System.out.println("a" + " karakteri " + Collections.frequency(list, 'a') + " tane..");
System.out.println("b" + " karakteri " + Collections.frequency(list, 'b') + " tane.."); */
    }

}