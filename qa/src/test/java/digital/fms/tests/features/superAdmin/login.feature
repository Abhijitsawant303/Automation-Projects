@admin @login @e2e @smoke
Feature: Admin Login

  Background:
    Given Open browser for "FmsAdmin"

  Scenario: To check UI of FMS login screen
    When User on login screen
#    Then User can see xLongevity logo at top of page on login screen
#    And User can see xLongevity logo above page heading on login screen
#    And User can see heading title as "Welcome to xLongevity Admin Panel" on login screen
#    And User can see main Heading title as "A Holistic Approach to Healthy Aging" on login screen
#    And User can see main SubHeading title as "xLongevity is all-in-one solution with an app, coaches, supplements and testing to empower you to live a long, active, fulfilling and healthy life." on login screen
#    And User can see join button with heading "Join" on login screen
#    And User click on SignIn button on login screen
#    Then User can see validation messages on login screen

#  Scenario Outline: To check invalid login details on xLongevity login screen
#    When User on login screen
#    Then user can see title "Sign in" on login screen
#    Then user can see sub title "Sign in with your email" on login screen
#    Then User can see email with label as "Email" on login screen
#    When User enter email as <email> on login screen
#    And User can see password with label as "Password" on login screen
#    When User enter password as <password> on login screen
#    Then User can see SignIn button with label as "Sign in" on login screen
#    And User click on SignIn button on login screen
#    Then User can see validation messages on login screen
#
#    Examples:
#      | email             | password  |
#      | empty             |    123456 |
#      | demo              |    123456 |
#      | demo@g            | empty     |
#      | windmill.digital  | empty     |
#      | @windmill.digital | demoPass$ |
#      | " or ""="         | " or ""=" |
#
#  Scenario Outline: To verify login credentials on xLongevity login screen
#    When User on login screen
#    Then User can see email with label as "Email" on login screen
#    And User enter email as <email> on login screen
#    And User can see password with label as "Password" on login screen
#    And User enter password as <password> on login screen
#    Then User can see SignIn button with label as "Sign in" on login screen
#    And User click on SignIn button on login screen
#    Then User can see sub title as "Please provide the following details." on login email verification screen
#    Then User can see email id label as "Email Address" on login email verification screen
#    Then User can see encrypted email as "p********************************@gmail.com" on login email verification screen
#    Then User can see email verification message as "Verification is necessary. Please click Send button." on login email verification screen
#    Then User can see send verification code button label as "Send verification code" on login email verification screen
#    Then User can see continue button label as "Continue" on login email verification screen
#    Then User can see cancel button label as "Cancel" on login email verification screen
#
#    Examples:
#      | email                                       | password |
#      | peter.parkeruserxlongevity+admin1@gmail.com | Tuja2153 |
#
#  Scenario Outline: To verify element and label after click on send verification code button on xLongevity login screen
#    When User on login screen
#    Then User can see email with label as "Email" on login screen
#    And User enter email as <email> on login screen
#    And User can see password with label as "Password" on login screen
#    And User enter password as <password> on login screen
#    Then User can see SignIn button with label as "Sign in" on login screen
#    And User click on SignIn button on login screen
#    Then User can see sub title as "Please provide the following details." on login email verification screen
#    Then User can see email id label as "Email Address" on login email verification screen
#    Then User can see encrypted email as "p********************************@gmail.com" on login email verification screen
#    Then User can see email verification message as "Verification is necessary. Please click Send button." on login email verification screen
#    Then User can see send verification code button label as "Send verification code" on login email verification screen
#    Then User can click on send verification code button on login email verification screen
#    Then User can see verification code message as "Verification code has been sent to your inbox. Please copy it to the input box below." on login email verification screen
#    Then User can see verification code input field on login email verification screen
#    Then User can see verify code button label as "Verify code" on login email verification screen
#    Then User can see send new code button label as "Send new code" on login email verification screen
#    Then User can see continue button label as "Continue" on login email verification screen
#    Then User can see cancel button label as "Cancel" on login email verification screen
#
#    Examples:
#      | email                                       | password |
#      | peter.parkeruserxlongevity+admin1@gmail.com | Tuja2153 |
#
#  Scenario Outline: To verify validation message without click on verification code on xLongevity login screen
#    When User on login screen
#    Then User can see email with label as "Email" on login screen
#    And User enter email as <email> on login screen
#    And User can see password with label as "Password" on login screen
#    And User enter password as <password> on login screen
#    Then User can see SignIn button with label as "Sign in" on login screen
#    And User click on SignIn button on login screen
#    Then User can see sub title as "Please provide the following details." on login email verification screen
#    Then User can see email id label as "Email Address" on login email verification screen
#    Then User can see encrypted email as "p********************************@gmail.com" on login email verification screen
#    Then User can see email verification message as "Verification is necessary. Please click Send button." on login email verification screen
#    Then User can see send verification code button label as "Send verification code" on login email verification screen
#    Then User click on continue button on email verification screen
#    Then User can see validation information message as "Please wait while we process your information." on login email verification screen
#    Then User can see validation message as "Claim not verified: [Email Address]" on login email verification screen
#
#    Examples:
#      | email                                       | password |
#      | peter.parkeruserxlongevity+admin1@gmail.com | Tuja2153 |
#
#  Scenario Outline: To verify after click on cancel button on verification page on xLongevity login screen
#    When User on login screen
#    Then User can see email with label as "Email" on login screen
#    And User enter email as <email> on login screen
#    And User can see password with label as "Password" on login screen
#    And User enter password as <password> on login screen
#    Then User can see SignIn button with label as "Sign in" on login screen
#    And User click on SignIn button on login screen
#    Then User can see sub title as "Please provide the following details." on login email verification screen
#    Then User can see email id label as "Email Address" on login email verification screen
#    Then User can see encrypted email as "p********************************@gmail.com" on login email verification screen
#    Then User can see email verification message as "Verification is necessary. Please click Send button." on login email verification screen
#    Then User can see send verification code button label as "Send verification code" on login email verification screen
#    Then User click on cancel button on email verification screen
#    And User can see heading title as "Welcome to xLongevity Admin Panel" on login screen
#
#    Examples:
#      | email                                       | password |
#      | peter.parkeruserxlongevity+admin1@gmail.com | Tuja2153 |
#
#  Scenario Outline: To verify verification code and login xLongevity
#    When User on login screen
#    Then User can see email with label as "Email" on login screen
#    And User enter email as <email> on login screen
#    And User can see password with label as "Password" on login screen
#    And User enter password as <password> on login screen
#    Then User can see SignIn button with label as "Sign in" on login screen
#    And User click on SignIn button on login screen
#    Then User can see sub title as "Please provide the following details." on login email verification screen
#    Then User can see email id label as "Email Address" on login email verification screen
#    Then User can see encrypted email as "p********************************@gmail.com" on login email verification screen
#    Then User can see email verification message as "Verification is necessary. Please click Send button." on login email verification screen
#    Then User can see send verification code button label as "Send verification code" on login email verification screen
#    Then User can click on send verification code button on login email verification screen
#    When User read verification code from mail on email verification screen
#    Then User click on verify code button on email verification screen
#    Then User can see verification success message as "E-mail address verified. You can now continue." on email verification screen
#    Then User click on continue button on email verification screen
#    Then User on xLongevity Home screen
#
#    Examples:
#      | email                                       | password |
#      | peter.parkeruserxlongevity+admin1@gmail.com | Tuja2153 |
#
#  Scenario Outline: To verify verification code after click on send new code and login xLongevity
#    When User on login screen
#    Then User can see email with label as "Email" on login screen
#    And User enter email as <email> on login screen
#    And User can see password with label as "Password" on login screen
#    And User enter password as <password> on login screen
#    Then User can see SignIn button with label as "Sign in" on login screen
#    And User click on SignIn button on login screen
#    Then User can see sub title as "Please provide the following details." on login email verification screen
#    Then User can see email id label as "Email Address" on login email verification screen
#    Then User can see encrypted email as "p********************************@gmail.com" on login email verification screen
#    Then User can see email verification message as "Verification is necessary. Please click Send button." on login email verification screen
#    Then User can see send verification code button label as "Send verification code" on login email verification screen
#    Then User can click on send verification code button on login email verification screen
#    Then User can see send new code button label as "Send new code" on login email verification screen
#    Then User click on send new code button on email verification screen
#    When User read verification code from mail on email verification screen
#    Then User click on verify code button on email verification screen
#    Then User can see verification success message as "E-mail address verified. You can now continue." on email verification screen
#    Then User click on continue button on email verification screen
#    Then User on xLongevity Home screen
#
#    Examples:
#      | email                                       | password |
#      | peter.parkeruserxlongevity+admin1@gmail.com | Tuja2153 |