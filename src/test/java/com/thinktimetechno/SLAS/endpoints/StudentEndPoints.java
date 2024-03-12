package com.thinktimetechno.SLAS.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StudentEndPoints extends BaseEndpoints {

	RequestSpecification requestSpecification;
	public Response result;

	private String application_ENDPOINT_PATH = "";

	boolean islogtoken = false;
	boolean istoken = false;
	public static String jambtoken;
	public static String logtoken;
	boolean isurl = false;
	boolean isrequestbody = false;
	String bvntoken = "RVSEC-7466350c5989bd5064fed2196e766721ded9ba39bf6b62664aeed9e3aab8d92ee0dd6e13b4c4d74fb04765351a97cb81-1694187039251";

	public Response post(String jsonFile) throws IOException {

		requestSpecification = getRequestWithJSONHeaders();

		switch (jsonFile) {
		case "Reset Password Email.json":
			application_ENDPOINT_PATH = "/api/student/password/reset/email";

			break;
		case "Reset Password.json":
			application_ENDPOINT_PATH = "/api/student/password/reset";
			requestSpecification = getRequestWithJSONHeadersToken(jambtoken);

			break;
		case "Jamb Verify.json":
			application_ENDPOINT_PATH = "/api/student/register/jamb/verify";
			istoken = true;

			break;
		case "Registration.json":
			application_ENDPOINT_PATH = "/api/student/register";
			requestSpecification = getRequestWithJSONHeadersToken(jambtoken);

			break;
		case "Login.json":
			application_ENDPOINT_PATH = "/api/student/login";
			islogtoken= true;

			break;
		case "Refresh token.json":
			application_ENDPOINT_PATH = "/api/student/refresh-token";

			break;
		case "Email Verify.json":
			application_ENDPOINT_PATH = "/api/student/verify";

			JSONObject postRequestBody = new JSONObject();
			postRequestBody.put("token", jambtoken);
			result = requestSpecification.body(postRequestBody.toString())
					.post(getBaseUrl() + application_ENDPOINT_PATH);
			isrequestbody = true;
//			istoken=true;

			break;
		case "Verify NIN.json":
			application_ENDPOINT_PATH = "/api/student/verify/nin-details";
			requestSpecification = getRequestWithJSONHeadersToken(jambtoken);
			break;
		case "Resend Verification Email.json":
			application_ENDPOINT_PATH = "/api/student/resend/email";
			requestSpecification = getRequestWithJSONHeadersToken(jambtoken);
			break;
		case "BVN Verification.json":
			application_ENDPOINT_PATH = "https://integrations.getravenbank.com/v1/bvn/verify";
			requestSpecification = getRequestWithJSONHeadersToken(bvntoken);
			isurl = true;
			break;

		case "NIN Verification.json":
			application_ENDPOINT_PATH = "https://integrations.getravenbank.com/v1/nin/verify";
			requestSpecification = getRequestWithJSONHeadersToken(bvntoken);
			isurl = true;
			break;
		case "Update Profile - personal details.json":
			application_ENDPOINT_PATH = "/api/profile/update";
			requestSpecification = getRequestWithJSONHeadersToken(logtoken);
			break;
		case "Update Profile - contact details.json":
			application_ENDPOINT_PATH = "/api/profile/update";
			requestSpecification = getRequestWithJSONHeadersToken(logtoken);
			break;
		case "Update Profile - Educational details.json":
			application_ENDPOINT_PATH = "/api/profile/update/institute-details";
			requestSpecification = getRequestWithJSONHeadersToken(logtoken);
			break;
		case "Update Profile - Account details (BVN).json":
			application_ENDPOINT_PATH = "/api/profile/update/bvn-details";
			requestSpecification = getRequestWithJSONHeadersToken(logtoken);
			break;
		case "Update Profile - Account details (bank verificaiton).json":
			application_ENDPOINT_PATH = "/api/profile/update/bank-details";
			requestSpecification = getRequestWithJSONHeadersToken(logtoken);
			break;
		case "Update Password.json":
			application_ENDPOINT_PATH = "/api/student/password/update";
			requestSpecification = getRequestWithJSONHeadersToken(logtoken);
			break;
		case "Upload documents":
			application_ENDPOINT_PATH = "/api/media";
			File testUploadFile1 = new File(System.getProperty("user.dir")+"/src/test/resources/Payloads/StudentPayloads/download.jpeg");
			result= RestAssured.given()
             .header("Authorization", "Bearer "+ logtoken)
            .multiPart("name", "Admissionl letter","text/plain")
            .multiPart("file", testUploadFile1).post(getBaseUrl() + application_ENDPOINT_PATH);

			break;
		case "Create loan application.json":
			application_ENDPOINT_PATH = "/api/loans/apply";

			break;
		case "Create ticket.json":
			application_ENDPOINT_PATH = "/api/tickets";
			requestSpecification = getRequestWithJSONHeadersToken(logtoken);

			break;

		}
//		if(isrequestbody) {String requestBody1 = "{ \"token\": [ \"" + jambtoken + "\" ] }";
//		requestSpecification.body(requestBody1);
//		}

		if (isurl) {
			File jsonDataInFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator
					+ "test" + File.separator + "resources" + File.separator + "Payloads" + File.separator
					+ "StudentPayloads" + File.separator + jsonFile);
			result = requestSpecification.body(jsonDataInFile).post(application_ENDPOINT_PATH);
		} else {
			if(isrequestbody) {File jsonDataInFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator
					+ "test" + File.separator + "resources" + File.separator + "Payloads" + File.separator
					+ "StudentPayloads" + File.separator + jsonFile);
			result = requestSpecification.post(getBaseUrl() + application_ENDPOINT_PATH);}
			else {
			File jsonDataInFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator
					+ "test" + File.separator + "resources" + File.separator + "Payloads" + File.separator
					+ "StudentPayloads" + File.separator + jsonFile);
			result = requestSpecification.body(jsonDataInFile).post(getBaseUrl() + application_ENDPOINT_PATH);
			}}

		if (istoken) {
			String responseBody = result.getBody().asString();
			JSONObject postResponseJson = new JSONObject(responseBody);
			jambtoken = postResponseJson.getJSONObject("data").getString("token");
		}

		if (islogtoken) {
			String responseBody = result.getBody().asString();
			JSONObject postResponseJson1 = new JSONObject(responseBody);
			logtoken = postResponseJson1.getJSONObject("data").getString("token");
		}
		
		return result;

	}

	public Response get(String name) {

		requestSpecification = getRequestWithJSONHeadersToken(logtoken);
		switch (name) {
		case "get dashboard data":
			application_ENDPOINT_PATH = "/api/dashboard/";
			
			break;
		case "Get profile details":
			application_ENDPOINT_PATH = "/api/profile/";
			break;
		case "Get media":
			application_ENDPOINT_PATH = "/api/media";
			break;
		case "Loan analytics":
			application_ENDPOINT_PATH = "/api/loans/analytics";
			break;
		case "Get all Loans":
			application_ENDPOINT_PATH = "/api/loans?page=1&limit=2";
			break;
		case "Get Loan":
			application_ENDPOINT_PATH = "/api/loans/:id";
			break;
		case "List all tickets":
			application_ENDPOINT_PATH = "/api/tickets";
			break;
		case "Get ticket":
			application_ENDPOINT_PATH = "/api/tickets/6543";
			
			break;
		case "Ticket Analysis":
			application_ENDPOINT_PATH = "/api/tickets/analysis";
			break;

		}
		result = requestSpecification.get(getBaseUrl() + application_ENDPOINT_PATH);
		return result;

	}

}