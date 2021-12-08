Feature: Contacts page

  Scenario: Default page number
    Given the user is on the login page

  Scenario: Verify Create Calendar Event
    Given the user is on the login page

  Scenario: Menu Options
    Given the user logged in as "sales manager"

  Scenario Outline: Login as a given user <usertype>
    Given the user is on the login page
    Then the user logs in using following credentials

      | username  | <usertype>  |
      | password  | UserUser123 |
      | firstname | <firstName> |
      | lastname  | <lastName>  |
    Examples:
      | usertype        | firstName | lastName |
      | user1           | John      | Doe      |
      | salesmanager101 | Peyton    | Harber   |
