@Search
Feature: As a user I want to search cryptocurrencies, exchanges and others so I can validate the result

  Scenario Outline: Cryptocurrencies correct search
    Given homepage is displayed
    When do the search process with '<symbol>'
    Then cryptocurrency name is '<name>'
    And cryptocurrency symbol is '<symbol>'

    Examples:
      | symbol | name      |
      | DOGE   | Dogecoin  |
      | LINK   | Chainlink |
      | USDT   | Tether    |