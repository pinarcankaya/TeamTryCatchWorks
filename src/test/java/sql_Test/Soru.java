package sql_Test;

import utilities.DatabaseConnector;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Soru {

    @Test
    public void testName() throws SQLException {
        String query1 = "select count(city) \n" +
                "from customers\n" +
                "where city='Berlin'";

        List<Map<String, String>> list1 = DatabaseConnector.getQueryAsAListOfMaps(query1);
        System.out.println(list1.get(0).get("count(city)"));
        Assert.assertTrue(list1.get(0).equals(1));

        String query2 = "select count(city),city\n" +
                "from customers\n" +
                "where city='London' or city='Berlin'\n" +
                "group by city;";
        
        List<Map<String, String>> list2 = DatabaseConnector.getQueryAsAListOfMaps(query2);
        System.out.println(list2.get(0).get("count(city)"));
    }
}