package UI.Test;

import UI_Pages.US01_SimpleFormDemo_Page;
import UI_Pages.US_08_Table_Data_Download_Page;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;

import javax.print.*;
import javax.print.attribute.PrintRequestAttributeSet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        tableDataDownloadPage.tableLink.click();
        tableDataDownloadPage.tableDataDownloadLink.click();
        ReusableMethods.waitFor(1);
    }

    @Test
    public void TC01() {
        tableDataDownloadPage.searchBox.sendKeys("2012");
        ReusableMethods.waitFor(1);

        List<String> list = new ArrayList<>();
        for (WebElement w : tableDataDownloadPage.cityName) {
            list.add(w.getText());
        }

        Set<String> set = new HashSet<String>(list);//TC sonucu
        System.out.println(set.size());
        Assert.assertEquals(set.size(), 4);

        //==========hangi sehirden kac tane//=================
        System.out.println("List of elements: " + list);
        System.out.println("\n Hangi sehirden kac tane:");
        Set<String> uniqueSet = new HashSet<String>(list);
        for (String w : uniqueSet) {
            System.out.println(w + ": " + Collections.frequency(list, w));
        }

//*****************2.yol*********************
        List<String> list1 = new ArrayList<>();
        for (WebElement w : tableDataDownloadPage.cityName) {
            String city = w.getText();
            if (!list1.contains(city)) {
                list1.add(city);
            }
        }
        System.out.println(list1);
        System.out.println(list1.size());


    }

    @Test
    public void TC02() {
        tableDataDownloadPage.searchBox.sendKeys("London");
        tableDataDownloadPage.pdfButton.click();

        String filePath = "C:\\Users\\pinar\\Downloads\\Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.pdf";
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        ReusableMethods.waitFor(4);
        Assert.assertTrue(isDownloaded);


    }

    @Test
    public void pdfReader() {
        String filePath = "C:\\Users\\pinar\\Downloads\\Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.pdf";
        String page = "";

        try {

            PdfReader reader = new PdfReader(filePath);
            System.out.println("This PDF has " + reader.getNumberOfPages() + " pages.");
            page = PdfTextExtractor.getTextFromPage(reader, 1);
            System.out.println("Page Content:\n\n" + page + "\n\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(page.contains("London"));

    }

    //////////*****************PRINTER************************

    @Test//PDF, yazıcı tarafından desteklenip desteklenmediigini anlamak icin
    public void printerUyum() throws IOException, PrintException {
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        int count = 0;
        for (DocFlavor docFlavor : service.getSupportedDocFlavors()) {
            if (docFlavor.toString().contains("pdf")) {
                count++;
            }
        }
        if (count == 0) {
            System.err.println("PDF not supported by printer: " + service.getName());
            System.exit(1);
        } else {
            System.out.println("PDF is supported by printer: " + service.getName());
        }

    }


    @Test
    public void FilePrinter() throws FileNotFoundException {
        String filePath = "C:\\Users\\pinar\\Downloads\\Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.pdf";
        FileInputStream in = new FileInputStream(filePath);
        Doc doc = new SimpleDoc(in, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();

        try {
            service.createPrintJob().print(doc, null);
        } catch (PrintException e) {
            e.printStackTrace();
        }


    }

//    @Test
//    public void pdfWiewer() throws FileNotFoundException {
//        String filePath="C:\\Users\\pinar\\Downloads\\Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.pdf";
//        PdfViewer viewer = new PdfViewer();
////Open input PDF file
//        viewer.bindPdf(dataDir + filePath);
////Print PDF document
//        viewer.printDocument();
////Close PDF file
//        viewer.close();
//
//    }


    @Test///devam et
    public void rrrrr() {

        String excelFile="C:\\Users\\pinar\\Downloads\\Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.xlsx";
        ExcelUtil excelUtil=new ExcelUtil(excelFile,"Sheet1");
        List<Map<String,String>> testData=excelUtil.getDataList();
        excelUtil.getDataList();
        System.out.println(testData);

    }
}