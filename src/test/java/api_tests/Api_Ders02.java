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

public class Api_Ders02 {

    //Kullanici 2010-01-12 tarihindeki döviz referans oranlarını alabilmali ve
    //asagidakilerini sirasiyla yapabilmelidir.
    //         * Status kodunun 200 oldugunu,
    //         * "rates" in icinde  ==> - "TRY": 2.1084,
    //                                                  -  "CZK": 26.258,
    //                                                  -  "PLN": 4.0838, para birmlerinin bulundugunu ve
    //karsisinda sözkonusu yukardaki degerlerin oldugunu (verify)
    //         * "base" in ==>  "EUR" oldugunu,
    //         * "date" in ==>   2010-01-12 "yil/ay/gun" tarih zaman
    //dilimi oldugunu.(verify)

    ObjectMapper objectMapper = new ObjectMapper();
    Response response;
    String endPoint = "https://api.exchangeratesapi.io/2010-01-12";
    JsonPath json;

    @Test
    public void TC01() throws IOException {
        response = given().
                accept(ContentType.JSON).
                when().
                get(endPoint);
        json = response.jsonPath();
        //  response.prettyPrint();

        response.then().assertThat().statusCode(200);

        Money moneyPojo = objectMapper.readValue(response.asString(), Money.class);
        float tryy = moneyPojo.getRates().getTRY();
        System.out.println(tryy);
        float czk = moneyPojo.getRates().getCZK();
        System.out.println(czk);
        float pln = moneyPojo.getRates().getPLN();
        System.out.println(pln);

        Assert.assertTrue(tryy == 2.1084f);
        Assert.assertTrue(czk == 26.258f);
        Assert.assertTrue(pln == 4.0838f);

    }

    // * "EUR" ya göre en yüksek 3'üncü rate'in (en degerli paranin) ==>"USD" para birimi oldugu ve
//rate'inin ise  1.4481'oldugunu,
//- ayrica söz konusu tarihteki  en düsük para biriminin "HUF" oldugunu ve degerinin ise 268.18 oldugunu(verify)
    @Test
    public void TC02() {

        response = given().
                accept(ContentType.JSON).
                when().
                get(endPoint);
        json = response.jsonPath();

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