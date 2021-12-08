

Feature: Users should be able to see TodoList
  @add
  Scenario Outline:
    Given Empty ToDo list
    When I write "<item>" to <text box> and press <enter>
    Then I should see "<item>" item in ToDo list
    Examples:
      | item                 |
      | buy some milk        |

  @add
  Scenario:
    Given ToDo list with "buy some milk" item
#    When I write "<item>" to <text box> and press <enter>
#    Then I should see "<item>" item in ToDo list
#    Examples:
#      | item                 |
#      | enjoy the assignment |

