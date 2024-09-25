Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User has navigated to login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in

Examples: 
|username            |password|
|savi.telka@gmail.com|savi@123|
|shwtlka123@gmail.com|12345   |

Scenario: Login with invalid credentials
Given User has navigated to login page
When User enters invalid email address into email field
And User enters invalid password "savi@1231235" into password field
And User clicks on Login button
Then User should get a proper warning message about credential mismatch

Scenario: Login with valid email and invalid password
Given User has navigated to login page
When User enters valid email address "savi.telka@gmail.com" into email field
And User enters invalid password "savi@1231223" into password field
And User clicks on Login button
Then User should get a proper warning message about credential mismatch

Scenario: Login with invalid email and valid password
Given User has navigated to login page
When User enters invalid email address into email field
And User enters valid password "savi@123" into password field
And User clicks on Login button
Then User should get a proper warning message about credential mismatch

Scenario: Login without providing any credentials
Given User has navigated to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credential mismatch