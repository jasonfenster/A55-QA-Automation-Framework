Feature: Login feature

  Scenario: Login Success
    Given I open login page
    When I enter email "jason.fenstermaker1234@testpro.io"
    And I enter password "Testpro.io2"
    And I click on login button
    Then I should be logged in



