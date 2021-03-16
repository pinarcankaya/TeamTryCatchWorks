package sql;

import org.testng.annotations.Test;
import utilities.DatabaseConnector;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

///git remote -v hangi relote respository'e bagalsin sorgu kodu
//git remote set-url origin https://github.com/........git////yeni baglanacak repo
public class Work2 {

    //-supliers ülkesi almanya olan ülkelerin product name.leri nedir?suppliers ve
    // products tabloları kullanılacak, 9 adet ürün listelenecek.


    @Test
    public void TC01() throws SQLException {
        String query="select order_date\n" +
                "from orders\n" +
                "limit 1";
        List<Map<String,String>> list1= DatabaseConnector.getQueryAsAListOfMaps(query);
    }
}
