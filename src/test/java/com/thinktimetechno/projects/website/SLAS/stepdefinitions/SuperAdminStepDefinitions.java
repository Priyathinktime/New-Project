package com.thinktimetechno.projects.website.SLAS.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

import com.thinktimetechno.SLAS.endpoints.SuperAdminEndPoints;

public class SuperAdminStepDefinitions {

	private SuperAdminEndPoints superadmin;

	String responseBody;
	

	public SuperAdminStepDefinitions(SuperAdminEndPoints superadmin) {
		this.superadmin = superadmin;
	}
	@Given("I send a GET request for Super Admin from {string} and capture the response body")
	public void i_send_a_get_request_for_super_admin_from_and_capture_the_response_body(String name) {
		superadmin.get(name);
	}
	
	@Given("I send a Post request for Super Admin from {string} and capture the response body")
	public void i_send_a_post_request_for_super_admin_from_and_capture_the_response_body(String jsonFile) throws IOException {
		superadmin.post(jsonFile);
}
	@When("The order request response for Super Admin has a {string} response code")
	public void the_order_request_response_for_super_admin_has_a_response_code(String value) {
		int intValue = Integer.parseInt(value);
		superadmin.verifyResponseStatusValue(superadmin.result, intValue);
	}
	
	@Then("the response body for Super Admin should contain key {string} with value {string}")
	public void the_response_body_for_super_admin_should_contain_key_with_value(String key, String value) {
		superadmin.verifyResponseKeyValues(key, value, superadmin.result);
	}
	}
	
	