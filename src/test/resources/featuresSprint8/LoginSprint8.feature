Feature: I want to login to Koel Sprint Eight

  Scenario: 2. User should be navigated to the Homepage after successful login
    Given I open the Koel login page
    When I enter my Koel email "jason.fenstermaker1234@testpro.io"
    And I enter my Koel password "Testpro.io2"
    And I hit the Koel submit button
    Then I am taken to the Koel homepage

    Scenario: 3.1 User should be able to navigate to Current Queue page in Koel
    after successful login.
      Given I open the Koel login page
      When I enter my Koel email "jason.fenstermaker1234@testpro.io"
      And I enter my Koel password "Testpro.io2"
      And I hit the Koel submit button
      And I am taken to the Koel homepage
      And I select the Current Queue tab
    Then I am taken to the Current Queue Page


    Scenario: 3.2 User should be able to navigate to All Songs page in Koel
    after successful login.
      Given I open the Koel login page
      When I enter my Koel email "jason.fenstermaker1234@testpro.io"
      And I enter my Koel password "Testpro.io2"
      And I hit the Koel submit button
      And I am taken to the Koel homepage
      And I select the All Songs tab
      Then I am taken to the All Songs Page

    Scenario: 3.3 User should be able to navigate to Albums page in Koel
    after successful login.
      Given I open the Koel login page
      When I enter my Koel email "jason.fenstermaker1234@testpro.io"
      And I enter my Koel password "Testpro.io2"
      And I hit the Koel submit button
      And I am taken to the Koel homepage
      And I select the Albums tab
      Then I am taken to the Albums Page

    Scenario: 3.4 User should be able to navigate to Artists page in Koel
    after successful login.
      Given I open the Koel login page
      When I enter my Koel email "jason.fenstermaker1234@testpro.io"
      And I enter my Koel password "Testpro.io2"
      And I hit the Koel submit button
      And I am taken to the Koel homepage
      And I select the Artists tab
      Then I am taken to the Artists Page

    Scenario: 3.5 User should be able to navigate to Favorites page in Koel
    after successful login.
      Given I open the Koel login page
      When I enter my Koel email "jason.fenstermaker1234@testpro.io"
      And I enter my Koel password "Testpro.io2"
      And I hit the Koel submit button
      And I am taken to the Koel homepage
      And I select the Favorites tab
      Then I am taken to the Favorites Page

    Scenario: 3.6 User should be able to navigate to Recently Played page in Koel
    after successful login.
      Given I open the Koel login page
      When I enter my Koel email "jason.fenstermaker1234@testpro.io"
      And I enter my Koel password "Testpro.io2"
      And I hit the Koel submit button
      And I am taken to the Koel homepage
      And I select the Recently tab
      Then I am taken to the Recently Page

    Scenario: 3.7 User should be able to navigate to User's Created Playlist page in Koel
    after successful login.
      Given I open the Koel login page
      When I enter my Koel email "jason.fenstermaker1234@testpro.io"
      And I enter my Koel password "Testpro.io2"
      And I hit the Koel submit button
      And I am taken to the Koel homepage
      And I select the Created Playlist tab
      Then I am taken to the Created Playlist Page


  Scenario: 4. User should be taken to a last visited page
  (All Songs) after logging out and logging in again.
    Given I open the Koel login page
    When I enter my Koel email "jason.fenstermaker1234@testpro.io"
    And I enter my Koel password "Testpro.io2"
    And I hit the Koel submit button
    And I am taken to the Koel homepage
    And I select the All Songs tab
    And I am taken to the All Songs Page
    And I log out of Koel
    And I enter my Koel email "jason.fenstermaker1234@testpro.io"
    And I enter my Koel password "Testpro.io2"
    And I hit the Koel submit button
    And I am taken to the Koel homepage
    Then I am taken to the All Songs Page

  Scenario: 5.1 User should be able to log in with the updated email
  and the old email should not work
    Given I open the Koel login page
    When I enter my Koel email "jason.fenstermaker1234@testpro.io"
    And I enter my Koel password "Testpro.io2"
    And I hit the Koel submit button
    And I am taken to the Koel homepage
    And I select the profile button
    And I replace the current email
    And I enter the current password
    And I select the save button
    And I sign out
    And I am taken to the login page
    And I enter the new email "jason.fenstermaker123@testpro.io"
    And I enter my Koel password "Testpro.io2"
    And I hit the Koel submit button
    And I am taken to the Koel homepage

  Scenario: 5.2 User should not be able to log in with the old email
    Given I open the Koel login page
    When I enter my Koel email "jason.fenstermaker1234@testpro.io"
    And I enter my Koel password "Testpro.io2"
    And I hit the Koel submit button
    Then User should still be on the login screen

  Scenario: 6.1 User should be able to login with an updated password
    Given I open the Koel login page
    When I enter the new email "jason.fenstermaker123@testpro.io"
    And I enter my Koel password "Testpro.io2"
    And I hit the Koel submit button
    And I am taken to the Koel homepage
    And I select the profile button
    And I enter the current password
    And I enter the new password
    And I select the save button
    And I sign out
    And I am taken to the login page
    And I enter my New Koel password "Testpro.io1"
    And I hit the Koel submit button
    Then I am still on the login screen

  Scenario: 6.2 the old password should not work
    Given I open the Koel login page
    When I enter the new email "jason.fenstermaker123@testpro.io"
    And I enter my Koel password "Testpro.io2"
    And I hit the Koel submit button
    Then I am still on the login screen

    Scenario: 7.1 User should not be able to login with invalid format email (without @ symbol) and valid password.
    'email format is incorrect' message should be displayed
      Given I open the Koel login page
      When I enter email without @ symbol "jason.fenstermaker123testpro.io"
      And I enter my Koel password "Testpro.io1"
      And I hit the Koel submit button
      And I am still on the login screen
      Then Message "email format is incorrect" appears


  Scenario: 7.2 User should not be able to login with invalid format email (without dot) and valid password.
  'email format is incorrect' message should be displayed
      Given I open the Koel login page
      When I enter email without dot "jason.fenstermaker123@testproio"
      And I enter my Koel password "Testpro.io1"
      And I hit the Koel submit button
      And I am still on the login screen
      Then Message "email format is incorrect" appears



  Scenario: 7.3 User should not be able to login with invalid format email (without domain) and valid password.
  'email format is incorrect' message should be displayed
      Given I open the Koel login page
      When I enter email without domain "jason.fenstermaker123"
      And I enter my Koel password "Testpro.io1"
      And I hit the Koel submit button
      And I am still on the login screen
      Then Message "email format is incorrect" appears


  Scenario: 8. User should not be able to login with valid registered email and invalid password.
  'Password is incorrect' message should be displayed
    Given I open the Koel login page
    When I enter the new email "jason.fenstermaker123@testpro.io"
    And I enter my Koel password "Testpro.io2"
    And I hit the Koel submit button
    And I am still on the login screen
    Then Message "Password is incorrect" appears

  Scenario: 9.1 User should not be able to login with empty 'Email Address'
    Given I open the Koel login page
    When I enter email without @ symbol ""
    And I enter my Koel password "Testpro.io1"
    And I hit the Koel submit button
    Then I am still on the login screen

  Scenario: 9.2 User should not be able to login with empty'Password fields'
    Given I open the Koel login page
    When I enter email without @ symbol "jason.fenstermaker123testpro.io"
    And I enter my Koel password ""
    And I hit the Koel submit button
    Then I am still on the login screen