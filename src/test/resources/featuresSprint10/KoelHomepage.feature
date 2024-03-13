Feature: Homepage for Koel

  Scenario: Login Success
    Given I open a login page
    When I enter an email "jason.fenstermaker1234@testpro.io"
    And I enter a password "Testpro.io2"
    And I click on the-a login button
    And I should be logged in hopefully

  Scenario: Welcome message for a new user should be the following: 'Hello, Student!'
    Given I open a login page
    When I enter newly registered newEmail "jason.fenstermaker@testpro.io"
    And I enter newly registered newPassword "Ft7lNxia"
    And I click on the-a login button
    And I should be logged in hopefully
    Then Welcome message for a new user should be "Hello, Student!"

  Scenario: Recently played songs should be present if user played at least one song
    Given I open a login page
    When I enter an email "jason.fenstermaker1234@testpro.io"
    And I enter a password "Testpro.io2"
    And I click on the-a login button
    And I should be logged in hopefully
    And I select the recently played tab
    Then I interact with the first song in the playlist

  Scenario: 'View All' button should be displayed next to Recently played songs
    Given I open a login page
    When I enter an email "jason.fenstermaker1234@testpro.io"
    And I enter a password "Testpro.io2"
    And I click on the-a login button
    And I should be logged in hopefully
    Then 'View All' button should be displayed next to Recently played songs

  Scenario: Recently added songs should be present
    Given I open a login page
    When I enter an email "jason.fenstermaker1234@testpro.io"
    And I enter a password "Testpro.io2"
    And I click on the-a login button
    And I should be logged in hopefully
    And 'View All' button should be displayed next to Recently played songs
    And User selects 'View All' button
    And User should be taken to Recently played songs
    Then Recently added songs should be present

  Scenario: Album name should be displayed for the Recently added songs
    Given I open a login page
    When I enter an email "jason.fenstermaker1234@testpro.io"
    And I enter a password "Testpro.io2"
    And I click on the-a login button
    And I should be logged in hopefully
    And 'View All' button should be displayed next to Recently played songs
    And User selects 'View All' button
    And User should be taken to Recently played songs
    Then Album name should be displayed for the Recently added songs

#  There is no Download icon present for Recently added songs - manually tested
  Scenario: Download and Shuffle icons should be present for Recently added songs
    Given I open a login page
    When I enter an email "jason.fenstermaker1234@testpro.io"
    And I enter a password "Testpro.io2"
    And I click on the-a login button
    And I should be logged in hopefully
    And 'View All' button should be displayed next to Recently played songs
    And User selects 'View All' button
    And User should be taken to Recently played songs
    Then Shuffle icon should be present for Recently added songs


  Scenario: Search field should be present and accessible fromHomepage
    Given I open a login page
    When I enter an email "jason.fenstermaker1234@testpro.io"
    And I enter a password "Testpro.io2"
    And I click on the-a login button
    And I should be logged in hopefully
    Then Search field should be present and accessible

  Scenario: Music panel includes Home, Current Queue, All Songs, Albums, Artists
    Given I open a login page
    When I enter an email "jason.fenstermaker1234@testpro.io"
    And I enter a password "Testpro.io2"
    And I click on the-a login button
    And I should be logged in hopefully
    Then Musical panel includes Home
    And Musical panel includes Current Queue
    And Musical panel includes All Songs
    And Musical panel includes Album
    And Musical panel includes Artists

    Scenario: PLAYLISTS panel should include: + button for new playlist
      Given I open a login page
      When I enter an email "jason.fenstermaker1234@testpro.io"
      And I enter a password "Testpro.io2"
      And I click on the-a login button
      And I should be logged in hopefully
      Then Playlist panel includes + button

  Scenario: Playlists panel should include: Favorites, Recently played, smart and user's created playlists
    Given I open a login page
    When I enter an email "jason.fenstermaker1234@testpro.io"
    And I enter a password "Testpro.io2"
    And I click on the-a login button
    And I should be logged in hopefully
    Then Playlist panel includes Favorites
    And Playlist panel includes Recently Played
    And Playlist panel includes Smart
    And Playlist panel includes User Created

  Scenario: Profile link, Logout and About Koel icons should be displayed and linked to correct pages.
    Given I open a login page
    When I enter an email "jason.fenstermaker1234@testpro.io"
    And I enter a password "Testpro.io2"
    And I click on the-a login button
    And I should be logged in hopefully
    And Profile link is displayed
    And User selects profile button
    And User is taken to profile
    And Home tab is displayed
    And User selects home tab
    And User is taken to home page
    And AboutKoel icon is displayed
    And User selects About Koel Icon
    And AboutKoel page is displayed
    And User selects About Koel Close button
    And Logout Icon is displayed
    And User selects Logout Icons
    Then User is taken to Login Page


