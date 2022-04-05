Feature: This feature will test ClickUp API

  Scenario: Create a new folder, list and task in the test space
    Given The test space exists and contains the correct information
    When I create the folder with title "Example folder"
    And I add a list with title "Example List" to the folder
    Then I check that the list name is "Example List"
    And  I add a task with title "Example task" to the list
    Then I check that the task name is "Example task"
    And I delete created task
