Feature: Doctor is Creating an appointment to the Patient

  Background: User Login To The Application With Valid Credentials
    Given User Is In The Login Page
    When User Enters Valid Username
    And User Enters Valid Password
    And User Select Terms And Conditions
    And User Clicks On SignIn
    And User Select Hospital Location And Click On Go
    And User Is In The Dashboard Page
    Then User Validates Valid Login

  Scenario Outline: User Creating an appointment to the Patient
    And User Is In The Dashboard Page
    Given User Clicks On Add Or View Patients Button
    And User Search For The Patient By Name And Clicks On Patient <patient name>
    And User Enters Visit ID <visit id>
    Then User Creates An Appointment
    Then User Validates The Created Appointment
    Examples:
      |patient name|visit id|
      |vinod       |visitID|
      |Vinay A     |visitID|
      |test        |visitID|
      |rupesh      |visitID|





