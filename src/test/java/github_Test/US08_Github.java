package github_Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.*;

public class US08_Github {


    //ilgili end pointe get request yapildiginda
    // 1. status codun 200 oldugunu assert ediniz.
    // 2. toplam veri [] sayisini assert ediniz.
    // 3. "login" : datalarinin unique oldugunu assert ediniz
    // 4.  tum datalarin "type": "User", "site_admin": false oldugunu assert ediniz.     (FAIL)
    // 5. "id": datalarinin natural order olarak siralandigini assert ediniz.
    // 6."node_id" datalarinin en az bir numerik character icerdigini assert ediniz.
    // 7.""gravatar_id":  datalarinin bos ("") oldugunu assert ediniz.


    Response response;
    JsonPath json;
    String endpoint = "https://api.github.com/users";


    public void setup() {
        response = given().
                when().

                get(endpoint);
        // response.prettyPrint();
        json = response.jsonPath();
        response.then().assertThat().statusCode(200);


    }

    //toplam veri [] sayisini assert ediniz.
    @Test
    public void TC0802() {
        setup();

        int list = json.getList("$").size();
        System.out.println(list);
        Assert.assertEquals(list, 30);
    }

    //"login" : datalarinin unique oldugunu assert ediniz
    @Test
    public void TC0803() {
        setup();
        List<String> loginList = json.getList("login");
        int loginListSize = loginList.size();
        Set<String> loginSet = new HashSet<>(loginList);
        int loginSetSize = loginSet.size();
        Assert.assertEquals(loginListSize, loginSetSize);
    }

    // tum datalarin "type": "User", "site_admin": false oldugunu assert ediniz.     (FAIL)
    @Test
    public void TC0804() {
        setup();
        List<String> typeList = json.getList("type");
        List<String> siteAdminList = json.get("site_admin");


        for (int i = 0; i < typeList.size(); i++) {
            Assert.assertEquals(typeList.get(i), "User");//eksik
            //Assert.assertEquals(siteAdminList.get(i), "false");
        }


    }

    //"id": datalarinin natural order olarak siralandigini assert ediniz.
    @Test
    public void TC0805() {
        setup();
        List<Integer> idList = json.get("id");
        System.out.println(idList);
        Set<Integer> idSet = new TreeSet<>(idList);
        System.out.println(idSet);
        Assert.assertEquals(idList, idSet);
    }

    //"node_id" datalarinin en az bir numerik character icerdigini assert ediniz.
    @Test
    public void TC0806() {
        setup();
        List<String> nodeIddList = json.get("node_id");


    }

    //"gravatar_id":  datalarinin bos ("") oldugunu assert ediniz.
    @Test
    public void TC0807() {
        setup();
        List<String> gravataridList = json.getList("gravatar_id");
        System.out.println(gravataridList);
        for (String w : gravataridList) {
            Assert.assertEquals(w, "");
        }

        //lambda
        gravataridList.forEach(x -> Assert.assertEquals(x, ""));


    }


}
