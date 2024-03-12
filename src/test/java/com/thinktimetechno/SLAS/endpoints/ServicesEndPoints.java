package com.thinktimetechno.SLAS.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServicesEndPoints extends BaseEndpoints{


	
	RequestSpecification requestSpecification;
	public Response result;
	
	private  String application_ENDPOINT_PATH="";

//   boolean istoken=false;
//   public static String highertoken ;
	public Response post(String jsonFile) throws IOException {

		
		requestSpecification =getRequestWithJSONHeaders();
		
		switch (jsonFile){
			case "Contact Us.json":
				application_ENDPOINT_PATH="/api/services/contact";
//				 istoken=true;
				break;
				
			
		}
		File jsonDataInFile = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Payloads"+File.separator+"ServicesPayloads"+File.separator+jsonFile);
		
		result=requestSpecification.body(jsonDataInFile).post(getBaseUrl() + application_ENDPOINT_PATH);
//		if(istoken) {
//		String responseBody = result.getBody().asString();
//	    JSONObject postResponseJson = new JSONObject(responseBody);
//	    highertoken= postResponseJson.getJSONObject("data").getString("token");
//		}
	    return result;
	
	}

	public Response get(String name ) {
		
		requestSpecification =getRequestWithJSONHeaders();
		switch (name){
		case "All Institutions":
			application_ENDPOINT_PATH="/api/services/institutions";
			break;
		case "All States":
			application_ENDPOINT_PATH="/api/services/states";
			break;
		case "LGAs by StateID":
			application_ENDPOINT_PATH="/api/services/lgas/2";
			break;
		case "All Banks":
			application_ENDPOINT_PATH="/api/services/banks";
			break;
		case "Courses by Institutions":
			application_ENDPOINT_PATH="/api/services/courses/10";
			break;
		case "Course Details":
			application_ENDPOINT_PATH="/api/services/courses/details/45";
			break;
		
		}
			result=requestSpecification.get(getBaseUrl() + application_ENDPOINT_PATH);
	     	return result;
	
}
	

}