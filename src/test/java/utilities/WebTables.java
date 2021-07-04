package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTables {

    public static List<WebElement> getBasliklar(){
        return Driver.getDriver().findElements(By.xpath("(//table)[1]//th"));
    }
    public static List<WebElement> getSatirlar(){
        return Driver.getDriver().findElements(By.xpath("(//table)[1]/tbody/tr"));
    }
    public static List<WebElement> getTumHucreler(){
        return Driver.getDriver().findElements(By.xpath("(//table)[1]/tbody//td"));
    }
    public static List<WebElement> getSatirdakiHucreler(int satir){
        return Driver.getDriver().findElements(By.xpath("((//table)[1]/tbody/tr)["+satir+"]"));
    }
    public static List<WebElement> getSutun(int sutun){
        return Driver.getDriver().findElements(By.xpath("(//table)[1]//tr/td["+sutun+"]"));
    }
}
