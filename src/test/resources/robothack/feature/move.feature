Feature: Move

  In order to change cell
  As a program
  I want to move

#    1   2
#  +---+---+
#  |   |   | 1
#  +---+---+
#  |   |   | 2
#  +---+---+

  Background:
    Given a very simple 2x2 sector

  @dev
  Scenario: Move south to a valid cell

    Given my location is (1,1), headed south
    When I move forward
    Then my location should be (1,2)

  @dev
  Scenario Outline: Move any direction to a valid cell

    Given  my location is <location>, headed <direction>
    When I move forward
    Then my location should be <destination>

  Examples:
    | location | direction | destination |
    | (1,1)    | south     | (1,2)       |
    | (1,2)    | north     | (1,1)       |
    | (1,1)    | east      | (2,1)       |
    | (2,2)    | west      | (1,2)       |

  @dev
  Scenario: Moving to an invalid cell

    Given  my location is (1,1), headed north
    And a simple program
    When I move forward
    Then the program should crash
