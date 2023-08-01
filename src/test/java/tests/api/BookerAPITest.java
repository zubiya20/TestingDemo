package tests.api;

import org.junit.Before;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BookerAPITest {
	RequestSpecification request;
	Response response;
	@Before
	public void setUP()
	{
		RestAssured.baseURI ="https://restful-booker.herokuapp.com";
	}
	@Test
	public void createBooking()
	{
	   request=given().log().all().header("content-type", "application/json")
		.body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}");
		response = request.when().post("/booking");
		response.then().log().all().assertThat().statusCode(200)
		.body("booking.firstname", equalTo("Jim"));
	}
	
	@Test
	public void getBooking()
	{
		 request=given().log().all().header("content-type", "application/json")
				 .pathParam("id", 11);
		 response = request.when().get("/booking/{id}");
		 response.then().log().all().assertThat().statusCode(200);
	}
}
