@Services
@SLAS
@iterative
Feature: Services

Scenario: TC-01 All Institutions
 Given I send a GET request for Services from "All Institutions" and capture the response body
When The order request response for Services has a '200' response code
Then the response body for Services should contain key "status" with value "true"

Scenario: TC-02 All States
 Given I send a GET request for Services from "All States" and capture the response body
When The order request response for Services has a '200' response code
Then the response body for Services should contain key "status" with value "true"

Scenario: TC-03 LGAs by StateID
 Given I send a GET request for Services from "LGAs by StateID" and capture the response body
When The order request response for Services has a '200' response code
Then the response body for Services should contain key "status" with value "true"

Scenario: TC-04 All Banks
 Given I send a GET request for Services from "All Banks" and capture the response body
When The order request response for Services has a '200' response code
Then the response body for Services should contain key "status" with value "true"

Scenario: TC-05 Courses by Institutions
 Given I send a GET request for Services from "Courses by Institutions" and capture the response body
When The order request response for Services has a '200' response code
Then the response body for Services should contain key "status" with value "true"

Scenario: TC-06 Course Details
 Given I send a GET request for Services from "Course Details" and capture the response body
When The order request response for Services has a '200' response code
Then the response body for Services should contain key "status" with value "true"

 Scenario: TC-07 Contact Us
Given I send a Post request for Services from "Contact Us.json" and capture the response body
When The order request response for Services has a '200' response code
Then the response body for Services should contain key "status" with value "true"