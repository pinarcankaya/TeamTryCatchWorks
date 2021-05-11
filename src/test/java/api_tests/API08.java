package api_tests;
import api_pojos.Result;
import api_pojos.TriviaPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;
public class API08 {
    Response response;
    JsonPath json;
    String endpoint = "https://opentdb.com/api.php?amount=10&category=23&difficulty=easy&type=multiple";
    ObjectMapper objectMapper;
    RequestSpecification spec ;


    @BeforeClass
    public void setUp() {
        response = given().get(endpoint);
        json = response.jsonPath();
        objectMapper = new ObjectMapper();
        spec = new RequestSpecBuilder().setBaseUri(endpoint).build();
    }

    @Test
    public void TC_01() {
        Response response = given().
                spec(spec).
                when().
                get();
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.getBody().asString(),"");

    }

    @Test
    public void TC_02() throws JsonProcessingException {
        spec.queryParam("amount","10");
        Response response = given().
                spec(spec).
                when().
                get();

        TriviaPojo questions = objectMapper.readValue(response.asString(), TriviaPojo.class);

        int amount =  questions.getResults().size();
        Assert.assertEquals(amount,10);

        Set<String> cateqories = questions.getResults().
                stream().
                map(Result::getCategory).
                collect(Collectors.toSet());
        System.out.println(cateqories);
        Assert.assertTrue(cateqories.size()>1);

        Set<String> difficulty = questions.getResults().
                stream().
                map(Result::getDifficulty).
                collect(Collectors.toSet());
        System.out.println(difficulty);
        Assert.assertTrue(difficulty.size()>1);

        Set<String> type = questions.getResults().
                stream().
                map(Result::getType).
                collect(Collectors.toSet());
        System.out.println(type);
        Assert.assertEquals(type.size(), 1);
    }

    @Test
    public void TC_03() throws JsonProcessingException {
        spec.queryParams("amount", "10",
                "category", "27");
        Response response = given().
                spec(spec).
                when().
                get();

        TriviaPojo questions = objectMapper.readValue(response.asString(), TriviaPojo.class);
        Set<String> category = questions.getResults().
                stream().
                map(Result::getCategory).
                collect(Collectors.toSet());
        System.out.println("category = " + category);
        Assert.assertTrue(category.size()==1 && category.contains("Animals"));

        Set<String> type = questions.getResults().
                stream().
                map(Result::getType).
                collect(Collectors.toSet());
        System.out.println(type);
        Assert.assertTrue(type.size()>1);

    }

    @Test
    public void TC_04() {
        spec.queryParams("amount",10,
                "type","boolean");
        response =  given().
                spec(spec).
                when().
                get();
        TriviaPojo questions = response.as(TriviaPojo.class);
        int amount = questions.getResults().size();
        Assert.assertEquals(amount,10);

        Set<String> types =  questions.getResults().stream().map(Result::getType).collect(Collectors.toSet());
        Assert.assertTrue(types.size()==1 && types.contains("boolean"));
    }
}


