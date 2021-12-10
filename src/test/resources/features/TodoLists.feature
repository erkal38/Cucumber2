Feature: Users should be able to see TodoList

  @add
  Scenario: One item in ToDo list
    Given Empty ToDo list
    When I write "buy some milk" to text box and press enter
    Then I should see "buy some milk" item in ToDo list

  @add
  Scenario:Second item in ToDo list
    Given ToDo list with "buy some milk" item
    When I write "enjoy the assignment" to text box and press enter
    Then I should see "enjoy the assignment" item inserted to ToDo list below "buy some milk"

  @add
  Scenario:Check one item in ToDo list
    Given ToDo list with "buy some milk" item
    When I click on checkbox next to "buy some milk" item
    Then I should see "buy some milk" item marked as DONE

  @add
  Scenario:Unchecked one item in ToDo list
    Given ToDo list with marked item
    When I click on checkbox next to item
    Then I should see "buy some milk" item marked as UNDONE

  @add
  Scenario:Delete one item in ToDo list
    Given ToDo list with "rest for a while" item
    When I click on delete button next to "rest for a while" item
    Then List should be empty

  @add
  Scenario:Check one of items in ToDo list
    Given ToDo list with following items in order
      | rest for a while |
      | drink water      |
    When I click on delete button next to "rest for a while" item
    Then I should see "drink water" item in ToDo list