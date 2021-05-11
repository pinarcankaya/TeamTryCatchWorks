package api_tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Trivia_Test {


    Response response;
    String endPoint = "https://opentdb.com/api.php?amount=10&category=23&difficulty=easy&type=multiple";
    JsonPath json;


    //Kullanici asagidakilerini sirasiyla yapabilmelidir.
    //   * Status kodunun 200 oldugunu,+++
    //  * "results" in icinde on(10) sorunun oldugunu dogrulayiniz.+++
    // * Response ta gelen sorularda
    //   * "question" larin null olmadigini dogrulayiniz
    //   * "correct_answer" in null olmadigini ve her bir soruda birtane "correct_answer" oldugunu dogrulayiniz.
    //   * "incorrect_answers" cevaplarinin her soruda toplam 3 adet oldugunu ve gelen verilen null olmadiginidogrulayiniz.
    @Test
    public void responseMethod() {
        response = given().
                accept(ContentType.JSON).
                when().
                get(endPoint);
        json = response.jsonPath();
        //  response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
// * "results" in icinde on(10) sorunun oldugunu dogrulayiniz.+++
    @Test
    public void TC01() {
        responseMethod();
        List<Map<String,String>> resultlist = json.getList("results");
         System.out.println(resultlist.size());
        Assert.assertEquals(resultlist.size(), 10);
        for (Map<String,String> w : resultlist) {
            Assert.assertTrue(w.containsKey("correct_answer"));
        }

    }

    ///   * "question" larin null olmadigini dogrulayiniz
    @Test
    public void TC02() {
        responseMethod();
        List<String> questionList = json.getList("results.question");
        System.out.println(questionList);

        int count = 0;
        for (String w : questionList) {
            if (w==null) {
                count++;
            }
        }
         System.out.println(count);
        Assert.assertEquals(count,0);
    }

    // //// * "correct_answer" in null olmadigini ve her bir soruda birtane "correct_answer" oldugunu dogrulayiniz.
    @Test
    public void TC03() {
        responseMethod();
        List<String> correctAnswerList = json.getList("results.correct_answer");
        System.out.println(correctAnswerList);
        System.out.println(correctAnswerList.size());

        int count2 = 0;
        for (String w : correctAnswerList) {
            if (w==null ) {
                count2++;
            }
        }
         System.out.println(count2);
        Assert.assertEquals(count2,0);

    }
// // * "incorrect_answers" cevaplarinin her soruda toplam 3 adet oldugunu ve gelen verilen null olmadiginidogrulayiniz.
    @Test
    public void TC04() {
        responseMethod();
        List<List<String>> inCorrectAnswerList = json.getList("results.incorrect_answers");
        System.out.println(inCorrectAnswerList);
        System.out.println(inCorrectAnswerList.size());

        int count3 = 0;
        for (List<String> w : inCorrectAnswerList) {
            System.out.println(w.size());
            Assert.assertEquals(w.size(),3);

            for (String k : w) {
                if (w == null) {
                    count3++;
                }

            }
        }
        System.out.println(count3);
    }


}