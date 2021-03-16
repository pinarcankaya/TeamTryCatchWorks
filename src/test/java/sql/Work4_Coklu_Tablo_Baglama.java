package sql;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DatabaseConnector;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Work4_Coklu_Tablo_Baglama {

    //--tablo birlestirme formul
    //  select * from T1  join
    //              (T2, T3)
    //              on T2.A=T1.A and T3.C=T1.C and T3.B=T2.B
    @Test
    public void soru4() throws SQLException {

        String queryNew = "  select  distinct suppliers.company_name,first_name from  newschema.employees  join \n" +
                "       (newschema.orders,newschema.order_details,newschema.products,newschema.suppliers)\n" +
                "       on (orders.employee_id=employees.employee_id  and orders.order_id=order_details.order_id\n" +
                "       and order_details.product_id=products.product_id and products.supplier_id=suppliers.supplier_id)\n" +
                "       where first_name='Nancy';";
        List<Map<String, String>> list = DatabaseConnector.getQueryAsAListOfMaps(queryNew);
        System.out.println(list.size());
        Assert.assertEquals(list.size(), 29);

        /*
        String query4="select distinct suppliers.company_name,first_name\n" +
                "from newschema.employees\n" +
                "join newschema.orders\n" +
                "on orders.employee_id=employees.employee_id\n" +
                "join newschema.order_details\n" +
                "on orders.order_id=order_details.order_id\n" +
                "join newschema.products\n" +
                "on order_details.product_id=products.product_id\n" +
                "join newschema.suppliers\n" +
                "on products.supplier_id=suppliers.supplier_id\n" +
                "where first_name='Nancy'";  */


    }


}
