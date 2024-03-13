Feature: User should be able to log in to
  Koel app after registering new account,
  with registered email and password
  and User should be navigated
  to the Homepage after successful login

  Scenario: Login Success and navigate to a new page
    Given I open the login page
    When I enter my email "jason.fenstermaker1234@testpro.io"
    And I enter my password "Testpro.io2"
    And I click on the login button
    Then I should be taken to the home page

  Scenario: Login Failure with invalid email
    Given I open the login page
    When I enter my email "jason@testpro.io"
    And I enter my password "Testpro.io2"
    And I click on the login button
    Then I should not be taken to the home page

  Scenario: Login Failure with invalid password
    Given I open the login page
    When I enter my email "jason.fenstermaker1234@testpro.io"
    And I enter my invalid password "invalidpassword"
    And I click on the login button
    Then I should not be taken to the home page

  Scenario: Login Failure with empty Email and Password fields
    Given I open the login page
    When I enter empty email ""
    And I enter empty password ""
    And I click on the login button
    Then I should not be taken to the home page

  Scenario: User can update email successfully
    Given I open the login page
    When I enter my email "jason.fenstermaker1234@testpro.io"
    And I enter my password "Testpro.io2"
    And I click on the login button
    Then I should be taken to the home page
    And User selects edit user profile
    And User enters current password
    And User clears current email
    And User enters new email
    And User selects Save Button
    Then Profile Updated popup appears

#  Scenario: Login with new email
#    Given I open the login page
#    When I enter my new email "jason.fenstermaker123@testpro.io"
#    And I enter my password "Testpro.io2"
#    And I click on the login button
#    Then I should be taken to the home page

  Scenario: Not be able to login with old email
    Given I open the login page
    When I enter my old email "jason.fenstermaker1234@testpro.io"
    And I enter my password "Testpro.io2"
    And I click on the login button
    Then I should not be taken to the home page

  Scenario: User can update password successfully
    Given I open the login page
    When I enter my email "jason.fenstermaker123@testpro.io"
    And I enter my password "Testpro.io2"
    And I click on the login button
    Then I should be taken to the home page
    And User selects edit user profile
    And User enters current password
    And User enters new password "Testpro.io1"
    And User selects Save Button
    Then Profile Updated popup appears

  Scenario: User should be able to login with the updated password
    Given I open the login page
    When I enter my email "jason.fenstermaker123@testpro.io"
    And I enter my password "Testpro.io1"
    And I click on the login button
    Then I should be taken to the home page

  Scenario: Not be able to login with old password
    Given I open the login page
    When I enter my old email "jason.fenstermaker123@testpro.io"
    And I enter my password "Testpro.io2"
    And I click on the login button
    Then I should not be taken to the home page

