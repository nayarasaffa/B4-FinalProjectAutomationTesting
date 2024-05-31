package stepdefinitions.apitesting;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetSteps {
    private Response response;
    private String appId;
    private String userId;

    @Given("App id get request {string}")
    public void setAppId(String appId){
        this.appId = appId;
    }

    @Given("Id user get request {string}")
    public void setIdUser(String userId) {
        this.userId = userId;
    }

    @When("Mengirim request GET")
    public void sendGetRequest() {
        response = RestAssured.given()
                .baseUri("https://dummyapi.io/data/v1/user")
                .header("Accept", "application/json")
                .header("app-id", appId)
                .get("/" + userId);
    }

    @Then("Respon status code get request harus {int}")
    public void matchStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        System.out.println("Expected Status Code : " + actualStatusCode);
        System.out.println("Actual Status Code : " + actualStatusCode);
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("Respon body get request harus {string}")
    public void matchResponseBody(String expectedResponseBody) {
        String actualResponseBody = response.getBody().asString();
        System.out.println("Expected Response Body : " + expectedResponseBody);
        System.out.println("Actual Response Body : " + actualResponseBody);
        Assert.assertEquals(expectedResponseBody, actualResponseBody);
    }

    @Then("Respon body get request harus sesuai dengan JSONSchema {string}")
    public void matchJsonSchema(String schemaPath) {
        String responseBody = response.getBody().asString();
        System.out.println("Response Body : " + responseBody);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("JSONSchemaData/" + schemaPath));
    }

}
