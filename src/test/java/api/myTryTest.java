package api;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class myTryTest {
       private final static String URL = "https://reqres.in/";
       private final static String first_name = "Janet";

    @DisplayName("Working")
    @Test
    public void checkNameAndIdTest () {
        checkNameAndId();

    }

    @Step("This is my first Step")

    public  void  checkNameAndId (){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());

       UserDataWithData userWithData = given()
               .when()
               .get("api/users/2")
               .then().log().all()
               .extract()
               .as(UserDataWithData.class);
       UserData userData = userWithData.getData();
       Assertions.assertThat(first_name).isEqualTo(userData.getFirst_name());


    }



}
