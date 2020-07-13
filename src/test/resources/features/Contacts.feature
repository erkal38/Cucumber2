Feature: Contacts page

  Scenario: Default page number
    Given the user is on the login page
    And the user enter the driver information
    Then the user navigates "Customers", "Contacts"
    Then default page number should be 1

  Scenario: Verify Create Calendar Event
    Given the user is on the login page
    And the user enter the sales manager information
    Then the user navigates "Activities", "Calendar Events"


  Scenario: Menu Options
    Given the user logged in as "sales manager"
    Then the user should see following options

      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |


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
