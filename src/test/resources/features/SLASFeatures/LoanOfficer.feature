@LoanOfficer
@SLAS
Feature: Loan Officer
@iterative
 Scenario: TC-01 Login
Given I send a Post request for Loan Officer from "Login.json" and capture the response body
When The order request response for Loan Officer has a '200' response code
Then the response body for Loan Officer should contain key "status" with value "true"
@iterative
Scenario: TC-02 Loan Analytics
 Given I send a GET request for Loan Officer from "Loan Analytics" and capture the response body
When The order request response for Loan Officer has a '200' response code
Then the response body for Loan Officer should contain key "status" with value "true"
@iterative
Scenario: TC-03 Get all loan applications
 Given I send a GET request for Loan Officer from "Get all loan applications" and capture the response body
When The order request response for Loan Officer has a '200' response code
Then the response body for Loan Officer should contain key "status" with value "true"

Scenario: TC-04 Get loan details
 Given I send a GET request for Loan Officer from "Get loan details" and capture the response body
When The order request response for Loan Officer has a '200' response code
Then the response body for Loan Officer should contain key "status" with value "true"


