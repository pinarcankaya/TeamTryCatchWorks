package api_tests;


import api_pojos.Result;
import api_pojos.TriviaPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class TriviaTest_Pojo_Cozum {

    ObjectMapper objectMapper = new ObjectMapper();
    Response response;
    String endPoint = "https://opentdb.com/api.php?amount=10&category=23&difficulty=easy&type=multiple";
    TriviaPojo triviaPojo;


    @Test
    public void responseMethod() {

        response = given().
                accept(ContentType.JSON).
                when().
                get(endPoint);

        response.then().
                assertThat().
                statusCode(200);
        //response.prettyPrint();

    }

    //  * "results" in icinde on(10) sorunun oldugunu dogrulayiniz.+++
    @Test
    public void TC02() throws IOException {
        responseMethod();
        triviaPojo = objectMapper.readValue(response.asString(), TriviaPojo.class);
        List<Result> resultlist = triviaPojo.getResults();
        Assert.assertEquals(resultlist.size(), 10);

    }
    ///   * "question" larin null olmadigini dogrulayiniz
    @Test
    public void TC03() throws IOException {
        responseMethod();
        triviaPojo = objectMapper.readValue(response.asString(), TriviaPojo.class);
        List<Result> questionList = triviaPojo.getResults();
        int count = 0;
        for (Result w : questionList) {
            System.out.println(w.getQuestion());
            if (w == null) {
                count++;
            }
        }
        /*    for (Result w : triviaPojo.getResults()) {
               Assert.assertNotNull(w.getQuestion());
               }
      */
        System.out.println(count);
        Assert.assertEquals(count, 0);



    }

    // // //// * "correct_answer" in null olmadigini ve her bir soruda birtane "correct_answer" oldugunu dogrulayiniz.
    @Test
    public void TC04() throws JsonProcessingException {
        responseMethod();
        triviaPojo = objectMapper.readValue(response.asString(), TriviaPojo.class);
        int count = 0;
        List<Result> correctList = triviaPojo.getResults();
        for (Result w : correctList) {
            Assert.assertNotNull(w.getCorrectAnswer());
            System.out.println(w.getCorrectAnswer());
            if (w == null) {
                count++;
            }
        }
        System.out.println(count);
        Assert.assertEquals(count, 0);
    }

    // * "incorrect_answers" cevaplarinin her soruda toplam 3 adet oldugunu ve gelen verilen null olmadiginidogrulayiniz.
    @Test
    public void TC05() throws JsonProcessingException {
        responseMethod();
        triviaPojo = objectMapper.readValue(response.asString(), TriviaPojo.class);
        int count = 0;
        List<Result> inCorrectList = triviaPojo.getResults();
        for (Result w : inCorrectList) {
          Assert.assertEquals(w.getIncorrectAnswers().size(),3);
            if (w == null) {
                count++;
            }
        }
        System.out.println(count);
        Assert.assertEquals(count, 0);
    }
}