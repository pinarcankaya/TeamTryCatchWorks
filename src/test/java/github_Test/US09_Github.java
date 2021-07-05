package github_Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class US09_Github {


    Response response;
    JsonPath json;
    String endpoint = "https://api.github.com/orgs/toml-lang";


    public void setup() {
        response = given().
                when().
                get(endpoint);
        // response.prettyPrint();
        json = response.jsonPath();
        response.then().assertThat().statusCode(200);

    }

    //1. "login" nin ==> "toml-lang",
    //    "id"       nin ==> 7966854, oldugunu verify ediniz.
    @Test
    public void TC0901() {
        setup();
        String login=json.getString("login");
        System.out.println(login);
        int id=json.getInt("id");
        System.out.println(id);

    }


    //2. "company": null,
    //    "blog": null,
    //    "location": null,
    //    "email": null,
    //    "twitter_username": null,
    //Bes(5) tane value'nin null oldugunu assert ediniz
    @Test
    public void TC0902() {
        setup();
        String company=json.getString("company");
        String blog=json.getString("blog");
        String location=json.getString("location");
        String email=json.getString("email");
        String twitter_username=json.getString("twitter_username");

        boolean values=false;
        if(company==null && blog==null && location==null && email==null && twitter_username==null){
            values=true;
        }
        Assert.assertTrue(values);

    }

    //3. olusturma tarihinin (created_at) 2014
    //güncelleme tarihinin(updated_at) 2020 oldugunu dogrulayiniz.
    @Test
    public void TC0903() {
        setup();
        String created=json.getString("created_at");
        String updated=json.getString("updated_at");

        String createdYear=created.substring(0,4);
        String updatedYear=updated.substring(0,4);
        System.out.println(createdYear);
        System.out.println(updatedYear);

        Assert.assertEquals(createdYear,"2014");
        Assert.assertEquals(updatedYear,"2020");




    }
}
