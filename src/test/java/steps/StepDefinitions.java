package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


import java.io.File;
import java.net.URI;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;


public class StepDefinitions {

    private URI uri;
    private RequestSpecification requestSpec;
    private io.restassured.response.Response response;

    //private WebDriver driver;

    @Given("^I have setup web Api$")
    public void iHaveSetupWebApi() throws Throwable {
        // Write code here that turns the phrase above into concrete actions


         String url = "http://denotsl454.int.kn:8013//msswifttransformation/service";
       // String url = "http://denotsl278.int.kn:8013/msswiftenvironment/meta/configurations/";
        uri = new URI(url);
        requestSpec =
                given()

                        // .accept(ContentType.JSON)
                        .contentType("application/json");

    }

    @When("^I call the web api endpoint$")
    public void iCallTheWebApiEndpoint() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        response = requestSpec
                .when()
                .get(uri);
    }

    @Then("^there should be respone back$")
    public void thereShouldBeResponeBack() throws Throwable {

        // Write code here that turns the phrase above into concrete actions
        requestSpec.then()
                .statusCode(200).log().all()
                .body("values:", equalTo("LT0_d"));


        // Validate that response status code matches 200
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println(statusCode);

        // Validate that response body contains "LT0"
        String res = response.getBody().asString();
        Assert.assertThat(res, containsString("LT0"));
        System.out.println(res);


    }

    @Given("^I have setup Audit web Api$")
    public void i_have_setup_Audit_web_Api() throws Throwable {
        String url = "http://denotsl278.int.kn:8013/msswiftenvironment/meta/instance/";
        uri = new URI(url);

        requestSpec =
                given()
                        // .accept(ContentType.JSON)
                        .contentType("application/json");
    }

    @When("^I call the web Audit api endpoint$")
    public void i_call_the_web_Audit_api_endpoint() throws Throwable {
        response = requestSpec
                .when()
                .get(uri);
    }

    @Then("^there should be respone$")
    public void there_should_be_respone() throws Throwable {
        requestSpec.then()
                .statusCode(200);

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
        System.out.println(statusCode);


        String res = response.getBody().asString();
        System.out.println(res);

    }


    @Given("^I have setup Transformation web Api$")
    public void i_have_setup_Transformation_web_Api() throws Throwable {

        File file = new File("C:\\Users\\anil.nagisetty\\IdeaProjects\\Example\\src\\test\\java\\Resources\\transformation.json");
        String content = null;


        // Write code here that turns the phrase above into concrete actions
        String url = "http://denotsl278.int.kn:8013/msswifttransformation/service/";

        uri = new URI(url);

        requestSpec =
                given()
                        // .accept(ContentType.JSON)
                        .contentType("application/json")
                        .header("X-KN-SWIFT-ROUTE", 1)
                        //.param("","")
                        .header("X-KN-SWIFT-STUB", "false")
                        .header("X-KN-SWIFT-STEP", "{\"routeId\":1,\"stepNo\":1,\"action\":{\"id\":1,\"name\":\"Test Transformation Action 1\",\"serviceId\":\"msswifttransformation\",\"actionType\":\"TRANSFORMATION\",\"synchronousCapable\":true,\"implementation\":{\"id\":4,\"name\":\"Test Transformation 1\",\"version\":\"0.0.1\",\"source\":null,\"target\":null},\"fromMessage\":{\"id\":2,\"name\":\"ITMMST\",\"version\":\"0100\"},\"toMessage\":{\"id\":3,\"name\":\"KN_PART_INB_IFD\",\"version\":\"\"}},\"synchronous\":true}")
                        .body(file).log().all();
    }


    @When("^I call the web Transformation api endpoint using POST$")
    public void i_call_the_web_Transformation_api_endpoint_using_POST() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        response = requestSpec
                .when()
                .post(uri);
    }

    @Then("^there should be response back$")
    public void there_should_be_response_back() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        requestSpec.then()
                .statusCode(200);

        String res = response.getBody().asString();
        System.out.println(res);

        // Validate that response status code matches 200
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println(statusCode);


    }



    @Given("^I have setup Message Dispatcher web Api$")
    public void i_have_setup_Message_Dispatcher_web_Api() throws Throwable {

        File file = new File("C:\\Users\\anil.nagisetty\\IdeaProjects\\Example\\src\\test\\java\\Resources\\dispatcher.json");
        String content = null;


        // Write code here that turns the phrase above into concrete actions
        String url = "http://denotsl454.int.kn:8013/msswiftmessagedispatcher/service/";

        uri = new URI(url);

        requestSpec =
                given()
                        // .accept(ContentType.JSON)
                        .contentType("application/json")
                        .header("X-KN-MESSAGE-CORRELATION", 23232-3434343-34346)

                        .header("X-KN-SENDER-SOFTWARE-VERSION", 1)
                        .header("X-KN-SWIFT-STEP", "{\"routeId\":null,\"stepNo\":null,\"action\":{\"id\":null,\"name\":null,\"actionType\":\"DISPATCHER\",\"serviceId\":null,\"actionType\":null,\"synchronousCapable\":null,\"broker\":null,\"queue\":null,\"topic\":\"KNMS_SwiftLOG_DespatchConfirmationV0100\"},\"synchronous\":null}")
                        .body(file).log().all();

    }

    @When("^I call the web Message Dispatcher api endpoint using POST$")
    public void i_call_the_web_Message_Dispatcher_api_endpoint_using_POST() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        response = requestSpec
                .when()
                .post(uri);
    }
}


