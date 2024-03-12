package com.thinktimetechno.SLAS.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SuperAdminEndPoints extends BaseEndpoints{


	
	RequestSpecification requestSpecification;
	public Response result;
	
	private  String application_ENDPOINT_PATH="";

   boolean istoken=false;
   public static String supertoken ;
	public Response post(String jsonFile) throws IOException {

		
		requestSpecification =getRequestWithJSONHeaders();
		
		switch (jsonFile){
			case "Login.json":
				application_ENDPOINT_PATH="/api/admin/auth/login";
				 istoken=true;
				break;
				
			
		}
		File jsonDataInFile = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Payloads"+File.separator+"HigherInstitutionsPayloads"+File.separator+jsonFile);
		
		result=requestSpecification.body(jsonDataInFile).post(getBaseUrl() + application_ENDPOINT_PATH);
		if(istoken) {
		String responseBody = result.getBody().asString();
	    JSONObject postResponseJson = new JSONObject(responseBody);
	    supertoken= postResponseJson.getJSONObject("data").getString("token");
		}
	    return result;
	
	}

	public Response get(String name ) {
		
	requestSpecification = getRequestWithJSONHeadersToken(supertoken);
		switch (name){
		case "Loan Analytics":
			application_ENDPOINT_PATH="/api/admin/loans/analytics";
			break;
		case "Get all loan applications":
			application_ENDPOINT_PATH="/api/admin/loans?page=1&limit=10";
			break;
		case "Get All Students":
			application_ENDPOINT_PATH="/api/admin/students?page=1&limit=10";
			break;
		case "Get Students analytics":
			application_ENDPOINT_PATH="/api/admin/students/analytics";
			break;
		case "Get loan officers":
			application_ENDPOINT_PATH="/api/admin/staffs?page=1&limit=10";
			break;
		case "Get institutes":
			application_ENDPOINT_PATH="/api/admin/institute?page=1&limit=10";
			break;
		
		}
			result=requestSpecification.get(getBaseUrl() + application_ENDPOINT_PATH);
	     	return result;
	
}
	

}