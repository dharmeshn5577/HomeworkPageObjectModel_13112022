Feature: User should be login successfully on www.kmail.com
  As a new user
  User want to login successfully
  So that user can access his or her account

  @login
  Scenario: User should be able to login successfully with valid username and valid password
    Given user is on login page
    When user type valid username
    And user type valid password
    And user click on submit button
    Then user should be logged in successfully

  Scenario: User should not be able to login successfully with valid username and invalid password
    Given user is on login page
    When user type valid username
    And user type invalid password
    And user click on submit button
    Then user should not be logged in

  Scenario: User should not be able to login successfully with invalid username and valid password
    Given user is on login page
    When user type invalid username
    And user type valid password as
    And user click on submit button
    Then user should not be logged in

  Scenario: User should not be able to login successfully with invalid username and invalid password
    Given user is on login page
    When user type invalid username
    And user type invalid password
    And user click on submit button
    Then user should not be logged in
  Scenario: User should not be able to login successfully with valid username and without password
    Given user is on login page
    When user type valid username
    And user click on submit button
    Then user should not be logged in

  Scenario: User should not be able to login successfully with invalid username and without password
    Given user is on login page
    When user type invalid username
    And user click on submit button
    Then user should not be logged in

  Scenario: User should not be able to login successfully without username and with valid password
    Given user is on login page
    When user type valid password
    And user click on submit button
    Then user should not be logged in

  Scenario: User should not be able to login successfully without username and with invalid password
    Given user is on login page
    When user type invalid password
    And user click on submit button
    Then user should not be logged in



  Scenario: User should not be able to login successfully without username and without password
    Given user is on login page
    When user click on submit button
    Then user should not be logged in

