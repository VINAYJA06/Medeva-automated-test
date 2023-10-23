Feature: Login & Logout Page Testing

Scenario: User Login To The Application With Valid Credentials
    Given User Is In The Login Page
    When User Enters Valid Username
    And User Enters Valid Password
    And User Select Terms And Conditions
    And User Clicks On SignIn
    And User Select Hospital Location And Click On Go
    And User Is In The Dashboard Page
    Then User Validates Valid Login

  Scenario: User Successfully Login & Logout From The Application
    Given User Is In The Login Page
    When User Enters Valid Username
    And User Enters Valid Password
    And User Select Terms And Conditions
    And User Clicks On SignIn
    And User Select Hospital Location And Click On Go
    And User Is In The Dashboard Page
    When User Clicks On User Dropdown And Logout From Application Successfully
    Then User Should Redirect Back To The Login Page And Validates Login Page

  Scenario: User Login To The Application With Valid Username And Invalid Password
    Given User Is In The Login Page
    When User Enters InValid Username
    And User Enters Invalid Password
    And User Select Terms And Conditions
    And User Clicks On SignIn
    Then User Validates Invalid Login Page

  Scenario: User Login To The Application With Invalid Username And Valid Password
    Given User Is In The Login Page
    When User Enters InValid Username
    And User Enters Valid Password
    And User Select Terms And Conditions
    And User Clicks On SignIn
    Then User Validates Invalid Login Page

  Scenario: User Login To The Application With Empty Username And Empty Password
    Given User Is In The Login Page
    When User Enters Empty Username
    And User Enters Empty Password
    And User Select Terms And Conditions
    And User Clicks On SignIn
    Then User Validates Empty Username
    Then User Validates Empty Password

  Scenario: User Login To The Application With Valid Username And Empty Password
    Given User Is In The Login Page
    When User Enters Valid Username
    And User Enters Empty Password
    And User Select Terms And Conditions
    And User Clicks On SignIn
    Then User Validates Empty Password

  Scenario: User Login To The Application With Empty Username And Valid Password
    Given User Is In The Login Page
    When User Enters Empty Username
    And User Enters Valid Password
    And User Select Terms And Conditions
    And User Clicks On SignIn
    Then User Validates Empty Username