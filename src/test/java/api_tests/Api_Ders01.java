package api_tests;


import api_pojos.Money;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Api_Ders01 {

    ObjectMapper objectMapper = new ObjectMapper();
    Response response;
    String endPoint = "https://api.exchangeratesapi.io/latest";
    JsonPath json;

    //(Pojo Ile Yapilacak)
//Kullanici aktuel döviz referans oranlarını alabilmali ve
//asagidakilerini sirasiyla yapabilmelidir.
//         * Status kodunun 200 oldugunu,
//         * "rates" in icinde  ==> - "CAD": 1.5394,
//                                                  -  "USD": 1.2127,
//                                                  -  "TRY": 8.5503, para birmlerinin bulundugugunu ve
//karsisinda sözkonusu yukardaki degerlerin oldugunu (verify)
//         * "base" in ==>  "EUR" oldugunu,
//         * "date" in ==>   Rate'lerin alindigi (testinin yapildigi) gündeki "yil/ay/gun" tarih zaman
//dilimi oldugunu.(verify)
    @Test
    public void TC01() throws IOException {
        response = given().
                accept(ContentType.JSON).
                when().
                get(endPoint);
        json = response.jsonPath();
        response.prettyPrint();

        response.then().assertThat().statusCode(200);


        Money ratesPojo = objectMapper.readValue(response.asString(), Money.class);

        float cad = ratesPojo.getRates().getCAD();
        float usd = ratesPojo.getRates().getUSD();
        float try1 = ratesPojo.getRates().getTRY();

        Assert.assertTrue(cad == 1.5418f);
        Assert.assertTrue(usd == 1.2108f);
        Assert.assertTrue(try1 == 8.5010f);

//        Assert.assertEquals(cad, 1.5418);  ///1.5418000221252441 cikiyor
//        Assert.assertEquals(usd, 1.2108);   //,1.210800051689148
//        Assert.assertEquals(try1, 8.5010);  //8.50100040435791



        String base = ratesPojo.getBase();
        String date = ratesPojo.getDate();
        Assert.assertEquals(base, "EUR");
        Assert.assertEquals(date, "2021-02-12");


        // * "EUR" ya göre en yüksek rate'in (en degerli paranin) ==>"GBP"para birimi oldugu ve
        //rate'in ise  0.8765'oldugunu (verify)

    }

    @Test
    public void TC02() {

        JsonPath json = response.jsonPath();
        Map<String, Float> allRates = json.getMap("rates");

        float euro = 1.0F;
        for (String currencyKey : allRates.keySet()) {
            float rate = allRates.get(currencyKey);

            if (currencyKey.toUpperCase().equals("GBP")) {
                Assert.assertTrue(euro > rate);
            } else {
                Assert.assertTrue(euro < rate);
            }
        }
    }
}