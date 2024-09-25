Feature: Search functionality

Scenario: User serches for a valid product
Given User opens the application
When user enters valid product "HP" into search box field
And user clicks on Search button
Then user should get valid product displayed on search result

Scenario: User serches for a invalid product
Given User opens the application
When user enters invalid product "Honda" into search box field
And user clicks on Search button
Then user should get a message about no product matching

Scenario: User serches without any product
Given User opens the application
When user dont enter any product name into search box field
And user clicks on Search button
Then user should get a message about no product matching