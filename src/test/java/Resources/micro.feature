Feature: This will Test the EndPoints of STIG layer

  Background: STIG micro Services integration with JDA

  @wip
  Scenario: Validate STIG micro services
    Given I have setup web Api
    When  I call the web api endpoint
    Then  there should be respone back
@wip
  Scenario: Validate Audit micro services
    Given I have setup Audit web Api
    When  I call the web Audit api endpoint
    Then  there should be respone

  @wip
  Scenario: Validate Transformation service
   Given I have setup Transformation web Api
   When I call the web Transformation api endpoint using POST
    Then there should be response back

  @wip
  Scenario: Validate Message Dispatcher service
    Given I have setup Message Dispatcher web Api
    When I call the web Message Dispatcher api endpoint using POST
    Then there should be response back





