Feature: Login Scenario

  Scenario: Validating login with valid credentials
    Given Rexel app is launched
    When User enters username and password
    And Clicks on login button
    Then Home screen should be displayed
    
  Scenario: Validating login with invalid credentials
    Given Rexel app is launched
    When User enters invalid username and password
    And Clicks on login button
    Then Invalid credentials pop up should be displayed