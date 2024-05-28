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

public class CreateSteps {
    private Response response;
    private Map<String, String> userData;

    @Given("I have user data")
    public void createUser(DataTable dataTable) {
        userData = new HashMap<>();
        userData.putAll(dataTable.asMaps().get(0));
    }

    @When("I send a POST request to create the user")
    public void sendPostRequest() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("app-id", "662715096cae038e24dee790");
        response = request.body(userData).post("/user/create");
    }

    @Then("the response status code should be {int}")
    public void matchStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        System.out.println("Status Code : " + actualStatusCode);
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("the response should match with JSONSchema {string}")
    public void matchJsonSchema(String schemaPath) {
        String responseBody = response.getBody().asString();
        System.out.println("Response Body : " + responseBody);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("JSONSchemaData/" + schemaPath));
    }

    @Then("the response body should be {string}")
    public void matchResponseBody(String expectedResponseBody) {
        String actualResponseBody = response.getBody().asString();
        System.out.println("Expected Response Body : " + expectedResponseBody);
        System.out.println("Actual Response Body : " + actualResponseBody);
        Assert.assertEquals(expectedResponseBody, actualResponseBody);
    }
}
