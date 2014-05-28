Feature: hack

  Scenario: A block with document is hacked

    Given a block with a document
    When I hack
    Then the block has no document

  Scenario: A block without document is hacked

    Given a block without a document
    When I hack
    Then the block is corrupted

