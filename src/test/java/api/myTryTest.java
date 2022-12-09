package api;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class myTryTest {
       private final static String URL = "https://reqres.in/";
       private final static String first_name = "Janet";

    @DisplayName("Working")
    @Test
    public void checkNameAndIdTest () {
        checkNameAndId();

    }

    @Step  ("This is my first Step")
    public static void  checkNameAndId (){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());

       UserDataWithData userWithData = given()
               .when()
               .get("api/users/2")
               .then().log().all()
               .extract()
               .as(UserDataWithData.class);
       UserData userData = userWithData.getData();
        Assert.assertEquals(first_name, userData.getFirst_name());

    }



}
