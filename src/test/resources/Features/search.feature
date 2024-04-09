@smoketest
Feature: To check search functionality of Aardea website & filter section

  @smoketest
  Scenario Outline: To check search functionality and filter section
    Given open a browser
    And Go to Aardea website
    When users enters <product>
    And click on search button
    And Check the sortby functionality
    Then Search result should come according product name <pageurl>

    Examples: 
      | product                             | pageurl                                                                            |
      | Amalfi                              | https://www.aardea.com/search?q.x=10&q.y=10&q=+Amalfi                              |
      | Refined Flatstone - Tea Cup - Black | https://www.aardea.com/search?q.x=10&q.y=10&q=+Refined+Flatstone+-+Tea+Cup+-+Black |
