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

Scenario Outline: User Login To The Application With Valid Credentials
    Given User Is In The Login Page
    When User Enters Multiple Usernames <email>
    And User Enters Multiple Passwords <password>
    And User Select Terms And Conditions
    And User Clicks On SignIn
    And User Select Hospital Location And Click On Go
    Then User Validates Valid Login
    Examples:
        |email|password|
        |test1|test1|
        |test2|test2|
        |test3|test3|


#  Scenario: User Successfully Login & Logout From The Application
#    Given User Is In The Login Page
#    When User Enters Valid Username
#    And User Enters Valid Password
#    And User Clicks On SignIn
#    Given User Navigated To Dashboard Page
#    When User Clicks On User Dropdown And Logout From Application Successfully
#    Then User Should Redirect Back To The Login Page And Validates Login Page
#
#  Scenario: User Login To The Application With Valid Username And Invalid Password
#    Given User Is In The Login Page
#    When User Enters Invalid Username
#    And User Enters Invalid Password
#    And User Clicks On SignIn
#    Then User Navigated To Dashboard Page
#    Then User Validates Invalid Login Page
#
#  Scenario: User Login To The Application With Invalid Username And Valid Password
#    Given User Is In The Login Page
#    When User Enters InValid Username
#    And User Enters Valid Password
#    And User Clicks On Login Button
#    Then User Navigated To Dashboard Page
#    Then User Validates Invalid Login Page
#
#  Scenario: User Login To The Application With Empty Username And Empty Password
#    Given User Is In The Login Page
#    When User Enters Empty Username
#    And User Enters Empty Password
#    And User Clicks On Login Button
#    Then User Navigated To Dashboard Page
#    Then User Validates PP Empty Username And Password
#
#  Scenario: User Login To The Application With Valid Username And Empty Password
#    Given User Is In The Login Page
#    When User Enters Valid Username
#    And User Enters Empty Password
#    And User Clicks On Login Button
#    Then User Navigated To Dashboard Page
#    Then User Validates Empty PP Password
#
#  Scenario: User Login To The Application With Empty Username And Valid Password
#    Given User Is In The Login Page
#    When User Enters Empty Username
#    And User Enters Valid Password
#    And User Clicks On Login Button
#    Then User Navigated To Dashboard Page
#    Then User Validates Empty PP Username