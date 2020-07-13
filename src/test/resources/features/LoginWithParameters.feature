Feature: Login as different users

  Scenario: Login as a driver user
    Given the user is on the login page
    When the user logs in using "user1" and "UserUser123"
    Then the user should be able to login
    Then the title contains "Dashboard"