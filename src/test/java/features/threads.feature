@Thread
Feature: The reason for this feature is to see how the TestRunnerThreads works

  Scenario Outline:
    Given The User is sent to the Google page
    Then I should see the homepage title as "<Title>"

    Examples:
      | Title   |
      | Google  |
      #NOT A MISTAKE BUT TO SEE HOW THE REPORT LOOKS LIKE WITH THE SCREENSHOT ATTACHED
      | Google` |
      | Google  |
      | Google  |
      | Google  |