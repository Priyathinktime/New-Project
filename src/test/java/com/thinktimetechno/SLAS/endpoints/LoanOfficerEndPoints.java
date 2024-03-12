package com.thinktimetechno.SLAS.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoanOfficerEndPoints extends BaseEndpoints{


	
	RequestSpecification requestSpecification;
	public Response result;
	
	private  String application_ENDPOINT_PATH="";

   boolean istoken=false;
   public static String loantoken ;
	public Response post(String jsonFile) throws IOException {

		
		requestSpecification =getRequestWithJSONHeaders();
		
		switch (jsonFile){
			case "Login.json":
				application_ENDPOINT_PATH="/api/staff/auth/login";
				 istoken=true;
				break;
				
			
		}
		File jsonDataInFile = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Payloads"+File.separator+"LoanOfficerPayloads"+File.separator+jsonFile);
		
		result=requestSpecification.body(jsonDataInFile).post(getBaseUrl() + application_ENDPOINT_PATH);
		if(istoken) {
		String responseBody = result.getBody().asString();
	    JSONObject postResponseJson = new JSONObject(responseBody);
	    loantoken= postResponseJson.getJSONObject("data").getString("token");
		}
	    return result;
	
	}

	public Response get(String name ) {
		
		requestSpecification =getRequestWithJSONHeadersToken(loantoken);
		switch (name){
		case "Loan Analytics":
			application_ENDPOINT_PATH="/api/staff/loans/analytics";
			break;
		case "Get all loan applications":
			application_ENDPOINT_PATH="/api/staff/loans?page=1&limit=10&to=2023-09-29&from=2023-01-01&status=pending&institute_id=12";
			break;
		case "Get loan details":
			application_ENDPOINT_PATH="/api/staff/loans/15/details";
			break;
		
		
		}
			result=requestSpecification.get(getBaseUrl() + application_ENDPOINT_PATH);
	     	return result;
	
}
	

}