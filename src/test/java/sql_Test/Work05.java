package sql_Test;

import org.testng.annotations.Test;
import utilities.DatabaseConnector;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Work05 {
//ÖDEV:Suppliers tablosundan rastgele bir supplier'in company_name,supplier_id' sini getirin.
//  customers tablosundaki  "company_name,customer_id" sütunlarina random olarak buldugunuz degerleri ekleyiniz
//  eklediginiz bilgileri dogrulayiniz
    @Test
    public void soru1() throws SQLException {
        String query1 = "select * from customers;";

        List<Map<String, String>> list1 = DatabaseConnector.getQueryAsAListOfMaps(query1);
        System.out.println(list1);

        List<String> yeniList = new ArrayList<>();
        String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (Map<String, String> w : list1) {
         

        }
    }}