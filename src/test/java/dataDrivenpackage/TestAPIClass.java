package dataDrivenpackage;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataDrivenpackage.TestExcelUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TestAPIClass {
	
	
	@Test(dataProvider="TestDataProvider")
	public void postMethod(String firstname, String lastname,String Email){
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Here we have created data which we can send along with post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("first_name", firstname);
		requestParams.put("last_name", lastname);
		requestParams.put("email", Email);
		
		//Add a header stating that Request body is a JSON
		httpRequest.header("Content-Type","application/json");
		
		//Add JSON to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		//POST Request
		Response response = httpRequest.request(Method.POST,"/create");
		
		//Capture Response body for Validation
		String responseBody = response.getBody().asString();
		
		System.out.println("Response Body is: "+responseBody);
		
		Assert.assertEquals(responseBody.contains(firstname), true);
		Assert.assertEquals(responseBody.contains(lastname), true);
		Assert.assertEquals(responseBody.contains(Email), true);
		
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		
	}
	
	@Test
	void GetApiTest(){
		
		//Specify the base URI
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET);
		
		//Print Response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: "+ responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: "+ statusCode);
		Assert.assertEquals(statusCode, 200);

		
	}
		
	
	@DataProvider(name="TestDataProvider")
	String [][] getTestData() throws IOException{

		
		//Read data from Excel file
		String path = System.getProperty("user.dir")+"./src/test/java/dataDrivenpackage/XLInputdata.xlsx";
		
		int rownum = TestExcelUtils.getRowCount(path,"Sheet1");
		int colcount = TestExcelUtils.getCellCount(path,"Sheet1",1);
		
		String testdata[][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum;i++){
			for(int j=0; j<colcount;j++){
				testdata[i-1][j] = TestExcelUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		

		return testdata;
	}

			
		

}
