package robothack.feature.core;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.technbolts.Block;
import org.technbolts.Sector;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class SectorSteps {

    private Sector sector;
    private Block block;

    @Given("^a Sector with (\\d+) documents$")
    public void createNewSector(int documentCount) {
        sector = new Sector();
        for (int i = 0; i < documentCount; ++i) {
            sector.declareDocument(new org.technbolts.Document());
        }
    }

    @When("^I hack (\\d+) document$")
    public void hackDocuments(int documentCount) {
        for (int i = 0; i < documentCount; ++i) {
            sector.hackDocument();
        }
    }

    @Then("^the Sector should not be won$")
    public void sectorIsNotWon() {
        assertFalse(sector.isWon());
    }

    @Then("^the Sector should be won$")
    public void sectorIsWon() {
        assertTrue(sector.isWon());
    }

    @Given("^a block with a document$")
    public void blockWithDocument() {
        block = new Block(false, false);
    }

    @Given("^a block without a document$")
    public void blockWithoutDocument() {
        block = new Block(true, false);
    }

    @When("^I hack$")
    public void hack() {
        block.hack();
    }

    @Then("^the block should have no document$")
    public void blockShouldHaveNoDocument() {
        assertTrue(block.isEmpty());
    }


    @Then("^the block should be corrupted$")
    public void blockShouldBeCorrupted() {
        assertTrue(block.isCorrupted());
    }
}
