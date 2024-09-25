Feature: Registration functionality

Scenario: User creates an account only with mandetory fields
Given User navigates to Register account page
When user enters the deatils into below fields
|firstName       |Savi                   |
|lastName        |Telka                  |
|telephone       |1234567890             |
|password        |savi@1231235           |
|confirmPassword |savi@1231235           |
And User select privacy policy
And User click on continue button
Then User account should get created successfully

Scenario: User creates an account with all fields
Given User navigates to Register account page
When user enters the deatils into below fields
|firstName       |Savi                   |
|lastName        |Telka                  |
|telephone       |1234567890             |
|password        |savi@1231235           |
|confirmPassword |savi@1231235           |
And User select Yes for newsletter
And User select privacy policy
And User click on continue button
Then User account should get created successfully

Scenario: User creates a duplicate account
Given User navigates to Register account page
When user enters the deatils into below fields with duplicate email
|firstName       |Savi                   |
|lastName        |Telka                  |
|email           |savi369telka@gmail.com |
|telephone       |1234567890             |
|password        |savi@1231235           |
|confirmPassword |savi@1231235           |
And User select Yes for newsletter
And User select privacy policy
And User click on continue button
Then User should get warning about duplicate email

Scenario: User creates an account without filling any details
Given User navigates to Register account page
When User dont enter any deatils into the fields
And User click on continue button
Then User should get proper warning message for each mandetory fields














