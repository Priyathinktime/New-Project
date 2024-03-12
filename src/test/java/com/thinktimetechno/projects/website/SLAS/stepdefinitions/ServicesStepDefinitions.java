package com.thinktimetechno.projects.website.SLAS.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

import com.thinktimetechno.SLAS.endpoints.ServicesEndPoints;

public class ServicesStepDefinitions {

	private ServicesEndPoints services;

	String responseBody;
	

	public ServicesStepDefinitions(ServicesEndPoints services) {
		this.services = services;
	}
	@Given("I send a GET request for Services from {string} and capture the response body")
	public void i_send_a_get_request_for_super_admin_from_and_capture_the_response_body(String name) {
		services.get(name);
	}
	
	@Given("I send a Post request for Services from {string} and capture the response body")
	public void i_send_a_post_request_for_super_admin_from_and_capture_the_response_body(String jsonFile) throws IOException {
		services.post(jsonFile);
}
	@When("The order request response for Services has a {string} response code")
	public void the_order_request_response_for_super_admin_has_a_response_code(String value) {
		int intValue = Integer.parseInt(value);
		services.verifyResponseStatusValue(services.result, intValue);
	}
	
	@Then("the response body for Services should contain key {string} with value {string}")
	public void the_response_body_for_super_admin_should_contain_key_with_value(String key, String value) {
		services.verifyResponseKeyValues(key, value, services.result);
	}
	}
	
	