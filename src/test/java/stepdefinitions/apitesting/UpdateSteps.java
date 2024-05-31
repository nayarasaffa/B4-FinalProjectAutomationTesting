package stepdefinitions.apitesting;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UpdateSteps {
    private RequestSpecification request;
    private Response response;
    private int statusCode;
    private String responseBody;
    private String userId;

    @Given("telah dilakukan authorization dengan app-id valid")
    public void authorizationAppID() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("app-id", "6627151a6cae036629dee799");
    }

    @Given("memiliki id user yaitu {string}")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @When("mengirimkan request PUT")
    public void sendPutRequest() {
        response = request.put("https://dummyapi.io/data/v1/user/" + userId);
        statusCode = response.getStatusCode();
        responseBody = response.getBody().asString();
    }

    @When("data firstname baru yaitu {string}")
    public void setStringFirstname(String stringFirstname) {
        updateUserData("{\"firstName\":\"" + stringFirstname + "\"}");
    }

    @When("data firstname baru yaitu {int}")
    public void setIntegerFirstname(int integerFirstname) {
        updateUserData("{\"firstName\":" + integerFirstname + "}");
    }

    @When("data email baru yaitu {string}")
    public void setEmail(String email) {
        updateUserData("{\"email\":\"" + email + "\",\"firstName\":\"Rachel\"}");
    }

    @Then("status code harus {int}")
    public void matchStatusCode(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, statusCode);
    }

    @Then("response body harus {string}")
    public void matchResponseBody(String expectedResponseBody) {
        Assert.assertEquals(expectedResponseBody, responseBody);
    }

    @Then("response harus sesuai skema JSON {string}")
    public void matchJsonSchema(String schemaPath) {
        response.then().assertThat().body(matchesJsonSchemaInClasspath("JSONSchemaData/" + schemaPath));
    }

    private void updateUserData(String data) {
        response = request.body(data).put("https://dummyapi.io/data/v1/user/" + userId);
        statusCode = response.getStatusCode();
        responseBody = response.getBody().asString();
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
    }
}
