package UI.Test;

import UI_Pages.US01_SimpleFormDemo_Page;
import UI_Pages.US_09_JQuery_Download_Page;
import UI_Pages.US_10_Page;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US10_ {

    private static Object Convert;
    Actions action = new Actions(Driver.getDriver());
    US01_SimpleFormDemo_Page seleniumEasyPage = new US01_SimpleFormDemo_Page();
    US_10_Page us10Page=new US_10_Page();


    @BeforeTest
    public void setup() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seleniumEasyPage.noThanks.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us10Page.progresBarLink.click();
        ReusableMethods.waitFor(1);
        us10Page.drogDropSliderLink.click();
        ReusableMethods.waitFor(1);

    }

    //Kullanici, Advanced ==> "Drag & Drop Sliders" linkine tiklar. Acilan sayfada 'Default value 10'
   // slider'ini range 1'e kaydirir. Range'in 1 oldugunu dogrular
    @Test
    public void TC01() {

      //  action.dragAndDropBy(us10Page.sliderList.get(0),-40 , 0).build().perform();
    // action.moveToElement(us10Page.sliderList.get(0)).moveByOffset(-267,0).release().perform();
      // action.moveByOffset(44,0).build().perform();
       // action.clickAndHold(us10Page.sliderList.get(0)).moveByOffset(-49,0).build().perform();
      //  ReusableMethods.waitFor(1);
       // action.clickAndHold(us10Page.sliderList.get(0)).moveByOffset(10,0).build().perform();
       // ReusableMethods.waitFor(1);
       // action.clickAndHold(us10Page.sliderList.get(0)).moveByOffset(-123,0).build().perform();
//
        int sliderWidth = us10Page.sliderList.get(0).getSize().getWidth();
        int sliderHigth=us10Page.sliderList.get(0).getSize().getHeight();
        Dimension sliderWidth2=us10Page.sliderList.get(0).getSize();

      //  System.out.println(sliderWidth);

        action.moveToElement(us10Page.sliderList.get(0)).clickAndHold().moveByOffset(-sliderWidth, 0)
                .release().perform();
        action.moveToElement(us10Page.sliderList.get(0)).clickAndHold().moveByOffset(sliderWidth, 0)
                .release().perform();

//        ReusableMethods.waitFor(1);
//        if(sliderWidth>sliderHigth){
//            //high likely a horizontal slider
//             action.clickAndHold( us10Page.sliderList.get(0)).moveByOffset(-(sliderWidth/2),0).
//                    moveByOffset(((sliderWidth/100)*33),0).
//                    release().build().perform();
//        }else{
//            //high likely a vertical slider
//            action.clickAndHold( us10Page.sliderList.get(0)).moveByOffset(0, -(sliderHigth/2)).
//                    moveByOffset(0,(int)((sliderHigth/100)*33)).
//                    release().build().perform();
//        }

//        JavascriptExecutor js= (JavascriptExecutor)Driver.getDriver();
//        js.executeScript("arguments[0].setAttribute('style', 'left: 99%;')",us10Page.sliderList.get(0));



    }


}
