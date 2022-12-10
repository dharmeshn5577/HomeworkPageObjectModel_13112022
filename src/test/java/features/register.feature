Feature:  As a new user, user want to register, So that user can access the account

  @regression @registration
  Scenario: When user enters registration details user should able to register successfully
    Given user is on registration page
    When user enter registration details and click on register button
    Then registration complete message should display