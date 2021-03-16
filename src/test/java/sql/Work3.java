package sql;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DatabaseConnector;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Work3 {
    //--suppliers region.u 'OR' olan product name.leri nedir?
    // suppliers ve products tabloları kullanılacak, 3 adet ürün listelendigini dogrulayiniz.


    @Test
    public void soru1() throws SQLException {
        String query1 = "select count(region)\n" +
                "from newschema.suppliers\n" +
                "join newschema.products\n" +
                "on newschema.suppliers.supplier_id=newschema.products.supplier_id\n" +
                "where region='OR'";

        List<Map<String, String>> list1 = DatabaseConnector.getQueryAsAListOfMaps(query1);
        System.out.println(list1.get(0));
      Assert.assertEquals(list1.get(0).get("count(region)"), "3");
    }

    @Test
    public void soru2() throws SQLException {
        //--contact title i owner olan kisilerin region degerlerinin null oldugunu dogrulayiniz.
        // Suppliers tablosu kullanılacak.

        String query2 = "select region\n" +
                "        from newschema.suppliers\n" +
                "        where  contact_title='Owner'";

        List<Map<String, String>> list2 = DatabaseConnector.getQueryAsAListOfMaps(query2);
        System.out.println(list2.get(0));
        Assert.assertEquals(list2.get(0).get("region"), null);


    }

    //--customers tablosunda 69 farkli city bulunmaktadir.dogrulayiniz
    @Test
    public void soru3() throws SQLException {
        String query3 = "select distinct city\n" +
                "from newschema.customers";

        List<Map<String, String>> list2 = DatabaseConnector.getQueryAsAListOfMaps(query3);
        System.out.println(list2.size());
       Assert.assertEquals(list2.size(), 69);
    }

    //--employees tablosundan `Nancy' hangi firmalarin urunlerini satmis? ( kullanilacak tablolar: orders,employees,
    //--order_dateils,products,suppliers) Nancy nin toplam 29 urun sattigini dogrulayiniz.
    @Test
    public void soru4() throws SQLException {
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
                "where first_name='Nancy'";

        List<Map<String, String>> list4 = DatabaseConnector.getQueryAsAListOfMaps(query4);
        System.out.println(list4.size());
        Assert.assertEquals(list4.size(), 29);
    }

    //tablo birlestirme ***************
   // select * from region join
   //               (territories,employee_territories,employees)
   //               on (region.region_id=territories.region_id and employee_territories.territory_id= territories.territory_id and
  //                employee_territories.employee_id=employees.employee_id)
    // where employees.employee_id >=6 and region.region_description='Western' and territories.territory_description='Seattle' ;
    //
    //--tablo birlestirme formul
    //  select * from T1  join
    //              (T2, T3)
    //              on T2.A=T1.A and T3.C=T1.C and T3.B=T2.B
}
