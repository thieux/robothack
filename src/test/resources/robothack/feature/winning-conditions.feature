Feature: RobotHack winning condition

  Scenario: Level is not won if there is still non-hacked document

    Given a Sector with 3 documents
    When I hack 1 document
    Then the Sector should not be won

  Scenario: Level is won if all documents are hacked

    Given a Sector with 3 documents
    When I hack 3 document
    Then the Sector should be won




