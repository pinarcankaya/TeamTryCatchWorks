package api_pojos;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Bilgi {

    JsonPath jsonPath;
    Response myResponse;
 //   String endPoint="";

    // api sorusu için ihtiyaç duyabileceğiniz map.leri value.lerine göre sıralama kodları....
    // büyükten küçüğe ve küçükten büyüğe.

    @Test
    private void TC0202(){
   //     jsonPath = myResponse(endPoint).jsonPath();
        Map<String,Integer> myRates = jsonPath.getMap("rates");
        TreeMap<String,Integer> myOrderedRates = new TreeMap<>(myRates);
        System.out.println(myOrderedRates);
//kucukten buyuge
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        myOrderedRates.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        System.out.println(sortedMap);
//buyukten kucuge
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        myOrderedRates.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        System.out.println(reverseSortedMap);
    }
}
