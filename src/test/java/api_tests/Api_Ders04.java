package api_tests;


import api_pojos.Money;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Api_Ders04 {
//Kullanici ilgili Endpoint ile asagidakilerini sirasiyla yapabilmelidir.
//         * Status kodunun 200 oldugunu,
//         * "rates" in icinde  ==> - "USD": 1.1969,
//                                                  -  "GPD": 0.8567
//                                                 para birmlerinin bulundugunu ve  karsisinda sözkonusu
//yukardaki degerlerin güncel halinin bulundugunu (verify)
//         * "base" in ==>  "USD" oldugunu,(verify)

    ObjectMapper objectMapper = new ObjectMapper();
    Response response;
    String endPoint = "https://api.exchangeratesapi.io/latest?symbols=USD,GBP";
    JsonPath json;
    Money moneyPojo;
    @Test
    public void setup() throws IOException {
        response = given().
                accept(ContentType.JSON).
                when().
                get(endPoint);
        json = response.jsonPath();
        //  response.prettyPrint();

        response.then().assertThat().statusCode(200);

        moneyPojo= objectMapper.readValue(response.asString(), Money.class);
        float usd = moneyPojo.getRates().getUSD();
        System.out.println(usd);
        float gpd=moneyPojo.getRates().getGBP();
        System.out.println(gpd);

        Assert.assertTrue(usd>=1.19);
        Assert.assertTrue(gpd>=0.85);
    }

    @Test
    public void TC02() throws IOException {
        response = given().
                accept(ContentType.JSON).
                when().
                get(endPoint);
        json = response.jsonPath();

        moneyPojo= objectMapper.readValue(response.asString(), Money.class);
        String baseDegeri=moneyPojo.getBase();
        System.out.println(baseDegeri);
        Assert.assertNotEquals(baseDegeri,"USD");
    }
}