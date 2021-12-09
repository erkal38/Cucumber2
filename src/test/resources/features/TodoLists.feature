

Feature: Users should be able to see TodoList
  @add
  Scenario:
    Given Empty ToDo list
    When I write "buy some milk" to <text box> and press <enter>
    Then I should see "buy some milk" item in ToDo list

  @add
  Scenario:
    Given ToDo list with "buy some milk" item
    When I write "enjoy the assignment" to <text box> and press <enter>
    Then I should see "enjoy the assignment" item inserted to ToDo list below "buy some milk"

  @add
  Scenario:
    Given ToDo list with "buy some milk" item
    When I click on <checkbox> next to "buy some milk" item
    Then I should see "buy some milk" item marked as DONE

