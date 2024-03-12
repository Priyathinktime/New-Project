package com.thinktimetechno.projects.website.SLAS.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

import com.thinktimetechno.SLAS.endpoints.ServicesEndPoints;
import com.thinktimetechno.SLAS.endpoints.StudentEndPoints;

public class StudentStepDefinitions {

	private StudentEndPoints student;

	String responseBody;
	

	public StudentStepDefinitions(StudentEndPoints student) {
		this.student = student;
	}
	@Given("I send a GET request for Student from {string} and capture the response body")
	public void i_send_a_get_request_for_student_from_and_capture_the_response_body(String name) {
		student.get(name);
	}
	
	@Given("I send a Post request for Student from {string} and capture the response body")
	public void i_send_a_post_request_for_student_from_and_capture_the_response_body(String jsonFile) throws IOException {
		student.post(jsonFile);
}
	@When("The order request response for Student has a {string} response code")
	public void the_order_request_response_for_student_has_a_response_code(String value) {
		int intValue = Integer.parseInt(value);
		student.verifyResponseStatusValue(student.result, intValue);
	}
	
	@Then("the response body for Student should contain key {string} with value {string}")
	public void the_response_body_for_student_should_contain_key_with_value(String key, String value) {
		student.verifyResponseKeyValues(key, value, student.result);
	}
	}
	
	