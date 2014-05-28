Feature: winnning conditons

 Scenario: The hacker wins
   Given There is 1 document on the sector
   And I am the program
   When I hack the document
   Then I should win the game
   