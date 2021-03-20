package api_tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static io.restassured.RestAssured.given;

public class Api_Ders05 {



    Response response;
    String endPoint = "https://api.exchangeratesapi.io/history?start_at=2018-01-01&end_at=2018-09-01";
    JsonPath json;

    //Kullanici ilgili Endpoint ile asagidakilerini sirasiyla yapabilmelidir.
    //         * Status kodunun 200 oldugunu,
    //         * "2018-05-04" ==> dönemindeki en degerli Para biriminin ==>"GBP" oldugunu,
    //         * "TRY" nin ise Euro karsisindaki degerinin ==> "5.0963" oldugunu dogrulayiniz.
    @Test
    public void TC0502() {
        response = given().
                accept(ContentType.JSON).
                when().
                get(endPoint);
        json = response.jsonPath();
     //   response.prettyPrint();

        response.then().assertThat().statusCode(200);
        Map<String, Float> allRates = json.getMap("rates.2018-05-04");
      //  System.out.println(allRates);

        Map<String, Float> treeMap=new TreeMap<>(allRates);
        Map<String, Float> linked=new LinkedHashMap<>();

        float min=1.0f;
        String minKey="";
        for (String w: allRates.keySet()) {
            if(allRates.get(w)<min){
               min=allRates.get(w);
                minKey=w;
            }
        }
        System.out.println(minKey);
        System.out.println(allRates.get(minKey));


        //////////*******LAMBDA ILE COZUM
        Map<String, Float> treeMapRates = new TreeMap<>(allRates);
        Map<String, Float> sortedMapByValue = new LinkedHashMap<>();
        treeMapRates.entrySet().
                stream().
                sorted(Map.Entry.comparingByValue()).
                forEachOrdered(t -> sortedMapByValue.put(t.getKey(), t.getValue()));
        System.out.println(sortedMapByValue);
        Object [] keyset = sortedMapByValue.keySet().toArray();

        Assert.assertEquals(keyset[0].toString(), "GBP");

        Double expectedRate=5.0963;
        Double actualRate = Double.parseDouble(allRates.get("TRY") + "");

        Assert.assertEquals(actualRate, expectedRate);
    }
}
