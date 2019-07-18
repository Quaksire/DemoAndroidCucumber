Feature: Login screen
    As a user
    I would like to insert my credentials
    So that I can access to my private information

        Scenario: Login Success
            Given A user is at the login screen
            When Insert username correctUsername
            And Insert password correctPassword1234
            And Press login button
            Then Success message is displayed

        Scenario Outline: Login fails
            Given A user is at the login screen
            When Insert username <username>
            And Insert password <password>
            And Press login button
            Then Error message is displayed
            Examples:
            | username| password |
            | correctUsername | 1234 |
            | correctUsername | wrong |