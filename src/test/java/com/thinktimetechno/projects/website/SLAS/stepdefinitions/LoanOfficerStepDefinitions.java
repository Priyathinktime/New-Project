package com.thinktimetechno.projects.website.SLAS.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

import com.thinktimetechno.SLAS.endpoints.LoanOfficerEndPoints;
import com.thinktimetechno.SLAS.endpoints.ServicesEndPoints;

public class LoanOfficerStepDefinitions {

	private LoanOfficerEndPoints loanofficer;

	String responseBody;
	

	public LoanOfficerStepDefinitions(LoanOfficerEndPoints loanofficer) {
		this.loanofficer = loanofficer;
	}
	@Given("I send a GET request for Loan Officer from {string} and capture the response body")
	public void i_send_a_get_request_for_loan_officer_from_and_capture_the_response_body(String name) {
		loanofficer.get(name);
	}
	
	@Given("I send a Post request for Loan Officer from {string} and capture the response body")
	public void i_send_a_post_request_for_loan_officer_from_and_capture_the_response_body(String jsonFile) throws IOException {
		loanofficer.post(jsonFile);
}
	@When("The order request response for Loan Officer has a {string} response code")
	public void the_order_request_response_for_loan_officer_has_a_response_code(String value) {
		int intValue = Integer.parseInt(value);
		loanofficer.verifyResponseStatusValue(loanofficer.result, intValue);
	}
	
	@Then("the response body for Loan Officer should contain key {string} with value {string}")
	public void the_response_body_for_loan_officer_should_contain_key_with_value(String key, String value) {
		loanofficer.verifyResponseKeyValues(key, value, loanofficer.result);
	}
	}
	
	