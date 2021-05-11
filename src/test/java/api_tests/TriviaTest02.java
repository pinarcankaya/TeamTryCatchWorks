package api_tests;

import api_pojos.TriviaPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class TriviaTest02 {

    ObjectMapper objectMapper = new ObjectMapper();
    Response response;
    String baseUrl = "https://opentdb.com/api.php";
    JsonPath json;
    RequestSpecification spec01;

    @BeforeTest
    public void setup() {
        spec01 = new RequestSpecBuilder().setBaseUri(baseUrl).build();
        response = given().
                accept(ContentType.JSON).
                when().
                get(baseUrl);
        json = response.jsonPath();

    }
    //Base enpointe get request yapildiginda
    // status kodu 200 ve body nin bos oldugunu dogrulayiniz.

    @Test
    public void TC01() {
        Response response = given().
                spec(spec01).
                when().
                get();
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.getBody().asString(), "");
        // response.getBody().asString().equals("");
    }

    //Base endpointe amount key ve 10 value su ile query yapildiginda
    // responsta toplam 10 adet sorunun oldugunu dogrulayiniz
    @Test
    public void TC02() {
        spec01.queryParam("amount", "10");
        response = given().
                spec(spec01).
                when().
                get();
        json = response.jsonPath();
        // response.prettyPrint();
        List<String> questionList = json.getList("results.question");
        System.out.println(questionList.size());
        Assert.assertEquals(questionList.size(), 10);

    }

    //  * category ve difficulty degerlerinin birbirinden farkli degrler geldigini dogrulayiniz.
    @Test
    public void TC03() {
        spec01.queryParam("amount", "10");
        response = given().
                spec(spec01).
                when().
                get();
        json = response.jsonPath();

        List<Object> categoryList = json.getList("results.category");
        Set<Object> categorySet = new HashSet<Object>(categoryList);

        List<Object> difficultyList = json.getList("results.difficulty");
        Set<Object> difficultySet = new HashSet<Object>(difficultyList);

        for (Object w : categorySet) {
            for (Object k : difficultySet) {
                Assert.assertTrue(w.toString() != k.toString());
            }
        }

    }

    //Tum sorularin coktan secmeli olarak geldigini dogrulayiniz.
    @Test
    public void TC04() {
        spec01.queryParam("amount", "10");
        response = given().
                spec(spec01).
                when().
                get();
        json = response.jsonPath();
        List<String> typeList = json.getList("results.type");
        System.out.println(typeList);
        boolean coktanSecmeliMi = false;
        for (String w : typeList) {
            if (w.equals("multiple") || w.equals("boolean"))
                coktanSecmeliMi = true;
            Assert.assertEquals(coktanSecmeliMi, true);
        }
    }

    //Base endponte (amount key, value 10) ve (category key value 27) query paramlari ile get request yapildiginda
    // Gelen sorularin categorisinin Animals oldugunu dogrulayiniz
    @Test
    public void TC05() {
        spec01.queryParams("amount", "10", "category", "27");
        response = given().
                spec(spec01).
                when().
                get();
        json = response.jsonPath();
        List<String> animalsList = json.getList("results.category");
        for (String w : animalsList) {
            Assert.assertEquals(w, "Animals");
        }

    }
    //Base endponte (amount key, value 10) ve (category key value 27) query paramlari ile get request yapildiginda
 //* Gelen sorularin typenin birbirinden farkli oldugunu dogrulayniz.
    @Test
    public void TC06() {
        spec01.queryParams("amount", "10", "category", "27");
        response = given().
                spec(spec01).
                when().
                get();
        json = response.jsonPath();
    }

   //Base endpointe (amount key, value 10) ve (type key , value boolean)  query paramlari ile get request yapildiginda
   //        *  responsta toplam 10 adet sorunun oldugunu dogrulayiniz
    @Test
    public void TC07() {
        spec01.queryParams("amount", "10", "category", "27");
        response = given().
                spec(spec01).
                when().
                get();
        json = response.jsonPath();
    }
    //Base endpointe (amount key, value 10) ve (type key , value boolean)  query paramlari ile get request yapildiginda
    //  * gelen sorularin typenin boolean oldugunu dogrulayiniz.
    @Test
    public void TC08() {
        spec01.queryParams("amount", "10", "category", "27");
        response = given().
                spec(spec01).
                when().
                get();
        json = response.jsonPath();
    }

}