@SLAS 
@Student
Feature: Student

 Scenario: TC-01 Jamb Verify
Given I send a Post request for Student from "Jamb Verify.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"

 Scenario: TC-02 Registration
Given I send a Post request for Student from "Registration.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"

 Scenario: TC-03 Reset Password Email
Given I send a Post request for Student from "Reset Password Email.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"

 Scenario: TC-04 Reset Password
Given I send a Post request for Student from "Reset Password.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"

 Scenario: TC-05 Email Verify
Given I send a Post request for Student from "Email Verify.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"

 Scenario: TC-06 Verify NIN
Given I send a Post request for Student from "Verify NIN.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"

 Scenario: TC-07 Resend Verification Email
Given I send a Post request for Student from "Resend Verification Email.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
@iterative @Stud
 Scenario: TC-08 Login
Given I send a Post request for Student from "Login.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"

 Scenario: TC-09 Refresh token
Given I send a Post request for Student from "Refresh token.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"

 Scenario: TC-10 BVN Verification
Given I send a Post request for Student from "BVN Verification.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "fail"

 Scenario: TC-11 NIN Verification
Given I send a Post request for Student from "NIN Verification.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "fail"
@iterative @Stud
Scenario: TC-12 get dashboard data
 Given I send a GET request for Student from "get dashboard data" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
@iterative @Stud
Scenario: TC-13 Get profile details
 Given I send a GET request for Student from "Get profile details" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"

 Scenario: TC-14 Update Profile - personal details
Given I send a Post request for Student from "Update Profile - personal details.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
@iterative @Stud
 Scenario: TC-15 Update Profile - contact details
Given I send a Post request for Student from "Update Profile - contact details.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
@iterative @Stud
 Scenario: TC-16 Update Profile - Educational details
Given I send a Post request for Student from "Update Profile - Educational details.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
@iterative @Stud
 Scenario: TC-17 Update Profile - Account details (BVN)
Given I send a Post request for Student from "Update Profile - Account details (BVN).json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"

 Scenario: TC-18 Update Profile - Account details (bank verificaiton)
Given I send a Post request for Student from "Update Profile - Account details (bank verificaiton).json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"

 Scenario: TC-19 Update Password
Given I send a Post request for Student from "Update Password.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
@iterative @Stud
Scenario: TC-20 Get media
 Given I send a GET request for Student from "Get media" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
@iterative @Stud
 Scenario: TC-21 Upload documents
Given I send a Post request for Student from "Upload documents" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"

 Scenario: TC-22 Create loan application
Given I send a Post request for Student from "Create loan application.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
@iterative @Stud
Scenario: TC-23 Loan analytics
 Given I send a GET request for Student from "Loan analytics" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
@iterative @Stud
Scenario: TC-24 Get all Loans
 Given I send a GET request for Student from "Get all Loans" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"

Scenario: TC-25 Get Loan
 Given I send a GET request for Student from "Get Loan" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
@iterative @Stud
 Scenario: TC-26 Create ticket
Given I send a Post request for Student from "Create ticket.json" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
@iterative @Stud
Scenario: TC-27 List all tickets
 Given I send a GET request for Student from "List all tickets" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
@iterative @Stud
Scenario: TC-28 Get ticket
 Given I send a GET request for Student from "Get ticket" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
@iterative @Stud
Scenario: TC-29 Ticket Analysis
 Given I send a GET request for Student from "Ticket Analysis" and capture the response body
When The order request response for Student has a '200' response code
Then the response body for Student should contain key "status" with value "true"
